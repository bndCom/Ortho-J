package com.example.orthoj;

import com.example.orthoj.Model.BO;
import com.example.orthoj.Model.Cabinet;
import com.example.orthoj.Model.Diagnostic;
import com.example.orthoj.Model.DossierManagementPackage.Dossier;
import com.example.orthoj.Model.EpreuveClinique;
import com.example.orthoj.Model.Patient.PatientAdulte;
import com.example.orthoj.Model.RendezVousManagement.ConsultaionAdulte;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class Main extends Application {
    public static Cabinet cabinet = new Cabinet();

    // tmp (waiting for integration)
    public static List<BO> bos = new ArrayList<>();
    // used variables (tmp) --------------------------------------------

    // -----------------------------------------------------------------
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {

        // loading cabinet
//        try (FileInputStream fileIn = new FileInputStream("C:\\Users\\anesb\\IdeaProjects\\Ortho-J\\src\\main\\resources\\com\\example\\orthoj\\Data\\cabinet.ser");
//             ObjectInputStream in = new ObjectInputStream(fileIn)) {
//            cabinet = (Cabinet) in.readObject();
//        } catch (IOException i) {
//            i.printStackTrace();
//        } catch (ClassNotFoundException c) {
//            System.out.println("Class not found");
//            c.printStackTrace();
//        }

        // setting the main stage
        Main.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        stage.setTitle("Ortho-J");
        stage.setScene(scene);

        stage.setOnCloseRequest(event -> {
            // Call your cleanup or shutdown method
            try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\anesb\\IdeaProjects\\Ortho-J\\src\\main\\resources\\com\\example\\orthoj\\Data\\cabinet.ser");
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(cabinet);
            } catch (IOException i) {
                i.printStackTrace();
            }
        });

        //hello chakib
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



        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}