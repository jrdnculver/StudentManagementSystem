package application;

import java.sql.Connection;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_adminAccountAccess {
	@FXML
	private TextField userNameTxt;
	@FXML
	private TextField passwordTxt;
	@FXML
	private Label displayStatusLbl;
	
	@FXML
	public void adminAccess() {
		try {
			Sequel_Admin dataAdmin = new Sequel_Admin();
			Connection data = dataAdmin.connectToDatabase();
			@SuppressWarnings("unchecked")
			ArrayList<Admin> Admins = dataAdmin.readValue(data, "Admin");
			
			String user = userNameTxt.getText();
			String pass = passwordTxt.getText();
			
			for (Admin value : Admins) {
				String userIter = value.getUserName();
				String passIter = value.getPassword();
				
				if (user.equals(userIter) && pass.equals(passIter)) {
					Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
					Stage window = (Stage)userNameTxt.getScene().getWindow();
					window.setScene(new Scene(root));
				}
				else {
					displayStatusLbl.setText("Something is wrong with your Credentials");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void returnHome() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			Stage window = (Stage)userNameTxt.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
