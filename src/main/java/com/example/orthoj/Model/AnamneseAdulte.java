package com.example.orthoj.Model;

import com.example.orthoj.Model.CustomException.*;
import com.example.orthoj.Model.Enumeration.TypeQLAnamAdulte;

import java.util.List;


public class AnamneseAdulte extends Anamnese{
    // attributes
    private QLAnamAdulte[] questions;

    // constructor
    public AnamneseAdulte(){
        this.questions = new QLAnamAdulte[2];
    }

    // setters
    public void setQLHistoire(QLAnamAdulte ql) throws InvalidAnamQuestionType, QuestionNotAnswered {
        if(!ql.getState()){
            throw new QuestionNotAnswered();
        }
        // check if the type is the suitable type for this method
        if(ql.getType() != TypeQLAnamAdulte.HISTOIRE){
            throw new InvalidAnamQuestionType();
        }
        this.questions[0] = ql;
    }

    public void setQLSuiviMedical(QLAnamAdulte ql) throws InvalidAnamQuestionType, QuestionNotAnswered {
        if(!ql.getState()){
            throw new QuestionNotAnswered();
        }
        // check if the type is the suitable type for this method
        if(ql.getType() != TypeQLAnamAdulte.SUIVI_MEDICAL){
            throw new InvalidAnamQuestionType();
        }
        this.questions[1] = ql;
    }

    // getters
    public QLAnamAdulte getQLHistoire(){
        return this.questions[0];
    }

    public QLAnamAdulte getQLSuiviMedical(){
        return this.questions[1];
    }

    public QLAnamAdulte[] getQuestions(){
        return this.questions;
    }
}
