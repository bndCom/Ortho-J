package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.Exercice;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EpreuveTestExercice {

    @FXML
    private Button ajouter;

    @FXML
    private TableView<Exercice> exerTable;

    @FXML
    private TableColumn<Exercice, String> materielColumn;

    @FXML
    private TextField materielField;

    @FXML
    private TableColumn<Exercice, String> nomColumn;

    @FXML
    private TextField nomField;

    @FXML
    private TableColumn<Exercice, Integer> scoreColumn;

    @FXML
    private TextField scoreField;

    @FXML
    private Button suivant;

    @FXML
    private TextField testNom;

    static List<Exercice> exercices;

    @FXML
    void onAjouter(ActionEvent event) {
        Exercice exercice = new Exercice(nomField.getText(), materielField.getText());
        try{
            exercice.setScore(Integer.parseInt(scoreField.getText()));
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Erreur");
            String errorMessage = "Score n'est pas valid";
            alert.setContentText(errorMessage);
            alert.showAndWait();
        }
        // add the exercise to the array
        exercices.add(exercice);
        // add the exercise to the table
        exerTable.getItems().add(exercice);
    }

    @FXML
    void onSuivant(ActionEvent event) throws IOException {
        TestChoix.testExercice.setExercices(exercices);
        TestChoix.testExercice.setNom(testNom.getText());
        EpreuveObservation.epreuve.addTest(TestChoix.testExercice);

        // loading the test choice stage
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/test_choix.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void initialize() {
        // init table
        nomColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        materielColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMateriel()));
        scoreColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getScore()).asObject());

        exercices = new ArrayList<>();
    }

}
