package com.ccsw.techassessment.skill;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ccsw.techassessment.skill.model.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long>, JpaRepository<Skill, Long> {

    /**
     * Find all skills
     * @param pageable
     * @return {@link Page} of {@link Skill}
     */
    Page<Skill> findAll(Pageable pageable);

}
