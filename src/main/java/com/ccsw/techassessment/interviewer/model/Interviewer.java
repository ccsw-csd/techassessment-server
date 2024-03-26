package com.ccsw.techassessment.interviewer.model;

import com.ccsw.techassessment.skill.model.Skill;
import com.ccsw.techassessment.skill.model.SkillDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "interviewer")
public class Interviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "grade")
    private String grade;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "saga")
    private String saga;

    @ManyToMany
    @JoinTable(
            name = "interviewer_skill",
            joinColumns = @JoinColumn(name = "interviewer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skill;

    public Interviewer() {
    }

    public Interviewer(Long id, String name, String lastName, String grade, String email, String username, String saga, List<Skill> skill) {
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

    public List<Skill> getSkill() {
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

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Interviewer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade='" + grade + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", saga='" + saga + '\'' +
                ", skill=" + skill +
                '}';
    }

}
