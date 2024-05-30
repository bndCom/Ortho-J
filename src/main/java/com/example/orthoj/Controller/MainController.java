package com.example.orthoj.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import com.example.orthoj.Main;

import java.io.IOException;

public class MainController {

    @FXML
    private Button inscrire;

    @FXML
    private Button connecter;

    @FXML
    void getInscrireView(ActionEvent event) throws IOException {
        // loading the signup page
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/inscrire.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void getConnecterView(ActionEvent event) throws IOException {
        // loading the login page
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/connecter.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

}
