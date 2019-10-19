package org.standalone.banking.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.standalone.banking.actions.CustomerActions;
import org.standalone.banking.constant.ErrorCode;
import org.standalone.banking.entity.CustomerInfo;
import org.standalone.banking.exception.BankingCompileTimeException;
import org.standalone.banking.util.LogUtils;

/**
 * 
 * @author Amir Ansari
 * created at 19-10-2019
 * Handle all the DB methods in this class
 * like manager login,customer login,deposit 
 */


public class BankingDbActions {
	private static LogUtils log = new LogUtils(BankingDbActions.class.getName());
	private static PreparedStatement psmt = null;
	
	   
	/**
	 * 
	 * @param email enter email for login
	 * @param pass enter password for login
	 * @return
	 */
		public static boolean isValidateAccount(String table,String email, String pass) {
			String sqlQuery = "select * from "+table+" where emailID=? and password=?";
			try {
				PreparedStatement psmt = DbPreparedStatement.getPreparedStatement(sqlQuery);
				psmt.setString(1, email);
				psmt.setString(2, pass);
				ResultSet rs = psmt.executeQuery();
				return rs.next();
			} catch (SQLException e) {
				log.error("Valid User SQLException " + e.getMessage());
			} catch (Exception e) {
				log.error("Valid User Cach Exception " + e.getMessage());
			}
        	return false;
		}
		
		

		// customer account opening registration
		public static int doRegistration(String fullName, Long mobileNo, String gender, double availableAmount,
				String emailID, String password, String address) throws BankingCompileTimeException {

			int registrationDone = -1;
			String sqlQuery = " insert into customertable (fullName,mobileNo,gender,availableAmount,emailID,password,address)"
					+ " values (?, ?, ?, ?, ?,?,?)";
			try {
				psmt = DbPreparedStatement.getPreparedStatement(sqlQuery);
				psmt.setString(1, fullName);
				psmt.setLong(2, mobileNo);
				psmt.setString(3, gender);
				psmt.setDouble(4, availableAmount);
				psmt.setString(5, emailID);
				psmt.setString(6, password);
				psmt.setString(7, address);

				registrationDone = psmt.executeUpdate();
				// close the connection
				DbPreparedStatement.closeConnection();
			} catch (SQLException e) {
				log.error("Valid User SQLException " + e.getMessage());
			} catch (Exception e) {
				throw new BankingCompileTimeException(e.getMessage(), ErrorCode.NULLPOINTERCODE);
			}
			return registrationDone;
		}
		
		
		
		/**
		 * List of All registered Customers
		 */
		public static List<CustomerInfo> getAllRegisteredCustomerList() throws BankingCompileTimeException {
			String sqlQuery = "SELECT custID, fullName,	mobileNo,gender,availableAmount,"
					+ "emailID,address,createdAccount " + "FROM customertable";
			List<CustomerInfo> custList = new ArrayList<CustomerInfo>();
			try {
				psmt = DbPreparedStatement.getPreparedStatement(sqlQuery);
				ResultSet rs = psmt.executeQuery();

				// loop to fetch all the records
				while (rs.next()) {

					int custID = rs.getInt("custID");
					String fullName = rs.getString("fullName");
					Long mobileNumber = rs.getLong("mobileNo");
					String gender = rs.getString("gender");
					double availableAmount = rs.getDouble("availableAmount");
					String emailID = rs.getString("emailID");
					String address = rs.getString("address");
					Date createdDate = rs.getDate("createdAccount");
					custList.add(new CustomerInfo(custID, fullName, mobileNumber, gender, availableAmount, emailID, address,
							createdDate));
				}
				// close the connection
				rs.close();
				DbPreparedStatement.closeConnection();
				return custList;
				// DbPreparedStatement.closeConnection();
			} catch (SQLException e) {
				log.error("Valid User SQLException " + e.getMessage());
			} catch (Exception e) {
				throw new BankingCompileTimeException(e.getMessage(), ErrorCode.NULLPOINTERCODE);
			}
        	return custList;
		}
		

		
		/**
		 * get the customer by ID
		 */

		public static CustomerInfo getCustomerById(int id) throws BankingCompileTimeException {
			CustomerInfo customer = null;
			String sqlQuery = "Select * from customertable where custID='" + id + "'";
			try {
				psmt = DbPreparedStatement.getPreparedStatement(sqlQuery);
				ResultSet rs = psmt.executeQuery();

				// loop to fetch all the records
				while (rs.next()) {
					int custID = rs.getInt("custID");
					String fullName = rs.getString("fullName");
					Long mobileNumber = rs.getLong("mobileNo");
					String gender = rs.getString("gender");
					double availableAmount = rs.getDouble("availableAmount");
					String emailID = rs.getString("emailID");
					String address = rs.getString("address");
					Date createdDate = rs.getDate("createdAccount");
					customer = new CustomerInfo(custID, fullName, mobileNumber, gender, availableAmount, emailID, address,
							createdDate);
				}
				// close the connection
				rs.close();
				DbPreparedStatement.closeConnection();
				return customer;
				// DbPreparedStatement.closeConnection();
			} catch (SQLException e) {
				log.error("Valid User SQLException " + e.getMessage());
			} catch (Exception e) {
				throw new BankingCompileTimeException(e.getMessage(), ErrorCode.NULLPOINTERCODE);
			}

			return customer;

		}


