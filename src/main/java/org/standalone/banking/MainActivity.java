package org.standalone.banking;
import java.math.BigDecimal;
import java.util.Scanner;

import org.standalone.banking.actions.BankingThread;
import org.standalone.banking.actions.CustomerActions;
import org.standalone.banking.actions.ManagerActions;
import org.standalone.banking.actions.SonAccount;
import org.standalone.banking.entity.ParentsAccount;
import org.standalone.banking.exception.BankingCompileTimeException;
import org.standalone.banking.util.EntityValidation;
import org.standalone.banking.util.Global;
import org.standalone.banking.util.LogUtils;

public class MainActivity{
//public class MainActivity extends BaseActivity{
	private static LogUtils log = new LogUtils(MainActivity.class.getSimpleName());
	private static Scanner sn;
	
	public static void main(String args[]) throws BankingCompileTimeException {
		//instance of ManagerActions class
		ManagerActions managerActions= new ManagerActions();
		
		//crete the instance of CustomerActions class
		 CustomerActions  customerActions= new  CustomerActions();
		 
		 //create the instance of BankingThread
		 BankingThread bThrad= new BankingThread();
	
		String userInput;
		 sn = new Scanner(System.in);
		// loop the utility in loop until the user makes the choice to exit

		while (true) {
			// Print the options for the user to choose from
			System.out.println("****Please Choose the Options****");
			System.out.println("*. Press 1 Manager Actions");
			System.out.println("*. Press 2 Customer Actions");
			System.out.println("*. Press 3 Fetch Customer Actions Using Thread");
			System.out.println("*. Press 4 Parents Details");
			System.out.println("*. Press 5 Son Details");
			System.out.println("*. Press 6 Exit");
			System.out.println("Enter Your Choice:");
		  		
			// Capture the user input in scanner object and store it in a pre declared
			// variable
			userInput = sn.next();
			// Check the user input
			switch (userInput) {
			
			case "1":
				managerActions.managerActionChoice();
				break;
		       
			case "2":
				customerActions.customerActionChoice();
				break;
				
			case "3":
				bThrad.start();
				break;
			case "4":
				ParentsAccount pa= new ParentsAccount(222,7373.33,"Unnao");
				pa.getParentsDetails();
				break;	
				
			case "5":
				SonAccount son= new SonAccount(222,7373.33,"Unnao");
				 son.showParentByID(9);;
				 son.AccountDetails();
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
		
		
	}
	
	
}
