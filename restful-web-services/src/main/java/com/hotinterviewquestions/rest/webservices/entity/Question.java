package com.hotinterviewquestions.rest.webservices.entity;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "category")
    private String category;

    public Question() {}

    public Question(String question, String answer, String difficulty, String category, Long id) {
        this.question = question;
        this.answer = answer;
        this.difficulty = difficulty;
        this.category = category;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
