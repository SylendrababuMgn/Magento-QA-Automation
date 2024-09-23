package com.magento.pages;

import org.magento.seleniumBase.Locators;
import org.magento.seleniumBase.SeleniumBase;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage extends SeleniumBase {
	

	public LoginPage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public boolean pageTitle() {
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
	
	
}
