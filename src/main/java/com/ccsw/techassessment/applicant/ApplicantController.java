package com.ccsw.techassessment.applicant;

import com.ccsw.techassessment.applicant.model.Applicant;
import com.ccsw.techassessment.applicant.model.ApplicantDto;
import com.ccsw.techassessment.applicant.model.ApplicantSearchDto;
import com.ccsw.techassessment.exception.NotFoundException;
import com.ccsw.techassessment.exception.RequiredFieldsException;
import io.swagger.v3.oas.annotations.Operation;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/applicant")
@RestController
public class ApplicantController {

    private ApplicantService applicantService;
    private DozerBeanMapper mapper;

    @Autowired
    public ApplicantController(ApplicantService applicantService, DozerBeanMapper mapper) {
        this.applicantService = applicantService;
        this.mapper = mapper;
    }

    @Operation(summary = "Paginated Applicants", description = "Method that return a paginated list of Applicants")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Page<ApplicantDto> findPage(@RequestBody ApplicantSearchDto dto) {

        Page<Applicant> page = applicantService.findPage(dto);

        return new PageImpl<>(
                page.getContent().stream().map(applicant -> mapper.map(applicant, ApplicantDto.class)).collect(Collectors.toList()),
                page.getPageable(), page.getTotalElements());
    }

    @Operation(summary = "All Applicants", description = "Method that return a list of Applicants")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ApplicantDto> getAllApplicants() {
        List<Applicant> applicants = applicantService.getAllApplicants();
        return applicants.stream().map(applicant -> mapper.map(applicant, ApplicantDto.class)).toList();
    }

    @Operation(summary = "Find Applicant by Id", description = "Method that return an Applicant by ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ApplicantDto getApplicant(@PathVariable("id") Long id) {
        return mapper.map(applicantService.getApplicant(id), ApplicantDto.class);
    }

    @Operation(summary = "New Applicant", description = "Method that create a new Applicant")
    @RequestMapping(path ={"/new"}, method = RequestMethod.POST)
    public void newApplicant(@RequestBody ApplicantDto applicantDto) throws RequiredFieldsException{
        applicantService.saveApplicant(null,applicantDto);
    }

    @Operation(summary = "Update Applicant", description = "Method that update an Applicant")
    @RequestMapping(path ={"/{id}"}, method = RequestMethod.PUT)
    public void updateApplicant(@PathVariable(name = "id", required = false) Long id, @RequestBody ApplicantDto applicantDto) throws RequiredFieldsException {
        applicantService.saveApplicant(id,applicantDto);
    }

    @Operation(summary = "Delete Applicant", description = "Method that delete an Applicant")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteApplicant(@PathVariable("id") Long id) throws NotFoundException {
        applicantService.deleteApplicant(id);
    }

}
