package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller_viewStudents implements Initializable {

	@FXML
	private TableView<Student> tableAdmin;
	@FXML
	private TableColumn<Student, String> firstNameCol;
	@FXML
	private TableColumn<Student, String> lastNameCol;
	@FXML
	private TableColumn<Student, Integer> addressCol;
	@FXML
	private TableColumn<Student, Boolean> isAdminCol;
	@FXML
	private TableColumn<Student, Boolean> isTeacherCol;
	@FXML
	private TableColumn<Student, Boolean> isStudentCol;
	@FXML
	private TableColumn<Student, String> userNameCol;
	@FXML
	private TableColumn<Student, String> passwordCol;
	
	private ObservableList<Student> observeStudent = FXCollections.observableArrayList();
	
	@FXML
	public void returnBack() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
			Stage window = (Stage)tableAdmin.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			Sequel_Students dataStudents = new Sequel_Students();
			Connection data = dataStudents.connectToDatabase();
			
			ResultSet studentList = data.createStatement().executeQuery("SELECT firstName, lastName, address, isAdmin, isTeacher, isStudent, userName, password from Student");
			
			while (studentList.next()) {
				observeStudent.add(new Student(studentList.getString("firstName"), studentList.getString("lastName"),
						studentList.getString("address"), studentList.getBoolean("isAdmin"), studentList.getBoolean("isTeacher"), studentList.getBoolean("isStudent"),
						studentList.getString("userName"), studentList.getString("password")));
			}
			
			firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
			lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
			addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
			isAdminCol.setCellValueFactory(new PropertyValueFactory<>("isAdmin"));
			isTeacherCol.setCellValueFactory(new PropertyValueFactory<>("isTeacher"));
			isStudentCol.setCellValueFactory(new PropertyValueFactory<>("isStudent"));
			userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
			passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
			
			tableAdmin.setItems(observeStudent);
			System.out.println("Success");
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
