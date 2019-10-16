package org.standalone.banking.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.standalone.banking.constant.DBConstant;
import org.standalone.banking.util.LogUtils;

public class DbPreparedStatement {
	private static LogUtils log=new LogUtils(DbPreparedStatement.class.getSimpleName());
	private static Connection conn=null;
	 
	public static PreparedStatement getPreparedStatement(String sqlQuery) {
		PreparedStatement psmt=null;
		try {
			Class.forName(DBConstant.DBCLASSNAME);
			 conn=DriverManager.getConnection(DBConstant.DBURL,DBConstant.DBUSER,DBConstant.DBPASSWORD);
			psmt=conn.prepareStatement(sqlQuery);
			
		} catch(SQLException e) {
			log.error("Sql Exception "+e.getMessage());;
		} catch(Exception e) {
			log.catching(e);
		}
		return psmt;
		
	}

	public static void closeConnection() {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				log.error("Close Sql Exception "+e.getMessage());;
	
			}
		}
	}
}
