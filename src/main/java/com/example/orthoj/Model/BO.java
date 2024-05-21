package com.example.orthoj.Model;

import java.util.ArrayList;
import java.util.List;

public class BO {

    // attributes
    protected List<EpreuveClinique> epreuves;
    protected Diagnostic diagnostic;
    protected String projetTherapeutique;

    //constructor
    public BO(){
        epreuves = new ArrayList<EpreuveClinique>();
        diagnostic = new Diagnostic();
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
}
