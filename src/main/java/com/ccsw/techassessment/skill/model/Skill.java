package com.ccsw.techassessment.skill.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "skill")
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "`group`")
    private String group;


    @Column(name = "label")
    private String label;

    public Skill() {
    }

    public Skill(Long id, String group, String label) {
        this.id = id;
        this.group = group;
        this.label = label;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return group
     */
    public String getGroup() {
        return group;
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
     * @param group new value of {@link #getGroup}.
     */
    public void setGroup(String group) {
        this.group = group;
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
                ", group='" + group + '\'' +
                ", label='" + label + '\'' +
                '}';
    }



}