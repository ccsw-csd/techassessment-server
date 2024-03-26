package com.ccsw.techassessment.interviewer;

import com.ccsw.techassessment.interviewer.model.Interviewer;
import com.ccsw.techassessment.interviewer.model.InterviewerDto;
import com.ccsw.techassessment.interviewer.model.InterviewerSearchDto;
import com.ccsw.techassessment.position.model.PositionDto;
import com.ccsw.techassessment.skill.model.SkillDto;
import io.swagger.v3.oas.annotations.Operation;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/interviewer")
@RestController
public class InterviewerController {

    private InterviewerService interviewerService;
    private DozerBeanMapper mapper;

    @Autowired
    public InterviewerController(InterviewerService interviewerService, DozerBeanMapper mapper) {
        this.interviewerService = interviewerService;
        this.mapper = mapper;
    }

    @Operation(summary = "Page of Interviewers", description = "Method that return a page of Interviewers")
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<InterviewerDto> findPage(@RequestBody InterviewerSearchDto dto) {

        Page<Interviewer> page = this.interviewerService.findPage(dto);

        return new PageImpl<>(
                page.getContent().stream().map(position -> mapper.map(position, InterviewerDto.class)).collect(Collectors.toList()),
                page.getPageable(), page.getTotalElements());
    }

    @Operation(summary = "Interviewer by id", description = "Method that return a interviewer by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public InterviewerDto getInterviewer(@PathVariable("id") Long id) {
        return mapper.map(interviewerService.getInterviewer(id), InterviewerDto.class);
    }

    @Operation(summary = "All interviewers", description = "Method that return all interviewers")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<InterviewerDto> getAllInterviewers() {
        List<Interviewer> interviewers = interviewerService.getAllInterviewers();
        return interviewers.stream().map(interviewer -> mapper.map(interviewer, InterviewerDto.class)).toList();
    }

    @Operation(summary = "New Interviewer", description = "Method that create a new Interviewer")
    @RequestMapping(path ={"/new"}, method = RequestMethod.POST)
    public void newInterviewer(@RequestBody InterviewerDto dto){
        interviewerService.saveInterviewer(null,dto);
    }

    @Operation(summary = "Update", description = "Method that update a Interviewer")
    @RequestMapping(path ={"","/{id}"}, method = RequestMethod.PUT)
    public void updateInterviewer(@PathVariable(name = "id", required = false) Long id, @RequestBody InterviewerDto dto){
        interviewerService.saveInterviewer(id,dto);
    }

    @Operation(summary = "Delete Interviewer", description = "Method that delete a Interviewer")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteInterviewer(@PathVariable("id") Long id){
        interviewerService.deleteInterviewer(id);
    }

}
