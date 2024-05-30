package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.*;
import com.example.orthoj.Model.Enumeration.TypeQLAnamAdulte;
import com.example.orthoj.Model.Enumeration.TypeQLAnamEnfant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ShowAnam {

    @FXML
    private TableView<AnamData> anamTable;

    @FXML
    private Button anamnese;

    @FXML
    private TableColumn<AnamData, String> categorieColumn;

    @FXML
    private Button diagnostic;

    @FXML
    private Button epreuve;

    @FXML
    private Label nomBO;

    @FXML
    private Button projet;

    @FXML
    private TableColumn<AnamData, String> questionColumn;

    @FXML
    private TableColumn<AnamData, String> reponseColumn;

    @FXML
    void onAnamnese(ActionEvent event){

    }

    @FXML
    void onDiagnostic(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/show_diagnostic.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
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
    void initialize(){
        nomBO.setText("BO "+BoMain.bo.getId());
        anamnese.setDisable(true);
        // init the table
        categorieColumn.setCellValueFactory(data -> data.getValue().categoryProperty());
        questionColumn.setCellValueFactory(data -> data.getValue().questionProperty());
        reponseColumn.setCellValueFactory(data -> data.getValue().responseProperty());
        // adding data to table
        Anamnese anam1 = ((PremierBO)BoMain.bo).getAnamnese();
        if(anam1 instanceof AnamneseEnfant){
            QLAnamEnfant[] qlAnamEnfants = ((AnamneseEnfant) anam1).getQuestions();
            for(int i=0; i<qlAnamEnfants.length; i++){
                TypeQLAnamEnfant type = (TypeQLAnamEnfant) qlAnamEnfants[i].getType();
                Map<String, String> form = qlAnamEnfants[i].getForm();
                for(Map.Entry<String, String> entry : form.entrySet()){
                    AnamData row = new AnamData(entry.getKey(), entry.getValue(), type.toString());
                    anamTable.getItems().add(row);
                }
            }
        }else if(anam1 instanceof AnamneseAdulte){
            QLAnamAdulte[] qlAnamAdultes = ((AnamneseAdulte) anam1).getQuestions();
            for(int i=0; i<qlAnamAdultes.length; i++){
                TypeQLAnamAdulte type = (TypeQLAnamAdulte) qlAnamAdultes[i].getType();
                Map<String, String> form = qlAnamAdultes[i].getForm();
                for(Map.Entry<String, String> entry : form.entrySet()){
                    AnamData row = new AnamData(entry.getKey(), entry.getValue(), type.toString());
                    anamTable.getItems().add(row);
                }
            }
        }

    }

}
