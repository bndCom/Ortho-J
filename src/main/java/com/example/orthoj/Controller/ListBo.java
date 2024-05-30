package com.example.orthoj.Controller;

import com.example.orthoj.Main;
import com.example.orthoj.Model.BO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.List;

public class ListBo {

    @FXML
    private FlowPane areaBo;

    public static List<BO> list;

    @FXML
    void initialize(){
        //List<BO> list = Main.bos;
        if(list.size() == 0){
            Label label = new Label("No List");
            areaBo.getChildren().add(label);
        }else{
            for(BO bo : list){
                // creating button for each bo
                Button button = new Button("BO");
                button.setId(Integer.toString(bo.getId()));
                button.setOnAction(event -> {
                    BoMain.bo = bo;
                    FXMLLoader fxmlLoader = new FXMLLoader(com.example.orthoj.Main.class.getResource("View/bo_main.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load(), 600, 400);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Main.stage.setScene(scene);
                    Main.stage.show();
                });
                areaBo.getChildren().add(button);


            }
        }
    }
}
