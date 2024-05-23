package com.example.orthoj.Model.RendezVousManagement;


import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TreeMap;
import com.example.orthoj.Model.CustomException.*;

public class Main {
    public static void main(String args[]) throws InvalidRendezVousTimeClash {
        // testez si le rendez vous manager ( calendrier fonctionne in good condition ) ;
        ConsultationEnfant consultationEnfant = new ConsultationEnfant();
        ConsultationEnfant consultationEnfant1 = new ConsultationEnfant();
        LocalDateTime date = LocalDateTime.of(2020, 01, 01, 8, 30);
        consultationEnfant.setDateTime(date);
        consultationEnfant1.setDateTime(date.plusHours(1));

        Calendrier calendrier = new Calendrier();
        calendrier.AjouterRDV(consultationEnfant);
        calendrier.AjouterRDV(consultationEnfant1);
        System.out.println("yeah baby");
        System.out.println("boolean : " + calendrier.RendezVousExist(date));
        System.out.println("boolean : " + calendrier.RendezVousExist(date.plusHours(1)));




    }
}
