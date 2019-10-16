package org.standalone.banking;

import java.util.Scanner;

import org.standalone.banking.util.Global;

public class Main {
	public static void main(String args[]) {

		// declare a variable that will store the user input
		String userInput;
		// declate a scanner object to read the command line input by user
		Scanner sn = new Scanner(System.in);
		// loop the utility in loop until the user makes the choice to exit

		while (true) {
			// Print the options for the user to choose from
			System.out.println("****Please Choose the Options****");
			System.out.println("*. Press 1 Registration");
			System.out.println("*. Press 2 Login");
			System.out.println("*. Press 3 Display Registered Customer");
			System.out.println("*. Press 4 Exit");
			System.out.println("Enter Your Choice:");

			// Capture the user input in scanner object and store it in a pre declared
			// variable
			userInput = sn.next();

			// Check the user input
			switch (userInput) {
			case "1":
				// System.out.println("1.Registration Done");
				doRegistration(sn);
				break;
			case "2":
				System.out.println("2.Login");
				break;
			case "3":
				System.out.println("3.Display Registered Customer");
				break;
			case "4":
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

	private static void doRegistration(Scanner sn) {
		sn= new Scanner(System.in);
		System.out.print("Enter Full Name");
		String fullName = sn.next();
		 System.out.print("Enter Mobile Number");
		 int mobileNumber = sn.nextInt();
		System.out.print("Enter Balance");
		double availableAmount = sn.nextDouble();
		
		System.out.print("Enter Gender");
		String gender = sn.next();
		
		System.out.print("Enter Email");
		String email = sn.next();

		System.out.print("Enter Password");
		String pass = sn.next();

		System.out.print("Enter Confirm Password");
		String cPass = sn.next();

		System.out.print("Enter Address");
		String address = sn.next();
		
		System.out.println("Want to Save please Enter Yes or No");
		String choice = sn.nextLine();
		if(choice.equals("No")) {
			System.exit(0);
		}
		
		System.out.println(null +", "+mobileNumber +" ,"+gender +" ,"+availableAmount +" ,"+
		email +" ,"+pass +" ,"+cPass +" ,"+address);

	}

	private static void initialization() {
		Global.loadConfig();

		System.out.println("DBClass Name " + Global.dbClassName);
	}

}
