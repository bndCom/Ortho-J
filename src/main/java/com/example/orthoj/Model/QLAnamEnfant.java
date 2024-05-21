package com.example.orthoj.Model;

import com.example.orthoj.Model.Enumeration.TypeQLAnamEnfant;

import java.util.List;

public class QLAnamEnfant extends QLAnam{

    // type of ql anamnese enfant
    private TypeQLAnamEnfant type;

    // constructors
    public QLAnamEnfant(TypeQLAnamEnfant type, List<String> questions){
        super(questions); // set the questions
        this.type = type;
    }



    public Object getType(){
        return this.type;
    }
}
