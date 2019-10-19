package org.standalone.banking.entity;

import java.util.Scanner;

import org.standalone.banking.exception.BankingCompileTimeException;

public interface BankingAction {

	// customer registration
	public void doRegistration(Scanner sc) throws BankingCompileTimeException;

	// display registered customers
	public void showRegisteredCustomers() throws BankingCompileTimeException;;

	// display customer by Id
	public void showCustomerById(int id) throws BankingCompileTimeException;;

	// delete customer by Id
	public void deleteCustomerById(int id) throws BankingCompileTimeException;;
	
	// update customer by Id
	public void updateCustomerByEmail(String email) throws BankingCompileTimeException;;
}
