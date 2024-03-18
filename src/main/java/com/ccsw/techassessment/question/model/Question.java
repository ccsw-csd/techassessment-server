package com.ccsw.techassessment.question.model;

import jakarta.persistence.*;
import com.ccsw.techassessment.skill.model.Skill;

import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

    @Column(name = "level")
    private Double level;

    @ManyToMany
    @JoinTable(
            name = "question_skill",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id")
    )
    private List<Skill> tag;

    public Question() {
    }

    public Question(String question, String answer, Double level, List<Skill> tag) {
        this.question = question;
        this.answer = answer;
        this.level = level;
        this.tag = tag;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @return level
     */
    public Double getLevel() {
        return level;
    }

    /**
     * @return  tag
     */
    public List<Skill> getTag() {
        return tag;
    }

    /**
     * @param id new value of {@link #getId}.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param question new value of {@link #getQuestion}.
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @param answer new value of {@link #getAnswer}.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @param level new value of {@link #getLevel}.
     */
    public void setLevel(Double level) {
        this.level = level;
    }

    /**
     * @param tag new value of {@link #getTag}.
     */
    public void setTag(List<Skill> tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" +
                question + '\'' +
                ", answer='" + answer + '\'' +
                ", level=" + level +
                ", tag=" + tag +
                '}';
    }


}
