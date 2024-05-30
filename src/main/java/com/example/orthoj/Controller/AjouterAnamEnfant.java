package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.Enumeration.TypeQLAnamEnfant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AjouterAnamEnfant {

    @FXML
    private Button ajouter;

    @FXML
    private ChoiceBox<TypeQLAnamEnfant> categorie;

    @FXML
    private TextField question;

    @FXML
    void onAjouter(ActionEvent event) throws IOException {
        if(!question.getText().equals("")){
            switch (categorie.getSelectionModel().getSelectedItem()){
                case TypeQLAnamEnfant.STRUCTURE_FAMILIALE:
                    Main.cabinet.addqStructure(question.getText());
                    break;
                case TypeQLAnamEnfant.ANTECEDENTS_FAMILIAUX:
                    Main.cabinet.addqEntecedent(question.getText());
                    break;
                case TypeQLAnamEnfant.CARACTERE_COMPORTEMENT:
                    Main.cabinet.addqCaractere(question.getText());
                    break;
                case TypeQLAnamEnfant.CONDITIONS_NATALES:
                    Main.cabinet.addqCondition(question.getText());
                    break;
                case TypeQLAnamEnfant.DEVELOPPEMENT_LANGAGIER:
                    Main.cabinet.addqLangagier(question.getText());
                    break;
                case TypeQLAnamEnfant.DEVELOPPEMENT_PSYCHOMOTEURS:
                    Main.cabinet.addqPsycho(question.getText());
                    break;
                case TypeQLAnamEnfant.DYNAMIQUE_FAMILIALE:
                    Main.cabinet.addqDynamique(question.getText());
                    break;
                default:
                    Main.cabinet.addqStructure("");
                    break;
            }
            // return to anamnese window
            FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/enfant_anam.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
            Main.stage.setScene(scene);
            Main.stage.show();
        }
    }

    @FXML
    void initialize(){
        // add categories to choice box
        categorie.getItems().addAll(
                TypeQLAnamEnfant.STRUCTURE_FAMILIALE,
                TypeQLAnamEnfant.DYNAMIQUE_FAMILIALE,
                TypeQLAnamEnfant.ANTECEDENTS_FAMILIAUX,
                TypeQLAnamEnfant.CONDITIONS_NATALES,
                TypeQLAnamEnfant.DEVELOPPEMENT_PSYCHOMOTEURS,
                TypeQLAnamEnfant.DEVELOPPEMENT_LANGAGIER,
                TypeQLAnamEnfant.CARACTERE_COMPORTEMENT);
        categorie.setValue(TypeQLAnamEnfant.STRUCTURE_FAMILIALE);
    }

}
