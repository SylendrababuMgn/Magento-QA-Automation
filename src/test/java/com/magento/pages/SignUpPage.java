package com.magento.pages;

import org.magento.seleniumBase.Locators;
import org.magento.seleniumBase.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends SeleniumBase {
	
	private String firstNameLoc = "firstname";
	private String lastNameLoc = "lastname";
	private String emailLoc = "email_address";
	private String passwordLoc = "password";
	private String confirmPassLoc = "password-confirmation";
	private String createAcctLoc = "//button/span[text()='Create an Account']";
	private String pageTitle = "//h1";
	private String signUpUrlLoc = "//a[text()='Create an Account']";
	
	public SignUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void clickSignUp() {
		click(element(Locators.xpath, signUpUrlLoc));
	}
	
	public String getPageTitle() {
		return getText(element(Locators.xpath, pageTitle));
	}
	
	public void enterFirstName(String Name) {
		type(element(Locators.id,firstNameLoc), Name);
	}
	
	public void enterLastName(String lastName) {
		type(element(Locators.id,lastNameLoc), lastName);
	}
	
	public void enterEmail(String email) {
		type(element(Locators.id,emailLoc), email);
	}
	
	public void enterPassword(String password) {
		type(element(Locators.id,passwordLoc), password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		type(element(Locators.id,confirmPassLoc), confirmPassword);
	}
	
	public void clickCreateAccount() {
		click(element(Locators.xpath, createAcctLoc));
	}
	
	public void signUp(String firstName, String lastName, String email, String password, String confirmPassword) {
		clickSignUp();
		enterFirstName(firstName);
		enterLastName(lastName);
		enterEmail(email);
		enterPassword(password);
		enterConfirmPassword(confirmPassword);
		clickCreateAccount();
	}
	
}


