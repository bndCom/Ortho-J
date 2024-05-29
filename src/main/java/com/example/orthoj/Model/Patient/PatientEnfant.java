package com.example.orthoj.Model.Patient;

import com.example.orthoj.Model.RendezVousManagement.ConsultationEnfant;
import com.example.orthoj.Model.RendezVousManagement.RendezVous;

import java.util.LinkedList;

public class PatientEnfant  extends  Patient{
    String Classe ;
    String nomPere ;
    String prenomPere;
    String nomMere ;
    String prenomMere ;
    String numPapa ;
    String numMama ;

    LinkedList<RendezVous> rendezVousLinkedList = new LinkedList<RendezVous>();
    public ConsultationEnfant getConsultationEnfant() {
        return consultationEnfant;
    }

    public void setConsultationEnfant(ConsultationEnfant consultationEnfant) {
        this.consultationEnfant = consultationEnfant;
        rendezVousLinkedList.add(consultationEnfant);
    }



    ConsultationEnfant consultationEnfant;

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }

    public String getNomPere() {
        return nomPere;
    }

    public void setNomPere(String nomPere) {
        this.nomPere = nomPere;
    }

    public String getPrenomPere() {
        return prenomPere;
    }

    public void setPrenomPere(String prenomPere) {
        this.prenomPere = prenomPere;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public String getPrenomMere() {
        return prenomMere;
    }

    public void setPrenomMere(String prenomMere) {
        this.prenomMere = prenomMere;
    }

    public String getNumPapa() {
        return numPapa;
    }

    public void setNumPapa(String numPapa) {
        this.numPapa = numPapa;
    }

    public String getNumMama() {
        return numMama;
    }

    public void setNumMama(String numMama) {
        this.numMama = numMama;
    }

    public String getType(){
        return "Enfant";
    }
}
