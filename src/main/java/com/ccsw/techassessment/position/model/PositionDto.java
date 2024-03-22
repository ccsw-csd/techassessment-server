package com.ccsw.techassessment.position.model;

import com.ccsw.techassessment.skill.model.SkillDto;

import java.util.List;

public class PositionDto {

    private Long id;
    private String request;
    private String client;
    private String grade;
    private List<SkillDto> skill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<SkillDto> getSkill() {
        return skill;
    }

    public void setSkill(List<SkillDto> skill) {
        this.skill = skill;
    }
}