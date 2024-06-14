package com.example.orthoj.Model;

import java.io.Serializable;

public class QLData implements Serializable {

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
