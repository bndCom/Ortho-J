package com.example.orthoj.Model;

import java.util.ArrayList;
import java.util.List;

public class Diagnostic {

    // attributes
    private List<Trouble> troubles;

    // constructor
    public Diagnostic() {
        this.troubles = new ArrayList<Trouble>();
    }

    // add a new trouble
    public void addTrouble(Trouble trouble){
        this.troubles.add(trouble);
    }

    public void setTroubles(List<Trouble> troubles) {
        this.troubles = troubles;
    }

    public List<Trouble> getTroubles() {
        return troubles;
    }
}
