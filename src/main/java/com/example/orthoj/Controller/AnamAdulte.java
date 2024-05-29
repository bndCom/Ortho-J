package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.AnamData;
import com.example.orthoj.Model.CustomException.InvalidAnamQuestionType;
import com.example.orthoj.Model.CustomException.InvalidResponse;
import com.example.orthoj.Model.CustomException.QuestionNotAnswered;
import com.example.orthoj.Model.Enumeration.TypeQLAnamAdulte;
import com.example.orthoj.Model.Enumeration.TypeQLAnamEnfant;
import com.example.orthoj.Model.QLAnamAdulte;
import com.example.orthoj.Model.QLAnamEnfant;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    private Button submit;

    @FXML
    private TableColumn<AnamData, String> categorieColumn;

    @FXML
    private ChoiceBox<TypeQLAnamAdulte> categorieField;

    @FXML
    private TableColumn<AnamData, String> questionColumn;

    @FXML
    private ChoiceBox<String> questionField;

    @FXML
    private TableColumn<AnamData, String> reponseColumn;

    @FXML
    private TextField reponseField;

    @FXML
    private Button suivant;

    @FXML
    private TableView<AnamData> anamTable;

    List<String> qHistoir= new LinkedList<>();
    List<String> aHistoir= new LinkedList<>(); // answers
    List<String> qSuivi= new LinkedList<>();
    List<String> aSuivi= new LinkedList<>();


    @FXML
    void initialize() {
        categorieColumn.setCellValueFactory(data -> data.getValue().categoryProperty());
        questionColumn.setCellValueFactory(data -> data.getValue().questionProperty());
        reponseColumn.setCellValueFactory(data -> data.getValue().responseProperty());

        // init choice box
        categorieField.getItems().addAll(
                TypeQLAnamAdulte.HISTOIRE,
                TypeQLAnamAdulte.SUIVI_MEDICAL);

        // show questions depending on the category
        categorieField.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TypeQLAnamAdulte>() {
            @Override
            public void changed(ObservableValue<? extends TypeQLAnamAdulte> observable, TypeQLAnamAdulte oldValue, TypeQLAnamAdulte newValue) {
                questionField.getItems().clear();
                switch (newValue){
                    case TypeQLAnamAdulte.HISTOIRE:
                        questionField.getItems().addAll(Main.cabinet.getqHistoir());
                        if(!questionField.getItems().isEmpty()){
                            questionField.setValue(questionField.getItems().getFirst());
                        }
                        break;
                    case TypeQLAnamAdulte.SUIVI_MEDICAL:
                        questionField.getItems().addAll(Main.cabinet.getqSuivi());
                        if(!questionField.getItems().isEmpty()){
                            questionField.setValue(questionField.getItems().getFirst());
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        categorieField.setValue(TypeQLAnamAdulte.HISTOIRE);

    }

    @FXML
    void onAjouter(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/ajouter_anam_adulte.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onSubmit(ActionEvent event) {
        if(categorieField.getValue().equals(TypeQLAnamAdulte.HISTOIRE)){
            qHistoir.add(questionField.getValue());
            aHistoir.add(reponseField.getText());
        } else if (categorieField.getValue().equals(TypeQLAnamAdulte.SUIVI_MEDICAL)) {
            qSuivi.add(questionField.getValue());
            aSuivi.add(reponseField.getText());
        }
        // adding the element to the table
        AnamData row = new AnamData(questionField.getValue(), reponseField.getText(), categorieField.getValue().toString());
        anamTable.getItems().add(row);
    }

    @FXML
    void suivant(ActionEvent event) throws InvalidResponse, InvalidAnamQuestionType, QuestionNotAnswered, IOException {
        // adding the qls to the anamnese
        try {
            QLAnamAdulte ql = new QLAnamAdulte(TypeQLAnamAdulte.HISTOIRE, qHistoir);
            ql.setReponsesChoisis(aHistoir);
            AnamChoix.anamAdulte.setQLHistoire(ql);
            ql = new QLAnamAdulte(TypeQLAnamAdulte.SUIVI_MEDICAL, qSuivi);
            ql.setReponsesChoisis(aSuivi);
            AnamChoix.anamAdulte.setQLSuiviMedical(ql);
        }catch (InvalidResponse e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Question répetée");
            alert.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/adulte_anam.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Main.stage.setScene(scene);
            Main.stage.show();
            return;
        }
        // loading the next window
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/epreuve_observation.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

}
