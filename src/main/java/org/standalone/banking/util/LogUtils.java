package org.standalone.banking.util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {
	private static Logger logger;
	
	public LogUtils(String tag) {
		logger= LogManager.getLogger(tag);
}

	public void info(String message) {
		logger.info(message);
	}
	 public void debug(String message) {
		 logger.debug(message);
		}
	
	 public void warn(String message) {
		 logger.warn(message);
	 }

     public void error(String message) {
    	 logger.error(message);
     }
     
    

public void catching(Exception e) {
		 logger.catching(e);
		
	}

public boolean isDebugEnabled() {
	return logger.isDebugEnabled();
}
     
     
      
}
