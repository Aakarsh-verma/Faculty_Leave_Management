package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class FacultyDetails implements Initializable {

    @FXML
    private TableView<FacultyDetailsTable> ftable;

    @FXML
    private TableColumn<FacultyDetailsTable, String> id;

    @FXML
    private TableColumn<FacultyDetailsTable, String> fname;

    @FXML
    private TableColumn<FacultyDetailsTable, String> age;

    @FXML
    private TableColumn<FacultyDetailsTable, String> gender;

    @FXML
    private TableColumn<FacultyDetailsTable, String> dob;

    @FXML
    private TableColumn<FacultyDetailsTable, String> dept;

    @FXML
    private TableColumn<FacultyDetailsTable, String> address;

    @FXML
    private TableColumn<FacultyDetailsTable, String> contact;

    @FXML
    private TableColumn<FacultyDetailsTable, String> pwd;


    ObservableList<FacultyDetailsTable> oblist= FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/Emp_leave", "postgres", "12345");
            Statement stmt = con.createStatement();
            String sql = "select *from faculty_login;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                oblist.add(new FacultyDetailsTable(rs.getString("facultyid"),rs.getString("facultyname"),rs.getString("age"),rs.getString("gender"),rs.getString("dob"),rs.getString("dept"),rs.getString("address"),rs.getString("contact"),rs.getString("pwd")));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        id.setCellValueFactory(new PropertyValueFactory<>("facultyid"));
        fname.setCellValueFactory(new PropertyValueFactory<>("facultyname"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        pwd.setCellValueFactory(new PropertyValueFactory<>("pwd"));
        ftable.setItems(oblist);
    }

}