package application;

import java.sql.*;
import java.util.ArrayList;

public abstract class Sequel {
	public Connection connectToDatabase() {
		 try {
	         Class.forName("org.sqlite.JDBC");
	         Connection data = DriverManager.getConnection("jdbc:sqlite:schoolManagementSystem.db");
	         return data;
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	         return null;
	      }
	}
	abstract public void createTable(Connection data, String tableName);
	abstract public void deleteTable(Connection data, String tableName);
	public void insertValue(Connection data) {};
	@SuppressWarnings("rawtypes")
	abstract public ArrayList readValue(Connection data, String tableName);
}
