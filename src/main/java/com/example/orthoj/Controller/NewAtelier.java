package com.example.orthoj.Controller;

import com.example.orthoj.Model.Patient.Patient;
import com.example.orthoj.Model.RendezVousManagement.Atelier;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import com.example.orthoj.Main;
import com.example.orthoj.Main;
import com.example.orthoj.Model.CustomException.InvalidRendezVousTimeClash;
import com.example.orthoj.Model.DossierManagementPackage.Dossier;
import com.example.orthoj.Model.RendezVousManagement.RendezVous;
import com.example.orthoj.Model.RendezVousManagement.Suivi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import com.example.orthoj.Model.DossierManagementPackage.Dossier;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class NewAtelier {
    @FXML
    private TextField min ;

    @FXML
    private TextField heure;

    @FXML
    private DatePicker date;

    @FXML
    private TextField theme;


    @FXML
        private TextField inputField;

        @FXML
        private TableView<NumberWrapper> tableView;

        @FXML
        private TableColumn<NumberWrapper, Integer> numberColumn;

    @FXML
    private TableColumn<NumberWrapper, String> nomColumn;

    @FXML
    private TableColumn<NumberWrapper, String> prenomColumn;

    private LinkedList<Dossier> ListDossierTmp = new LinkedList<Dossier>();


    private ObservableList<NumberWrapper> numbers;

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
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onListePatients(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/Dossiertable.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onQuestions(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/questions_home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onCalendrier(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/CalendrierMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onAnam(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/AnamTypeHome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onDisconnect(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

        @FXML
        public void initialize() {
             numbers = FXCollections.observableArrayList();
             tableView.setItems(numbers);



            numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
             nomColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
             prenomColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));


        }

        @FXML
        private void handleAdd() {
            try {
                int number = Integer.parseInt(inputField.getText());
                Dossier dossier = Main.cabinet.dossierExist(number);
                if (dossier != null) {
                    boolean exist = false;
                    for (Dossier dossier1 : ListDossierTmp) {

                        if (dossier1.getNbDossier() == number) {
                            exist = true;
                            break;

                        }
                    }

                    if (!exist) {
                        ListDossierTmp.add(dossier);
                        String name = dossier.getPatient().getNom();
                        String lastName = dossier.getPatient().getPrenom();
                        numbers.add(new NumberWrapper(number, name, lastName));
                        inputField.clear();
                    } else {
                        inputField.setText("deja ajoutee ");

                    }
                }else {
                    inputField.setText("Dossier existe pas ");
                }

                } catch(NumberFormatException e){
                    inputField.setText("numero invalide");
                }
            }




    public static class NumberWrapper {
        private final Integer number;
        private final String name;
        private final String lastName;

        public NumberWrapper(Integer number, String name, String lastName) {
            this.number = number;
            this.name = name;
            this.lastName = lastName;
        }

        public Integer getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }
    }

    @FXML
    public void BackToCalendrier(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/CalendrierMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    public void save(ActionEvent actionEvent) throws InvalidRendezVousTimeClash, IOException {
        Atelier atelier = new Atelier();
        atelier.setList(ListDossierTmp);
        atelier.setTheme(theme.getText());
        int i = 0 ;
        for (Dossier dossier : ListDossierTmp){
            dossier.addRendezVous(atelier);
            i++;
        }
        if(i > 0 ) {
            atelier.setDateTime(LocalDateTime.of(date.getValue().getYear(), date.getValue().getMonth(), date.getValue().getDayOfMonth(), Integer.parseInt(heure.getText()), Integer.parseInt(min.getText())));
            Patient patient = new Patient();
            patient.setNom("---");
            patient.setPrenom("---");
            atelier.setPatient(patient);
            Main.cabinet.getCalendrier().AjouterRDV((RendezVous) atelier);
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/CalendrierMain.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Main.stage.setScene(scene);
            Main.stage.show();

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Erreur");
            String errorMessage = "Liste vide de dossier";
            alert.setContentText(errorMessage);
            alert.showAndWait();
        }
    }


}
