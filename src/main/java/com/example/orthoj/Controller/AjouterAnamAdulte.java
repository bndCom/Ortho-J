package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.Enumeration.TypeQLAnamAdulte;
import com.example.orthoj.Model.Enumeration.TypeQLAnamEnfant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AjouterAnamAdulte {

    @FXML
    private Button ajouter;

    @FXML
    private ChoiceBox<TypeQLAnamAdulte> categorie;

    @FXML
    private TextField question;

    @FXML
    void onAjouter(ActionEvent event) throws IOException {
        if(!question.getText().equals("")){
            switch (categorie.getSelectionModel().getSelectedItem()){
                case TypeQLAnamAdulte.HISTOIRE:
                    Main.cabinet.addqHistoir(question.getText());
                    break;
                case TypeQLAnamAdulte.SUIVI_MEDICAL:
                    Main.cabinet.addqSuivi(question.getText());
                    break;
                default:
                    Main.cabinet.addqHistoir("");
                    break;
            }
            // return to anamnese window
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/adulte_anam.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
            Main.stage.setScene(scene);
            Main.stage.show();
        }
    }

    @FXML
    void initialize(){
        // add categories to choice box
        categorie.getItems().addAll(
                TypeQLAnamAdulte.HISTOIRE,
                TypeQLAnamAdulte.SUIVI_MEDICAL);
        categorie.setValue(TypeQLAnamAdulte.HISTOIRE);
    }

}
