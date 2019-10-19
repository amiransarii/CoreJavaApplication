package org.standalone.banking.db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.standalone.banking.util.LogUtils;


public class DbRegisteredUser {
	 private static LogUtils log= new LogUtils(DbRegisteredUser.class.getName()); 
		
	 public static boolean isValidateUser1(String userName,String userPass) {
		String sqlQuery="select * from registrationtable where email=? and password=?";
		 try {
			 PreparedStatement psmt=DbPreparedStatement.getPreparedStatement(sqlQuery);
			 psmt.setString(1, userName);
			 psmt.setString(2, userPass); 
			  ResultSet rs= psmt.executeQuery();
			  log.info("Login Success User Name"+userName);
			  return rs.next();
		 } catch(SQLException e) {
			log.error("Valid User SQLException "+e.getMessage());
		 } catch(Exception e) {
			 log.error("Valid User Cach Exception "+e.getMessage());
		 }
		
		return false;
		
		
	}
}
