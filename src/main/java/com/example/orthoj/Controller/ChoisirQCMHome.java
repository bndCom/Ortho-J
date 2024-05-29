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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Map;

public class ChoisirQCMHome {

    @FXML
    private Button annuler;

    @FXML
    private VBox formArea;

    @FXML
    private ScrollPane scrollpane;

    public static QCM qcmForm;

    @FXML
    private Button supprimer;

    @FXML
    void onSupprimer(ActionEvent event) throws IOException {
        Main.cabinet.removeQuestion(qcmForm);
        // return to qcm listing
        qcmForm = null;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/liste_QCM_home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onAnnuler(ActionEvent event) throws IOException {
        // return to qcm listing
        qcmForm = null;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/liste_QCM_home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

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
