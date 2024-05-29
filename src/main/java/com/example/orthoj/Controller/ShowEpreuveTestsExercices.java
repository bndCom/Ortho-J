package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.Exercice;
import com.example.orthoj.Model.TestExercice;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class ShowEpreuveTestsExercices {

    @FXML
    private Button anamnese;

    @FXML
    private Button diagnostic;

    @FXML
    private Button epreuve;

    @FXML
    private TableView<Exercice> exercicesTable;

    @FXML
    private TableColumn<Exercice, String> materielColumn;

    @FXML
    private Label nomBO;

    @FXML
    private TableColumn<Exercice, String> nomColumn;

    @FXML
    private Button projet;

    @FXML
    private TableColumn<Exercice, String> scoreColumn;

    public static TestExercice test;

    @FXML
    void onAnamnese(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/show_anam.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onDiagnostic(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/show_diagnostic.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onEpreuve(ActionEvent event) throws IOException {

    }

    @FXML
    void onProjet(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/projet.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void initialize(){
        nomBO.setText("BO "+BoMain.bo.getId());
        epreuve.setDisable(true);
        // init table
        nomColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        materielColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMateriel()));
        scoreColumn.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getScore())));
        // filling the table
        for(Exercice exercice : test.getExercices()) {
            exercicesTable.getItems().add(exercice);
        }
    }

}
