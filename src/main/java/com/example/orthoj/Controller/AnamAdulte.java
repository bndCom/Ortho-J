package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.AnamData;
import com.example.orthoj.Model.CustomException.InvalidAnamQuestionType;
import com.example.orthoj.Model.CustomException.InvalidResponse;
import com.example.orthoj.Model.CustomException.QuestionNotAnswered;
import com.example.orthoj.Model.Enumeration.TypeQLAnamAdulte;
import com.example.orthoj.Model.QLAnamAdulte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AnamAdulte {

    @FXML
    private Button ajouter;

    @FXML
    private TableColumn<AnamData, String> categorieColumn;

    @FXML
    private ChoiceBox<TypeQLAnamAdulte> categorieField;

    @FXML
    private TableColumn<AnamData, String> questionColumn;

    @FXML
    private TextField questionField;

    @FXML
    private TableColumn<AnamData, String> reponseColumn;

    @FXML
    private TextField reponseField;

    @FXML
    private Button suivant;

    @FXML
    private TableView<AnamData> anamTable;

    List<String> qHistoir;
    List<String> aHistoir; // answers
    List<String> qSuivi;
    List<String> aSuivi;


    @FXML
    void initialize() {
        categorieColumn.setCellValueFactory(data -> data.getValue().categoryProperty());
        questionColumn.setCellValueFactory(data -> data.getValue().questionProperty());
        reponseColumn.setCellValueFactory(data -> data.getValue().responseProperty());

        // init choice box
        categorieField.getItems().addAll(
                TypeQLAnamAdulte.HISTOIRE,
                TypeQLAnamAdulte.SUIVI_MEDICAL);
        // initialize the lists
        qHistoir = new LinkedList<>();
        aHistoir = new LinkedList<>();
        qSuivi= new LinkedList<>();
        aSuivi= new LinkedList<>();

    }

    @FXML
    void onAjouter(ActionEvent event) {
        if(categorieField.getValue().equals(TypeQLAnamAdulte.HISTOIRE)){
            qHistoir.add(questionField.getText());
            aHistoir.add(reponseField.getText());
        } else if (categorieField.getValue().equals(TypeQLAnamAdulte.SUIVI_MEDICAL)) {
            qSuivi.add(questionField.getText());
            aSuivi.add(reponseField.getText());
        }
        // adding the element to the table
        AnamData row = new AnamData(questionField.getText(), reponseField.getText(), categorieField.getValue().toString());
        anamTable.getItems().add(row);
    }

    @FXML
    void suivant(ActionEvent event) throws InvalidResponse, InvalidAnamQuestionType, QuestionNotAnswered, IOException {
        // adding the qls to the anamnese
        QLAnamAdulte ql = new QLAnamAdulte(TypeQLAnamAdulte.HISTOIRE, qHistoir);
        ql.setReponsesChoisis(aHistoir);
        AnamChoix.anamAdulte.setQLHistoire(ql);
        ql = new QLAnamAdulte(TypeQLAnamAdulte.SUIVI_MEDICAL, qSuivi);
        ql.setReponsesChoisis(aSuivi);
        AnamChoix.anamAdulte.setQLSuiviMedical(ql);

        // loading the next window
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/epreuve_observation.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

}
