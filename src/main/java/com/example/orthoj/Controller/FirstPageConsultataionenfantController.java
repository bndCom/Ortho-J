package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.Patient.PatientEnfant;
import com.example.orthoj.Model.RendezVousManagement.ConsultationEnfant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;

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
    private  TextField classe;

    @FXML
    private Button suivant;

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
        Main.cabinet.getSelectedRendezVous().getPatient().setAge(19);
        ((PatientEnfant) Main.cabinet.getSelectedRendezVous().getPatient()).setNumPapa(numtelpapa.getText());
        ((PatientEnfant) Main.cabinet.getSelectedRendezVous().getPatient()).setNumPapa(numtelmama.getText());
        ((PatientEnfant) Main.cabinet.getSelectedRendezVous().getPatient()).setClasse(classe.getText());
        // set the patient
        ProjetTherapeutique.patient = Main.cabinet.getSelectedRendezVous().getPatient();
        // loading first bo
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/anam_choix.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();






    }

}
