package com.ccsw.techassessment.skill.model;


public class FiltersDto {

    private String group;
    private String label;

    public FiltersDto() {
    }

    public FiltersDto(String group, String label) {
        this.group = group;
        this.label = label;
    }

    public String getGroup() {
        return group;
    }

    public String getLabel() {
        return label;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "FiltersDto{" +
                "group='" + group + '\'' +
                ", label='" + label + '\'' +
                '}';
    }

}
