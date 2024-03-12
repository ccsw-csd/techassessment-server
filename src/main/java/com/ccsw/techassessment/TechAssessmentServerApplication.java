package com.ccsw.techassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class TechAssessmentServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechAssessmentServerApplication.class, args);
	}

}
