package org.standalone.banking;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import org.standalone.banking.actions.CustomerActions;
import org.standalone.banking.constant.ErrorCode;
import org.standalone.banking.db.BankingDbActions;
import org.standalone.banking.entity.CustomerInfo;
import org.standalone.banking.exception.BankingCompileTimeException;
import org.standalone.banking.util.EntityValidation;
import org.standalone.banking.util.LogUtils;

public abstract class BaseActivity {
	private static LogUtils log = new LogUtils(BaseActivity.class.getSimpleName());
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// admin Login
	protected static boolean doAccountLogin(String tableName,Scanner sn) {
		boolean isLogin=false;
		System.out.print("Enter Email");
		String emailID = sn.next();
		System.out.print("Enter Password");
		String pass = sn.next();
		 isLogin = BankingDbActions.isValidateAccount(tableName,emailID, pass);
		if (isLogin) {
			log.info("*.Admin Login Success " + emailID);
		} else {
			log.info("*.Please Enter Correct EmailId and Password");
			doAccountLogin(tableName,sn);
		}
       return  isLogin;
	}

	// customer registration
	protected static void doRegistration(Scanner sn) throws BankingCompileTimeException {
		String emailID = "";
		String pass = "";
		String cPass = "";
		// sn= new Scanner(System.in);
		System.out.print("Enter Full Name");
		String fullName = sn.next();
		System.out.print("Enter Mobile Number");
		Long mobileNumber = sn.nextLong();
		System.out.print("Enter Balance");
		double availableAmount = sn.nextDouble();

		System.out.print("Enter Gender");
		String gender = sn.next();

		System.out.print("Enter Email");
		emailID = sn.next();

		if (!EntityValidation.isValidEmail(emailID)) {
			System.out.println("Please Enter Correct Emai");
			System.out.print("Enter Email");
			emailID = sn.next();
		}

		System.out.print("Enter Password");
		pass = sn.next();
		if (pass.length() < 6) {
			System.out.println("Password Length should not be less than 6");
			System.out.print("Enter Password");
			pass = sn.next();
		}

		System.out.print("Enter Confirm Password");
		cPass = sn.next();
		if (cPass.length() < 6) {
			System.out.println("Confirm Password Length should not be less than 6");
			System.out.print("Enter Confirm Password");
			cPass = sn.next();
		}

		if (!pass.equals(cPass)) {
			System.out.println("Please Check Password and Confirm Password");
			System.out.print("Enter Confirm Password");
			cPass = sn.next();
		}

		System.out.print("Enter Address");
		String address = sn.next();

		System.out.print("Want to Save please Enter Yes or No");
		String choice = sn.next();
		if (choice.equals("No")) {
			System.exit(0);
		}

		int saved = BankingDbActions.doRegistration(fullName, mobileNumber, gender, availableAmount, emailID, pass,
				address);
		if (saved == -1) {
			log.info("UnSuccesfull Registration");
		} else {
			log.info("Registration done Successfully");
		}
	}

	/**
	 * show All registered customers
	 */
	protected static void showRegisteredCustomers() {

		try {
			List<CustomerInfo> customerList = BankingDbActions.getAllRegisteredCustomerList();

			customerList.forEach(cust -> {
				System.out.println("Record of Customer " + cust.getCustID() + "**********************");
				System.out.println("Customer ID " + cust.getCustID());
				System.out.println("Full Name " + cust.getFullName());
				System.out.println("Mobile Number" + cust.getMobileNumber());
				System.out.println("Gender " + cust.getGender());
				System.out.println("Available Amount " + cust.getAvailableAmount());
				System.out.println("Email ID " + cust.getEmailId());
				System.out.println("Address " + cust.getAddress());
				System.out.println("Created Account Date " + sdf.format(cust.getCreatedDate()));
				System.out.println("");

			});

		} catch (BankingCompileTimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param id show customer by Id
	 * @throws BankingCompileTimeException
	 */
	protected static void showCustomerByID(int id) throws BankingCompileTimeException {
		try {
			CustomerInfo cust = BankingDbActions.getCustomerById(id);
			System.out.println("Record of Customer " + cust.getCustID() + "**********************");
			System.out.println("Customer ID " + cust.getCustID());
			System.out.println("Full Name " + cust.getFullName());
			System.out.println("Mobile Number" + cust.getMobileNumber());
			System.out.println("Gender " + cust.getGender());
			System.out.println("Available Amount " + cust.getAvailableAmount());
			System.out.println("Email ID " + cust.getEmailId());
			System.out.println("Address " + cust.getAddress());
			System.out.println("Created Account Date " + sdf.format(cust.getCreatedDate()));
			System.out.println("");
		} catch (BankingCompileTimeException e) {
			throw new BankingCompileTimeException("Record does not exist", ErrorCode.NULLPOINTERCODE);
		}
	}

	/**
	 * update customer by email
	 */
	protected static void updateCustomer(Scanner sn) throws BankingCompileTimeException {
		System.out.print("Enter Email");
		String emailID = sn.next();
		System.out.print("Enter Full Name");
		String fullName = sn.next();
		System.out.print("Enter Password");
		String pass = sn.next();

		int saved = BankingDbActions.updateCustomerById(emailID, fullName, pass);
		if (saved > 0) {
			log.info("Record Successfully Updated");
		} else {
			log.info("Record not updated");
		}

	}

	/**
	 * 
	 * @param pass the customer Id which want to be delete
	 * @throws BankingCompileTimeException it will throw exception for invalid
	 *                                     arguments
	 */
	protected static void deleteCustomerById(int custId) throws BankingCompileTimeException {
		int deleted = BankingDbActions.deleteCustomerById(custId);
		if (deleted > 0) {
			log.info("Record deleted Successfully");
		} else {
			log.info("Sorry,Record is not deleted");
		}

	}

	/**
	 * delete all customers
	 * 
	 * @throws BankingCompileTimeException
	 */
	protected static void deleteAllCustomers() throws BankingCompileTimeException {
		int deletedAll = BankingDbActions.deleteCustomerAll();
		if (deletedAll > 0) {
			log.info("All Customers deleted");
		} else {
			log.info("Unable to delete All Customers");
		}
	}

	/**
	 * 
	 * @param custID enter the customer id
	 * @param amount enter the amount
	 * @throws BankingCompileTimeException throw exception
	 */
	protected static void addDeposit(int custID, double amount) throws BankingCompileTimeException {
		int updatedBalance = BankingDbActions.updateAccountBalance(custID, amount);
		if (updatedBalance > 0) {
			log.info("Accout Balance deposited successfully");
		} else {
			log.info("Unable to update Blance ");
		}
	}

	/**
	 * 
	 * @param custID customer Id
	 * @param amount enter the amount which want to withdraw
	 * @throws BankingCompileTimeException
	 */
	protected static void withDrawAmount(int custID, double amount) throws BankingCompileTimeException {
		int updatedBalance = BankingDbActions.withdrawAccountBalance(custID, amount);
		if (updatedBalance > 0) {
			log.info("Account Balance withdraw successfully");
		} else {
			log.info("Unable to withdraw ");
		}
	}
	
	

}
