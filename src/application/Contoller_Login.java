package application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class Contoller_Login {
	@FXML
	public TextField userNameTxt;
	@FXML
	public TextField passwordTxt;
	
	private Sequel_Students mainStudents = new Sequel_Students();
	private Sequel_Teachers mainTeachers = new Sequel_Teachers();
	private Student studentLogin;
	private Teacher teacherLogin;
	private Parent root;
	
	@FXML
	public void login() {
		Connection data = mainStudents.connectToDatabase();
		@SuppressWarnings("unchecked")
		ArrayList<Student> students = mainStudents.readValue(data, "Student");
		@SuppressWarnings("unchecked")
		ArrayList<Teacher> teachers = mainTeachers.readValue(data, "Teacher");
		for (Student stu : students) {
			if (userNameTxt.getText().equals(stu.userName) && passwordTxt.getText().equals(stu.password)) {
				studentLogin = stu;
				studentAccount();
			}
		}
		
		for (Teacher tea : teachers) {
			if (userNameTxt.getText().equals(tea.userName) && passwordTxt.getText().equals(tea.password)) {
				teacherLogin = tea;
				teacherAccount();
			}
		}
	
	}
	
	@FXML
	public void exit() {
		Platform.exit();
	}
	
	@FXML
	public void adminAccount() {
		try {
			root = FXMLLoader.load(getClass().getResource("adminAccountAccess.fxml"));
			Stage window = (Stage)userNameTxt.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void studentAccount() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("studentAccount.fxml"));
			root = loader.load();
			
			Controller_StudentAccount studentAcct = loader.getController();
			
			studentAcct.returnLogin(studentLogin);
			Stage window = (Stage)userNameTxt.getScene().getWindow();
			
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void teacherAccount() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("teacherAccount.fxml"));
			root = loader.load();
			//root = FXMLLoader.load(getClass().getResource("teacherAccount.fxml"));
			Controller_TeacherAccount teacherAcct = loader.getController();
			teacherAcct.returnLogin(teacherLogin);
			Stage window = (Stage)userNameTxt.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
