package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.EpreuveClinique;
import com.example.orthoj.Model.Test;
import com.example.orthoj.Model.TestExercice;
import com.example.orthoj.Model.TestQuestion;
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
import java.util.ArrayList;
import java.util.List;

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

    static EpreuveClinique epreuve;
    private List<String> observations;

    @FXML
    void ajouterObs(ActionEvent event) throws IOException {
        // adding the observation to the observations list
        observations.add(newObs.getText());
        // update the table
        observationTable.getItems().add(newObs.getText());

    }

    @FXML
    void suivant(ActionEvent event) throws IOException {
        // update les epreuves
        epreuve.setObservations(observations);
        // load the next stage
//        EpreuveTest.testQuestion = new TestQuestion();
//        EpreuveTest.testExercise = new TestExercice();
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/test_choix.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void initialize() {
        // filling the table with observations
        observationColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()));
        // init epreuve
        epreuve = new EpreuveClinique();
        observations = new ArrayList<String>();

    }

}
