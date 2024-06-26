package com.example.orthoj.Model.Patient;

import com.example.orthoj.Model.PremierBO;
import com.example.orthoj.Model.RendezVousManagement.Consultaion;

import java.io.Serializable;
import java.time.LocalDate;

public class Patient implements Serializable {
    String nom ;
    String prenom ;

    int age ;

    String NumTel ;

    int numDossier;

    private PremierBO premierBO;


    LocalDate DateDeNaissance ;
    String lieuDeNaissance;
    String adresse;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        DateDeNaissance = dateDeNaissance;
    }



    public LocalDate getDateDeNaissance() {
        return DateDeNaissance;
    }

    public String getLieuDeNaissance() {
        return lieuDeNaissance;
    }


    public void setLieuDeNaissance(String lieuDeNaissance) {
        this.lieuDeNaissance = lieuDeNaissance;
    }

    public int getNumDossier() {
        return numDossier;
    }

    public void setNumDossier(int numDossier) {
        this.numDossier = numDossier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumTel() {
        return NumTel;
    }

    public void setNumTel(String numTel) {
        NumTel = numTel;
    }

    public  String getType(){
        return "";
    }

    public void setPremierBO(PremierBO premierBO){
        this.premierBO = premierBO;
    }
    public PremierBO getPremierBO(){
        return this.premierBO;
    }
}
