package org.standalone.banking.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.standalone.banking.util.Global;
import org.standalone.banking.util.LogUtils;

public class DbPreparedStatement {
	private static LogUtils log=new LogUtils(DbPreparedStatement.class.getSimpleName());
	private static Connection conn=null;
	 
	public static PreparedStatement getPreparedStatement(String sqlQuery) {
		
		PreparedStatement psmt=null;
		try {
			//load the config file
			Global.loadConfig();
			 Class.forName(Global.dbClassName);
			 conn=DriverManager.getConnection(Global.dbURL,Global.dbUser,Global.dbPass);
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
