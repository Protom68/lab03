package org.example.lab03.controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label rozpocznijgre;

    @FXML
    private Button rozpocznijgrestart;

    @FXML
    private Label witam;

    @FXML
    private Label wybierzjezyk;

    @FXML
    private Button wybierzjezykangielski;

    @FXML
    private Button wybierzjezykpolski;
    private ResourceBundle resourceBundle;
    private int questionnumber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.resourceBundle = ResourceBundle.getBundle("org.example.lab03.jezyk.MessageBundle_en");
        ustawtekst();
        wybierzboundla();
        questionnumber = 1;
        startgame();
    }

    private void ustawtekst() {
        witam.setText(resourceBundle.getString("welcomeMessage"));


    }

    private void wybierzboundla() {
        wybierzjezykpolski.setOnAction(actionEvent -> {
            resourceBundle = ResourceBundle.getBundle("org.example.lab03.jezyk.MessageBundle_pl");
            ustawtekst();

        });
        wybierzjezykangielski.setOnAction(actionEvent -> {
            resourceBundle = ResourceBundle.getBundle("org.example.lab03.jezyk.MessageBundle_en");
            ustawtekst();
        });

    }

    private void nextquestion(ActionEvent event) {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/lab03/strona/q1.fxml"));
        loader.setResources(resourceBundle);
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        K1 k1 = loader.getController();
        k1.setQuestionnumber(questionnumber);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    private void startgame() {
        rozpocznijgrestart.setOnAction(this::nextquestion);


    }
}