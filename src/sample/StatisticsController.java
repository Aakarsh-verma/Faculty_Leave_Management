package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StatisticsController implements Initializable{

    @FXML
    private TableView<ApplyLeavetable> table;

    @FXML
    private TableColumn<ApplyLeavetable, String> f_id;

    @FXML
    private TableColumn<ApplyLeavetable, String> f_name;

    @FXML
    private TableColumn<ApplyLeavetable, String> dept;

    @FXML
    private TableColumn<ApplyLeavetable, String> LeaveType;

    @FXML
    private TableColumn<ApplyLeavetable, LocalDate> StartDate;

    @FXML
    private TableColumn<ApplyLeavetable, LocalDate> EndDate;

    @FXML
    private TableColumn<ApplyLeavetable, String> Reason;

    @FXML
    private TableColumn<ApplyLeavetable, String> Status;

    @FXMLs
    private TextField id;

    void myFunction1(String text){
        id.setText(text);
    }

    ObservableList<ApplyLeavetable> oblist= FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/Emp_leave", "postgres", "12345");
        Statement stmt = con.createStatement();
        String sql = "select * from applyleave;"; //where fid='"+id.getText()+"';";
        ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String dept = rs.getString("dept");
                Statement stmt1 = con.createStatement();
                ResultSet rs1 = stmt1.executeQuery("select * from applyleave where dept='"+dept+"';");
                //while (rs1.next()) {
                    oblist.add(new ApplyLeavetable(rs.getString("fid"), rs.getString("fname"), rs.getString("dept"), rs.getString("leavetype"), rs.getString("startdate"), rs.getString("enddate"), rs.getString("reason"), rs.getString("status")));
                //}
                //rs1.close();
                //stmt1.close();
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        f_id.setCellValueFactory(new PropertyValueFactory<>("fid"));
        f_name.setCellValueFactory(new PropertyValueFactory<>("fname"));
        dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        LeaveType.setCellValueFactory(new PropertyValueFactory<>("leavetype"));
        StartDate.setCellValueFactory(new PropertyValueFactory<>("startdate"));
        EndDate.setCellValueFactory(new PropertyValueFactory<>("enddate"));
        Reason.setCellValueFactory(new PropertyValueFactory<>("reason"));
        Status.setCellValueFactory(new PropertyValueFactory<>("status"));
        table.setItems(oblist);
    }

}
