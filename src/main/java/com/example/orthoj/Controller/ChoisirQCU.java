package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.QCM;
import com.example.orthoj.Model.QCU;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Map;

public class ChoisirQCU {

    @FXML
    private Button annuler;

    @FXML
    private Button choisir;

    @FXML
    private VBox formArea;

    @FXML
    private ScrollPane scrollpane;

    public static QCU qcuForm;

    @FXML
    private Button supprimer;

    @FXML
    void onSupprimer(ActionEvent event) throws IOException {
        Main.cabinet.removeQuestion(qcuForm);
        // return to qcm listing
        qcuForm = null;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/liste_QCU.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onAnnuler(ActionEvent event) throws IOException {
        // return to qcm listing
        qcuForm = null;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/liste_QCU.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onChoisir(ActionEvent event) throws IOException {
        EpreuveTestQCU.qcuForm = qcuForm;
        // loading answering windows
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/epreuve_testQCU.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void initialize(){
        if(qcuForm != null){
            Map<String, Map<String, Boolean>> form = qcuForm.getForm();
            for (Map.Entry<String, Map<String, Boolean>> entry : form.entrySet()) {
                // adding the question
                Label question = new Label(entry.getKey());
                formArea.getChildren().add(question);
                // adding answers
                for(Map.Entry<String, Boolean> entry1 : entry.getValue().entrySet()){
                    CheckBox checkBox = new CheckBox(entry1.getKey());
                    if(entry1.getValue()){
                        checkBox.setSelected(true);
                    }
                    checkBox.setDisable(true);
                    formArea.getChildren().add(checkBox);
                }

            }
            scrollpane.setContent(formArea);
        }
    }

}
