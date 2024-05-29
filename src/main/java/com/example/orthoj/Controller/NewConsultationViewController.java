package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Main;
import com.example.orthoj.Model.CustomException.InvalidRendezVousTimeClash;
import com.example.orthoj.Model.Patient.Patient;
import com.example.orthoj.Model.Patient.PatientAdulte;
import com.example.orthoj.Model.Patient.PatientEnfant;
import com.example.orthoj.Model.RendezVousManagement.Calendrier;
import com.example.orthoj.Model.RendezVousManagement.ConsultaionAdulte;
import com.example.orthoj.Model.RendezVousManagement.ConsultationEnfant;
import com.example.orthoj.Model.RendezVousManagement.RendezVous;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
//import  jfxtras.scene.control.*;
import javafx.beans.*;
import javafx.util.converter.LocalDateStringConverter;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.text.LabelView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.SequencedSet;

public class NewConsultationViewController{

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField age;

    @FXML
    private TextField numTel;

    @FXML
    private DatePicker date;

   // @FXML
    //private LocalTimeTextField temp;

    @FXML
    private RadioButton adulte;

    @FXML
    private RadioButton enfant;

    @FXML
    private TextField min ;

    @FXML
    private TextField heure;

    @FXML
    private ToggleGroup grp1;


//    public void initialize(URL location, ResourceBundle resources) {
//        // Add a listener to ensure only numeric input
//        age.textProperty().addListener((observable, oldValue, newValue) -> {
//            if (!newValue.matches("\\d*")) {
//                age.setText(newValue.replaceAll("[^\\d]", ""));
//            }
//        });}





    public void SaveNewConsultation(javafx.event.ActionEvent actionEvent) {
    RadioButton selectedRadioButton = ( RadioButton) grp1.getSelectedToggle();
    String selectedValue = selectedRadioButton.getText();
    System.out.println("*************");
    System.out.print(selectedValue);
    System.out.println("");
    if(selectedValue.equals("Enfant")){
        PatientEnfant patientEnfant = new PatientEnfant();
        patientEnfant.setNom(nom.getText());
        patientEnfant.setPrenom(prenom.getText());
        patientEnfant.setAge(Integer.parseInt(age.getText()));
        patientEnfant.setNumTel(numTel.getText());
        ConsultationEnfant consultationEnfant = new ConsultationEnfant();
        consultationEnfant.setDateTime(LocalDateTime.of(date.getValue().getYear() , date.getValue().getMonth() , date.getValue().getDayOfMonth(), Integer.parseInt(heure.getText()), Integer.parseInt(min.getText()) ));
        patientEnfant.setConsultationEnfant(consultationEnfant);
        consultationEnfant.setPatient(patientEnfant);
        // we should probably save this somewhere ?
        Calendrier calendrier = Main.cabinet.getCalendrier();
        try {
            calendrier.AjouterRDV((RendezVous) consultationEnfant);
        } catch (InvalidRendezVousTimeClash e) {
            throw new RuntimeException(e);
        }
        Main.cabinet.setCalendrier(calendrier);
        Main.cabinet.insertPatient(patientEnfant);
        consultationEnfant.getClass();

    }else {
        PatientAdulte patientEnfant = new PatientAdulte();
        patientEnfant.setNom(nom.getText());
        patientEnfant.setPrenom(prenom.getText());
        patientEnfant.setAge(Integer.parseInt(age.getText()));
        patientEnfant.setNumTel(numTel.getText());
        ConsultaionAdulte consultationEnfant = new ConsultaionAdulte();
        consultationEnfant.setDateTime(LocalDateTime.of(date.getValue().getYear() , date.getValue().getMonth() , date.getValue().getDayOfMonth(), Integer.parseInt(heure.getText()), Integer.parseInt(min.getText()) ));
        patientEnfant.setConsultaionAdulte(consultationEnfant);
        consultationEnfant.setPatient(patientEnfant);
        // we should probably save this somewhere ?
        Calendrier calendrier = Main.cabinet.getCalendrier();
        try {
            calendrier.AjouterRDV((RendezVous) consultationEnfant);
        } catch (InvalidRendezVousTimeClash e) {
            throw new RuntimeException(e);
        }

        Main.cabinet.setCalendrier(calendrier);
        Main.cabinet.insertPatient(patientEnfant);
        consultationEnfant.getClass();


    }

        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/CalendrierMain.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Main.stage.setScene(scene);
        Main.stage.show();


    }





    public void BackToCalendrier(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/CalendrierMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }


}
