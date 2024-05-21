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
}
