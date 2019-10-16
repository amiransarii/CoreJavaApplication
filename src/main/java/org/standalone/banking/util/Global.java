package org.standalone.banking.util;
import java.io.FileNotFoundException;

/**
 * 
 * @author Amir Ansari
 * created 15-10-2019
 * declare all global variable which will store value
 * of properties file and can be accessed from any class
 */
public class Global {
	//log method 
	public static  LogUtils log=new LogUtils(Global.class.getSimpleName());
	//this one is used which mode need to test
	 public  static boolean isDebugEnabled=log.isDebugEnabled();
	//properties file name
	 public  static final String configFile="bankingapp..properties";
	 //db class name
	  public static String dbClassName="";
	  public static String dbURL="";
	  public static String dbUser="";
	  public static String dbPass="";
	
	  
	  public static void loadConfig() {
		 try {
			 Config cfg= new Config(configFile);
			 isDebugEnabled=cfg.getPropertySafely("app_debug", isDebugEnabled);
			 dbClassName=cfg.getPropertySafely("db_classname", dbClassName);
			 dbURL=cfg.getPropertySafely("db_url", dbURL);
			 dbPass=cfg.getPropertySafely("db_pass", dbPass);
		 }
		 catch(Exception e) {
			 log.error("Unable to Process Config File and Message "+e.getMessage());
		 }
		  
		  
	  }
    
	

}
