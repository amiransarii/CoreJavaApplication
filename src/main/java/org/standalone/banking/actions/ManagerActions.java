package org.standalone.banking.actions;
import java.util.Scanner;
import org.standalone.banking.BaseActivity;
import org.standalone.banking.MainActivity;
import org.standalone.banking.exception.BankingCompileTimeException;
import org.standalone.banking.util.LogUtils;

/**
 * 
 * @author Amir Ansari created at 19-10-2019 
 * handle manager actions here
 */
public class ManagerActions extends BaseActivity {
	private Scanner sn;

	private static LogUtils log = new LogUtils(ManagerActions.class.getSimpleName());

	/**
	 * ManagerAction default constructor
	 */
	public ManagerActions() {

	}

	public void managerActionChoice() throws BankingCompileTimeException {

		int custID;
		boolean isLogin=false;
		// declare a variable that will store the user input
		String userInput;
		// declate a scanner object to read the command line input by user
		sn = new Scanner(System.in);
		// loop the utility in loop until the user makes the choice to exit

		while (true) {
			// Print the options for the user to choose from
			System.out.println("****Please Choose the Options****");
			System.out.println("*. Press 1 Admin Login");
			System.out.println("*. Press 2 Customer Registration");
			System.out.println("*. Press 3 Display All Registered Customer");
			System.out.println("*. Press 4 Display Customer By ID");
			System.out.println("*. Press 5 Update Customer By Email");
			System.out.println("*. Press 6 Delete Customer By Id");
			System.out.println("*. Press 7 Delete All Customer");
			System.out.println("*. Press 8 Exit");
			System.out.println("Enter Your Choice:");

			// Capture the user input in scanner object and store it in a pre declared
			// variable
			userInput = sn.next();
			// Check the user input
			switch (userInput) {

			case "1":
				isLogin=doAccountLogin("admintable", sn);
				break;
			case "2":
				if(!isLogin) 
					System.out.println("*. Please  Login First");
				else
				doRegistration(sn);
				break;
			case "3":
				if(!isLogin) 
					System.out.println("*. Please  Login First");
				else
				showRegisteredCustomers();
				break;
			case "4":
				if(!isLogin) 
					System.out.println("*. Please  Login First");
				else
				System.out.print("Please Enter Customer ID");
				custID = sn.nextInt();
				showCustomerByID(custID);
				break;
			case "5":
				updateCustomer(sn);
				break;
			case "6":
				if(!isLogin) 
					System.out.println("*. Please  Login First");
				else
				System.out.print("Please Enter Customer ID");
				custID = sn.nextInt();
				deleteCustomerById(custID);
				break;
			case "7":
				if(!isLogin) 
					System.out.println("*. Please  Login First");
				else
				deleteAllCustomers();
				break;

			case "8":
				// exit from the program
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				// inform user in case of invalid choice.
				System.out.println("Invalid choice. Read the options carefully...");
			}
		}

	}

}
