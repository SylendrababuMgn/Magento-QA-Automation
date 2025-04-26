package com.magnto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.magento.seleniumBase.Locators;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.report.CustomAssert;
import com.util.LogUtil;


public class LoginTestCase extends Base {

	
	private static final Logger log = LogManager.getLogger(LoginTestCase.class);
	@Test(dataProvider = "data")
	public void TC01_valid_login(String email, String password) {
		
		log.info("Started Executing TC01_valid_login... ");
		CustomAssert.assertTrue(page.getpageTitle(), "Validating page Title is present or not");
		CustomAssert.assertTrue(page.getEmailLabel(), "Validateing email label is present or not");
		CustomAssert.assertTrue(page.getPasswordLabel(), "Validating password label is present or not");
		page.enterEmail(email);
		page.enterPasword(password);
		page.clickSignIn();
		
		String loginSuccess;
		try {
			loginSuccess = page.getText(page.element(Locators.xpath, "//div[@class='box-content']")).split("\n")[1];
		} catch (Exception e) {
			driver.navigate().refresh();
			loginSuccess = page.getText(page.element(Locators.xpath, "//span[@class=\"logged-in\"]"));
		}
		
		Assert.assertEquals(loginSuccess,email);
	}
	
	@Test(dataProvider = "data")
	public void TC02_Invalid_login(String[] data) throws InterruptedException {
		System.out.println(data[0]);
		page.enterEmail(data[0]);
		page.enterPasword(data[1]);
		page.clickSignIn();
		Thread.sleep(2000);
		CustomAssert.assertTrue(page.getErrorMessgae(), "Validating error message for invalid login");
	}
	
	@Test
	public void TC03_valid_signUp() {
		signUp.signUp("Babu", "M", "Babu@gmail.com", "abc@1234", "abc@1234");
	}
	
	@Test
	public void TC04_Invalid_signUp() {
		signUp.signUp("Babu", "M", "Babu@", "abc@1234", "abc@1234");
	}
	
	@Test
	public void TC05_PlaceOrderFromHomePage() throws InterruptedException {
		home.navigateToHomePage();
		home.selectProduct("Fusion Backpack");
		product.enterQTY("2");
		product.clickAddToCart();
		Thread.sleep(2000);
		home.selectMyCart();
		home.clickProceedToCheckOut();
		
	}
	
	@Test
	public void TC06_SearchProduct() {
		home.navigateToHomePage();
		home.typeSearchBox("Shirts");
		home.selectSearchDropDown("shirts for men");
	}
	
	
	
}
