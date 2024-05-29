package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.Orthophoniste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
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
    private Button ajouterBO;

    @FXML
    private Button listeBO;

    @FXML
    private Button questions;

    @FXML
    private Button anam;

    @FXML
    void onAjouterBO(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/anam_choix.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onListeBO(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/list_bo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }


    @FXML
    void initialize(){
        // getting the doctor of the cabinet
        Orthophoniste doctor = Main.cabinet.getOrthophoniste();
        if(doctor != null){
            // showing info of the doctor
            nom.setText(doctor.getNom());
            prenom.setText(doctor.getPrenom());
            email.setText(doctor.getEmail());
            telephone.setText(doctor.getTelephone());
            adresse.setText(doctor.getAddress());
            password.setText(doctor.getPassword());
        }


    }


    @FXML
    void onQuestions(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/questions_home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }


    @FXML
    void onAnam(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/anam_type_home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }


}
