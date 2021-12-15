package application;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller_Admin {
	@FXML
	private Button createAdmins;
	
	@FXML
	public void createAdmin() throws Exception{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("creatingAdmin.fxml"));
			Stage window = (Stage)createAdmins.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void createSchool() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("creatingSchool.fxml"));
			Stage window = (Stage)createAdmins.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	@FXML
	public void createTeacher() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("creatingTeacher.fxml"));
			Stage window = (Stage)createAdmins.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	@FXML
	public void createStudent() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("creatingStudent.fxml"));
			Stage window = (Stage)createAdmins.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void createCourse() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("creatingCourses.fxml"));
			Stage window = (Stage)createAdmins.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void viewAdmins() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("viewAdmin.fxml"));
			Stage window = (Stage)createAdmins.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void viewSchools() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("viewSchools.fxml"));
			Stage window = (Stage)createAdmins.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void viewCourses() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("viewCourses.fxml"));
			Stage window = (Stage)createAdmins.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void viewStudent() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("viewStudents.fxml"));
			Stage window = (Stage)createAdmins.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void viewTeacher() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("viewTeachers.fxml"));
			Stage window = (Stage)createAdmins.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@FXML
	public void returnHome() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			Stage window = (Stage)createAdmins.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
