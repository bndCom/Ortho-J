package com.example.orthoj.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BO implements Serializable {

    // attributes
    protected List<EpreuveClinique> epreuves;
    protected Diagnostic diagnostic;
    protected String projetTherapeutique;
    private static int id = 0;

    //constructor
    public BO(){
        epreuves = new ArrayList<EpreuveClinique>();
        diagnostic = new Diagnostic();
        this.id++;
    }

    // setters
    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    public void setProjetTherapeutique(String projetTherapeutique) {
        this.projetTherapeutique = projetTherapeutique;
    }

    // add new Epreuve
    public void addEpreuveClinique(EpreuveClinique ep) {
        epreuves.add(ep);
    }

    // getters
    public int getId(){
        return id;
    }
    public String getProjetTherapeutique(){
        return projetTherapeutique;
    }
    public Diagnostic getDiagnostic(){
        return diagnostic;
    }
    public List<EpreuveClinique> getEpreuveCliniques(){
        return epreuves;
    }
    // get all troubles
    public List<Trouble> getTroubles(){
        return diagnostic.getTroubles();
    }
}
