package com.example.orthoj.Model;

import com.example.orthoj.Model.Enumeration.TypeQLAnamAdulte;

import java.util.List;

public class QLAnamAdulte extends QLAnam{

    // type of ql anamnese enfant
    private TypeQLAnamAdulte type;

    // constructors
    public QLAnamAdulte(TypeQLAnamAdulte type, List<String> questions){
        super(questions); // set the questions
        this.type = type;
    }
    public Object getType(){
        return this.type;
    }
}