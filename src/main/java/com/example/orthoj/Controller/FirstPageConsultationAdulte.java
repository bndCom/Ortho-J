package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.Patient.PatientAdulte;
import com.example.orthoj.Model.Patient.PatientEnfant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.MinguoChronology;

public class FirstPageConsultationAdulte {
    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField diplome;

    @FXML
    private TextField profession;

    @FXML
    private DatePicker date;

    @FXML
    private TextField adresse;

    @FXML
    private TextField lieu;

    @FXML
    private  TextField numtel;

    @FXML
    private Button suivant;


    @FXML
    public void initialize(){
        nom.setText(Main.cabinet.getSelectedRendezVous().getPatient().getNom());
        prenom.setText(Main.cabinet.getSelectedRendezVous().getPatient().getPrenom());
        numtel.setText(Main.cabinet.getSelectedRendezVous().getPatient().getNumTel());

    }

    @FXML
    public void onSuivant(ActionEvent event) throws IOException {
        Main.cabinet.getSelectedRendezVous().getPatient().setNom(nom.getText());
        Main.cabinet.getSelectedRendezVous().getPatient().setPrenom(prenom.getText());

        Main.cabinet.getSelectedRendezVous().getPatient().setAge(calculateAge(date.getValue()));
        Main.cabinet.getSelectedRendezVous().getPatient().setDateDeNaissance(date.getValue());
        Main.cabinet.getSelectedRendezVous().getPatient().setLieuDeNaissance(lieu.getText());
        Main.cabinet.getSelectedRendezVous().getPatient().setAdresse(adresse.getText());
        Main.cabinet.getSelectedRendezVous().getPatient().setNumTel(numtel.getText());
        ((PatientAdulte) Main.cabinet.getSelectedRendezVous().getPatient()).setProfession(profession.getText());
        ((PatientAdulte) Main.cabinet.getSelectedRendezVous().getPatient()).setDiplome(diplome.getText());

        // set the patient
        ProjetTherapeutique.patient = Main.cabinet.getSelectedRendezVous().getPatient();
        // loading first bo
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/anam_choix.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();






    }


    public static int calculateAge(LocalDate birthDate) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Check if birthDate is not null and before the current date
        if (birthDate != null && birthDate.isBefore(currentDate)) {
            // Calculate the period between the birth date and the current date
            Period period = Period.between(birthDate, currentDate);

            // Return the years part of the period
            return period.getYears();
        } else {
            // Handle cases where birthDate is null or in the future
            throw new IllegalArgumentException("Birth date is invalid.");
        }
    }


}
