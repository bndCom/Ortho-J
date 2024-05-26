package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.CompteRenduQCM;
import com.example.orthoj.Model.CustomException.QuestionNotAnswered;
import com.example.orthoj.Model.QCM;
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

public class ShowEpreuveTestsQuestionsQCM {

    @FXML
    private Button anamnese;

    @FXML
    private TableColumn<CompteRenduQCM, String> choisisColumn;

    @FXML
    private TableColumn<CompteRenduQCM, String> choixColumn;

    @FXML
    private TableColumn<CompteRenduQCM, String> correctColumn;

    @FXML
    private Button diagnostic;

    @FXML
    private Button epreuve;

    @FXML
    private TableView<CompteRenduQCM> exercicesTable;

    @FXML
    private Label nomBO;

    @FXML
    private Button projet;

    @FXML
    private TableColumn<CompteRenduQCM, String> questionsColumn;

    @FXML
    private TableColumn<CompteRenduQCM, String> scoreColumn;

    public static QCM qcmQuestions;

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
    void initialize() throws QuestionNotAnswered {
        nomBO.setText("BO "+BoMain.bo.getId());
        epreuve.setDisable(true);
        // adding les comptes rendus to table
        questionsColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getQuestion()));
        choixColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getChoix()));
        correctColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCorrectes()));
        choisisColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getChoisis()));
        scoreColumn.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getScore())));

        exercicesTable.getItems().addAll(qcmQuestions.getCompteRendus());
    }

}
