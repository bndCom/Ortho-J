package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.Orthophoniste;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard{

    @FXML
    private Label adresse;

    @FXML
    private Label email;

    @FXML
    private Label nom;

    @FXML
    private Label password;

    @FXML
    private Label prenom;

    @FXML
    private Label telephone;


    @FXML
    void initialize(){
        // getting the doctor of the cabinet
        Orthophoniste doctor = Main.cabinet.getOrthophoniste();
        // showing info of the doctor
        nom.setText(doctor.getNom());
        prenom.setText(doctor.getPrenom());
        email.setText(doctor.getEmail());
        telephone.setText(doctor.getTelephone());
        adresse.setText(doctor.getAddress());
        password.setText(doctor.getPassword());

    }


}
