package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class PatientProfile {

    @FXML
    private Button bo;

    @FXML
    private Button fiche;

    @FXML
    private Button information;

    @FXML
    private Button progression;

    @FXML
    private Button rdv;
    // ----------------------------------------------
    public static Dossier dossier;

    @FXML
    void onBo(ActionEvent event) throws IOException {
        //ListBo.list = dossier.getBO();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/list_bo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onFiche(ActionEvent event) {

    }

    @FXML
    void onInformation(ActionEvent event) {

    }

    @FXML
    void onProgression(ActionEvent event) {

    }

    @FXML
    void onRdv(ActionEvent event) {

    }

}
