package com.example.orthoj.Model;

public class Orthophoniste {

    // attributes
    private String nom;
    private String prenom;
    private String address;
    private String telephone;
    private String email;
    private String password;

    // constructor
    public Orthophoniste(String nom, String prenom, String address, String telephone, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
    }
    // setters
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
