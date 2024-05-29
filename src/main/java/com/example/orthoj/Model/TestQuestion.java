package com.example.orthoj.Model;

import java.util.HashSet;
import java.util.Set;

public class TestQuestion extends Test{
    // attributes
    private Set<Question> questions;


    //constructure
    public TestQuestion() {
        this.questions = new HashSet<>();
    }

    // calculate the score of the test
    @Override
    public int calcTestScore() {
        for (Question q : questions) {
            this.scoreTotal += q.getQstScore();
        }
        return this.scoreTotal;
    }

    // to add a question to the test
    public void addQuestion(Question q){
        // check if the question is answered
        if(q.getState()){
            this.questions.add(q);
        }
    }

    // getters
    public Set<Question> getQuestions() {
        return questions;
    }
}