		/**
		 * update customer by email
		 */
		public static int updateCustomerById(String email, String fullname, String password)
				throws BankingCompileTimeException {

			String sqlQuery = "UPDATE customertable SET password=?, fullname=? WHERE emailID=?";
			int registrationUpdate = -1;
			try {
				psmt = DbPreparedStatement.getPreparedStatement(sqlQuery);
				psmt.setString(1, password);
				psmt.setString(2, fullname);
				psmt.setString(3, email);
				registrationUpdate = psmt.executeUpdate();
				// close the connection
				DbPreparedStatement.closeConnection();
			} catch (SQLException e) {
				log.error("Valid User SQLException " + e.getMessage());
			} catch (Exception e) {
				throw new BankingCompileTimeException(e.getMessage(), ErrorCode.NULLPOINTERCODE);
			}
			return registrationUpdate;

		}


		/**
		 * delete customer by Id
		 */
		public static int deleteCustomerById(int customerId) throws BankingCompileTimeException {

			String sqlQuery = "delete from customertable where custID = ?";
			int deletedCustomer = -1;
			try {
				psmt = DbPreparedStatement.getPreparedStatement(sqlQuery);
				psmt.setInt(1, customerId);
				deletedCustomer = psmt.executeUpdate();
				// close the connection
				DbPreparedStatement.closeConnection();
			} catch (SQLException e) {
				log.error("Valid User SQLException " + e.getMessage());
			} catch (Exception e) {
				throw new BankingCompileTimeException(e.getMessage(), ErrorCode.NULLPOINTERCODE);
			}
			return deletedCustomer;

		}
		
		/**
		 * delete all customer
		 */

		public static int deleteCustomerAll() throws BankingCompileTimeException {
			String sqlQuery = "delete from customertable";
			int deletedAll = -1;
			try {
				psmt = DbPreparedStatement.getPreparedStatement(sqlQuery);
				deletedAll = psmt.executeUpdate();
				// close the connection
				DbPreparedStatement.closeConnection();
			} catch (SQLException e) {
				log.error("Valid User SQLException " + e.getMessage());
			} catch (Exception e) {
				throw new BankingCompileTimeException(e.getMessage(), ErrorCode.NULLPOINTERCODE);
			}
			return deletedAll;

		}
		
		
		/**
		 * add deposit amount
		 */
		
		public static int updateAccountBalance(int custID,double amount)
				throws BankingCompileTimeException  {
			//availableAmount	
			String sqlQuery = "Select availableAmount from customertable where custID='" + custID + "'";
			int updateBalance = -1;
			try {
				psmt = DbPreparedStatement.getPreparedStatement(sqlQuery);
				ResultSet resultSet=psmt.executeQuery();
				resultSet.next();
			    
				 if(amount<0) {
					 throw new
					 BankingCompileTimeException("Unsufficient Fund", ErrorCode.NULLPOINTERCODE);
				 } 
				 double balance=resultSet.getInt(1)+amount;
				 resultSet.close();
				 	
				 sqlQuery= "UPDATE customertable SET availableAmount=? WHERE custID=?";
				 psmt = DbPreparedStatement.getPreparedStatement(sqlQuery);
				 
				 psmt.setDouble(1, balance);
				 psmt.setInt(2, custID);
				 updateBalance= psmt.executeUpdate();
				 
				// close the connection
				DbPreparedStatement.closeConnection();
							
			}catch (Exception e) {
				throw new BankingCompileTimeException(e.getMessage(), ErrorCode.NULLPOINTERCODE);
			}
				return updateBalance;
		}
		
		/**
		 * 
		 * @param custID enter customer id
		 * @param account
		 * @return
		 * @throws BankingCompileTimeException
		 */
		public static int withdrawAccountBalance(int custID,double amount)
				throws BankingCompileTimeException  {
			//availableAmount	
			String sqlQuery = "Select availableAmount from customertable where custID='" + custID + "'";
			int updateBalance = -1;
			try {
				psmt = DbPreparedStatement.getPreparedStatement(sqlQuery);
				ResultSet resultSet=psmt.executeQuery();
				resultSet.next();
			    
				 if(amount<0) {
					 throw new
					 BankingCompileTimeException("Unsufficient Fund", ErrorCode.NULLPOINTERCODE);
				 } 
				 double balance=resultSet.getInt(1)-amount;
				 
				 if(balance<0) {
					 throw new
					 BankingCompileTimeException("Unsufficient Fund", ErrorCode.NULLPOINTERCODE);
				 } 
				 
				 resultSet.close();	 	
				 sqlQuery= "UPDATE customertable SET availableAmount=? WHERE custID=?";
				 psmt = DbPreparedStatement.getPreparedStatement(sqlQuery);
				 
				 psmt.setDouble(1, balance);
				 psmt.setInt(2, custID);
				 updateBalance= psmt.executeUpdate();
				 
				// close the connection
				DbPreparedStatement.closeConnection();
							
			}catch (Exception e) {
				throw new BankingCompileTimeException(e.getMessage(), ErrorCode.NULLPOINTERCODE);
			}
				return updateBalance;
		}
		
		
		
}
