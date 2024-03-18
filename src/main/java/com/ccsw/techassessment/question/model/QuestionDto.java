package com.ccsw.techassessment.question.model;

import com.ccsw.techassessment.skill.model.Skill;
import com.ccsw.techassessment.skill.model.SkillDto;

import java.util.List;

public class QuestionDto {

    private Long id;
    private String question;
    private String answer;
    private Double level;
    private List<SkillDto> tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }

    public List<SkillDto> getTag() {
        return tag;
    }

    public void setTag(List<SkillDto> tag) {
        this.tag = tag;
    }

}

