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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller_StudentAccount implements Initializable {
	@FXML
	private Label welcome;
	@FXML
	private Label studentNumber;
	@FXML
	private Label GPA;
	@FXML
	private TableView<GivenGrade> tableAdmin;
	@FXML
	private TableColumn<GivenGrade, Integer> courseNumberCol;
	@FXML
	private TableColumn<GivenGrade, String> courseNameCol;
	@FXML
	private TableColumn<GivenGrade, String> courseGradeCol;
	@FXML
	private TableColumn<GivenGrade, String> courseTeacherCol;
	
	private Parent root;
	
	private Student studentLogin;
	
	private ObservableList<GivenGrade> observeGivenGrade = FXCollections.observableArrayList();
	
	@FXML
	public void returnBack() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			Stage window = (Stage)welcome.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void returnLogin(Student student) {
		welcome.setText(String.format("Welcome, %s",student.firstName));
		studentNumber.setText(student.getNumber().toString());
		GPA.setText(Double.toString(student.getGpa()));
		
		studentLogin = student;
		
		try {
			Sequel_Classes dataGivenGrade = new Sequel_Classes();
			Connection data = dataGivenGrade.connectToDatabase();
			
			dataGivenGrade.createTable(data, studentLogin.getNumber());
			
			ResultSet givenGradeList = data.createStatement().executeQuery(String.format("SELECT number, name, teacher, grade from %s", studentLogin.getNumber()));
			
			while (givenGradeList.next()) {
				observeGivenGrade.add(new GivenGrade(givenGradeList.getInt("number"), givenGradeList.getString("name"),
						givenGradeList.getString("teacher"), givenGradeList.getString("grade")));
			}
			
			courseNumberCol.setCellValueFactory(new PropertyValueFactory<>("courseNumber"));
			courseNameCol.setCellValueFactory(new PropertyValueFactory<>("courseName"));
			courseGradeCol.setCellValueFactory(new PropertyValueFactory<>("courseGrade"));
			courseTeacherCol.setCellValueFactory(new PropertyValueFactory<>("courseTeacher"));
			
			tableAdmin.setItems(observeGivenGrade);
				
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@FXML
	public void goToAddClass() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("classSignUp.fxml"));
			root = loader.load();
			
			Controller_classSignUp signUpAcct = loader.getController();
			
			signUpAcct.returnLogin(studentLogin);
			Stage window = (Stage)welcome.getScene().getWindow();
			
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
}
 