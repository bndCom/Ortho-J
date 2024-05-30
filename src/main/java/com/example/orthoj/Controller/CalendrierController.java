package com.example.orthoj.Controller;
import com.example.orthoj.Main;
import com.example.orthoj.Main;
import com.example.orthoj.Model.DossierManagementPackage.Dossier;
import com.example.orthoj.Model.Patient.Patient;
import com.example.orthoj.Model.RendezVousManagement.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.print.attribute.standard.PDLOverrideSupported;
import java.io.IOException;
import java.time.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class CalendrierController {

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


    @FXML
    void initialize(){
        date.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDateTime().toLocalDate().toString()));
        heure.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDateTime().toLocalTime().toString()));
        nom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPatient().getNom()));
        online.setCellValueFactory(data ->new SimpleBooleanProperty(data.getValue().isOnline()));
        prenom.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getPatient().getPrenom()));
        type.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().type()));
        TreeMap<LocalDate , LinkedList<RendezVous> > tmp =  Main.cabinet.getCalendrier().getCalendrier();


        for (Map.Entry<LocalDate , LinkedList<RendezVous> > entry : tmp.entrySet()){
            LocalDate localDate = entry.getKey();
            LinkedList<RendezVous> rendezVousList = entry.getValue();
            for (RendezVous rv : rendezVousList){
                rendezvous.getItems().add(rv);

            }
        }

        rendezvous.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedRendezVous = newSelection;
                // Here you can enable buttons or take other actions based on the selection
                System.out.println("Selected rendezvous: " + newSelection);
            } else {
                selectedRendezVous = null;
            }
        });



    }





    public void start(ActionEvent event) throws IOException {
        if (selectedRendezVous != null) {
            Main.cabinet.setSelectedRendezVous(selectedRendezVous);

            FXMLLoader fxmlLoader;
            if (selectedRendezVous instanceof Consultaion) {
                if (selectedRendezVous instanceof ConsultaionAdulte) {
                    System.out.print("1");
                    fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/page1adulte.fxml"));
                } else {
                    System.out.print("2");
                    fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/page1enfant.fxml"));
                }

                try {
                    Parent root = fxmlLoader.load();
                    Scene scene = new Scene(root, 600, 400);
                    Main.stage.setScene(scene);
                    Main.stage.show();

                    // Optional: Pass selectedRendezVous to the new controller if needed
                    // ControllerType controller = fxmlLoader.getController();
                    // controller.setRendezVous(selectedRendezVous);

                } catch (IOException e) {
                    e.printStackTrace();
                    // Optionally, show an error dialog to the user
                    showAlert("Error", "Unable to load the requested page.");
                }
            } else {

                if (selectedRendezVous instanceof Suivi){
                    ProjetTherapeutique.numDossier = Main.cabinet.getSelectedRendezVous().getPatient().getNumDossier();
                    fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/epreuve_observation.fxml"));


                }else {
                    fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/page1Atelier.fxml"));


                }

                try {
                    Parent root = fxmlLoader.load();
                    Scene scene = new Scene(root, 600, 400);
                    Main.stage.setScene(scene);
                    Main.stage.show();

                    // Optional: Pass selectedRendezVous to the new controller if needed
                    // ControllerType controller = fxmlLoader.getController();
                    // controller.setRendezVous(selectedRendezVous);

                } catch (IOException e) {
                    e.printStackTrace();
                    // Optionally, show an error dialog to the user
                    showAlert("Error", "Unable to load the requested page.");
                }


            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void delete(ActionEvent event)throws IOException{
        if(selectedRendezVous != null){
            if(selectedRendezVous instanceof Consultaion){
                Main.cabinet.getCalendrier().deleteRDV(selectedRendezVous);
                LinkedList<Patient> patientLinkedListtmp = Main.cabinet.getPatientsNonPrisEnCharge();
                patientLinkedListtmp.remove(selectedRendezVous.getPatient());
                Main.cabinet.setPatientsNonPrisEnCharge(patientLinkedListtmp);
            }else {
                if(selectedRendezVous instanceof Atelier){
                    LinkedList<Dossier> dossierLinkedListtmp =  ((Atelier) selectedRendezVous).getList();
                    for(Dossier dossier : dossierLinkedListtmp){
                        LinkedList<RendezVous> rendezVousLinkedListtmp = dossier.getRendezVousListe();
                        rendezVousLinkedListtmp.remove(selectedRendezVous);
                        dossier.setListDeRendezVousTotale(rendezVousLinkedListtmp);
                    }
                    Main.cabinet.getCalendrier().deleteRDV(selectedRendezVous);
                }else {
                    Main.cabinet.getCalendrier().deleteRDV(selectedRendezVous);
                    int num = selectedRendezVous.getPatient().getNumDossier();
                    LinkedList<Dossier> linkedList = Main.cabinet.getLinkedListDossier();
                    Dossier dossier = null;
                    for (Dossier dossier1 : linkedList){
                        if(dossier1.getNbDossier() == num){
                            dossier = dossier1;
                            break;
                        }
                    }
                    LinkedList<RendezVous> list = dossier.getRendezVousListe();
                    list.remove(selectedRendezVous);
                    dossier.setListDeRendezVousTotale(list);


                }
            }
        }
    }






    @FXML
    void NewAtelier(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/NewAtelier.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();

    }

    @FXML
    private void NewConsultation(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/newconsultationview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();

    }

    @FXML
    void NewSuivi(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/NewSuivi.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Main.stage.setScene(scene);
        Main.stage.show();

    }




}

