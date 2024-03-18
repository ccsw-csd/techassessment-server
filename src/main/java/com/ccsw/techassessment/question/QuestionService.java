package com.ccsw.techassessment.question;

import com.ccsw.techassessment.question.model.Question;
import com.ccsw.techassessment.question.model.QuestionDto;
import com.ccsw.techassessment.question.model.QuestionSearchDto;
import com.ccsw.techassessment.skill.model.Skill;
import com.ccsw.techassessment.skill.model.SkillSearchDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QuestionService {


    /**
     * Find a filtered page of questions
     * @param dto
     * @return {@link Page} of {@link Question}
     */
    Page<Question> findPage(QuestionSearchDto dto);

    /**
     * Get a question by id
     * @param id
     * @return {@link Question}
     */
    Question getQuestion(Long id);

    /**
     * Get all questions
     *
     * @return {@link List} of {@link Question}
     */
    List<Question> getAllQuestions();

    /**
     * Save or update a question
     * @param questionDto
     */
    void saveQuestion(Long id, QuestionDto questionDto) throws Exception;

    /**
     * Delete a question
     * @param id
     */
    void deleteQuestion(Long id) throws Exception;


}
