package com.ccsw.techassessment.position;

import com.ccsw.techassessment.position.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long>, JpaSpecificationExecutor<Position> {

    @EntityGraph(attributePaths = { "client" })
    Page<Position> findAll(Specification<Position> spec, Pageable pageable);

}