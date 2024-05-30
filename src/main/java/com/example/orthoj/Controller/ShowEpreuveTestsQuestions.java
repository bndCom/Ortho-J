package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class ShowEpreuveTestsQuestions {

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
    private FlowPane qcmArea;

    @FXML
    private FlowPane qcuArea;

    @FXML
    private FlowPane qlArea;

    public static TestQuestion test;

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
        nomBO.setText("BO " + BoMain.bo.getId());
        epreuve.setDisable(true);
        // setting the buttons for tests
        for (Question question : test.getQuestions()) {
            if (question instanceof QCM) {
                Button button = new Button("qcm"); // change it with the name of qcm
                button.setOnAction(event -> {
                    // setting the qcm
                    ShowEpreuveTestsQuestionsQCM.qcmQuestions = (QCM) question;
                    FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/show_epreuve_tests_questions_QCM.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load(), 1440, 810);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Main.stage.setScene(scene);
                    Main.stage.show();
                });
                // adding the button to its area
                qcmArea.getChildren().add(button);

            } else if (question instanceof QCU) {
                Button button = new Button("qcu"); // change it with the name of qcm
                button.setOnAction(event -> {
                    // setting the qcm
                    ShowEpreuveTestsQuestionsQCU.qcuQuestions = (QCU) question;
                    FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/show_epreuve_tests_questions_QCU.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load(), 1440, 810);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Main.stage.setScene(scene);
                    Main.stage.show();
                });
                // adding the button to its area
                qcuArea.getChildren().add(button);

            } else if (question instanceof QL) {
                Button button = new Button("ql"); // change it with the name of qcm
                button.setOnAction(event -> {
                    // setting the qcm
                    ShowEpreuveTestsQuestionsQL.qlQuestions = (QL) question;
                    FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/show_epreuve_tests_questions_QL.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load(), 1440, 810);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Main.stage.setScene(scene);
                    Main.stage.show();
                });
                // adding the button to its area
                qlArea.getChildren().add(button);
            }


        }

    }
}