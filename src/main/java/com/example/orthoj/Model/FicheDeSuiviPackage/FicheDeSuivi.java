package com.example.orthoj.Model.FicheDeSuiviPackage;

import javax.print.attribute.standard.JobKOctets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class FicheDeSuivi {
   LinkedList<Objectif> objectifs = new LinkedList<>();

    public Objectif CreeObjectif(String nom, TypeObjectifs type) {
        return new Objectif(nom, type);
    }

    public void AjouterObjectif(String nom, TypeObjectifs type) {
        objectifs.add(CreeObjectif(nom , type));
    }



    // suppression de objectif par le nombre


    public LinkedList<Objectif> getObjectifs() {
        return objectifs;
    }


    public void setObjectifs(LinkedList<Objectif> objectifs) {
        this.objectifs = objectifs;
    }

    public void addNoteObjectif(Objectif objectif , int n){
        objectif.addNote(n);

    }
}
