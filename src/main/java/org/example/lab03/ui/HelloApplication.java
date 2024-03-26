package org.example.lab03.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Object root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/org/example/lab03/strona/hello-view.fxml")));
            Scene scene = new Scene((Parent) root);
            stage.setTitle("Lab 3 App");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error loading FXML file" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}