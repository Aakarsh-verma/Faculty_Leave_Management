package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Choice {

    @FXML
    void Admin(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Adminlogin.fxml"));
        primaryStage.setTitle("Faculty Leave Management");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    void Faculty(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FacultyLogin.fxml"));
        primaryStage.setTitle("Faculty Leave Management");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
