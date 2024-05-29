package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.AnamData;
import com.example.orthoj.Model.CustomException.InvalidAnamQuestionType;
import com.example.orthoj.Model.CustomException.InvalidResponse;
import com.example.orthoj.Model.CustomException.QuestionNotAnswered;
import com.example.orthoj.Model.Enumeration.TypeQLAnamEnfant;
import com.example.orthoj.Model.Enumeration.TypeTrouble;
import com.example.orthoj.Model.QLAnamEnfant;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AnamEnfant {

    @FXML
    private Button ajouter;

    @FXML
    private Button submit;

    @FXML
    private TableColumn<AnamData, String> categorieColumn;

    @FXML
    private ChoiceBox<TypeQLAnamEnfant> categorieField;

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

    List<String> qStructure= new LinkedList<>();
    List<String> aStructure= new LinkedList<>(); // answers
    List<String> qDynamique= new LinkedList<>();
    List<String> aDynamique= new LinkedList<>();
    List<String> qEntecedent= new LinkedList<>();
    List<String> aEntecedent= new LinkedList<>();
    List<String> qCondition= new LinkedList<>();
    List<String> aCondition= new LinkedList<>();
    List<String> qPsycho= new LinkedList<>();
    List<String> aPsycho= new LinkedList<>();
    List<String> qLangagier= new LinkedList<>();
    List<String> aLangagier= new LinkedList<>();
    List<String> qCaractere= new LinkedList<>();
    List<String> aCaractere= new LinkedList<>();


    @FXML
    void initialize() {
        categorieColumn.setCellValueFactory(data -> data.getValue().categoryProperty());
        questionColumn.setCellValueFactory(data -> data.getValue().questionProperty());
        reponseColumn.setCellValueFactory(data -> data.getValue().responseProperty());

        // init choice box
        categorieField.getItems().addAll(
                TypeQLAnamEnfant.STRUCTURE_FAMILIALE,
                TypeQLAnamEnfant.DYNAMIQUE_FAMILIALE,
                TypeQLAnamEnfant.ANTECEDENTS_FAMILIAUX,
                TypeQLAnamEnfant.CONDITIONS_NATALES,
                TypeQLAnamEnfant.DEVELOPPEMENT_PSYCHOMOTEURS,
                TypeQLAnamEnfant.DEVELOPPEMENT_LANGAGIER,
                TypeQLAnamEnfant.CARACTERE_COMPORTEMENT);

        // show questions depending on the category
        categorieField.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TypeQLAnamEnfant>() {
            @Override
            public void changed(ObservableValue<? extends TypeQLAnamEnfant> observable, TypeQLAnamEnfant oldValue, TypeQLAnamEnfant newValue) {
                questionField.getItems().clear();
                switch (newValue){
                    case TypeQLAnamEnfant.STRUCTURE_FAMILIALE:
                        questionField.getItems().addAll(Main.cabinet.getqStructure());
                        if(!questionField.getItems().isEmpty()){
                            questionField.setValue(questionField.getItems().getFirst());
                        }
                        break;
                    case TypeQLAnamEnfant.ANTECEDENTS_FAMILIAUX:
                        questionField.getItems().addAll(Main.cabinet.getqEntecedent());
                        if(!questionField.getItems().isEmpty()){
                            questionField.setValue(questionField.getItems().getFirst());
                        }
                        break;
                    case TypeQLAnamEnfant.CARACTERE_COMPORTEMENT:
                        questionField.getItems().addAll(Main.cabinet.getqCaractere());
                        if(!questionField.getItems().isEmpty()){
                            questionField.setValue(questionField.getItems().getFirst());
                        }
                        break;
                    case TypeQLAnamEnfant.CONDITIONS_NATALES:
                        questionField.getItems().addAll(Main.cabinet.getqCondition());
                        if(!questionField.getItems().isEmpty()){
                            questionField.setValue(questionField.getItems().getFirst());
                        }
                        break;
                    case TypeQLAnamEnfant.DEVELOPPEMENT_LANGAGIER:
                        questionField.getItems().addAll(Main.cabinet.getqLangagier());
                        if(!questionField.getItems().isEmpty()){
                            questionField.setValue(questionField.getItems().getFirst());
                        }
                        break;
                    case TypeQLAnamEnfant.DEVELOPPEMENT_PSYCHOMOTEURS:
                        questionField.getItems().addAll(Main.cabinet.getqPsycho());
                        if(!questionField.getItems().isEmpty()){
                            questionField.setValue(questionField.getItems().getFirst());
                        }
                        break;
                    case TypeQLAnamEnfant.DYNAMIQUE_FAMILIALE:
                        questionField.getItems().addAll(Main.cabinet.getqDynamique());
                        if(!questionField.getItems().isEmpty()){
                            questionField.setValue(questionField.getItems().getFirst());
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        categorieField.setValue(TypeQLAnamEnfant.STRUCTURE_FAMILIALE);

    }

    @FXML
    void onAjouter(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/ajouter_anam_enfant.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onSubmit(ActionEvent event) {
        if(categorieField.getValue().equals(TypeQLAnamEnfant.STRUCTURE_FAMILIALE)){
            qStructure.add(questionField.getValue());
            aStructure.add(reponseField.getText());
        } else if (categorieField.getValue().equals(TypeQLAnamEnfant.DYNAMIQUE_FAMILIALE)) {
            qDynamique.add(questionField.getValue());
            aDynamique.add(reponseField.getText());
        }else if (categorieField.getValue().equals(TypeQLAnamEnfant.ANTECEDENTS_FAMILIAUX)) {
            qEntecedent.add(questionField.getValue());
            aEntecedent.add(reponseField.getText());
        }else if (categorieField.getValue().equals(TypeQLAnamEnfant.CONDITIONS_NATALES)) {
            qCondition.add(questionField.getValue());
            aCondition.add(reponseField.getText());
        }else if (categorieField.getValue().equals(TypeQLAnamEnfant.DEVELOPPEMENT_PSYCHOMOTEURS)) {
            qPsycho.add(questionField.getValue());
            aPsycho.add(reponseField.getText());
        }else if (categorieField.getValue().equals(TypeQLAnamEnfant.DEVELOPPEMENT_LANGAGIER)) {
            qLangagier.add(questionField.getValue());
            aLangagier.add(reponseField.getText());
        }else if (categorieField.getValue().equals(TypeQLAnamEnfant.CARACTERE_COMPORTEMENT)) {
            qCaractere.add(questionField.getValue());
            aCaractere.add(reponseField.getText());
        }
        // adding the element to the table
        AnamData row = new AnamData(questionField.getValue(), reponseField.getText(), categorieField.getValue().toString());
        anamTable.getItems().add(row);
    }

    @FXML
    void suivant(ActionEvent event) throws InvalidResponse, InvalidAnamQuestionType, QuestionNotAnswered, IOException {
        // adding the qls to the anamnese
        try {
            QLAnamEnfant ql = new QLAnamEnfant(TypeQLAnamEnfant.STRUCTURE_FAMILIALE, qStructure);
            ql.setReponsesChoisis(aStructure);
            AnamChoix.anamEnfant.setQLStructureFamilale(ql);
            ql = new QLAnamEnfant(TypeQLAnamEnfant.DYNAMIQUE_FAMILIALE, qDynamique);
            ql.setReponsesChoisis(aDynamique);
            AnamChoix.anamEnfant.setQLDynamicFamilale(ql);
            ql = new QLAnamEnfant(TypeQLAnamEnfant.CARACTERE_COMPORTEMENT, qCaractere);
            ql.setReponsesChoisis(aCaractere);
            AnamChoix.anamEnfant.setQLCaractereComportement(ql);
            ql = new QLAnamEnfant(TypeQLAnamEnfant.ANTECEDENTS_FAMILIAUX, qEntecedent);
            ql.setReponsesChoisis(aEntecedent);
            AnamChoix.anamEnfant.setQLAntecedentsFamiliaux(ql);
            ql = new QLAnamEnfant(TypeQLAnamEnfant.CONDITIONS_NATALES, qCondition);
            ql.setReponsesChoisis(aCondition);
            AnamChoix.anamEnfant.setQLConditionsNatales(ql);
            ql = new QLAnamEnfant(TypeQLAnamEnfant.DEVELOPPEMENT_LANGAGIER, qLangagier);
            ql.setReponsesChoisis(aLangagier);
            AnamChoix.anamEnfant.setQLDeveloppementLanguagier(ql);
            ql = new QLAnamEnfant(TypeQLAnamEnfant.DEVELOPPEMENT_PSYCHOMOTEURS, qPsycho);
            ql.setReponsesChoisis(aPsycho);
            AnamChoix.anamEnfant.setQLDeveloppementPsychomoteurs(ql);
        }catch (InvalidResponse e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Question répetée");
            alert.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/enfant_anam.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Main.stage.setScene(scene);
            Main.stage.show();
            return;
        }
        // loading the next window
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/epreuve_observation.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

}
