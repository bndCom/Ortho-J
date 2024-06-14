package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.DossierManagementPackage.Dossier;
import com.example.orthoj.Model.FicheDeSuiviPackage.FicheDeSuivi;
import com.example.orthoj.Model.FicheDeSuiviPackage.Objectif;
import com.example.orthoj.Model.FicheDeSuiviPackage.TypeObjectifs;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

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
    public void save() throws IOException {
          int num =   Main.cabinet.getSelectedRendezVous().getPatient().getNumDossier();
          Dossier dossier = null;
          for (Dossier dossier1 : Main.cabinet.getLinkedListDossier()){
              if (dossier1.getNbDossier() == num){
                  dossier = dossier1;
                  dossier.setFicheDeSuiviCourante(ficheDeSuivi);
                  break;
              }
          }
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/objectif.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
            Main.stage.setScene(scene);
            Main.stage.show();


        }

        @FXML
        public void notnew() throws IOException {
        int num =   Main.cabinet.getSelectedRendezVous().getPatient().getNumDossier();
        Dossier dossier = null;
        for (Dossier dossier1 : Main.cabinet.getLinkedListDossier()){
            if (dossier1.getNbDossier() == num){
                dossier = dossier1;
                if (dossier.getFicheDeSuiviCourante() == null) {
                    break;
                }else {
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/objectif.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
                    Main.stage.setScene(scene);
                    Main.stage.show();
                }
            }
        }



    }

    @FXML
    public void onMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }
}