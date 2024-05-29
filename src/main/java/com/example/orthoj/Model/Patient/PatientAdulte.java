package com.example.orthoj.Model.Patient;

import com.example.orthoj.Model.RendezVousManagement.ConsultaionAdulte;
import com.example.orthoj.Model.RendezVousManagement.RendezVous;

import java.util.LinkedList;

public class PatientAdulte extends Patient {
    String Diplome ;
    String Numtel ;
    String Profession ;


    public String getDiplome() {
        return Diplome;
    }

    public void setDiplome(String diplome) {
        Diplome = diplome;
    }

    public String getNumtel() {
        return Numtel;
    }

    public void setNumtel(String numtel) {
        Numtel = numtel;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public ConsultaionAdulte getConsultaionAdulte() {
        return consultaionAdulte;
    }

    public void setConsultaionAdulte(ConsultaionAdulte consultaionAdulte) {
        this.consultaionAdulte = consultaionAdulte;
    }

    public String getType(){
        return "Adulte";
    }

    ConsultaionAdulte consultaionAdulte  ;



}
