package application;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller_TeacherAccount implements Initializable{
	@FXML
	private Button back;
	@FXML
	private Label teacherName;
	@FXML
	private Label teacherNumber;
	@FXML
	private ComboBox<String> teacherClasses;
	
	private Teacher teacherLogin;
	
	
	@FXML
	public void returnBack() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			Stage window = (Stage)back.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void addAssignment() {
		
	}
	
	@FXML
	public void confirmUpdate() {
		
	}
	
	@FXML
	public void listStudentsOfClass() {
		
	}
	
	
	@SuppressWarnings("unused")
	private void currentGradeCalc() {
		
	}
	
	public void returnLogin(Teacher teacher) {
		teacherLogin = teacher;
		teacherName.setText(String.format("Hello, %s", teacher.getFirstName().toString()));
		teacherNumber.setText(teacher.getTeacherNumber());
		//teacher.getClassesTaught();
		
		System.out.println("Hello!");
		ArrayList<String> teacherClass = new ArrayList<String>();
		Sequel_Courses dataCourse = new Sequel_Courses();
		Connection data = dataCourse.connectToDatabase();
		@SuppressWarnings("unchecked")
		ArrayList<Courses> value = dataCourse.readValue(data, "Course");
		for (Courses cou : value) {
			System.out.println("GoodBye!");
			String[] values = cou.getCourseTeacher().split(" ");
			int num = values.length - 1;
			String finalValue = values[num];
			
			System.out.println(finalValue);
			System.out.println(teacherLogin.getTeacherNumber());
	
			if (finalValue.equals(teacherLogin.getTeacherNumber())) {
				teacherClass.add(cou.getCourseName());
			}
		}
		
		
		ObservableList<String> observeClassTaught = FXCollections.observableArrayList(teacherClass);
		teacherClasses.setItems(observeClassTaught);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}
}
