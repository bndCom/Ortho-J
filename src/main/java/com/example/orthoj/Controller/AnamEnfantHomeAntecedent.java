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

public class AnamEnfantHomeAntecedent {

    @FXML
    private Button antecedent;

    @FXML
    private Button caractere;

    @FXML
    private Button condition;

    @FXML
    private Button dynamique;

    @FXML
    private Button langagier;

    @FXML
    private Button psycho;

    @FXML
    private Button structure;


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
    void onAntecedent(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/anam_enfant_home_antecedent.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onCaractere(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/anam_enfant_home_caractere.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onCondition(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/anam_enfant_home_condition.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onDynamique(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/anam_enfant_home_dynamique.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onLangagier(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/anam_enfant_home_langagier.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onPsycho(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/anam_enfant_home_psycho.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onStructure(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/anam_enfant_home_structure.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    public void initialize() {
        stringList = FXCollections.observableArrayList(Main.cabinet.getqEntecedent());
        tableView.setItems(stringList);

        stringColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
        stringColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));

        stringColumn.setOnEditCommit(event -> {
            int index = event.getTablePosition().getRow();
            String newValue = event.getNewValue();
            stringList.set(index, newValue);
        });

        tableView.setEditable(true);

        antecedent.setDisable(true);
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
        Main.cabinet.setqEntecedent(new ArrayList<>(stringList));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("View/anam_type_home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    public List<String> getStringList() {
        return stringList;
    }
}
