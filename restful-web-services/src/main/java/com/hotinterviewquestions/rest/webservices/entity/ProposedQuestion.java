package com.hotinterviewquestions.rest.webservices.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proposed_questions")
public class ProposedQuestion {

    @Id
    @GeneratedValue
    private Long id;

    private String question;
    private String answer;
    private String difficulty;
    private String category;

    public ProposedQuestion() {}

    public ProposedQuestion(String question, String answer, String difficulty, String category, Long id) {
        this.question = question;
        this.answer = answer;
        this.difficulty = difficulty;
        this.category = category;
        this.id = id;
    }

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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
