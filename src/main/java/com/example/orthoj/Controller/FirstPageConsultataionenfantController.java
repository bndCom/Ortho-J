package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.AnamneseEnfant;
import com.example.orthoj.Model.DossierManagementPackage.Dossier;
import com.example.orthoj.Model.Patient.PatientEnfant;
import com.example.orthoj.Model.RendezVousManagement.Consultaion;
import com.example.orthoj.Model.RendezVousManagement.ConsultationEnfant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class FirstPageConsultataionenfantController {
    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField numtelpapa;

    @FXML
    private TextField numtelmama;

    @FXML
    private DatePicker date;

    @FXML
    private TextField adresse;

    @FXML
    private TextField lieu;

    @FXML
    private  TextField classe;

    @FXML
    private Button suivant;


    @FXML
    private CheckBox creerDossier;

    // @FXML
    //private LocalTimeTextField temp;

    @FXML
    public void initialize(){
        nom.setText(Main.cabinet.getSelectedRendezVous().getPatient().getNom());
        prenom.setText(Main.cabinet.getSelectedRendezVous().getPatient().getPrenom());

    }

    @FXML
    public void onSuivant(ActionEvent event) throws IOException {
        Main.cabinet.getSelectedRendezVous().getPatient().setNom(nom.getText());
        Main.cabinet.getSelectedRendezVous().getPatient().setPrenom(prenom.getText());

        Main.cabinet.getSelectedRendezVous().getPatient().setAge(calculateAge(date.getValue()));
        ((PatientEnfant) Main.cabinet.getSelectedRendezVous().getPatient()).setNumPapa(numtelpapa.getText());
        ((PatientEnfant) Main.cabinet.getSelectedRendezVous().getPatient()).setNumPapa(numtelmama.getText());
        ((PatientEnfant) Main.cabinet.getSelectedRendezVous().getPatient()).setClasse(classe.getText());
        Main.cabinet.getSelectedRendezVous().getPatient().setDateDeNaissance(date.getValue());
        Main.cabinet.getSelectedRendezVous().getPatient().setLieuDeNaissance(lieu.getText());
        Main.cabinet.getSelectedRendezVous().getPatient().setAdresse(adresse.getText());
        // set the patient
        ProjetTherapeutique.patient = Main.cabinet.getSelectedRendezVous().getPatient();
        // add dossier if prise en charge
        if(creerDossier.isSelected()){
            Dossier dossier = new Dossier((Consultaion) Main.cabinet.getSelectedRendezVous());
            Main.cabinet.addDossier(dossier);
        }

        // loading first bo
        AnamChoix.anamEnfant = new AnamneseEnfant();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/enfant_anam.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
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
