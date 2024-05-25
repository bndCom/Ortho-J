package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.CustomException.InvalidResponse;
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
import java.util.*;

public class EpreuveTestQCU {

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
    private Button submit;

    @FXML
    private VBox formArea;
    @FXML
    private ScrollPane scrollpane;


    // the questions to be shown
    static QCU qcuForm;

    @FXML
    void initialize(){
        // deactivate the qcm page button
        qcu.setDisable(true);
        if(qcuForm != null){
            Map<String, Map<String, Boolean>> form = qcuForm.getForm();
            for (Map.Entry<String, Map<String, Boolean>> entry : form.entrySet()) {
                // adding the question
                Label question = new Label(entry.getKey());
                formArea.getChildren().add(question);
                // adding answers
                // Group checkboxes by question
                String questionId = entry.getKey();
                for(Map.Entry<String, Boolean> entry1 : entry.getValue().entrySet()){
                    CheckBox checkBox = new CheckBox(entry1.getKey());
                    checkBox.setId(questionId + "_" + entry1.getKey()); // Assign a unique ID

                    // Set the event handler using a lambda expression
                    checkBox.setOnAction(event -> {
                        // Unselect all checkboxes in the same group
                        formArea.getChildren().stream()
                                .filter(node -> node instanceof CheckBox)
                                .map(node -> (CheckBox) node)
                                .filter(cb -> cb.getId().startsWith(questionId + "_"))
                                .forEach(cb -> cb.setSelected(false));

                        // Select the clicked checkbox
                        checkBox.setSelected(true);
                    });

                    formArea.getChildren().add(checkBox);
                }

            }
            scrollpane.setContent(formArea);
        }
    }

    @FXML
    void ajouter(ActionEvent event) throws IOException {
        // loading adding question window
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/ajouterQCU.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void getQCMPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/epreuve_testQCM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void getQCUPage(ActionEvent event) {

    }

    @FXML
    void getQLPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/epreuve_testQL.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onSubmit(ActionEvent event) throws IOException {
        List<String> qcmAnswers = new LinkedList<>();
        String currentAnswers = new String();
        String currentQuestion = new String();
        boolean done = false; // used to check that only one answer per question is selected
        for(var node: formArea.getChildren()){
            // retrieve answers if the box is checked
            if(node instanceof CheckBox){
                CheckBox checkBox = (CheckBox)node;
                if(checkBox.isSelected()){
                    currentAnswers = checkBox.getText();
                }
            }else if(node instanceof Label){
                if(!currentQuestion.isEmpty()){ // to treat the case of the first question
                    // adding the previous question answers to the form answers
                    qcmAnswers.add(currentAnswers);
                }
                currentQuestion = ((Label) node).getText();
                // re-init the current answers
                currentAnswers = new String();

            }
        }
        // submit the last question answers
        if(!currentQuestion.isEmpty()){
            qcmAnswers.add(currentAnswers);
        }
        // save the qcm answers
        try {
            // setting the answers
            qcuForm.setReponsesChoisis(qcmAnswers);
            TestChoix.testQuestion.addQuestion(qcuForm);
            qcuForm = null;
            // reload the form windows
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/epreuve_testQCU.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Main.stage.setScene(scene);
            Main.stage.show();

        } catch (InvalidResponse e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void suivant(ActionEvent event) throws IOException {
        // save the test to the epreuve
        EpreuveObservation.epreuve.addTest(TestChoix.testQuestion);
        // load the diagnostic window
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/test_choix.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();

    }

}