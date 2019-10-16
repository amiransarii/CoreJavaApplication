package org.standalone.banking.util;

import java.util.regex.Pattern;

/**
 * 
 * @author Amir Ansari
 * created at 16-10-19 Entity Validation class
 * can check entity condition
 */
public class EntityValidation {
	
	
	/**
	 * 
	 * @param email check email is valid or not
	 * @return true if valid else false
	 */
	public static boolean isValidEmail(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 

}
