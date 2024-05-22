package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ProjetTherapeutique {

    @FXML
    private Button fin;

    @FXML
    private TextArea text;

    @FXML
    void onFin(ActionEvent event) {
        Main.bo.setProjetTherapeutique(text.getText());
    }

}
