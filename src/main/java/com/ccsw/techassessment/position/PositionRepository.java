package com.ccsw.techassessment.position;

import com.ccsw.techassessment.applicant.model.Applicant;
import com.ccsw.techassessment.position.model.Position;
import com.ccsw.techassessment.question.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long>, JpaSpecificationExecutor<Position> {

    Page<Position> findAll(Pageable pageable);

}
