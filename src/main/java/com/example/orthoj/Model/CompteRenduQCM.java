package com.example.orthoj.Model;

public class CompteRenduQCM {
    // attributes
    private String question;
    private String choix;
    private String correctes;
    private String choisis;
    private int score;
    // constructor
    public CompteRenduQCM(){}

    // getters

    public String getQuestion() {
        return question;
    }

    public String getChoix() {
        return choix;
    }

    public String getCorrectes() {
        return correctes;
    }

    public String getChoisis() {
        return choisis;
    }

    public int getScore() {
        return score;
    }

    // setters

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    public void setCorrectes(String correctes) {
        this.correctes = correctes;
    }

    public void setChoisis(String choisis) {
        this.choisis = choisis;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
