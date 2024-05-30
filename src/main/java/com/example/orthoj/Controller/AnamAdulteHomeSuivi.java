package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnamAdulteHomeSuivi {

    @FXML
    private TableView<String> tableView;

    @FXML
    private TableColumn<String, String> stringColumn;

    @FXML
    private TextField inputField;

    @FXML
    private Button histoir;

    @FXML
    private Button suivi;

    private transient ObservableList<String> stringList;

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
    public void onHistoir() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/anam_adulte_home_histoir.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    public void onSuivi() throws IOException {

    }

    @FXML
    public void initialize() {
        stringList = FXCollections.observableArrayList(Main.cabinet.getqSuivi());
        tableView.setItems(stringList);

        stringColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
        stringColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));

        stringColumn.setOnEditCommit(event -> {
            int index = event.getTablePosition().getRow();
            String newValue = event.getNewValue();
            stringList.set(index, newValue);
        });

        tableView.setEditable(true);

        suivi.setDisable(true);
    }

    @FXML
    private void handleAdd() {
        String newString = inputField.getText();
        if (newString != null && !newString.trim().isEmpty()) {
            stringList.add(newString);
            inputField.clear();
        }
    }

    @FXML
    private void handleEdit() {
        String selectedString = tableView.getSelectionModel().getSelectedItem();
        if (selectedString != null) {
            tableView.edit(tableView.getSelectionModel().getSelectedIndex(), stringColumn);
        }
    }

    @FXML
    private void handleDelete() {
        String selectedString = tableView.getSelectionModel().getSelectedItem();
        if (selectedString != null) {
            stringList.remove(selectedString);
        }
    }

    @FXML
    private void handleSave() throws IOException {
        Main.cabinet.setqSuivi(new ArrayList<>(stringList));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/anam_type_home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    public List<String> getStringList() {
        return stringList;
    }
}
