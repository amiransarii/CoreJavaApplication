package org.standalone.banking.actions;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.standalone.banking.entity.ParentsAccount;
import org.standalone.banking.exception.BankingCompileTimeException;

/**
 * 
 * @author Amir Ansari
 * created at 19-10-19
 * create show all the parents account and add to the son
 */
public class SonAccount extends ParentsAccount{

	private int accountNo;
	@Override
	public String toString() {
		return "SonAccount [accountNo=" + accountNo + ", balance=" + balance + ", branch=" + branch
				+ ", createdAccount=" + createdAccount + "]";
	}

	private double balance;
	private String branch;
	private String createdAccount;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public SonAccount(int accountNo, double balance, String branch) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.branch = branch;
		LocalDate ldt=LocalDate.now();
		this.createdAccount =formatter.format(ldt);
	}
	
	
	public void AccountDetails()  throws BankingCompileTimeException {
		//showParentByID(custId);
		
		String son="SonAccount [accountNo=" + accountNo + ", balance=" + balance + ", branch=" + branch
				+ ", createdAccount=" + createdAccount + "]";
		System.out.println(son);
		
		
	}
	
	


	

}
