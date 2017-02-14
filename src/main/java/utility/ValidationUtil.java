package main.java.utility;

import java.time.LocalDate;

import com.jfoenix.controls.JFXDatePicker;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import main.java.dao.UserManager;
import main.java.err.ErrorMessage;
import main.java.model.User;

public class ValidationUtil {
	
	static UserManager userManager = new UserManager();
	public ValidationUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Validate user's first name.
	 * It shouldn't be empty. It shouldn't have special characters (!,@,#,$,%,&,*..)
	 */
	public static boolean validateFirstName(TextField firstNameTF, Text firstNameError) {
		// Validate first name's empty
		if (Utility.isTextFieldEmpty(firstNameTF)) {
			displayErrorMessage(firstNameError, ErrorMessage.EMPTY_FIELD_ERR);
			return false;
		} 
		
		if (!Utility.isNameValid(firstNameTF.getText())) {
			displayErrorMessage(firstNameError, ErrorMessage.INVALID_NAME_ERR);
			return false;
		}
		// Valid first name
		hideErrorMessage(firstNameError);
		return true;
	}
	
	/**
	 * Last name is validate through several phases.
	 * If it fails in one phase, the error message corresponding to
	 * that phase will be displayed. Function stops validating.
	 */
	public static boolean validateLastName(TextField lastNameTF, Text lastNameError) {
		// Validate first name
		if (Utility.isTextFieldEmpty(lastNameTF)) {
			displayErrorMessage(lastNameError, ErrorMessage.EMPTY_FIELD_ERR);
			return false;
		} 
		
		if (!Utility.isNameValid(lastNameTF.getText())) {
			displayErrorMessage(lastNameError, ErrorMessage.INVALID_NAME_ERR);
			return false;
		}
		
		// Passed all phases, set error text invisible
		hideErrorMessage(lastNameError);
		return true;
	}
	
	public static boolean validateUsername(TextField usernameTF, Text usernameError) {
		// Validate first name
		if (Utility.isTextFieldEmpty(usernameTF)) {
			displayErrorMessage(usernameError, ErrorMessage.EMPTY_FIELD_ERR);
			return false;
		}
		
		boolean userAlreadyExisted = false;
		if (userAlreadyExisted) {
			// Search through all database to find if user already existed
			// Print warning message
			return false;
		}
		
		// Check if username contains invalid characters
		boolean isContainedInvalidChar = false; 
		if (isContainedInvalidChar) {
			// Print warning message
			return false;
		}
		
		final int minLength = 6;
		final int maxLength = 15;
		if (usernameTF.getText().length() < minLength || usernameTF.getText().length() > maxLength) { // Length should be from 6 - 30 (Eg)
			// Print warning message
			displayErrorMessage(usernameError, ErrorMessage.INVALID_USERNAME_LENGTH_ERR);
			return false;
		}
		hideErrorMessage(usernameError);
		return true;
	}
	
	public static boolean validateOriginalPassword(PasswordField passwordPF, Text passwordError) {
		// Validate empty
		if (Utility.isTextFieldEmpty(passwordPF)) {
			passwordError.setText(ErrorMessage.EMPTY_FIELD_ERR);
			passwordError.setVisible(true);
			return false;
		}
		
		final int minLength = 8;
		if(passwordPF.getText().length() < minLength) {
			displayErrorMessage(passwordError, ErrorMessage.PASSWORD_TOO_SHORT_ERR);
			return false;
		}
		// Passed all validation
		hideErrorMessage(passwordError);
		return true;
	}
	
	public static boolean validateConfirmedPassword(PasswordField passwordPF, PasswordField confirmPasswordPF, Text confirmPasswordError) {
		if (Utility.isTextFieldEmpty(confirmPasswordPF)) {
			displayErrorMessage(confirmPasswordError, ErrorMessage.EMPTY_FIELD_ERR);
			return false;
		}
		
		if (!passwordPF.getText().equals(confirmPasswordPF.getText())) {
			System.err.println("Passwords not matching!");
			displayErrorMessage(confirmPasswordError, ErrorMessage.PASSWORD_NOT_MATCHED_ERR);
			return false;
		}
		// Passed all validation
		hideErrorMessage(confirmPasswordError);
		return true;
	}
	
	/**
	 * Validate email address:
	 * <p><ul>
	 * 	<li> Is email empty?
	 *  <li> Is email valid (contains only alphabets, underscore, and period)
	 *  <li> Is email already existing on database?
	 *  <ul><p>
	 */
	public static boolean validateEmail(TextField emailTF, Text emailError) {
		if (Utility.isTextFieldEmpty(emailTF)) {
			displayErrorMessage(emailError, ErrorMessage.EMPTY_FIELD_ERR);
			return false;
		}
		
		if (!Utility.isValidEmail(emailTF.getText())) {
			displayErrorMessage(emailError, ErrorMessage.INVALID_EMAIL_ERR);
			return false;
		}
		
		User user = userManager.findByEmail(emailTF.getText());
		if (null != user) {
			displayErrorMessage(emailError, ErrorMessage.EMAIL_TAKEN_ERR);
			return false;
		}
		// Passed all validations
		hideErrorMessage(emailError);
		return true;
	}
	
	public static boolean validateDoB(JFXDatePicker dateOfBirthDP, Text dobError) {
		LocalDate dob = dateOfBirthDP.getValue();
		if (null == dob) {
			displayErrorMessage(dobError, ErrorMessage.EMPTY_FIELD_ERR);
			return false;
		}
		LocalDate maxDate = LocalDate.of(2000, 1, 1);
		LocalDate minDate = LocalDate.of(1950, 1, 1);
		if (dob.isAfter(maxDate)) {
			displayErrorMessage(dobError, "You are too young to play stock!");
			return false;
		}
		
		if (dob.isBefore(minDate)) {
			displayErrorMessage(dobError, "You are too old to play stock!");
			return false;
		}
		
		hideErrorMessage(dobError);
		return true;
	}
	
	public static void displayErrorMessage(Text instance, String errMessage) {
		instance.setText(errMessage);
		instance.setVisible(true);
	}
	
	public static void hideErrorMessage(Text instance) {
		instance.setVisible(false);   
	}
}