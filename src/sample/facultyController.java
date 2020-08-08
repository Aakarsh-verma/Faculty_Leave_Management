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

public class facultyController implements Initializable {

    @FXML
    private MenuItem menuitem1;

    @FXML
    private MenuItem menuitem2;

    @FXML
    private MenuItem menuitem3;

    @FXML
    private MenuItem menuitem4;

    @FXML
    private Label id;

    void myFunction(String text){
        id.setText(text);
    }
    @FXML
    public void handle1(ActionEvent e) throws IOException {

        if (e.getSource() == menuitem1) {
            Stage primaryStage = new Stage();
          // Parent root = FXMLLoader.load(getClass().getResource("Apply_leave.fxml"));
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Apply_leave.fxml"));
            Parent root = (Parent) loader.load();
            ApplyLeave fc =loader.getController();
            fc.myFunction2(id.getText());
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        else if(e.getSource() == menuitem2) {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("leave_status.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        else if(e.getSource() == menuitem3) {
            Stage primaryStage = new Stage();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("leaves.fxml"));
            Parent root = (Parent) loader.load();
            StatisticsController fc =loader.getController();
            fc.myFunction1(id.getText());
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        else if(e.getSource() == menuitem4) {
            Stage primaryStage = new Stage();
           // Parent root = FXMLLoader.load(getClass().getResource("statistics.fxml"));
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Statistics.fxml"));
            Parent root = (Parent) loader.load();
            StatisticsController fc =loader.getController();
            fc.myFunction1(id.getText());
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
    }

    @FXML
    void logout(ActionEvent event) {

        exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}