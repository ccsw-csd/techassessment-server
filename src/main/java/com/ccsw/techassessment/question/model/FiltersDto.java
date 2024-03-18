package com.ccsw.techassessment.question.model;


public class FiltersDto {
    private Long tag;
    private Double level;

    public Long getTag() {
        return tag;
    }

    public void setTag(Long tag) {
        this.tag = tag;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }

    public FiltersDto() {
    }

    public FiltersDto(Long tag, Double level) {
        super();
        this.tag = tag;
        this.level = level;
    }

    @Override
    public String toString() {
        return "FiltersDto{" +
                "tag=" + tag +
                ", level=" + level +
                '}';
    }



}
