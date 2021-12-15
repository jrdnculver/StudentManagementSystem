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

public class Controller_viewAdmin implements Initializable{
	
	@FXML
	private TableView<Admin> tableAdmin;
	@FXML
	private TableColumn<Admin, Integer> numberCol;
	@FXML
	private TableColumn<Admin, String> userNameCol;
	@FXML
	private TableColumn<Admin, String> passwordCol;
	
	private ObservableList<Admin> observeAdmin = FXCollections.observableArrayList();
	
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
			Sequel_Admin dataAdmin = new Sequel_Admin();
			Connection data = dataAdmin.connectToDatabase();
			
			ResultSet adminList = data.createStatement().executeQuery("SELECT * from Admin");
			
			while (adminList.next()) {
				observeAdmin.add(new Admin(adminList.getInt("Number"), adminList.getString("UserName"), adminList.getString("Password")));
			}
			
			numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
			userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
			passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
			
			tableAdmin.setItems(observeAdmin);
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
