package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.BO;
import com.example.orthoj.Controller.DiagnosticController;
import com.example.orthoj.Model.PremierBO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class ProjetTherapeutique {

    @FXML
    private Button fin;

    @FXML
    private TextArea text;

    @FXML
    void onFin(ActionEvent event) throws IOException {
        // checking if it is premierBO or not
        if(AnamChoix.anamEnfant != null){
            // it is premierBO
            PremierBO premierBO = new PremierBO();
            premierBO.setAnamnese(AnamChoix.anamEnfant);
            premierBO.addEpreuveClinique(EpreuveObservation.epreuve);
            premierBO.setDiagnostic(DiagnosticController.diagnostic);
            premierBO.setProjetTherapeutique(text.getText());
            // adding the bo
            Main.bos.add(premierBO);
            // setting anamEnfant to null
            AnamChoix.anamEnfant = null;
        }else if(AnamChoix.anamAdulte != null){
            // it is premierBO
            PremierBO premierBO = new PremierBO();
            premierBO.setAnamnese(AnamChoix.anamAdulte);
            premierBO.addEpreuveClinique(EpreuveObservation.epreuve);
            premierBO.setDiagnostic(DiagnosticController.diagnostic);
            premierBO.setProjetTherapeutique(text.getText());
            // adding the bo
            Main.bos.add(premierBO);
            // setting anamAdulte to null
            AnamChoix.anamAdulte = null;
        }else{
            // not premier bo
            // it is not premier BO
            // creating BO and saving it into the patient files
            BO bo = new BO();
            bo.addEpreuveClinique(EpreuveObservation.epreuve);
            bo.setDiagnostic(DiagnosticController.diagnostic);
            bo.setProjetTherapeutique(text.getText());
            // adding the bo
            Main.bos.add(bo);
        }

        // loading dashboard
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

}
