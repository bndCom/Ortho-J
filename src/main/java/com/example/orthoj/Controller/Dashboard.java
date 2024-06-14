package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.Enumeration.TypeTrouble;
import com.example.orthoj.Model.Orthophoniste;
import com.example.orthoj.Model.Trouble;
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
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class Dashboard{

    @FXML
    private Label adresse;

    @FXML
    private Label email;

    @FXML
    private Label nom;

    @FXML
    private Label telephone;

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
    private PieChart troublesPercent;



    @FXML
    void initialize(){
        // init bo list
        // free bos
        ListBo.list = new LinkedList<>();
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
        List<Trouble> list = new LinkedList<>();
        list = Main.cabinet.getTroubles();
        int deg = 0;
        int neuro = 0;
        int cog = 0;
        for (Trouble trouble : list){
            if(trouble.getType().equals(TypeTrouble.COGNITIF)){
                cog++;
            }else if(trouble.getType().equals(TypeTrouble.DEGLUTITION)){
                deg++;
            }else{
                neuro++;
            }
        }
        PieChart.Data slice1 = new PieChart.Data("déglutition", deg);
        PieChart.Data slice2 = new PieChart.Data("neuro-développementaux", neuro);
        PieChart.Data slice3 = new PieChart.Data("cognitifs", cog);

        troublesPercent.getData().addAll(slice1, slice2, slice3);


    }




}
