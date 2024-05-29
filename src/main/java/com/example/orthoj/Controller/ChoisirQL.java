package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.QCU;
import com.example.orthoj.Model.QL;
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

public class ChoisirQL {

    @FXML
    private Button annuler;

    @FXML
    private Button choisir;

    @FXML
    private VBox formArea;

    @FXML
    private ScrollPane scrollpane;

    public static QL qlForm;

    @FXML
    private Button supprimer;

    @FXML
    void onSupprimer(ActionEvent event) throws IOException {
        Main.cabinet.removeQuestion(qlForm);
        // return to qcm listing
        qlForm = null;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/liste_QL.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onAnnuler(ActionEvent event) throws IOException {
        // return to qcm listing
        qlForm = null;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/liste_QL.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onChoisir(ActionEvent event) throws IOException {
        EpreuveTestQL.qlForm = qlForm;
        // loading answering windows
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/epreuve_testQL.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void initialize(){
        if(qlForm != null){
            Map<String, String> form = qlForm.getForm();
            int i = 1;
            for (Map.Entry<String, String> entry : form.entrySet()) {
                // adding the question
                Label question = new Label("Question "+i+"\n"+entry.getKey());
                formArea.getChildren().add(question);
                i++;
            }
            scrollpane.setContent(formArea);
        }
    }

}
