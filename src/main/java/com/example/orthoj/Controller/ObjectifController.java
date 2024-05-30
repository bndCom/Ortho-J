package com.example.orthoj.Controller;

import com.example.orthoj.Model.FicheDeSuiviPackage.FicheDeSuivi;
import com.example.orthoj.Model.FicheDeSuiviPackage.Objectif;
import com.example.orthoj.Model.FicheDeSuiviPackage.TypeObjectifs;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;

public class ObjectifController {
    @FXML
    private TableView<Objectif> tableView1;

    @FXML
    private TableColumn<Objectif, String> nameColumn;

    @FXML
    private TableColumn<Objectif, String> typeColumn;

    @FXML
    private TableColumn<Objectif, String> gradesColumn;

    @FXML
    private TextField gradeField;

    @FXML
    private Label errorLabel;

    private FicheDeSuivi ficheDeSuivi;

    private ObservableList<Objectif> objectifs;

    public void initialize() {
        objectifs = FXCollections.observableArrayList();
        tableView1.setItems(objectifs);

        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        typeColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTypeObjectifString()));
       gradesColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLol()));

        ficheDeSuivi = new FicheDeSuivi();
    }

    @FXML
    private void handleLoadFicheDeSuivi() {
        // For demonstration, we'll just add some dummy data
        ficheDeSuivi.AjouterObjectif("Objectif 1", TypeObjectifs.Cours);
        ficheDeSuivi.AjouterObjectif("Objectif 2", TypeObjectifs.Long);
        // For demonstration, we'll just add some dummy data

        objectifs.setAll(ficheDeSuivi.getObjectifs());
        tableView1.refresh();

    }

    @FXML
    private void handleAddGrade() {
        Objectif selectedObjectif = tableView1.getSelectionModel().getSelectedItem();
        if (selectedObjectif != null) {
            try {
                int grade = Integer.parseInt(gradeField.getText());
                ficheDeSuivi.addNoteObjectif(selectedObjectif, grade);
                tableView1.refresh(); // Refresh the table to show the updated status
                gradeField.clear();
                errorLabel.setText("");
            } catch (NumberFormatException e) {
                errorLabel.setText("Please enter a valid grade.");
            }
        } else {
            errorLabel.setText("Please select an objectif.");
        }
    }
}




