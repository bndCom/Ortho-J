package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnamAdulteHomeHistoir {

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
    public void onHistoir(){

    }

    @FXML
    public void onSuivi() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/anam_adulte_home_suivi.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    public void initialize() {
        stringList = FXCollections.observableArrayList(Main.cabinet.getqHistoir());
        tableView.setItems(stringList);

        stringColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
        stringColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));

        stringColumn.setOnEditCommit(event -> {
            int index = event.getTablePosition().getRow();
            String newValue = event.getNewValue();
            stringList.set(index, newValue);
        });

        tableView.setEditable(true);

        histoir.setDisable(true);
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
        Main.cabinet.setqHistoir(new ArrayList<>(stringList));
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/anam_type_home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    public List<String> getStringList() {
        return stringList;
    }
}
