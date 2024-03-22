package com.ccsw.techassessment.position.model;

import com.ccsw.techassessment.skill.model.Skill;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "request")
    private String request;

    @Column(name = "client")
    private String client;

    @Column(name = "grade")
    private String grade;

    @ManyToMany
    @JoinTable(
            name = "position_skill",
            joinColumns = @JoinColumn(name = "position_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skill;

    public Position() {
    }

    public Position(String request, String client, String grade, List<Skill> skill) {
        this.request = request;
        this.client = client;
        this.grade = grade;
        this.skill = skill;
    }

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

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", request='" + request + '\'' +
                ", client='" + client + '\'' +
                ", grade='" + grade + '\'' +
                ", skill=" + skill +
                '}';
    }

}