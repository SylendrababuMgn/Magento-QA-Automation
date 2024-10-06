package com.magento.pages;

import org.magento.seleniumBase.Locators;
import org.magento.seleniumBase.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends SeleniumBase {
	

	public LoginPage(WebDriver driver, WebDriverWait wait) {
	  	this.driver = driver;
	  	this.wait = wait;
	}
//	
//	public LoginPage(RemoteWebDriver driver) {
//		super(driver);
//	}

	public boolean getpageTitle() {
		return isDisplayed(element(Locators.xpath,"//span[text()='Customer Login']"));
	}
	
	public boolean getEmailLabel() {
		return isDisplayed(element(Locators.xpath,"//span[text()='Email']"));
	}
	
	public boolean getPasswordLabel() {
		return isDisplayed(element(Locators.xpath,"//span[text()='Password']"));
	}
	/**
	 * 
	 * @param emailAddress - enter the email address to be logged in
	 * @return
	 */
	public void enterEmail(String emailAddress){
		type(element(Locators.xpath,"//input[@name='login[username]']"),emailAddress);
	}
	
	/**
	 * 
	 * @param Password - enter password
	 * @return
	 */
	public void enterPasword(String Password){
		type(element(Locators.xpath,"//input[@name='login[password]']"),Password);
	}
	
	public void clickSignIn() {
		click(element(Locators.xpath,"//button[@class='action login primary']"));
		
	}
	
	public boolean getErrorMessgae() {
		return isDisplayed(element(Locators.xpath, "//div[@role='alert']"));
	}
	
	public void login(String email, String password) {
		enterEmail(email);
		enterPasword(password);
		clickSignIn();
	}
}
