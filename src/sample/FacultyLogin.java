package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class FacultyLogin {

    @FXML
    public TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label status;

    @FXML
    void Login(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/Emp_leave", "postgres", "12345");
        Statement stmt = con.createStatement();
        String user = username.getText();
        String pswd = password.getText();
        String sql = "select facultyid, pwd from faculty_login where facultyid ='" + user + "' and pwd ='" + pswd + "';";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            status.setText("Success");
            //Stage primaryStage = new Stage();
            //Parent root = FXMLLoader.load(getClass().getResource("faculty.fxml"));
            try {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("faculty.fxml"));
                Parent root = (Parent) loader.load();
                facultyController fc =loader.getController();
                fc.myFunction(username.getText());
                Stage stage=new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //primaryStage.setScene(new Scene(root));
            //primaryStage.show();
        }
        rs.close();
        stmt.close();
        try {
            con.close();
            con = null;
        }catch(Exception e){
        }
    }
}

