package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.EpreuveClinique;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;

public class ShowEpreuveObs {

    @FXML
    private Button anamnese;

    @FXML
    private Button diagnostic;

    @FXML
    private Button epreuve;

    @FXML
    private Label nomBO;

    @FXML
    private Button projet;

    @FXML
    private TextFlow textField;

    @FXML
    void onAnamnese(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/show_anam.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onDiagnostic(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/show_diagnostic.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onEpreuve(ActionEvent event) throws IOException {

    }

    @FXML
    void onProjet(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/projet.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void initialize() {
        nomBO.setText("BO "+BoMain.bo.getId());
        epreuve.setDisable(true);
        // showing observations

        for(EpreuveClinique eprv : BoMain.bo.getEpreuveCliniques()){
            for(String obs : eprv.getObservations()){
                Text text = new Text(obs+"\n\n");
                textField.getChildren().add(text);
            }
        }

    }

}
