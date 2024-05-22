package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.QCM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class AjouterQCM {

    @FXML
    private CheckBox check1;

    @FXML
    private CheckBox check2;

    @FXML
    private CheckBox check3;

    @FXML
    private CheckBox check4;

    @FXML
    private TextField choix1;

    @FXML
    private TextField choix2;

    @FXML
    private TextField choix3;

    @FXML
    private TextField choix4;

    @FXML
    private Button fin;

    @FXML
    private Label num;

    @FXML
    private TextField qcmNom;

    @FXML
    private TextField qcmQuestion;

    @FXML
    private Button suivant;

    // one response for a single question in qcm
    private Map<String, Boolean> resp1;
    @FXML
    void initialize(){
        resp1 = new LinkedHashMap<String, Boolean>();
    }

    @FXML
    void onFin(ActionEvent event) {
        QCM qcm = new QCM(Main.qcmQuestion);
        Main.qcmQuestion = new LinkedHashMap<String, Map<String, Boolean>>(); // free the memory
    }

    @FXML
    void onSuivant(ActionEvent event) throws IOException {
        // getting the true responses
        resp1.put(choix1.getText(), check1.isSelected());
        resp1.put(choix2.getText(), check2.isSelected());
        resp1.put(choix3.getText(), check3.isSelected());
        resp1.put(choix4.getText(), check4.isSelected());
        // adding the question
        Main.qcmQuestion.put(qcmQuestion.getText(), resp1);
        // loading this stage again
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/ajouterQCM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 400);
        Main.stage.setScene(scene);
        Main.stage.show();

    }
}