package com.example.orthoj.Model;

public class PremierBO extends BO{

    // special attribute
    private Anamnese anamnese;

    public PremierBO() {
        super();
    }

    // setters
    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
    }
}
