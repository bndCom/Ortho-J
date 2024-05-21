package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.CustomException.NoUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Connecter {

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private Label status;

    @FXML
    void connecter(ActionEvent event) throws IOException {
        // checking the email and password
        boolean success = false;
        try{
            success = Main.cabinet.signIn(email.getText(), password.getText());
        }catch (NoUserException e){
            status.setText("email ou mot de passe incorrect");
        }

        // success
        if(success){
            // loading the dashboard
            FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Main.stage.setScene(scene);
            Main.stage.show();
        }
    }

}
