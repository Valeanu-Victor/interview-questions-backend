package com.hotinterviewquestions.rest.webservices.dto;

public class QuestionDto {

    private String question;
    private String answer;
    private String difficulty;
    private String category;

    public QuestionDto() {}

    public QuestionDto(String question, String answer, String difficulty, String category) {
        this.question = question;
        this.answer = answer;
        this.difficulty = difficulty;
        this.category = category;
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
