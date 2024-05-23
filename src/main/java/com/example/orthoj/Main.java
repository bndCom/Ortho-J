package com.example.orthoj;

import com.example.orthoj.Model.BO;
import com.example.orthoj.Model.Cabinet;
import com.example.orthoj.Model.Diagnostic;
import com.example.orthoj.Model.EpreuveClinique;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main extends Application {
    public static Cabinet cabinet = new Cabinet();
    // used variables (tmp) --------------------------------------------
    public static BO bo = new BO();
    public static EpreuveClinique epreuve = new EpreuveClinique();

    public static Map<String, Map<String, Boolean>> qcmQuestion = new LinkedHashMap<String, Map<String, Boolean>>();

    // -----------------------------------------------------------------
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        // setting the main stage
        Main.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/ajouterQCM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Ortho-J");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}