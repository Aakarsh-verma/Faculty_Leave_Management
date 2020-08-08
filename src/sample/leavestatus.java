package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.*;

public class leavestatus {

    @FXML
    private DatePicker startdate;

    @FXML
    private DatePicker enddate;

    @FXML
    private TextField status;

    @FXML
    private TextField fid;

    @FXML
    void check(ActionEvent event) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/Emp_leave", "postgres", "12345");
        Statement stmt = con.createStatement();
        String sql = "select status from applyleave where startdate ='"+startdate.getValue()+"'and enddate='"+enddate.getValue()+"'and fid='"+fid.getText()+"';";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            if (fid.getText().equals("1"))
                status.setText("Approved");
            else if(fid.getText().equals("2"))
                status.setText("Rejected");
            else
                status.setText("Pending");
        }
        rs.close();
        stmt.close();
        con.close();
    }

}