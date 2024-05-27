package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.EpreuveClinique;
import com.example.orthoj.Model.Test;
import com.example.orthoj.Model.TestExercice;
import com.example.orthoj.Model.TestQuestion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.List;

public class ShowEpreuveTests {

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
    private FlowPane questionsArea;

    @FXML
    private FlowPane exercicesArea;

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
        // showing tests
        for(EpreuveClinique eprv : BoMain.bo.getEpreuveCliniques()){
            for(Test test : eprv.getTests()){
                // tests questionnaires
                if(test instanceof TestQuestion){
                    Button button = new Button(test.getNom());
                    button.setOnAction(event -> {
                        ShowEpreuveTestsQuestions.test = (TestQuestion) test;
                        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/show_epreuve_tests_questions.fxml"));
                        Scene scene = null;
                        try {
                            scene = new Scene(fxmlLoader.load(), 600, 400);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Main.stage.setScene(scene);
                        Main.stage.show();
                    });
                    questionsArea.getChildren().add(button);
                } else if (test instanceof TestExercice) { // tests exercices
                    Button button = new Button(test.getNom());
                    button.setOnAction(event -> {
                        ShowEpreuveTestsExercices.test = (TestExercice) test;
                        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/show_epreuve_tests_exercices.fxml"));
                        Scene scene = null;
                        try {
                            scene = new Scene(fxmlLoader.load(), 600, 400);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Main.stage.setScene(scene);
                        Main.stage.show();
                    });
                    exercicesArea.getChildren().add(button);
                }
            }
        }
    }

}
