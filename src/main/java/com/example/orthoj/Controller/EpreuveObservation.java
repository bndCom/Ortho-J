package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.EpreuveClinique;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class EpreuveObservation {

    @FXML
    private TextArea newObs;

    @FXML
    private Button ajouter;

    @FXML
    private Button suivant;

    @FXML
    private TableView<String> observationTable;

    @FXML
    private TableColumn<String, String> observationColumn;

    @FXML
    void ajouterObs(ActionEvent event) throws IOException {
        // adding the observation to epreuve
        Main.epreuve.addObservation(newObs.getText());

        // reloading the table
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/epreuve_observation.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void suivant(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/epreuve_testQCM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void initialize() {
        // filling the table with observations
        observationColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()));
        if(!Main.epreuve.getObservations().isEmpty()){
            observationTable.setItems(FXCollections.observableArrayList(Main.epreuve.getObservations()));
        }
    }

}
