package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.CustomException.InvalidResponse;
import com.example.orthoj.Model.QCU;
import com.example.orthoj.Model.QL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EpreuveTestQL {

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
    static QL qlForm;

    @FXML
    void initialize(){
        // deactivate the qcm page button
        ql.setDisable(true);
        if(qlForm != null){
            Map<String, String> form = qlForm.getForm();
            int i = 0;
            for (Map.Entry<String, String> entry : form.entrySet()) {
                // adding the question
                Label question = new Label(entry.getKey());
                formArea.getChildren().add(question);
                // adding answers box
                TextField answer = new TextField(entry.getValue());
                answer.setId("a"+i);
                formArea.getChildren().add(answer);
                // adding note box
                TextField note = new TextField("3");
                note.setId("n"+i);
                formArea.getChildren().add(note);
                i += 1;
            }
            scrollpane.setContent(formArea);
        }
    }

    @FXML
    void getQCMPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/epreuve_testQCM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void getQCUPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/epreuve_testQCU.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void getQLPage(ActionEvent event) {

    }

    @FXML
    void onSubmit(ActionEvent event) throws IOException {

        List<String> qlAnswers = new LinkedList<>();
        List<Integer> notes = new LinkedList<>();

        for(var node: formArea.getChildren()){
            // retrieve answers
            if(node instanceof TextField){
                // checking if answer
                if(node.getId().charAt(0) == 'a'){
                    qlAnswers.add(((TextField) node).getText());
                } else if (node.getId().charAt(0) == 'n') {
                    notes.add(Integer.parseInt(((TextField) node).getText()));
                }

            }
        }
        int[] notesArr = notes.stream().mapToInt(Integer::intValue).toArray();

        // save the ql answers
        try {
            // setting the answers
            qlForm.setReponsesChoisis(qlAnswers);
            qlForm.setNotes(notesArr);
            TestChoix.testQuestion.addQuestion(qlForm);
            qlForm = null;
            // reload the form windows
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/epreuve_testQL.fxml"));
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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/test_choix.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();

    }

    @FXML
    void onChoisir(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/liste_QL.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

}
