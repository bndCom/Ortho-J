package com.example.orthoj.Model.RendezVousManagement;

import java.time.LocalDate;

public abstract class Consultaion extends RendezVous {
   String nom , prenom ;
   int age ;

   String adresseDeNaissance ;
   String adresseDomicile ;

   LocalDate dateDeNaissance ;

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

    public String getAdresseDeNaissance() {
        return adresseDeNaissance;
    }

    public void setAdresseDeNaissance(String adresseDeNaissance) {
        this.adresseDeNaissance = adresseDeNaissance;
    }

    public String getAdresseDomicile() {
        return adresseDomicile;
    }

    public void setAdresseDomicile(String adresseDomicile) {
        this.adresseDomicile = adresseDomicile;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
}
