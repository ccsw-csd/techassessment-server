package com.ccsw.techassessment.applicant;

import com.ccsw.techassessment.applicant.model.Applicant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long>{

    Page<Applicant> findAll(Pageable pageable);

}