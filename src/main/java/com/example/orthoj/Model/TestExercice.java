package com.example.orthoj.Model;

import java.util.ArrayList;
import java.util.List;

public class TestExercice extends Test{
    // attributes
    private List<Exercice> exercices;
    // constructure
    public TestExercice(){
        this.exercices = new ArrayList<>();
    }

    @Override
    public int calcTestScore() {
        // adding the score of exercices
        for (Exercice exercice : exercices) {
            this.scoreTotal += exercice.getScore();
        }
        return this.scoreTotal;
    }

    // add an exercise
    public void addExercise(Exercice e){
        if(e.getState()){
            exercices.add(e);
        }
    }

    // setters
    public void setExercices(List<Exercice> exercices){
        this.exercices = exercices;
    }
    // getters
    public List<Exercice> getExercices(){
        return exercices;
    }
}
