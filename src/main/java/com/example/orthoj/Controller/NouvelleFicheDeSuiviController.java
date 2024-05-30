package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.DossierManagementPackage.Dossier;
import com.example.orthoj.Model.FicheDeSuiviPackage.FicheDeSuivi;
import com.example.orthoj.Model.FicheDeSuiviPackage.Objectif;
import com.example.orthoj.Model.FicheDeSuiviPackage.TypeObjectifs;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class NouvelleFicheDeSuiviController {


        @FXML
        private TextField inputField1;

        @FXML
        private ComboBox<TypeObjectifs> typeComboBox;

        @FXML
        private TableView<Objectif> tableView1;

        @FXML
        private TableColumn<Objectif, String> nameColumn;

        @FXML
        private TableColumn<Objectif, String> typeColumn;

        private FicheDeSuivi ficheDeSuivi;

        private ObservableList<Objectif> objectifs;

        public void initialize() {
            objectifs = FXCollections.observableArrayList();
            tableView1.setItems(objectifs);

            nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
            typeColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTypeObjectifString()));

            typeComboBox.setItems(FXCollections.observableArrayList(TypeObjectifs.values()));
            ficheDeSuivi = new FicheDeSuivi();
        }

        @FXML
        private void handleAddObjectif() {
            String name = inputField1.getText();
            TypeObjectifs type = typeComboBox.getValue();
            if (name != null && !name.trim().isEmpty() && type != null) {
                Objectif objectif = ficheDeSuivi.CreeObjectif(name, type);
                ficheDeSuivi.AjouterObjectif(name, type);
                objectifs.add(objectif);
                inputField1.clear();
                typeComboBox.setValue(null);
            }
        }

        @FXML
    private void save(){
          int num =   Main.cabinet.getSelectedRendezVous().getPatient().getNumDossier();
          Dossier dossier = null;
          for (Dossier dossier1 : Main.cabinet.getLinkedListDossier()){
              if (dossier1.getNbDossier() == num){
                  dossier = dossier1;
                  // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                  // add the thing that adds the fiche de suivi to the dossier
                  break;
              }
          }


        }
}