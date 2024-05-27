package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.CustomException.InvalidResponse;
import com.example.orthoj.Model.QCM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
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
    private Button submit;

    @FXML
    private VBox formArea;
    @FXML
    private ScrollPane scrollpane;

    @FXML
    private TextField testNom;


    @FXML
    private Button choisir;


    // the questions to be shown
    public static QCM qcmForm;

    @FXML
    void initialize(){
        // deactivate the qcm page button
        qcm.setDisable(true);
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
    void ajouter(ActionEvent event) throws IOException {
        // loading adding question window
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/ajouterQCM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void getQCMPage(ActionEvent event) throws IOException {

    }

    @FXML
    void getQCUPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/epreuve_testQCU.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
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
        List<Set<String>> qcmAnswers = new LinkedList<>();
        LinkedHashSet<String> currentAnswers = new LinkedHashSet<>();
        String currentQuestion = new String();
        for(var node: formArea.getChildren()){
            // retrieve answers if the box is checked
            if(node instanceof CheckBox){
                CheckBox checkBox = (CheckBox)node;
                if(checkBox.isSelected()){
                    currentAnswers.add(checkBox.getText());
                }
            }else if(node instanceof Label){
                if(!currentQuestion.isEmpty()){ // to treat the case of the first question
                    // adding the previous question answers to the form answers
                    qcmAnswers.add(currentAnswers);
                }
                currentQuestion = ((Label) node).getText();
                // re-init the current answers
                currentAnswers = new LinkedHashSet<>();

            }
        }
        // submit the last question answers
        if(!currentQuestion.isEmpty()){
            qcmAnswers.add(currentAnswers);
        }
        // save the qcm answers
        try {
            // setting the answers
            qcmForm.setReponsesChoisis(qcmAnswers);
            TestChoix.testQuestion.addQuestion(qcmForm);
            qcmForm = null;
            // reload the form windows
            FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/epreuve_testQCM.fxml"));
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
        TestChoix.testQuestion.setNom(testNom.getText());
        EpreuveObservation.epreuve.addTest(TestChoix.testQuestion);
        // load the diagnostic window
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/test_choix.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();

    }

    @FXML
    void onChoisir(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/liste_QCM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

}
