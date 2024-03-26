package com.ccsw.techassessment.interviewer;

import com.ccsw.techassessment.interviewer.model.Interviewer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewerRepository extends CrudRepository<Interviewer, Long>{

    Page<Interviewer> findAll(Pageable pageable);

}
