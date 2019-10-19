package org.standalone.banking.exception;
import org.standalone.banking.util.LogUtils;

/**
 * 
 * @author Amir Ansari
 * created at 18-10-19
 *  this class will check all the run time exception which 
 *  will throw by different class
 */
public class BankingRunTimeException extends RuntimeException {
private static LogUtils log= new LogUtils(BankingRunTimeException.class.getSimpleName());
	
	/**
	 * create the instance of ErrorCode class which have different type
	 * which have different tyoe of error code
	 */
	 private final int code;
	 
	 /**
	  * 
	  * @param code only pass the eror code when throw
	  * the exception without any message
	  */
	 public BankingRunTimeException(int code) {
		 super();
		 this.code=code;
		 log.error("Error Code "+code);
	 }
	 
	 
	 /**
	  * 
	  * @param message pass the error message which want to display
	  * @param cause pass the object of throwable
	  * @param code pass the error code value
	  */
	 public BankingRunTimeException(String message,Throwable cause,int code) {
		 super(message,cause);
		 this.code=code;	 
		 log.error("Eror Message "+message +"Throwable "+cause +" ErrorCode"+code);
	 }
	 
	/**
	 *  
	 * @param message pass message error
	 * @param code pass the code
	 */
	  public BankingRunTimeException(String message,int code) {
		  super(message);
		  this.code=code;
		  log.error("Eror Message "+message +" ErrorCode"+code);
		  
		  
	  }
	
	  /**
	   * 
	   * @param cause throwable object
	   * @param code Error code
	   */
	   public BankingRunTimeException(Throwable cause,int code) {
		   super(cause);
		   this.code=code; 
		   log.error("Throwable "+cause +" ErrorCode"+code);
	   }
	   
	   /**
	    * 
	    * @return the final eror code
	    */
	public int getCode() {
		return this.code;
	}

}
