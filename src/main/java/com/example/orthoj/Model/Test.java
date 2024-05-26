package com.example.orthoj.Model;

/**
 * Test class is for managing session questions and suggested exercices
 * @author bnd-cboumi
 */
abstract public class Test {
    // attributes
    protected String nom;
    protected int scoreTotal;

    // abstract method
    abstract public int calcTestScore();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }
}
