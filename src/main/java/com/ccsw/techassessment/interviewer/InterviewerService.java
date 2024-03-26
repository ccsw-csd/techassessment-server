package com.ccsw.techassessment.interviewer;

import com.ccsw.techassessment.interviewer.model.Interviewer;
import com.ccsw.techassessment.interviewer.model.InterviewerDto;
import com.ccsw.techassessment.interviewer.model.InterviewerSearchDto;
import com.ccsw.techassessment.skill.model.SkillDto;
import org.springframework.data.domain.Page;
import java.util.List;

public interface InterviewerService {

    /**
     * Find a page of Interviewers
     * @param dto
     * @return
     */
    Page<Interviewer> findPage(InterviewerSearchDto dto);

    /**
     * Get an Interviewer by id
     * @param id
     * @return
     */
    Interviewer getInterviewer(Long id);

    /**
     * Get all Interviewers
     * @return
     */
    List<Interviewer> getAllInterviewers();

    /**
     * Save an Interviewer
     * @param id
     * @param dto
     */
    void saveInterviewer(Long id, InterviewerDto dto);

    /**
     * Delete an Interviewer
     * @param id
     */
    void deleteInterviewer(Long id);

}
