module com.example.orthoj {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.orthoj to javafx.fxml;
    exports com.example.orthoj;
    exports com.example.orthoj.Controller;
    opens com.example.orthoj.Controller to javafx.fxml;
}