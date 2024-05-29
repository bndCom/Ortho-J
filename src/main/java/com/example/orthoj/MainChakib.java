package com.example.orthoj;

import com.example.orthoj.Model.*;
import com.example.orthoj.Model.DossierManagementPackage.Dossier;
import com.example.orthoj.Model.Patient.Patient;
import com.example.orthoj.Model.Patient.PatientAdulte;
import com.example.orthoj.Model.RendezVousManagement.ConsultaionAdulte;
import com.example.orthoj.Model.RendezVousManagement.RendezVous;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class MainChakib extends Application {
    public static CabinetChakib cabinet = new CabinetChakib();
    // tmp (waiting for integration)
    public static List<BO> bos = new ArrayList<>();


    // used variables (tmp) --------------------------------------------

    // -----------------------------------------------------------------
    public static Stage stage;





    @Override
    public void start(Stage stage) {
        PatientAdulte patientAdulte = new PatientAdulte();
        ConsultaionAdulte consultaionAdulte = new ConsultaionAdulte();
        patientAdulte.setNom("chakib");
        patientAdulte.setPrenom("Boumissa");
        patientAdulte.setAge(28);


        consultaionAdulte.setPatient(patientAdulte);
        patientAdulte.setConsultaionAdulte(consultaionAdulte);
        Dossier dossier = new Dossier(consultaionAdulte);

        cabinet.ajouterDossier(dossier);
LinkedList<Dossier> listeDeDossier = cabinet.getLinkedListDossier();
        int num = 1;
        boolean found = false;
         dossier = null;
        for (Dossier dossier1 : listeDeDossier){
            System.out.print("Dossier num" + dossier1.getNbDossier());
        }
        System.out.print("done");

        if (found){
            System.out.print("hehe");
        }
        // setting the main stage
        System.out.println("lol");
        Main.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/CalendrierMain.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Ortho-J");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}