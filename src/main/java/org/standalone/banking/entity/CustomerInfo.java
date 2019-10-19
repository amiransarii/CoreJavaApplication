package org.standalone.banking.entity;

import java.util.Date;

/**
 * 
 * @author Amir Ansari created at 18-10-19 created an entity class for customer
 *         attribute
 */
public class CustomerInfo {
	private int custID;
	private String fullName;
	private long mobileNumber;
	private String gender;
	private double availableAmount;
	private String emailId;
	private String address;
	private Date createdDate;
	
	public CustomerInfo(int custID, String fullName, long mobileNumber, String gender, double availableAmount,
			String emailId, String address, Date createdDate) {
		super();
		this.custID = custID;
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.availableAmount = availableAmount;
		this.emailId = emailId;
		this.address = address;
		this.createdDate = createdDate;
	}
	
	
	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(double availableAmount) {
		this.availableAmount = availableAmount;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	

}
