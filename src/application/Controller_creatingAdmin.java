package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.*;

public class Controller_creatingAdmin {
	@FXML
	private TextField userNameTxt;
	@FXML
	private TextField passwordTxt;
	@FXML
	private TextField checkPasswordTxt;
	@FXML
	private Label displayStatusLbl;
	
	@FXML
	public void creatingAdmin() throws SQLException {
		Sequel_Admin dataAdmin = new Sequel_Admin();
		Admin newAdmin = new Admin();
		String user = userNameTxt.getText();
		String pass = passwordTxt.getText();
		String checkedPass = checkPasswordTxt.getText();
		newAdmin.setUserName(user);
		newAdmin.setPassword(pass);
		newAdmin.setCheckPassword(checkedPass);
		
		if (Pattern.matches(newAdmin.getPassword(), newAdmin.getCheckPassword())) {
			Connection data = dataAdmin.connectToDatabase();
			@SuppressWarnings("unchecked")
			ArrayList<Admin> Admins = dataAdmin.readValue(data, "Admin");
			Integer finalNum = null;
			for (Admin value : Admins) {
				finalNum = value.getNumber();
				
			}
			newAdmin.setNumber(finalNum + (Integer)1);
			dataAdmin.insertValue(data, newAdmin);
			displayStatusLbl.setText("Admin Account Successfully Created");
			data.close();
	
			Admins.clear();
		}
		else {
			displayStatusLbl.setText("Admin Account Could Not Be Created");
		}
	}
	
	@FXML
	public void returnBack() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
			Stage window = (Stage)userNameTxt.getScene().getWindow();
			window.setScene(new Scene(root));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
