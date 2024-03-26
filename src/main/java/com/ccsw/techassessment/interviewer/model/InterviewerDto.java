package com.ccsw.techassessment.interviewer.model;

import com.ccsw.techassessment.skill.model.SkillDto;

import java.util.List;

public class InterviewerDto {

    private Long id;
    private String name;
    private String lastName;
    private String grade;
    private String email;
    private String username;
    private String saga;
    private List<SkillDto> skill;

    public InterviewerDto() {
    }

    public InterviewerDto(Long id, String name, String lastName, String grade, String email, String username, String saga, List<SkillDto> skill) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.grade = grade;
        this.email = email;
        this.username = username;
        this.saga = saga;
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGrade() {
        return grade;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getSaga() {
        return saga;
    }

    public List<SkillDto> getSkill() {
        return skill;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSaga(String saga) {
        this.saga = saga;
    }

    public void setSkill(List<SkillDto> skill) {
        this.skill = skill;
    }
}
