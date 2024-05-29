package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.DossierManagementPackage.Dossier;
import com.example.orthoj.Model.RendezVousManagement.RendezVous;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class RendezVousUnSeulPatient {

    @FXML
    private TableColumn<RendezVous,String> date;


    @FXML
    private TableColumn<RendezVous, String> heure;

    @FXML
    private TableColumn<RendezVous, String> nom;

    @FXML
    private TableColumn<RendezVous, Boolean> online;

    @FXML
    private TableColumn<RendezVous, String> prenom;

    @FXML
    private TableView<RendezVous> rendezvous;

    @FXML
    private TableColumn<RendezVous, String> type;

    private RendezVous selectedRendezVous;

    private Dossier selectedDossier = null;

    @FXML
    void initialize(){
        date.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDateTime().toLocalDate().toString()));
        heure.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDateTime().toLocalTime().toString()));
        nom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPatient().getNom()));
        online.setCellValueFactory(data ->new SimpleBooleanProperty(data.getValue().isOnline()));
        prenom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPatient().getPrenom()));
        type.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().type()));
        LinkedList<RendezVous> tmp =  selectedDossier.getRendezVousListe();


        for (RendezVous rdv : tmp){

            rendezvous.getItems().add(rdv);
        }


    }


}
