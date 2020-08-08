package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class LeaveRequestController implements Initializable {

    @FXML
    private TextField stat;


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

    @FXML
    public TextField fid;



    @FXML
    void view(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/Emp_leave", "postgres", "12345");
        Statement stmt = con.createStatement();
        if(stat.getText().equals("Approved")) {
            String sql = "select * from applyleave  WHERE fid='" + fid.getText() + "';";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                String s = rs.getString("status");
                if(s==null) {
                    Statement stmt1 = con.createStatement();
                    String sql1 = "UPDATE applyleave SET status='" + stat.getText() + "' WHERE fid='" + fid.getText() + "';";
                    ResultSet rs1 = stmt1.executeQuery(sql1);
                }
            }
            rs.close();
            stmt.close();
            con.close();
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("applied-popup.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
        else if(stat.getText().equals("Rejected")){
            String sql = "UPDATE applyleave SET status='Disapproved' WHERE fid='" + fid.getText() + "';";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
            stmt.close();
            con.close();
        }
    }


    ObservableList<ApplyLeavetable> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/Emp_leave", "postgres", "12345");
            Statement stmt = con.createStatement();
            String sql = "select *from ApplyLeave;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                oblist.add(new ApplyLeavetable(rs.getString("fid"), rs.getString("fname"), rs.getString("dept"), rs.getString("leavetype"), rs.getString("startdate"), rs.getString("enddate"), rs.getString("reason"), rs.getString("status")));
            }
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
