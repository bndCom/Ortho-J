package com.example.orthoj.Model;

public class QLData {

    private String question;
    private String answer;

    public QLData(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
}
