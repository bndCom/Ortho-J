package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.TestExercice;
import com.example.orthoj.Model.TestQuestion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class TestChoix {

    @FXML
    private Button suivant;

    @FXML
    private Button testExer;

    @FXML
    private Button testQuest;

    public static TestQuestion testQuestion;
    public static TestExercice  testExercice;

    @FXML
    void onSuivant(ActionEvent event) throws IOException {
        // load the diagnostic window
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/diagnostic.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onTestExer(ActionEvent event) throws IOException {
        testExercice = new TestExercice();
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/epreuve_testExercice.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

    @FXML
    void onTestQuest(ActionEvent event) throws IOException {
        testQuestion = new TestQuestion();
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/epreuve_testQCM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1440, 810);
        Main.stage.setScene(scene);
        Main.stage.show();
    }

}
