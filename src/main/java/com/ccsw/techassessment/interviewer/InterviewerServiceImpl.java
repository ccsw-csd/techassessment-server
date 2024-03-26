package com.ccsw.techassessment.interviewer;

import com.ccsw.techassessment.exception.NotFoundException;
import com.ccsw.techassessment.interviewer.model.Interviewer;
import com.ccsw.techassessment.interviewer.model.InterviewerDto;
import com.ccsw.techassessment.interviewer.model.InterviewerSearchDto;
import com.ccsw.techassessment.position.model.Position;
import com.ccsw.techassessment.skill.SkillService;
import com.ccsw.techassessment.skill.model.Skill;
import com.ccsw.techassessment.skill.model.SkillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InterviewerServiceImpl implements InterviewerService {

    InterviewerRepository interviewerRepository;
    SkillService skillService;

    @Autowired
    public InterviewerServiceImpl(InterviewerRepository interviewerRepository, SkillService skillService) {
        this.interviewerRepository = interviewerRepository;
        this.skillService = skillService;
    }

    @Override
    public Page<Interviewer> findPage(InterviewerSearchDto dto) {
        return interviewerRepository.findAll(dto.getPageable().getPageable());
    }

    @Override
    public Interviewer getInterviewer(Long id) {
        return interviewerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Interviewer> getAllInterviewers() {
        return (List<Interviewer>) interviewerRepository.findAll();
    }

    @Override
    public void saveInterviewer(Long id, InterviewerDto dto) {

        Interviewer interviewer;

        if(id != null){
            interviewer = interviewerRepository.findById(id).orElse(null);
        } else {
            interviewer = new Interviewer();
        }

        interviewer.setName(dto.getName());
        interviewer.setLastName(dto.getLastName());
        interviewer.setGrade(dto.getGrade());
        interviewer.setEmail(dto.getEmail());
        interviewer.setUsername(dto.getUsername());
        interviewer.setSaga(dto.getSaga());

        List<Skill> skills = new ArrayList<>();
        for(SkillDto skillDto : dto.getSkill()){
            Skill skill = skillService.getSkill(skillDto.getId());
            if(skill == null){
                throw new NotFoundException("Skill not found");
            }
            skills.add(skill);
        }
        interviewer.setSkill(skills);

    }

    @Override
    public void deleteInterviewer(Long id) {
        interviewerRepository.deleteById(id);
    }
}
