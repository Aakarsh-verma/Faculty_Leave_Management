package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class ApplyLeave {

    @FXML
    private DatePicker startdate;

    @FXML
    private DatePicker enddate;

    @FXML
    private TextField leavetype;

    @FXML
    private TextField reason;

    @FXML
    private TextField fid;

    @FXML
    private Label lbl;

    @FXML
    private Label st;

    @FXML
    private Label et;

    void myFunction2(String text) {
        fid.setText(text);
    }

    @FXML
    void handle3(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {


        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/Emp_leave", "postgres", "12345");
        Statement stmt = con.createStatement();
        if (startdate.getValue().compareTo(enddate.getValue()) > 0) {
            et.setText("Enter valid end date!");
        }
        if (startdate.getValue().compareTo(LocalDate.now()) < 0) {
            st.setText("Enter valid start date!");
        }
        String sd = startdate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String ed = enddate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String sql1 = "select*from faculty_login where facultyid='" + fid.getText() + "';";
        ResultSet rs = stmt.executeQuery(sql1);
        while (rs.next()) {
            String a1 = rs.getString("facultyid");
            String a2 = rs.getString("facultyname");
            String a3 = rs.getString("dept");
            if (leavetype.getText().equals("Casual") || leavetype.getText().equals("casual") || leavetype.getText().equals("CASUAL")) {
                Statement stmt1 = con.createStatement();
                ResultSet rs1 = stmt1.executeQuery("insert into applyleave values('" + a1 + "','" + a2 + "','" + a3 + "','" + leavetype.getText() + "','" + sd + "','" + ed + "','" + reason.getText() + "');");
                while (rs1.next()) {
                }
                rs1.close();
            } else if (leavetype.getText().equals("Medical") || leavetype.getText().equals("medical") || leavetype.getText().equals("MEDICAL")) {
                Statement stmt1 = con.createStatement();
                ResultSet rs1 = stmt1.executeQuery("insert into applyleave values('" + a1 + "','" + a2 + "','" + a3 + "','" + leavetype.getText() + "','" + sd + "','" + ed + "','" + reason.getText() + "');");
                while (rs1.next()) {
                }
                rs1.close();
            } else if (leavetype.getText().equals("Paid") || leavetype.getText().equals("paid") || leavetype.getText().equals("PAID")) {
                Statement stmt1 = con.createStatement();
                ResultSet rs1 = stmt1.executeQuery("insert into applyleave values('" + a1 + "','" + a2 + "','" + a3 + "','" + leavetype.getText() + "','" + sd + "','" + ed + "','" + reason.getText() + "');");
                while (rs1.next()) {
                }
                rs1.close();
            } else
                lbl.setText("Please specify valid leave type!");
            // String sql = "("+fid.getText()+",'"+fname.getText()+"','"+dept.getText()+"','"+leavetype.getText()+"','"+sd+"','"+ed+"','"+reason.getText()+"');";
        }
        rs.close();
        stmt.close();
        con.close();

    }

    @FXML
    void pop(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("applied-popup.fxml"));
        primaryStage.setTitle("Applied");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}


