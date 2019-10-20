package org.standalone.banking.actions;
import org.standalone.banking.BaseActivity;
import org.standalone.banking.constant.ErrorCode;
import org.standalone.banking.exception.BankingCompileTimeException;

/**
 * 
 * @author Amir Ansari
 * created 19-10-2019
 * Fetch the Banking Thread
 */
public class BankingThread extends BaseActivity implements Runnable{
	private Thread th_Bank;
	
	public BankingThread() {
		
	}
	  

	/**
	 * 
	 * @return true if thread started
	 * @throws BankingCompileTimeException
	 */
	public boolean start() throws BankingCompileTimeException{
	    try {
	    	th_Bank= new Thread(this);
	    	th_Bank.setName(BankingThread.class.getSimpleName());
	    	th_Bank.start();
	    	return true;
	    	
	    } catch(Exception e) {
	    	throw new BankingCompileTimeException("Unable to start "+e.getMessage(),ErrorCode.NULLPOINTERCODE);
	    }
		
	}
	
	/**
	 * stop thread
	 */
	  public void stop(long waitMills) {
		  
		  
		  
	  }
	
	
	@Override
	public void run() {
		showRegisteredCustomers();
		
	}

	
}
