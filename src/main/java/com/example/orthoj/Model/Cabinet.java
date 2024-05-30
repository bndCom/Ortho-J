package com.example.orthoj.Model;

import com.example.orthoj.Model.CustomException.NoUserException;
import com.example.orthoj.Model.DossierManagementPackage.Dossier;
import com.example.orthoj.Model.Patient.Patient;
import com.example.orthoj.Model.RendezVousManagement.Calendrier;
import com.example.orthoj.Model.RendezVousManagement.RendezVous;

import java.io.Serializable;
import java.util.*;

public class Cabinet implements Serializable {

    LinkedList<Patient> listpatientsNonPrisEnCharge = new LinkedList<Patient>();
    LinkedList<Patient> patientsPrisEnCharge = new LinkedList<Patient>();

    LinkedList<Dossier> dossierLinkedList = new LinkedList<Dossier>();
    public RendezVous selectedRendezVous = null;

    public Dossier selectedDossier = null;

    public Dossier getSelectedDossier() {
        return selectedDossier;
    }

    public void setSelectedDossier(Dossier selectedDossier) {
        this.selectedDossier = selectedDossier;
    }

    public void setSelectedRendezVous(RendezVous selectedRendezVous) {
        this.selectedRendezVous = selectedRendezVous;
    }

    public RendezVous getSelectedRendezVous() {
        return selectedRendezVous;
    }

    public void insertPatient(Patient patient){
        listpatientsNonPrisEnCharge.add(patient);
    }



    public Patient getPatient(String nom , String prenom , String numtel){
        Iterator<Patient> iterator = listpatientsNonPrisEnCharge.iterator();
        Patient currentPatient = iterator.next();
        if (currentPatient.getNom().equals(nom) && currentPatient.getPrenom().equals(prenom) && currentPatient.getNumTel().equals(numtel) ){
            return currentPatient;
        }
        return null;
    }
    Calendrier calendrier = new Calendrier();

    public Calendrier getCalendrier(){
        return calendrier;
    }

    public void setCalendrier(Calendrier calendrier){
        this.calendrier = calendrier;
    }

    public void ajouterDossier(Dossier dossier){

        dossierLinkedList.add(dossier);

    }

    public LinkedList<Dossier> getLinkedListDossier(){
        return dossierLinkedList;

    }

    public Dossier dossierExist(int num ){
        Dossier dossier = null;
        for (Dossier dossier1 : dossierLinkedList){
            if (dossier1.getNbDossier() == num)
            {
                dossier = dossier1;
                break;
            }

        }
        return dossier;
    }

    public LinkedList<Patient> getPatientsNonPrisEnCharge() {
        return listpatientsNonPrisEnCharge;
    }

    public void setPatientsNonPrisEnCharge(LinkedList<Patient> patientsNonPrisEnCharge) {
        this.listpatientsNonPrisEnCharge = patientsNonPrisEnCharge;
    }

    public Dossier getDossierById(int id){
        for(Dossier dossier : dossierLinkedList){
            if (dossier.getNbDossier() == id){
                return dossier;
            }
        }
        return null;
    }
    // add a BO to an existing dossier
    public void addBOToDossier(BO bo, int num){
        for (Dossier dossier : this.dossierLinkedList){
            if (dossier.getNbDossier() == num){
                dossier.addBO(bo);
                break;
            }
        }
    }
    // add premier bo to patient
    public void addPremierBO(PremierBO premierBO,Patient patient){
        for (Dossier dossier : dossierLinkedList){
            if(dossier.getPatient().equals(patient)){
                dossier.addPremierBO(premierBO);
            }
        }
    }
    // add dossier
    public void addDossier(Dossier dossier){
        this.dossierLinkedList.add(dossier);
    }

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
