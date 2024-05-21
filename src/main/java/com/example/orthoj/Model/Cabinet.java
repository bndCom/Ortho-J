package com.example.orthoj.Model;

import com.example.orthoj.Model.CustomException.NoUserException;

public class Cabinet {

    //attributes
    private Orthophoniste orthophoniste;


    //constructor
    public Cabinet() {

    }

    //setters
    public void signUp(Orthophoniste orthophoniste) {
        this.orthophoniste = orthophoniste;
    }

    // getters
    public Orthophoniste getOrthophoniste(){
        return this.orthophoniste;
    }

    // login
    public boolean signIn(String email, String password) throws NoUserException{
        // checking if no doctor is in the app
        if ((this.orthophoniste == null) || (!this.orthophoniste.getEmail().equals(email)) || (!this.orthophoniste.verifyPassword(password))){
            throw new NoUserException();
        }
        return true;
    }
}
