package com.ccsw.techassessment.skill.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "skillGroup")
    private String skillGroup;


    @Column(name = "label")
    private String label;

    public Skill() {
    }

    public Skill(Long id, String skillGroup, String label) {
        this.id = id;
        this.skillGroup = skillGroup;
        this.label = label;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return skillGroup
     */
    public String getSkillGroup() {
        return skillGroup;
    }

    /**
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param id new value of {@link #getId}.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param skillGroup new value of {@link #getSkillGroup}.
     */
    public void setSkillGroup(String skillGroup) {
        this.skillGroup = skillGroup;
    }

    /**
     * @param label new value of {@link #getLabel}.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skillGroup='" + skillGroup + '\'' +
                ", label='" + label + '\'' +
                '}';
    }



}