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

public class Controller_viewSchools implements Initializable {
	@FXML
	private TableView<School> tableAdmin;
	@FXML
	private TableColumn<School, String> schoolNameCol;
	@FXML
	private TableColumn<School, String> schoolLocationCol;
	@FXML
	private TableColumn<School, Integer> schoolYearCol;
	@FXML
	private TableColumn<School, Integer> schoolLevelCol;
	
	
	private ObservableList<School> observeSchool = FXCollections.observableArrayList();
	
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
			Sequel_Schools dataSchool = new Sequel_Schools();
			Connection data = dataSchool.connectToDatabase();
			
			ResultSet schoolList = data.createStatement().executeQuery("SELECT * from School");
			
			while (schoolList.next()) {
				observeSchool.add(new School(schoolList.getString("SchoolName"), schoolList.getString("SchoolLocation"),
						schoolList.getInt("SchoolYear"), schoolList.getString("SchoolLevel")));
			}
			
			schoolNameCol.setCellValueFactory(new PropertyValueFactory<>("schoolName"));
			schoolLocationCol.setCellValueFactory(new PropertyValueFactory<>("schoolLocation"));
			schoolYearCol.setCellValueFactory(new PropertyValueFactory<>("schoolYear"));
			schoolLevelCol.setCellValueFactory(new PropertyValueFactory<>("schoolLevel"));
			
			tableAdmin.setItems(observeSchool);
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
