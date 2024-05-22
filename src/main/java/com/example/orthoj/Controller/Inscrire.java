package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.Orthophoniste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.example.orthoj.Main;

import java.io.IOException;

public class Inscrire {

    @FXML
    private TextField adresse;

    @FXML
    private TextField email;

    @FXML
    private Label inscrireLable;

    @FXML
    private TextField nom;

    @FXML
    private TextField password;

    @FXML
    private TextField prenom;

    @FXML
    private Button signupBtn;

    @FXML
    private TextField telephone;

    @FXML
    private Label status;

    @FXML
    void signUp(ActionEvent event) throws IOException, InterruptedException {
        Orthophoniste doctor = new Orthophoniste(nom.getText(), prenom.getText(), adresse.getText(), telephone.getText(), email.getText(), password.getText());
        Main.cabinet.signUp(doctor);
        status.setText("Success");

        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/connecter.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();

    }

}
