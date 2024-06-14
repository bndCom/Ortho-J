package com.example.orthoj.Model;

import java.io.Serializable;

public class Exercice implements Serializable {
    // attributes
    private String nom;
    private String materiel;
    private int score;
    private boolean done;

    //constructure
    public Exercice(String nom, String materiel) {
        this.nom = nom;
        this.materiel = materiel;
        this.done = false;
    }

    // setters
    public void setScore(int score) {
        this.score = score;
        this.done = true; // the exercise is answered
    }

    // getters

    public int getScore() {
        return this.score;
    }

    public String getNom(){
        return this.nom;
    }

    public String getMateriel(){
        return this.materiel;
    }

    public boolean getState(){
        return this.done;
    }
}
