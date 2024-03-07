package com.ccsw.techassessment.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ccsw.techassessment.question.model.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>, JpaRepository<Question, Long> {


}
