package com.example.orthoj.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;


import javax.swing.text.LabelView;
import java.awt.*;

public class NewConsultationViewController{

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField age;

    @FXML
    private TextField numTel;

    @FXML
    private DatePicker date;

    @FXML
    private LocalTimeTextField temp;

    @FXML
    private RadioButton adulte;

    @FXML
    private RadioButton enfant;

    @FXML
    private ToggleGroup grp1;
}
