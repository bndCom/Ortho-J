package com.example.orthoj.Model.FicheDeSuiviPackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class FicheDeSuivi {
    HashMap<Objectif , LinkedList<Integer>> Objectifs = new HashMap<Objectif , LinkedList<Integer>>();

    public Objectif CreeObjectif(String nom, TypeObjectifs type) {
        return new Objectif(nom, type);
    }

    public void AjouterObjectif(String nom, TypeObjectifs type) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Objectifs.put(CreeObjectif(nom, type), list);
    }


    // suppression de objectif par le nombre
    public void SupprimerObjectifs(String nom, TypeObjectifs type) {
        Iterator<Objectif> iterator = Objectifs.keySet().iterator();
        while (iterator.hasNext()) {
            Objectif obj = iterator.next();
            if (obj.getNom() == nom && obj.getTypeObjectifs() == type) {
               Objectifs.remove(obj);
            }


        }


    }

    public void SupprimerObjectifs(String nom) {
        Iterator<Objectif> iterator = Objectifs.keySet().iterator();
        while (iterator.hasNext()) {
            Objectif obj = iterator.next();
            if (obj.getNom() == nom ) {
                Objectifs.remove(obj);
            }


        }


    }

}
