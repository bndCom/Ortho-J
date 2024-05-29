package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.Orthophoniste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard{

    @FXML
    private Text adresse;

    @FXML
    private Text email;

    @FXML
    private Text nom;

    @FXML
    private Text telephone;

    @FXML
    private Button calendrier;

    @FXML
    private Button listeBO;

    @FXML
    private Button questions;

    @FXML
    private Button anam;

    @FXML
    private Button disconnect;

    @FXML
    private PieChart troublesPercent;

//    @FXML
//    void onAjouterBO(ActionEvent event) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/anam_choix.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
//        Main.stage.setScene(scene);
//        Main.stage.show();
//    }

    @FXML
    void onListeBO(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/list_bo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }


    @FXML
    void initialize(){
        // getting the doctor of the cabinet
        Orthophoniste doctor = Main.cabinet.getOrthophoniste();
        if(doctor != null){
            // showing info of the doctor
            nom.setText(doctor.getNom()+" "+doctor.getPrenom());
            email.setText(doctor.getEmail());
            telephone.setText(doctor.getTelephone());
            adresse.setText(doctor.getAddress());
        }
        // setting data in the piechart
        PieChart.Data slice1 = new PieChart.Data("déglutition", 30);
        PieChart.Data slice2 = new PieChart.Data("neuro-développementaux", 20);
        PieChart.Data slice3 = new PieChart.Data("cognitifs", 50);

        troublesPercent.getData().addAll(slice1, slice2, slice3);


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

    }

    @FXML
    void onDisconnect(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }


}
