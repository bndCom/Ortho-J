package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.AnamData;
import com.example.orthoj.Model.CustomException.InvalidAnamQuestionType;
import com.example.orthoj.Model.CustomException.InvalidResponse;
import com.example.orthoj.Model.CustomException.QuestionNotAnswered;
import com.example.orthoj.Model.Enumeration.TypeQLAnamEnfant;
import com.example.orthoj.Model.Enumeration.TypeTrouble;
import com.example.orthoj.Model.QLAnamEnfant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AnamEnfant {

    @FXML
    private Button ajouter;

    @FXML
    private TableColumn<AnamData, String> categorieColumn;

    @FXML
    private ChoiceBox<TypeQLAnamEnfant> categorieField;

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

    List<String> qStructure;
    List<String> aStructure; // answers
    List<String> qDynamique;
    List<String> aDynamique;
    List<String> qEntecedent;
    List<String> aEntecedent;
    List<String> qCondition;
    List<String> aCondition;
    List<String> qPsycho;
    List<String> aPsycho;
    List<String> qLangagier;
    List<String> aLangagier;
    List<String> qCaractere;
    List<String> aCaractere;


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
        // initialize the lists
        qStructure = new LinkedList<>();
        aStructure = new LinkedList<>();
        qDynamique= new LinkedList<>();
        aDynamique= new LinkedList<>();
        qEntecedent= new LinkedList<>();
        aEntecedent= new LinkedList<>();
        qCondition= new LinkedList<>();
        aCondition= new LinkedList<>();
        qPsycho= new LinkedList<>();
        aPsycho= new LinkedList<>();
        qLangagier= new LinkedList<>();
        aLangagier= new LinkedList<>();
        qCaractere= new LinkedList<>();
        aCaractere= new LinkedList<>();
    }

    @FXML
    void onAjouter(ActionEvent event) {
        if(categorieField.getValue().equals(TypeQLAnamEnfant.STRUCTURE_FAMILIALE)){
            qStructure.add(questionField.getText());
            aStructure.add(reponseField.getText());
        } else if (categorieField.getValue().equals(TypeQLAnamEnfant.DYNAMIQUE_FAMILIALE)) {
            qDynamique.add(questionField.getText());
            aDynamique.add(reponseField.getText());
        }else if (categorieField.getValue().equals(TypeQLAnamEnfant.ANTECEDENTS_FAMILIAUX)) {
            qEntecedent.add(questionField.getText());
            aEntecedent.add(reponseField.getText());
        }else if (categorieField.getValue().equals(TypeQLAnamEnfant.CONDITIONS_NATALES)) {
            qCondition.add(questionField.getText());
            aCondition.add(reponseField.getText());
        }else if (categorieField.getValue().equals(TypeQLAnamEnfant.DEVELOPPEMENT_PSYCHOMOTEURS)) {
            qPsycho.add(questionField.getText());
            aPsycho.add(reponseField.getText());
        }else if (categorieField.getValue().equals(TypeQLAnamEnfant.DEVELOPPEMENT_LANGAGIER)) {
            qLangagier.add(questionField.getText());
            aLangagier.add(reponseField.getText());
        }else if (categorieField.getValue().equals(TypeQLAnamEnfant.CARACTERE_COMPORTEMENT)) {
            qCaractere.add(questionField.getText());
            aCaractere.add(reponseField.getText());
        }
        // adding the element to the table
        AnamData row = new AnamData(questionField.getText(), reponseField.getText(), categorieField.getValue().toString());
        anamTable.getItems().add(row);
    }

    @FXML
    void suivant(ActionEvent event) throws InvalidResponse, InvalidAnamQuestionType, QuestionNotAnswered, IOException {
        // adding the qls to the anamnese
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
        // loading the next window
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/epreuve_observation.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

}
