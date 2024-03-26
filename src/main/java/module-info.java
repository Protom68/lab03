module org.example.lab03 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.net.http;
    requires com.google.gson;

    opens org.example.lab03.model;
    opens org.example.lab03.api;
    exports org.example.lab03.api;
    exports org.example.lab03.ui;
    opens org.example.lab03.ui to javafx.fxml;
    exports org.example.lab03.controlers;
    opens org.example.lab03.controlers to javafx.fxml;
}