package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.CustomException.InvalidQuestion;
import com.example.orthoj.Model.QCU;
import com.example.orthoj.Model.QL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AjouterQL {

    @FXML
    private Button fin;

    @FXML
    private Label num;

    @FXML
    private TextField qcuNom;

    @FXML
    private TextArea question;

    @FXML
    private Button suivant;

    private static List<String> qlQ;
    private static int qNum;

    @FXML
    void initialize(){
        qlQ = new LinkedList<>();
        qNum = 1;
        num.setText(Integer.toString(qNum));
    }

    @FXML
    void onFin(ActionEvent event) throws IOException {
        // update the last question
        qlQ.add(question.getText());

        QL ql;
        ql = new QL(qlQ);

        Main.cabinet.addQuestion(ql);
        // add the question to be shown in the qcm windows
        EpreuveTestQL.qlForm = ql;
        // loading the test scene
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/liste_QL.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onSuivant(ActionEvent event) {
        qlQ.add(question.getText());
        qNum+= 1;
        num.setText(Integer.toString(qNum));
    }

}
