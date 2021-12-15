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

public class Controller_viewTeachers implements Initializable {

		@FXML
		private TableView<Teacher> tableAdmin;
		@FXML
		private TableColumn<Teacher, String> firstNameCol;
		@FXML
		private TableColumn<Teacher, String> lastNameCol;
		@FXML
		private TableColumn<Teacher, Integer> addressCol;
		@FXML
		private TableColumn<Teacher, Boolean> isAdminCol;
		@FXML
		private TableColumn<Teacher, Boolean> isTeacherCol;
		@FXML
		private TableColumn<Teacher, Boolean> isStudentCol;
		@FXML
		private TableColumn<Teacher, String> userNameCol;
		@FXML
		private TableColumn<Teacher, String> passwordCol;
		
		private ObservableList<Teacher> observeTeacher = FXCollections.observableArrayList();
		
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
				Sequel_Teachers dataTeachers = new Sequel_Teachers();
				Connection data = dataTeachers.connectToDatabase();
				
				ResultSet teacherList = data.createStatement().executeQuery("SELECT * from Teacher");
				
				while (teacherList.next()) {
					observeTeacher.add(new Teacher(teacherList.getString("firstName"), teacherList.getString("lastName"),
							teacherList.getString("address"), teacherList.getBoolean("isAdmin"), teacherList.getBoolean("isTeacher"), teacherList.getBoolean("isStudent"),
							teacherList.getString("userName"), teacherList.getString("password")));
				}
				
				firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
				lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
				addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
				isAdminCol.setCellValueFactory(new PropertyValueFactory<>("isAdmin"));
				isTeacherCol.setCellValueFactory(new PropertyValueFactory<>("isTeacher"));
				isStudentCol.setCellValueFactory(new PropertyValueFactory<>("isStudent"));
				userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
				passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
				
				tableAdmin.setItems(observeTeacher);
				
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
}
