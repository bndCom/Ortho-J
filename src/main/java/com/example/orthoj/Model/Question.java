package com.example.orthoj.Model;

import java.util.List;

abstract public class Question {

    // attributes
    protected int score;
    // indicates if the question is answered or not
    protected boolean done;

    // constructure
    public Question(){
        this.score = 0;
        this.done = false;
    }
    // calculate the questions score, must be reimplemented
    abstract protected void calcQstScore();

    // getters
    public boolean getState(){
        return this.done;
    }

    public int getQstScore(){
        return this.score;
    };
}
