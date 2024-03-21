package com.ccsw.techassessment.question;

import com.ccsw.techassessment.skill.model.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ccsw.techassessment.question.model.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>, JpaSpecificationExecutor<Question> {

    @EntityGraph(attributePaths = { "tag","level" })
    Page<Question> findAll(Specification<Question> spec,Pageable pageable);

}
