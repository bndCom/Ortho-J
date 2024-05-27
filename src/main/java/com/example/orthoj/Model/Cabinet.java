package com.example.orthoj.Model;

import com.example.orthoj.Model.CustomException.NoUserException;

import java.util.ArrayList;
import java.util.List;

public class Cabinet {

    //attributes
    private Orthophoniste orthophoniste;
    // questions templates
    private List<Question> questions;


    //constructor
    public Cabinet() {
        this.questions = new ArrayList<Question>();
    }

    //setters
    public void signUp(Orthophoniste orthophoniste) {
        this.orthophoniste = orthophoniste;
    }

    // getters
    public Orthophoniste getOrthophoniste(){
        return this.orthophoniste;
    }
    public List<Question> getQuestions() {
        return questions;
    }

    // login
    public boolean signIn(String email, String password) throws NoUserException{
        // checking if no doctor is in the app
        if ((this.orthophoniste == null) || (!this.orthophoniste.getEmail().equals(email)) || (!this.orthophoniste.verifyPassword(password))){
            throw new NoUserException();
        }
        return true;
    }

    // add new question
    public void addQuestion(Question question){
        this.questions.add(question);
    }

    // delete a question
    public void removeQuestion(Question question){
        this.questions.remove(question);
    }
}
