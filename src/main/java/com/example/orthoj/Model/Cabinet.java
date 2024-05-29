package com.example.orthoj.Model;

import com.example.orthoj.Model.CustomException.NoUserException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Cabinet implements Serializable {

    //attributes
    private Orthophoniste orthophoniste;
    // questions templates
    private List<Question> questions;
    // list of questions of anamnese ( just a template (suggestions))
    List<String> qStructure;
    List<String> qDynamique;
    List<String> qEntecedent;
    List<String> qCondition;
    List<String> qPsycho;
    List<String> qLangagier;
    List<String> qCaractere;
    List<String> qHistoir;
    List<String> qSuivi;

    public void setqStructure(List<String> qStructure) {
        this.qStructure = qStructure;
    }

    public void setqDynamique(List<String> qDynamique) {
        this.qDynamique = qDynamique;
    }

    public void setqEntecedent(List<String> qEntecedent) {
        this.qEntecedent = qEntecedent;
    }

    public void setqCondition(List<String> qCondition) {
        this.qCondition = qCondition;
    }

    public void setqPsycho(List<String> qPsycho) {
        this.qPsycho = qPsycho;
    }

    public void setqCaractere(List<String> qCaractere) {
        this.qCaractere = qCaractere;
    }

    public void setqLangagier(List<String> qLangagier) {
        this.qLangagier = qLangagier;
    }

    public void setqHistoir(List<String> qHistoir) {
        this.qHistoir = qHistoir;
    }

    public void setqSuivi(List<String> qSuivi) {
        this.qSuivi = qSuivi;
    }

    //constructor
    public Cabinet() {
        this.questions = new ArrayList<Question>();
        // init questions
        qStructure = new LinkedList<>();
        qDynamique= new LinkedList<>();
        qEntecedent= new LinkedList<>();
        qCondition= new LinkedList<>();
        qPsycho= new LinkedList<>();
        qLangagier= new LinkedList<>();
        qCaractere= new LinkedList<>();
        qHistoir= new LinkedList<>();
        qSuivi= new LinkedList<>();
    }

    //setters
    public void signUp(Orthophoniste orthophoniste) {
        this.orthophoniste = orthophoniste;
    }

    // getters
    public Orthophoniste getOrthophoniste(){
        return this.orthophoniste;
    }
    public List<Question> getQuestions() {
        return questions;
    }

    public List<String> getqStructure() {
        return qStructure;
    }

    public List<String> getqDynamique() {
        return qDynamique;
    }

    public List<String> getqEntecedent() {
        return qEntecedent;
    }

    public List<String> getqCondition() {
        return qCondition;
    }

    public List<String> getqPsycho() {
        return qPsycho;
    }

    public List<String> getqLangagier() {
        return qLangagier;
    }

    public List<String> getqCaractere() {
        return qCaractere;
    }

    public List<String> getqHistoir() {
        return qHistoir;
    }

    public List<String> getqSuivi() {
        return qSuivi;
    }

    // login
    public boolean signIn(String email, String password) throws NoUserException{
        // checking if no doctor is in the app
        if ((this.orthophoniste == null) || (!this.orthophoniste.getEmail().equals(email)) || (!this.orthophoniste.verifyPassword(password))){
            throw new NoUserException();
        }
        return true;
    }

    // add new question
    public void addQuestion(Question question){
        this.questions.add(question);
    }

    // add new anamnese question
    public void addqStructure(String qStructure) {
        this.qStructure.add(qStructure);
    }
    public void addqDynamique(String qDynamique) {
        this.qDynamique.add(qDynamique);
    }

    public void addqEntecedent(String qEntecedent) {
        this.qEntecedent.add(qEntecedent);
    }

    public void addqCondition(String qCondition) {
        this.qCondition.add(qCondition);
    }

    public void addqPsycho(String qPsycho) {
        this.qPsycho.add(qPsycho);
    }

    public void addqLangagier(String qLangagier) {
        this.qLangagier.add(qLangagier);
    }

    public void addqCaractere(String qCaractere) {
        this.qCaractere.add(qCaractere);
    }

    public void addqHistoir(String qHistoir) {
        this.qHistoir.add(qHistoir);
    }

    public void addqSuivi(String qSuivi) {
        this.qSuivi.add(qSuivi);
    }

    // delete a question
    public void removeQuestion(Question question){
        this.questions.remove(question);
    }
}
