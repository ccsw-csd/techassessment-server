package com.ccsw.techassessment.applicant;

import com.ccsw.techassessment.applicant.model.Applicant;
import com.ccsw.techassessment.applicant.model.ApplicantDto;
import com.ccsw.techassessment.applicant.model.ApplicantSearchDto;
import com.ccsw.techassessment.exception.NotFoundException;
import com.ccsw.techassessment.exception.RequiredFieldsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ApplicantServiceImpl implements ApplicantService{

    private ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Applicant> findPage(ApplicantSearchDto dto) {

        return this.applicantRepository.findAll(dto.getPageable().getPageable());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Applicant> getAllApplicants() {
        return (List<Applicant>) applicantRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Applicant getApplicant(Long id) {
        return applicantRepository.findById(id).orElseThrow(() -> new NotFoundException("Applicant not found"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveApplicant(Long id, ApplicantDto applicantDto) throws RequiredFieldsException{

        Applicant applicant;

        if(id != null) {
            applicant = applicantRepository.findById(id).orElse(null);
        } else {
            applicant = new Applicant();
        }

        applicant.setName(applicantDto.getName());
        applicant.setGrade(applicantDto.getGrade());
        applicant.setFeedback(applicantDto.getFeedback());
        applicant.setCv(applicantDto.getCv());

        if(applicantDto.getName() == null || applicantDto.getName().isEmpty() || applicantDto.getGrade() == null || applicantDto.getGrade().isEmpty()
                || applicantDto.getFeedback() == null || applicantDto.getFeedback().isEmpty() || applicantDto.getCv() == null || applicantDto.getCv().isEmpty()){
            throw new RequiredFieldsException("All fields are required");
        }


        applicantRepository.save(applicant);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteApplicant(Long id) throws NotFoundException{

        if(applicantRepository.findById(id).orElse(null) == null){
            throw new NotFoundException("Applicant not found");
        }

        applicantRepository.deleteById(id);
    }

}