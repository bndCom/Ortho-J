package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.QCM;
import com.example.orthoj.Model.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class ListeQCMHome {

    @FXML
    private Button annuler;

    @FXML
    private FlowPane buttonArea;

    @FXML
    private Button ajouter;

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        // loading adding question window
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/ajouterQCM_home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onAnnuler(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void initialize(){
        for(Question question : Main.cabinet.getQuestions()){
            if(question instanceof QCM){
                // create button for it
                Button button = new Button("qcm");
                button.setOnAction(event -> {
                    ChoisirQCMHome.qcmForm = (QCM) question;
                    // loading the question window
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/choisir_QCM_home.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load(), 600, 400);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Main.stage.setScene(scene);
                    Main.stage.show();
                });
                buttonArea.getChildren().add(button);
            }
        }
    }

}
