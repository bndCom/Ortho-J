package com.example.orthoj.Model.RendezVousManagement;

//import org.example.ortho_j_front_end.Cabinet.FicheDeSuiviPackage.*;
import com.example.orthoj.Model.FicheDeSuiviPackage.*;
//import org.example.ortho_j_front_end.Cabinet.CustomException.*;
import com.example.orthoj.Model.CustomException.*;

import com.sun.source.tree.WhileLoopTree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class Suivi {
    private int NbDossier ;
    boolean online ;
    // not sure how to declare keep tab of the objectifs that were treated in this specific session
    // nothing is declared yet , should figure it out later
    //private int note ;

    public int getNbDossier() {
        return NbDossier;
    }

    public void setNbDossier(int nbDossier) {
        NbDossier = nbDossier;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    HashSet<Objectif> ObjectifLinkedList = new HashSet<Objectif>();

    // add elements to the list

    public void AjoutezUnObjectif(Objectif objectif){
        ObjectifLinkedList.add(objectif);

    }


    //suppression de objectif par nom et par objectif meme
    public void SupprimezUnObjectif(Objectif objectif){
        ObjectifLinkedList.remove(objectif);
    }

    public void SupprimezUnObjectif(String ObjectifName){

        Iterator<Objectif> iterator = ObjectifLinkedList.iterator();

        while (iterator.hasNext()){
            Objectif obj = iterator.next();
            if(Objects.equals(obj.getNom(), ObjectifName)){
                iterator.remove();
            }

        }
    }
    //


}
