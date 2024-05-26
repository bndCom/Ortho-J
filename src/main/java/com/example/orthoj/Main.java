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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main extends Application {
    public static Cabinet cabinet = new Cabinet();
    // tmp (waiting for integration)
    public static List<BO> bos = new ArrayList<>();
    // used variables (tmp) --------------------------------------------

    // -----------------------------------------------------------------
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        // setting the main stage
        Main.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Ortho-J");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}