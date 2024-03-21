package com.ccsw.techassessment.question.model;


public class FiltersDto {
    private Long skill;
    private Double level;

    public Long getSkill() {
        return skill;
    }

    public void setSkill(Long skill) {
        this.skill = skill;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }

    public FiltersDto() {
    }

    public FiltersDto(Long skill, Double level) {
        super();
        this.skill = skill;
        this.level = level;
    }

    @Override
    public String toString() {
        return "FiltersDto{" +
                "skill=" + skill +
                ", level=" + level +
                '}';
    }



}
