package com.ccsw.dashboard.reportversion;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ccsw.dashboard.reportversion.model.ReportVersion;

@Repository
public interface ReportVersionRepository extends CrudRepository<ReportVersion, Long>, JpaRepository<ReportVersion, Long> {

	Optional<ReportVersion> findById(Long id);
	
	Optional<ReportVersion> findByIdVersionCapacidades(Long id);	

}
