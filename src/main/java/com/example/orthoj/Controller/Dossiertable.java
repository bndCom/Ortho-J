package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.DossierManagementPackage.Dossier;
import com.example.orthoj.Model.Patient.Patient;
import com.example.orthoj.Model.RendezVousManagement.Atelier;
import com.example.orthoj.Model.RendezVousManagement.Consultaion;
import com.example.orthoj.Model.RendezVousManagement.RendezVous;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Dossiertable {
    @FXML
    private TableColumn<Dossier,String> numdossier;

    @FXML
    private TableColumn<Dossier,String> age;

    @FXML
    private TableColumn<Dossier, String> nom;


    @FXML
    private TableColumn<Dossier, String> prenom;


    @FXML
    private TableColumn<Dossier, String> type;

    @FXML
    private TableView<Dossier> dossierTableView;



    private Dossier selectedDossier ;

    @FXML
    private Button home;

    @FXML
    private Button calendrier;

    @FXML
    private Button listePatients;

    @FXML
    private Button questions;

    @FXML
    private Button anam;

    @FXML
    private Button disconnect;

    @FXML
    void onHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onListePatients(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/Dossiertable.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onQuestions(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/questions_home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onCalendrier(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/CalendrierMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onAnam(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/anam_type_home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onDisconnect(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }


    @FXML
    void initialize(){
        numdossier.setCellValueFactory(date -> new SimpleStringProperty(Integer.toString(date.getValue().getNbDossier())));
        nom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPatient().getNom()));
        prenom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPatient().getPrenom()));
        type.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPatient().getType()));
        age.setCellValueFactory(data -> new SimpleStringProperty( Integer.toString(data.getValue().getPatient().getAge())));

        LinkedList<Dossier> dossierLinkedListtmp = Main.cabinet.getLinkedListDossier();


        for (Dossier dossier : dossierLinkedListtmp){

            dossierTableView.getItems().add(dossier);
        }

        dossierTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedDossier= newSelection;
                // Here you can enable buttons or take other actions based on the selection
                System.out.println("Selected rendezvous: " + newSelection);
            } else {
                selectedDossier = null;
            }
        });



    }


    public void open(ActionEvent event)throws IOException {
        if (selectedDossier != null) {
            PatientProfile.dossier = selectedDossier;
            FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/patient_profile.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
            Main.stage.setScene(scene);
            Main.stage.show();

        }
    }


}
