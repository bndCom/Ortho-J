package com.example.orthoj.Model;

import com.example.orthoj.Model.Enumeration.TypeTrouble;

import java.io.Serializable;

public class Trouble implements Serializable {

    // attributes
    private String nom;
    private TypeTrouble type;

    //constructor
    public Trouble(String nom, TypeTrouble type) {
        this.nom = nom;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public TypeTrouble getType() {
        return type;
    }
}
