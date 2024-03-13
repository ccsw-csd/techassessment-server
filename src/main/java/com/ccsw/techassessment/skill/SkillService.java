package com.ccsw.techassessment.skill;

import com.ccsw.techassessment.skill.model.Skill;
import com.ccsw.techassessment.skill.model.SkillDto;
import com.ccsw.techassessment.skill.model.SkillSearchDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SkillService {

    /**
     * Find a page of skills
     * @param dto
     * @return {@link Page} of {@link Skill}
     */
    Page<Skill> findPage(SkillSearchDto dto);

    /**
     * Get a skill by id
     * @param id
     * @return {@link Skill}
     */
    Skill getSkill(Long id);

    /**
     * Get all skills
     *
     * @return {@link List} of {@link Skill}
     */
    List<Skill> getAllSkills();

    /**
     * Save or update a skill
     * @param skillDto
     */
    void saveSkill(Long id, SkillDto skillDto) throws Exception;

    /**
     * Delete a skill
     * @param id
     */
    void deleteSkill(Long id) throws Exception;


}
