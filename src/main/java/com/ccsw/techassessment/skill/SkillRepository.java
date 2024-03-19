package com.ccsw.techassessment.skill;

import com.ccsw.techassessment.question.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ccsw.techassessment.skill.model.Skill;

import java.util.Optional;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long>, JpaSpecificationExecutor<Skill> {

    @EntityGraph(attributePaths = { "group","label" })
    Page<Skill> findAll(Specification<Skill> spec,Pageable pageable);

    /**
     * Find a skill by group and label
     * @param group
     * @param label
     * @return {@link Optional} of {@link Skill}
     */
    Optional<Skill> findByGroupAndLabel(String group, String label);

}






