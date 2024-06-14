package com.example.orthoj.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EpreuveClinique implements Serializable {

    // attributes
    private List<String> observations;
    private List<Test> tests;

    // constructure
    public EpreuveClinique(){
        this.observations = new ArrayList<>();
        this.tests = new ArrayList<>();
    }

    // add an observation
    public void addObservation(String obs){
        this.observations.add(obs);
    }

    // add a test
    public void addTest(Test test){
        this.tests.add(test);
    }

    // getters
    // get all observations
    public List<String> getObservations(){
        return this.observations;
    }
    // get the total score of all tests
    public int getTestExerciseScore(){
        int score = 0;
        for(Test test : tests){
            if(test instanceof TestExercice){
                score += test.calcTestScore();
            }
        }
        return score;
    }
    public int getTestQuestionScore(){
        int score = 0;
        for(Test test : tests){
            if(test instanceof TestQuestion){
                score += test.calcTestScore();
            }
        }
        return score;
    }
    public List<Test> getTests(){
        return this.tests;
    }

    public void setObservations(List<String> obs){
        this.observations = obs;
    }


}
