package org.standalone.banking.db;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.standalone.banking.util.LogUtils;

public class CustomerRegistration {
	private static LogUtils log= new LogUtils(DbRegisteredUser.class.getName()); 
	
	 
	 public static boolean doRegistration(String fullName,int mobileNo,String gender,
			double 	availableAmount,String emailID,String password,String address) {
		 String sqlQuery = " insert into users (fullName,mobileNo,gender,availableAmount,emailID,password,address)"
			        + " values (?, ?, ?, ?, ?,?,?)";
		 try {
			 PreparedStatement psmt=DbPreparedStatement.getPreparedStatement(sqlQuery);
			 psmt.setString(1, fullName);
			 psmt.setInt(2, mobileNo);
			 psmt.setString(3, gender);
			 psmt.setDouble(4, availableAmount);
			 psmt.setString(5, emailID);
			 psmt.setString(6, password);
			 psmt.setString(7, address);
			 psmt.execute();
			 
			 //close the connection
			 DbPreparedStatement.closeConnection();
		 } catch(SQLException e) {
			log.error("Valid User SQLException "+e.getMessage());
		 } catch(Exception e) {
			 log.error("Valid User Cach Exception "+e.getMessage());
		 }
		 return false;
		 
		 
	 }
	
}
