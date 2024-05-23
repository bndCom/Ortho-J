package com.example.orthoj.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalendrierController {

    @FXML
    void NewAtelier(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(""));
        Parent root = loader.load();

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    void NewConsultation(ActionEvent event) {

    }

    @FXML
    void NewSuivi(ActionEvent event) {

    }

}
