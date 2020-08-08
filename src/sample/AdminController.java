package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static java.lang.System.exit;

public class AdminController {

    @FXML
    private MenuItem menuitem1;

    @FXML
    private MenuItem menuitem2;

    @FXML
    private MenuItem menuitem3;

    @FXML
    private MenuItem menuitem4;

    @FXML
    private Label fid;

    void myFunction2(String text){
        fid.setText(text);
    }

    @FXML
    void handle4(ActionEvent event) throws IOException {
        if (event.getSource() == menuitem1) {
            Stage primaryStage = new Stage();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("FacultyDetails.fxml"));
            Parent root = (Parent) loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        else if(event.getSource() == menuitem2) {
            Stage primaryStage = new Stage();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("LeaveRequest.fxml"));
            Parent root = (Parent) loader.load();
            LeaveRequestController fc =loader.getController();
           // fc.myFunction1(fid.getText());
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        else if(event.getSource() == menuitem3) {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("LeaveReport.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
    }
    @FXML
    void logout(ActionEvent event) {
        if(event.getSource() == menuitem4)
            exit(0);
    }

    //@Override
    //public void initialize(URL location, ResourceBundle resources) {

    //}
}

