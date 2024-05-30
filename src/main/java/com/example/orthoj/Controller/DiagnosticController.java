package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.Diagnostic;
import com.example.orthoj.Model.Enumeration.TypeTrouble;
import com.example.orthoj.Model.Trouble;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticController {

    @FXML
    private Button ajouter;

    @FXML
    private ChoiceBox<TypeTrouble> categorieChoix;

    @FXML
    private TableColumn<Trouble, String> categorieColumn;

    @FXML
    private TableColumn<Trouble, String> nomColumn;

    @FXML
    private TextField nomField;

    @FXML
    private Button suivant;

    @FXML
    private TableView<Trouble> troubleTable;

    static public Diagnostic diagnostic;
    List<Trouble> troubles;

    @FXML
    void ajouterTrouble(ActionEvent event) {
        // create new trouble
        Trouble trouble = new Trouble(nomField.getText(), categorieChoix.getValue());
        // add it to the troubles list
        troubles.add(trouble);
        // add the trouble to the table
        troubleTable.getItems().add(trouble);
    }

    @FXML
    void suivant(ActionEvent event) throws IOException {
        // update the diagnostic
        diagnostic.setTroubles(troubles);

        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/projet_therapeutique.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void initialize() {
        // init table
        nomColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        categorieColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getType().toString()));

        // init choice box
        categorieChoix.getItems().addAll(TypeTrouble.DEGLUTITION,
                TypeTrouble.NEURO_DEVELOPPEMENTAL,
                TypeTrouble.COGNITIF);

        // init diagnostic
        diagnostic = new com.example.orthoj.Model.Diagnostic();
        troubles = new ArrayList<>();
    }

}
