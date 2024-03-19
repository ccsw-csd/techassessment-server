package com.ccsw.techassessment.applicant;

import com.ccsw.techassessment.applicant.model.Applicant;
import com.ccsw.techassessment.applicant.model.ApplicantDto;
import com.ccsw.techassessment.applicant.model.ApplicantSearchDto;
import com.ccsw.techassessment.exception.NotFoundException;
import com.ccsw.techassessment.exception.RequiredFieldsException;
import com.ccsw.techassessment.question.model.Question;
import com.ccsw.techassessment.question.model.QuestionSearchDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ApplicantService {

    /**
     * Find a filtered page of applicants
     * @param dto
     * @return {@link Page} of {@link Applicant}
     */
    Page<Applicant> findPage(ApplicantSearchDto dto);

    /**
     * Get all applicants
     *
     * @return {@link List} of {@link Applicant}
     */
    List<Applicant> getAllApplicants();

    /**
     * Get an applicant by id
     * @param id
     * @return {@link Applicant}
     */
    Applicant getApplicant(Long id);

    /**
     * Save or update an applicant
     * @param applicantDto
     */
    void saveApplicant(Long id, ApplicantDto applicantDto) throws RequiredFieldsException;

    /**
     * Delete an applicant
     * @param id
     */
    void deleteApplicant(Long id) throws NotFoundException;
}
