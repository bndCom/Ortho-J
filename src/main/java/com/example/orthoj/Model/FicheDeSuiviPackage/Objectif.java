package com.example.orthoj.Model.FicheDeSuiviPackage;

import java.lang.reflect.Type;

public class Objectif {
    private String nom ;
    private TypeObjectifs typeObjectifs ;



    public  Objectif (String nom , TypeObjectifs typeObjectifs){

        this.nom = nom;

        this.typeObjectifs = typeObjectifs;

    }
    public TypeObjectifs getTypeObjectifs() {
        return typeObjectifs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTypeObjectifs(TypeObjectifs typeObjectifs) {
        this.typeObjectifs = typeObjectifs;
    }
}

