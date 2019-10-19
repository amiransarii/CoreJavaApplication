package org.standalone.banking.actions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.standalone.banking.BaseActivity;
import org.standalone.banking.constant.ErrorCode;
import org.standalone.banking.db.DbPreparedStatement;
import org.standalone.banking.entity.CustomerInfo;
import org.standalone.banking.exception.BankingCompileTimeException;
import org.standalone.banking.util.LogUtils;

/**
 * 
 * @author Amir Ansari created at 19-10-2019 handle all the customer related
 *         actions here
 */
public class CustomerActions extends BaseActivity {
	private static LogUtils log = new LogUtils(CustomerActions.class.getName());
	private Scanner sn;

	/**
	 * default constructor
	 */
	public CustomerActions() {

	}

	/**
	 * customer actions
	 */

	public void customerActionChoice() throws BankingCompileTimeException {
		try {
			int custID;
			double balance;
			boolean isLogin = false;
			// declare a variable that will store the user input
			String userInput;
			// declate a scanner object to read the command line input by user
			sn = new Scanner(System.in);
			// loop the utility in loop until the user makes the choice to exit

			while (true) {
				// Print the options for the user to choose from
				System.out.println("****Please Choose the Options****");
				System.out.println("*. Press 1 Customer Login");
				System.out.println("*. Press 2 Display Customer By ID");
				System.out.println("*. Press 3 Update Customer By Email");
				System.out.println("*. Press 4 Please Enter Amount for Deposit");
				System.out.println("*. Press 5 Please Enter Amount for Withdraw");
				System.out.println("*. Press 6 Exit");
				System.out.println("Enter Your Choice:");

				// Capture the user input in scanner object and store it in a pre declared
				// variable
				userInput = sn.next();
				// Check the user input
				switch (userInput) {

				case "1":
					isLogin = doAccountLogin("customertable", sn);
					break;
				case "2":
					if (!isLogin)
						System.out.println("*. Please  Login First");
					else {
						System.out.print("Please Enter Customer ID");
						custID = sn.nextInt();
						showCustomerByID(custID);
					}
					
					break;
				case "3":
					if (!isLogin)
						System.out.println("*. Please  Login First");
					else
						updateCustomer(sn);
					break;
				case "4":
					if (!isLogin)
						System.out.println("*. Please  Login First");
					else
					{
						System.out.print("Please Enter Customer ID");
						custID = sn.nextInt();
						System.out.print("Please EnterAmount");
						balance = sn.nextDouble();
						addDeposit(custID, balance);
					}
					break;

				case "5":
					if (!isLogin)
						System.out.println("*. Please  Login First");
					else
					{
						System.out.print("Please Enter Customer ID");
						custID = sn.nextInt();
						System.out.print("Please EnterAmount");
						balance = sn.nextDouble();
						withDrawAmount(custID, balance);
					}
					break;
				case "6":
					// exit from the program
					System.out.println("Exiting...");
					System.exit(0);
					break;
				default:
					// inform user in case of invalid choice.
					System.out.println("Invalid choice. Read the options carefully...");
				}
			}

		} catch (Exception e) {
			throw new BankingCompileTimeException("Invalid choice " + e.getMessage(), ErrorCode.NULLPOINTERCODE);
		}
	}

}
