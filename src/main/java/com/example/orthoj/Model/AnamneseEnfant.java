package com.example.orthoj.Model;

import com.example.orthoj.Model.CustomException.*;
import com.example.orthoj.Model.Enumeration.TypeQLAnamEnfant;

public class AnamneseEnfant extends Anamnese{
    // attributes
    private QLAnamEnfant[] questions;

    // constructor
    public AnamneseEnfant(){
        this.questions = new QLAnamEnfant[7];
    }

    // setters
    public void setQLStructureFamilale(QLAnamEnfant ql) throws InvalidAnamQuestionType, QuestionNotAnswered {
        if(!ql.getState()){
            throw new QuestionNotAnswered();
        }
        // check if the type is the suitable type for this method
        if(ql.getType() != TypeQLAnamEnfant.STRUCTURE_FAMILIALE){
            throw new InvalidAnamQuestionType();
        }
        this.questions[0] = ql;
    }

    public void setQLDynamicFamilale(QLAnamEnfant ql) throws InvalidAnamQuestionType, QuestionNotAnswered {
        if(!ql.getState()){
            throw new QuestionNotAnswered();
        }
        // check if the type is the suitable type for this method
        if(ql.getType() != TypeQLAnamEnfant.DYNAMIQUE_FAMILIALE){
            throw new InvalidAnamQuestionType();
        }
        this.questions[1] = ql;
    }

    public void setQLAntecedentsFamiliaux(QLAnamEnfant ql) throws InvalidAnamQuestionType, QuestionNotAnswered {
        if(!ql.getState()){
            throw new QuestionNotAnswered();
        }
        // check if the type is the suitable type for this method
        if(ql.getType() != TypeQLAnamEnfant.ANTECEDENTS_FAMILIAUX){
            throw new InvalidAnamQuestionType();
        }
        this.questions[2] = ql;
    }

    public void setQLConditionsNatales(QLAnamEnfant ql) throws InvalidAnamQuestionType, QuestionNotAnswered {
        if(!ql.getState()){
            throw new QuestionNotAnswered();
        }
        // check if the type is the suitable type for this method
        if(ql.getType() != TypeQLAnamEnfant.CONDITIONS_NATALES){
            throw new InvalidAnamQuestionType();
        }
        this.questions[3] = ql;
    }

    public void setQLDeveloppementPsychomoteurs(QLAnamEnfant ql) throws InvalidAnamQuestionType, QuestionNotAnswered {
        if(!ql.getState()){
            throw new QuestionNotAnswered();
        }
        // check if the type is the suitable type for this method
        if(ql.getType() != TypeQLAnamEnfant.DEVELOPPEMENT_PSYCHOMOTEURS){
            throw new InvalidAnamQuestionType();
        }
        this.questions[4] = ql;
    }

    public void setQLDeveloppementLanguagier(QLAnamEnfant ql) throws InvalidAnamQuestionType, QuestionNotAnswered {
        if(!ql.getState()){
            throw new QuestionNotAnswered();
        }
        // check if the type is the suitable type for this method
        if(ql.getType() != TypeQLAnamEnfant.DEVELOPPEMENT_LANGAGIER){
            throw new InvalidAnamQuestionType();
        }
        this.questions[5] = ql;
    }

    public void setQLCaractereComportement(QLAnamEnfant ql) throws InvalidAnamQuestionType, QuestionNotAnswered {
        if(!ql.getState()){
            throw new QuestionNotAnswered();
        }
        // check if the type is the suitable type for this method
        if(ql.getType() != TypeQLAnamEnfant.CARACTERE_COMPORTEMENT){
            throw new InvalidAnamQuestionType();
        }
        this.questions[6] = ql;
    }

    // getters
    public QLAnamEnfant getQLStructureFamilale(){
        return this.questions[0];
    }

    public QLAnamEnfant getQLDynamicFamilale(){
        return this.questions[1];
    }

    public QLAnamEnfant getQLAntecedentsFamiliaux(){
        return this.questions[2];
    }

    public QLAnamEnfant getQLConditionsNatales(){
        return this.questions[3];
    }

    public QLAnamEnfant getQLDeveloppementPsychomoteurs(){
        return this.questions[4];
    }

    public QLAnamEnfant getQLDeveloppementLanguagier(){
        return this.questions[5];
    }

    public QLAnamEnfant getQLCaractereComportement(){
        return this.questions[6];
    }

    public QLAnamEnfant[] getQuestions(){
        return this.questions;
    }

}
