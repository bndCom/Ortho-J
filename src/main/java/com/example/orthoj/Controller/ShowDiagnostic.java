package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.Diagnostic;
import com.example.orthoj.Model.PremierBO;
import com.example.orthoj.Model.Trouble;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class ShowDiagnostic {

    @FXML
    private Button anamnese;

    @FXML
    private TableColumn<Trouble, String> categorieColumn;

    @FXML
    private Button diagnostic;

    @FXML
    private Button epreuve;

    @FXML
    private Label nomBO;

    @FXML
    private TableColumn<Trouble, String> nomColumn;

    @FXML
    private Button projet;

    @FXML
    private TableView<Trouble> troubleTable;

    @FXML
    void onAnamnese(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/show_anam.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onDiagnostic(ActionEvent event) {

    }

    @FXML
    void onEpreuve(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/show_epreuve.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onProjet(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/projet.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void initialize(){
        nomBO.setText("BO "+BoMain.bo.getId());
        diagnostic.setDisable(true);
        if(!(BoMain.bo instanceof PremierBO)){
            anamnese.setDisable(true);
        }
        // init the table
        nomColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNom()));
        categorieColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getType().toString()));
        // getting the troubles
        troubleTable.getItems().addAll(BoMain.bo.getDiagnostic().getTroubles());
    }

}
