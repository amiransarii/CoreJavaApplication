package org.standalone.banking.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.standalone.banking.BaseActivity;
import org.standalone.banking.exception.BankingCompileTimeException;

/***
 * 
 * @author Amir Ansari created at 19-10-2019 test inheritance method
 *
 */
public class ParentsAccount extends BaseActivity {

	private int accountNo;
	private double balance;
	private String branch;
	private String createdAccount;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCreatedAccount() {
		return createdAccount;
	}

	public void setCreatedAccount(String createdAccount) {
		this.createdAccount = createdAccount;
	}

	/**
	 * call the default constructor
	 */
	public ParentsAccount() {

	}

	/**
	 * 
	 * @param account        account number of parents
	 * @param balance        available balance of parent's account
	 * @param branch         name of the branch
	 * @param createdAccount and created date
	 */
	public ParentsAccount(int accountNo, double balance, String branch) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
		this.branch = branch;
		 LocalDate ldt=LocalDate.now();
		this.createdAccount =formatter.format(ldt);
	}

	@Override
	public String toString() {
		return "ParentsAccount [accountNo=" + accountNo + ", balance=" + balance + ", branch=" + branch
				+ ", createdAccount=" + createdAccount + "]";
	}
	
	public void getParentsDetails() {
		String str="ParentsAccount [accountNo=" + accountNo + ", balance=" + balance + ", branch=" + branch
				+ ", createdAccount=" + createdAccount + "]";
		
		System.out.println(str);
	}
	
	
	/**
	 * List of all parents
	 */
	 
	public void showListOfParentsAccount() {
		showRegisteredCustomers();
	}
	
	public void showParentByID(int id) throws BankingCompileTimeException{
		showCustomerByID(id);
	}
	
	

}
