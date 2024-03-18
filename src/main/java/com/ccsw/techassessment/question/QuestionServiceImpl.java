package com.ccsw.techassessment.question;

import com.ccsw.techassessment.exception.NotFoundException;
import com.ccsw.techassessment.exception.RequiredFieldsException;
import com.ccsw.techassessment.exception.question.DuplicateTagException;
import com.ccsw.techassessment.exception.question.RequiredTagException;
import com.ccsw.techassessment.question.model.FiltersDto;
import com.ccsw.techassessment.question.model.Question;
import com.ccsw.techassessment.question.model.QuestionDto;
import com.ccsw.techassessment.question.model.QuestionSearchDto;
import com.ccsw.techassessment.skill.SkillService;
import com.ccsw.techassessment.skill.model.Skill;
import com.ccsw.techassessment.skill.model.SkillDto;
import com.ccsw.techassessment.skill.model.SkillSearchDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ccsw.techassessment.common.criteria.SearchCriteria;


@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

    private QuestionRepository questionRepository;
    private SkillService skillService;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, SkillService skillService) {
        this.questionRepository = questionRepository;
        this.skillService = skillService;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Question> findPage(QuestionSearchDto dto) {

        FiltersDto filtros = dto.getFilterParams();

        if(filtros == null){
            return this.questionRepository.findAll(null, dto.getPageable().getPageable());
        }

        QuestionSpecification tagSpec = new QuestionSpecification(new SearchCriteria("tag.id", ":", filtros.getTag()));
        QuestionSpecification levelSpec = new QuestionSpecification(new SearchCriteria("level", ":", filtros.getLevel()));

        Specification<Question> spec = Specification.where(tagSpec).and(levelSpec);
        //Specification<Question> spec = Specification.where(levelSpec);

        return this.questionRepository.findAll(spec, dto.getPageable().getPageable());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Question getQuestion(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Question> getAllQuestions() {
        return (List<Question>) questionRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveQuestion(Long id, QuestionDto dto) throws Exception{

        Question question;

        if(id != null){
            question = questionRepository.findById(id).orElse(null);
        } else {
            question = new Question();
        }

        question.setQuestion(dto.getQuestion());
        question.setAnswer(dto.getAnswer());
        question.setLevel(dto.getLevel());

        List<Skill> tags = new ArrayList<>();
        for(SkillDto skillDto : dto.getTag()){
            Skill skill = skillService.getSkill(skillDto.getId());
            if(skill == null){
                throw new NotFoundException("Skill not found");
            }
            tags.add(skill);
        }
        question.setTag(tags);

        if(tags == null || tags.isEmpty()){
            throw new RequiredTagException("At least, one skill is required");
        }

        if(dto.getQuestion() == null || dto.getQuestion().isEmpty() || dto.getAnswer() == null || dto.getAnswer().isEmpty() || dto.getLevel() == null){
            throw new RequiredFieldsException("Question, answer and level are required");
        }

        List<Long> ids = tags.stream().map(Skill::getId).collect(Collectors.toList());
        if(ids.size() != ids.stream().distinct().count()){
            throw new DuplicateTagException("A question cannot have the same tag twice");
        }


        questionRepository.save(question);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteQuestion(Long id) throws Exception {

        if(questionRepository.findById(id).orElse(null) == null){
            throw new NotFoundException("Question not found");
        }

        questionRepository.deleteById(id);
    }

 
}