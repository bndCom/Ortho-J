package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.Anamnese;
import com.example.orthoj.Model.AnamneseAdulte;
import com.example.orthoj.Model.AnamneseEnfant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class AnamChoix {

    @FXML
    private Button adulte;

    @FXML
    private Button enfant;

    @FXML
    private Button suivant;

    static AnamneseEnfant anamEnfant;
    static AnamneseAdulte anamAdulte;

    @FXML
    void onAdulte(ActionEvent event) throws IOException {
        // init anam
        anamAdulte = new AnamneseAdulte();
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/adulte_anam.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onEnfant(ActionEvent event) throws IOException {
        anamEnfant = new AnamneseEnfant();
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/enfant_anam.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onSuivant(ActionEvent event) {

    }

}
