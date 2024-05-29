package com.example.orthoj.Model;

import com.example.orthoj.Model.DossierManagementPackage.Dossier;
import com.example.orthoj.Model.Patient.Patient;
import com.example.orthoj.Model.RendezVousManagement.Calendrier;
import com.example.orthoj.Model.RendezVousManagement.RendezVous;

import javax.swing.*;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CabinetChakib {
    LinkedList<Patient> listpatientsNonPrisEnCharge = new LinkedList<Patient>();
    LinkedList<Patient> patientsPrisEnCharge = new LinkedList<Patient>();

    LinkedList<Dossier> dossierLinkedList = new LinkedList<Dossier>();
    public RendezVous selectedRendezVous = null;

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
}
