package application;

import java.sql.Connection;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	private Sequel_Admin dataAdmin = new Sequel_Admin();
	private Sequel_Schools dataSchool = new Sequel_Schools();
	private Sequel_Students dataStudent = new Sequel_Students();
	private Sequel_Teachers dataTeacher = new Sequel_Teachers();
	private Sequel_Courses dataCourse = new Sequel_Courses();
	private Sequel_Classes dataClass = new Sequel_Classes();
	
	public void start(Stage primaryStage){
		try {
			Connection data = dataAdmin.connectToDatabase();
			
//			dataAdmin.deleteTable(data, "Admin");
//			dataSchool.deleteTable(data, "School");
//			dataStudent.deleteTable(data, "Student");
//			dataTeacher.deleteTable(data, "Teacher");
//			dataCourse.deleteTable(data, "Course");
//			dataClass.deleteTable(data, "SN04236651");
			

			dataAdmin.createTable(data, "Admin");
			dataSchool.createTable(data, "School");
			dataStudent.createTable(data, "Student");
			dataTeacher.createTable(data, "Teacher");
			dataCourse.createTable(data, "Course");

			@SuppressWarnings("unchecked")
			ArrayList<Admin> Admins = dataAdmin.readValue(data, "Admin");
			
			if (Admins.isEmpty()) {
				Admin mainAdmin = new Admin(1, "admin", "password");
				dataAdmin.insertValue(data, mainAdmin);
			}
			
			data.close();
			
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
