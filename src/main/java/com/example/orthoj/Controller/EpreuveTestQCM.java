package com.example.orthoj.Controller;

import com.example.orthoj.Model.CustomException.InvalidResponse;
import com.example.orthoj.Model.QCM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.*;

public class EpreuveTestQCM {

    @FXML
    private Button ajouter;

    @FXML
    private Button qcm;

    @FXML
    private Button qcu;

    @FXML
    private Button ql;

    @FXML
    private Button suivant;

    @FXML
    private VBox formArea;
    @FXML
    private ScrollPane scrollpane;


    // the questions to be shown
    static QCM qcmForm;

    @FXML
    void initialize(){
        if(qcmForm != null){
            Map<String, Map<String, Boolean>> form = qcmForm.getForm();
            for (Map.Entry<String, Map<String, Boolean>> entry : form.entrySet()) {
                // adding the question
                Label question = new Label(entry.getKey());
                formArea.getChildren().add(question);
                // adding answers
                for(Map.Entry<String, Boolean> entry1 : entry.getValue().entrySet()){
                    CheckBox checkBox = new CheckBox(entry1.getKey());
                    formArea.getChildren().add(checkBox);
                }

            }
            scrollpane.setContent(formArea);
        }
    }

    @FXML
    void ajouterObs(ActionEvent event) {

    }

    @FXML
    void getQCMPage(ActionEvent event) {

    }

    @FXML
    void getQCUPage(ActionEvent event) {

    }

    @FXML
    void getQLPage(ActionEvent event) {

    }

    @FXML
    void suivant(ActionEvent event) {
        List<Set<String>> qcmAnswers = new ArrayList<>();
        for()
        Set<String> qcmAnswer1 = new LinkedHashSet<>();
        qcmAnswer1.add("lion");
        qcmAnswer1.add("dog");
        Set<String> qcmAnswer2 = new LinkedHashSet<>();
        qcmAnswer2.add("anes");
        qcmAnswer2.add("chakib");
        qcmAnswers.add(qcmAnswer1);
        qcmAnswers.add(qcmAnswer2);
        try {
            qcmForm.setReponsesChoisis(qcmAnswers);
        } catch (InvalidResponse e) {
            throw new RuntimeException(e);
        }
    }

}
