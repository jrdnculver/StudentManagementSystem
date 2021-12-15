package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Sequel_Admin extends Sequel{
	
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
	
	@Override
	public void createTable(Connection data, String tableName) {
		String sql = String.format("CREATE TABLE IF NOT EXISTS %s (Number integer NOT NULL, UserName text NOT NULL, Password text NOT NULL);", tableName);
		
		try (Statement sqlExecute = data.createStatement()) {
			
			sqlExecute.execute(sql);
			
        } catch (SQLException e) {
        	
            System.out.println(e.getMessage());
            
        }
	};
	
	@Override
	public void deleteTable(Connection data, String tableName) {
		String sql = String.format("DROP Table %s", tableName);
		
		try (Statement sqlExecute = data.createStatement()) {
			
			sqlExecute.execute(sql);
			
        } catch (SQLException e) {
        	
            System.out.println(e.getMessage());
            
        }
	};
	
	public void insertValue(Connection data, Admin admin) {
		String sql = String.format("INSERT into Admin (Number,UserName,Password) Values (%d,'%s','%s')",admin.getNumber(), admin.getUserName(), admin.getPassword());
		
		try (Statement sqlExecute = data.createStatement()) {
			
			sqlExecute.execute(sql);
			
        } catch (SQLException e) {
        	
            System.out.println(e.getMessage());
            
        }
	};
	
	@SuppressWarnings("rawtypes")
	@Override
	public ArrayList readValue(Connection data, String tableName) {
		ArrayList<Admin> Admins = new ArrayList<Admin>();
        String sql = "SELECT Number, UserName, Password FROM Admin;";

		try (PreparedStatement pstmt  = data.prepareStatement(sql)){
		  
		  //
		  ResultSet rs  = pstmt.executeQuery();
		  
		  // loop through the result set
		  while (rs.next()) {
			  Admin admin = new Admin();
			  admin.setNumber(rs.getInt("Number"));
			  admin.setUserName(rs.getString("UserName"));
			  admin.setPassword(rs.getString("Password"));
			  Admins.add(admin);
		      
		  }
		  return Admins;
		  
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		  return null;
		}
		}
}
