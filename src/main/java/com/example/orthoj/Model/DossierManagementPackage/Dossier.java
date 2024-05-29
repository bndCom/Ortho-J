package com.example.orthoj.Model.DossierManagementPackage;

import com.example.orthoj.Model.FicheDeSuiviPackage.*;

import com.example.orthoj.Model.Patient.Patient;
import com.example.orthoj.Model.RendezVousManagement.*;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class Dossier {
//    String nom ;
//    String prenom ;
//    String NumTel ;
//    int age ;

    private static int counter = 1;
    private int NbDossier ;
    FicheDeSuivi FicheDeSuiviCourante ;
    Patient patient;

    // Bilan ortophonique courant si on en a besoin ;


    LinkedList<FicheDeSuivi> ListFicheDeSuivi = new LinkedList<FicheDeSuivi>();
    // ajouter le bilan ortophonique
    // !!!!!!!!!!!!!!!! Do not forget
    LinkedList<RendezVous> ListDeRendezVousTotale = new LinkedList<RendezVous>();




    // assigning the NbDossier in a way that ensures no collision
    public Dossier(Consultaion consultaion){

        NbDossier = counter + 1 ;
        counter++;
        patient = consultaion.getPatient();
    }

    public int getNbDossier() {
        return NbDossier;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }

    public Patient getPatient(){
        return patient;
    }

    public void addRendezVous(RendezVous rendezVous){
        ListDeRendezVousTotale.add(rendezVous);
    }

    public LinkedList<RendezVous> getRendezVousListe(){
        return ListDeRendezVousTotale;
    }

    public void setListDeRendezVousTotale(LinkedList<RendezVous> listDeRendezVousTotale) {
        ListDeRendezVousTotale = listDeRendezVousTotale;
    }
}
