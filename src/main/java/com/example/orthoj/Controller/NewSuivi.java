package com.example.orthoj.Controller;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import com.example.orthoj.Model.DossierManagementPackage.Dossier;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class NewSuivi {

    @FXML
    TextField numDossier;

    @FXML
    ToggleGroup grp2;

    @FXML
    private TextField min ;

    @FXML
    private TextField heure;

    @FXML
    private DatePicker date;

    public void BackToCalendrier(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/CalendrierMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    public void NewSuivi() throws InvalidRendezVousTimeClash {

        int num =Integer.parseInt(numDossier.getText());
        boolean found = false;
        //Verifier si le N du dossier existe ou pas
        LinkedList<Dossier> listeDeDossier = Main.cabinet.getLinkedListDossier();
        Dossier dossier = null;
        for (Dossier dossier1 : listeDeDossier){
            if ( dossier1.getNbDossier() == num ){
                found = true;
                dossier = dossier1;
                break;
            }
        }

        if (found){
            System.out.print("hehe");
        }
           Suivi suivi = new Suivi();
            RadioButton selectedRadioButton = ( RadioButton) grp2.getSelectedToggle();
            String selectedValue = selectedRadioButton.getText();
            if(selectedValue == "En ligne"){
                suivi.setOnline(true);
            }else {
                suivi.setOnline(false);
            }
           suivi.setNbDossier(num);
        suivi.setDateTime(LocalDateTime.of(date.getValue().getYear() , date.getValue().getMonth() , date.getValue().getDayOfMonth(), Integer.parseInt(heure.getText()), Integer.parseInt(min.getText()) ));
        Main.cabinet.getCalendrier().AjouterRDV((RendezVous) suivi);
        dossier.addRendezVous(suivi);
        suivi.setPatient(dossier.getPatient());

            //*******************************************************************************\\
            FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/CalendrierMain.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 600, 400);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Main.stage.setScene(scene);
            Main.stage.show();
//
//
//
//
//
//
//        }

    }
}
