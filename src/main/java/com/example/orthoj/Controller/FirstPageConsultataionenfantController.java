package com.example.orthoj.Controller;

import com.example.orthoj.MainChakib;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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

    // @FXML
    //private LocalTimeTextField temp;

    @FXML
    public void initialize(){
        nom.setText(MainChakib.cabinet.getSelectedRendezVous().getPatient().getNom());
        prenom.setText(MainChakib.cabinet.getSelectedRendezVous().getPatient().getPrenom());

    }

}
