package org.standalone.banking.util;
import java.util.Properties;
import org.apache.logging.log4j.*;


public class Config {
    private static final Logger log = LogManager.getLogger();
	
	private Properties prop = null;
	
	
	public Config(String configFile){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			prop = new Properties();
			prop.load(classLoader.getResourceAsStream(configFile));
		} 
		catch (Exception e) {
			log.catching(e);
		}
	}
	
	public String getPropertySafely(String key,String defvalue){
	   try {
		   String val;
		   val = prop.getProperty(key).trim();
		   return val; 
	   } 
	   catch (Exception e){
	   }
	   return defvalue;
	}

	public boolean getPropertySafely(String key,boolean defvalue){
	   try {
		   boolean val;
		   val = Boolean.parseBoolean(prop.getProperty(key).trim());
		   return val; 
	   } 
	   catch (Exception e){
	   }
	   return defvalue;
    }

	public int getPropertySafely(String key,int defvalue){
	   try {
		   int val;
		   val = Integer.parseInt(prop.getProperty(key).trim());
		   return val; 
	   } 
	   catch (Exception e){
	   }
	   return defvalue;
    }
	
	
	public long getPropertySafely(String key,long defvalue){
		   try {
			   int val;
			   val = Integer.parseInt(prop.getProperty(key).trim());
			   return val; 
		   } 
		   catch (Exception e){
		   }
		   return defvalue;
	    }
	
}

