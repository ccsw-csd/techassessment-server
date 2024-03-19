package com.ccsw.techassessment.skill;


import com.ccsw.techassessment.common.criteria.SearchCriteria;
import com.ccsw.techassessment.exception.NotFoundException;
import com.ccsw.techassessment.exception.skill.DuplicateLabelException;
import com.ccsw.techassessment.exception.RequiredFieldsException;
import com.ccsw.techassessment.question.QuestionSpecification;
import com.ccsw.techassessment.question.model.Question;
import com.ccsw.techassessment.skill.model.FiltersDto;
import com.ccsw.techassessment.skill.model.Skill;
import com.ccsw.techassessment.skill.model.SkillDto;
import com.ccsw.techassessment.skill.model.SkillSearchDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class SkillServiceImpl implements SkillService{


    private SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Skill> findPage(SkillSearchDto dto) {

        FiltersDto filtros = dto.getFilterParams();

        if(filtros == null){
            return this.skillRepository.findAll(null, dto.getPageable().getPageable());
        }

        SkillSpecification groupSpec = new SkillSpecification(new SearchCriteria("group", ":", filtros.getGroup()));
        SkillSpecification labelSpec = new SkillSpecification(new SearchCriteria("label", ":", filtros.getLabel()));

        Specification<Skill> spec = Specification.where(groupSpec).and(labelSpec);

        return this.skillRepository.findAll(spec, dto.getPageable().getPageable());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Skill getSkill(Long id) {

        return skillRepository.findById(id).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Skill> getAllSkills() {
        return (List<Skill>) skillRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveSkill(Long id, SkillDto dto) throws Exception {

        Skill skill;

        if(id == null){
            skill = new Skill();

        } else {
            skill = skillRepository.findById(id).orElse(null);
        }

        if(dto.getGroup() == null || dto.getGroup().isEmpty() || dto.getLabel() == null || dto.getLabel().isEmpty()){
            throw new RequiredFieldsException("Group and label are required");
        }

        if(skillRepository.findByGroupAndLabel(dto.getGroup(), dto.getLabel()).isPresent()){
            throw new DuplicateLabelException("Skill with group " + dto.getGroup() + " and label " + dto.getLabel() + " already exists");
        }

        skill.setGroup(dto.getGroup());
        skill.setLabel(dto.getLabel());

        skillRepository.save(skill);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteSkill(Long id) throws Exception {

        if(skillRepository.findById(id).orElse(null) == null){
            throw new NotFoundException("Skill not found");
        }

        skillRepository.deleteById(id);
    }


}

