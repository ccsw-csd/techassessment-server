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
            inverseJoinColumns = @JoinColumn(name = "tags_id")
    )
    private List<Skill> tag;

    public Position() {
    }

    public Position(String request, String client, String grade, List<Skill> tag) {
        this.request = request;
        this.client = client;
        this.grade = grade;
        this.tag = tag;
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

    public List<Skill> getTag() {
        return tag;
    }

    public void setTag(List<Skill> tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", request='" + request + '\'' +
                ", client='" + client + '\'' +
                ", grade='" + grade + '\'' +
                ", tag=" + tag +
                '}';
    }

}
