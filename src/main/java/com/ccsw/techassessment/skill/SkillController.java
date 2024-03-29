package com.ccsw.techassessment.skill;

import com.ccsw.techassessment.skill.model.SkillSearchDto;
import org.dozer.DozerBeanMapper;

import com.ccsw.techassessment.skill.model.Skill;
import com.ccsw.techassessment.skill.model.SkillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import java.util.stream.Collectors;


@RequestMapping(value = "/skill")
@RestController
public class SkillController {

    private SkillService skillService;
    private DozerBeanMapper mapper;

    @Autowired
    public SkillController(SkillService skillService, DozerBeanMapper mapper) {
        this.skillService = skillService;
        this.mapper = mapper;
    }

    @Operation(summary = "Find Page", description = "Method that return a page of Skills")
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<SkillDto> findPage(@RequestBody SkillSearchDto dto) {

        Page<Skill> page = this.skillService.findPage(dto);

        return new PageImpl<>(
                page.getContent().stream().map(skill -> mapper.map(skill, SkillDto.class)).collect(Collectors.toList()),
                page.getPageable(), page.getTotalElements());
    }

    @Operation(summary = "Skill by id", description = "Method that return a skill by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SkillDto getSkill(@PathVariable("id") Long id) {
        return mapper.map(skillService.getSkill(id), SkillDto.class);
    }

    @Operation(summary = "All skills", description = "Method that return all skills")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<SkillDto> getAllSkills() {
        List<Skill> skills = skillService.getAllSkills();
        return skills.stream().map(skill -> mapper.map(skill, SkillDto.class)).toList();
    }

    @Operation(summary = "New Skill", description = "Method that save a new Skill")
    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public void newSkill(@RequestBody SkillDto skillDto) throws Exception {
        skillService.saveSkill(null, skillDto);
    }

    @Operation(summary = "Update", description = "Method that update a skill")
    @RequestMapping(path ={ "","/{id}" }, method = RequestMethod.PUT)
    public void updateSkill(@PathVariable(name = "id", required = true) Long id, @RequestBody SkillDto skillDto) throws Exception {

        skillService.saveSkill(id, skillDto);
    }

    @Operation(summary = "Delete skill", description = "Method that delete a skill")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSkill(@PathVariable("id") Long id) throws Exception {
        skillService.deleteSkill(id);
    }

}
