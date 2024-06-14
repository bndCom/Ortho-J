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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main extends Application {
    public static Cabinet cabinet = null;


    // -----------------------------------------------------------------
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {

        // loading cabinet from file ( file is found in the temporary directory %TEMP% )
        String tempDir = System.getenv("TEMP");
        if (tempDir == null || tempDir.isEmpty()) {
            tempDir = System.getProperty("java.io.tmpdir");
        }

        Path tempFile = Paths.get(tempDir, "cabinet.ser");
        try (FileInputStream fileIn = new FileInputStream(tempFile.toFile());
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            cabinet = (Cabinet) in.readObject();
        } catch (IOException i) {
            // create new cabinet
            cabinet = new Cabinet();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }

        // setting the main stage
        Main.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        stage.setTitle("Ortho-J");
        stage.setScene(scene);

        // executed when the application exits
        stage.setOnCloseRequest(event -> {
            // saving data to the file cabinet.ser in the temp directory
            try (FileOutputStream fileOut = new FileOutputStream(tempFile.toFile());
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(cabinet);
            } catch (IOException i) {
                i.printStackTrace();
            }
        });



        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}