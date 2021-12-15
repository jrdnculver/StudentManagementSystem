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

public class Controller_viewCourses implements Initializable{
	@FXML
	private TableView<Courses> tableAdmin;
	@FXML
	private TableColumn<Courses, Integer> courseNumberCol;
	@FXML
	private TableColumn<Courses, String> courseNameCol;
	@FXML
	private TableColumn<Courses, Integer> courseCapacityCol;
	@FXML
	private TableColumn<Courses, String> courseStartDateCol;
	@FXML
	private TableColumn<Courses, String> courseEndDateCol;
	@FXML
	private TableColumn<Courses, String> courseTeacherCol;
	@FXML
	private TableColumn<Courses, String> courseDescriptionCol;
	@FXML
	private TableColumn<Courses, Integer> courseCreditsCol;
	@FXML
	private TableColumn<Courses, Integer> courseSubjectCol;
	
	
	private ObservableList<Courses> observeCourse = FXCollections.observableArrayList();
	
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
			Sequel_Courses dataCourse = new Sequel_Courses();
			Connection data = dataCourse.connectToDatabase();
			
			ResultSet courseList = data.createStatement().executeQuery("SELECT * from Course");
			
			while (courseList.next()) {
				observeCourse.add(new Courses(courseList.getInt("courseNumber"), courseList.getString("courseName"),courseList.getInt("courseCapacity"),
						courseList.getString("courseStartDate"), courseList.getString("courseEndDate"), courseList.getString("courseTeacher"), 
						courseList.getString("courseDescription"), courseList.getInt("courseCredits"), courseList.getString("courseSubject")));
			}
			
			courseNumberCol.setCellValueFactory(new PropertyValueFactory<>("courseNumber"));
			courseNameCol.setCellValueFactory(new PropertyValueFactory<>("courseName"));
			courseCapacityCol.setCellValueFactory(new PropertyValueFactory<>("courseCapacity"));
			courseStartDateCol.setCellValueFactory(new PropertyValueFactory<>("courseStartDate"));
			courseEndDateCol.setCellValueFactory(new PropertyValueFactory<>("courseEndDate"));
			courseTeacherCol.setCellValueFactory(new PropertyValueFactory<>("courseTeacher"));
			courseDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("courseDescription"));
			courseCreditsCol.setCellValueFactory(new PropertyValueFactory<>("courseCredits"));
			courseSubjectCol.setCellValueFactory(new PropertyValueFactory<>("courseSubject"));
			
			tableAdmin.setItems(observeCourse);
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
