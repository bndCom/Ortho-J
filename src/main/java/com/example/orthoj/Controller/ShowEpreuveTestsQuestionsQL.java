package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.QCU;
import com.example.orthoj.Model.QL;
import com.example.orthoj.Model.QLData;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.Map;

public class ShowEpreuveTestsQuestionsQL {

    @FXML
    private Button anamnese;

    @FXML
    private Button diagnostic;

    @FXML
    private Button epreuve;

    @FXML
    private TableView<QLData> exercicesTable;

    @FXML
    private Label nomBO;

    @FXML
    private Button projet;

    @FXML
    private TableColumn<QLData, String> questionsColumn;

    @FXML
    private TableColumn<QLData, String> reponseColumn;

    @FXML
    private Label score;

    public static QL qlQuestions;

    @FXML
    void onAnamnese(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/show_anam.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onDiagnostic(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/show_diagnostic.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onEpreuve(ActionEvent event) throws IOException {

    }

    @FXML
    void onProjet(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/projet.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void initialize(){
        nomBO.setText("BO "+BoMain.bo.getId());
        epreuve.setDisable(true);
        // init the table
        questionsColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getQuestion()));
        reponseColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getAnswer()));
        // fill the table
        for(Map.Entry<String, String> entry : qlQuestions.getForm().entrySet()){
            QLData qlData = new QLData(entry.getKey(), entry.getValue());
            exercicesTable.getItems().add(qlData);
        }
        // writing the score
        score.setText("Score: "+qlQuestions.getQstScore());
    }

}
