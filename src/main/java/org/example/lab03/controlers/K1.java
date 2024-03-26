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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.lab03.api.ApiService;
import org.example.lab03.model.Book;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class K1 implements Initializable {
    private int questionnumber;
    private ResourceBundle resourceBundle;
    private final ApiService apiService = ApiService.getInstance();
    @FXML
    private Button przycisk;
    @FXML
    private TextField odpowiedzTextField;
    @FXML
    private Label questionlabel;

    @FXML
    private Label tekst2;

    @FXML
    private Label tekst3;

    @FXML
    private Label tekst4;

    private String ans;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        setLabels();
        checkAnswer();
    }

    public void setQuestionnumber(int questionnumber) {
        this.questionnumber = questionnumber;
    }

    @FXML
    private void nextQuestion(ActionEvent event) {
        if (questionnumber > 6) {
            endQuestion(event);
            return;
        }
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

    private void setLabels() {

        List<Book> bookList = apiService.getallBook();

        ans = bookList.get(new Random().nextInt(bookList.size())).getTitle();


        questionlabel.setText(resourceBundle.getString("questionlabel") + ans + " ?");
        tekst2.setText(resourceBundle.getString("question1placeholder") + ans + " ?");
        tekst3.setText(resourceBundle.getString("question2label") + ans + " ?");
        tekst4.setText(resourceBundle.getString("question2placeholder") + ans + " ?");
    }

    private void checkAnswer() {

        przycisk.setOnAction(event -> {
            String check1 = odpowiedzTextField.getText();


            if (check1 == null || check1.isBlank()) {
                System.out.println("cos tam");
                return;
            }

            if (check1.equals("Stephen King")) {

            } else {

            }

        });

    }

    private void endQuestion(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/lab03/strona/end.fxml"));
        loader.setResources(resourceBundle);
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void loadK2ControllerAndSetQuestionNumber(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/lab03/controlers/K2.fxml"));
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

    private void loadEndController(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/lab03/controlers/EndController.fxml"));
        loader.setResources(resourceBundle);
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}