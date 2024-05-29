package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.DossierManagementPackage.Dossier;
import com.example.orthoj.Model.Patient.Patient;
import com.example.orthoj.Model.Patient.PatientAdulte;
import com.example.orthoj.Model.Patient.PatientEnfant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;

public class PatientProfile {

    @FXML
    private Text age;

    @FXML
    private Button bo;

    @FXML
    private Text diplomeOuNomPere;

    @FXML
    private Text diplomeOuNomPereVal;

    @FXML
    private Button fiche;

    @FXML
    private Text nbrDossier;

    @FXML
    private Text nom;

    @FXML
    private Text numMama;

    @FXML
    private Text numMamaVal;

    @FXML
    private Text numPapa;

    @FXML
    private Text numPapaVal;

    @FXML
    private Text prenom;

    @FXML
    private Text prenomMere;

    @FXML
    private Text prenomMereVal;

    @FXML
    private Text professionOuNomMere;

    @FXML
    private Text professionOuNomMereVal;

    @FXML
    private Button progression;

    @FXML
    private Button rdv;

    @FXML
    private Text telephoneOuPrenomPere;

    @FXML
    private Text telephoneOuPrenomPereVal;

    public static Dossier dossier;

    @FXML
    void onBo(ActionEvent event) throws IOException {
        //ListBo.list = dossier.getBOs();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/list_bo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onFiche(ActionEvent event) {

    }

    @FXML
    void onProgression(ActionEvent event) {

    }

    @FXML
    void onRdv(ActionEvent event) {

    }

    @FXML
    void initialize(){
        // putting information
        Patient patient = dossier.getPatient();
        nom.setText(patient.getNom());
        prenom.setText(patient.getPrenom());
        age.setText(Integer.toString(patient.getAge()));
        nbrDossier.setText(Integer.toString(dossier.getNbDossier()));
        if(patient instanceof PatientAdulte){
            diplomeOuNomPere.setText("Diplome");
            diplomeOuNomPereVal.setText(((PatientAdulte)patient).getDiplome());
            telephoneOuPrenomPere.setText("N° téléphone");
            telephoneOuPrenomPereVal.setText(((PatientAdulte)patient).getNumtel());
            professionOuNomMere.setText("Profession");
            professionOuNomMereVal.setText(((PatientAdulte)patient).getProfession());
        }else if(patient instanceof PatientEnfant){
            numPapa.setText("N° téléphone du père");
            numPapaVal.setText(((PatientEnfant)patient).getNumPapa());
            numMama.setText("N° téléphone de mère");
            numMamaVal.setText(((PatientEnfant)patient).getNumMama());
            diplomeOuNomPere.setText("Nom du père");
            diplomeOuNomPereVal.setText(((PatientEnfant)patient).getNomPere());
            telephoneOuPrenomPere.setText("Prénom du père");
            telephoneOuPrenomPereVal.setText(((PatientEnfant)patient).getPrenomPere());
            professionOuNomMere.setText("Nom du mère");
            professionOuNomMereVal.setText(((PatientEnfant)patient).getNomMere());
            prenomMere.setText("Prénom de mère");
            prenomMereVal.setText(((PatientEnfant)patient).getPrenomMere());
        }
    }

}
