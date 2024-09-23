package com.magnto;

import org.magento.seleniumBase.SeleniumBase;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.magento.pages.LoginPage;

public class LoginTestCase extends SeleniumBase {
	SeleniumBase base = new SeleniumBase();
	RemoteWebDriver driver = null;
	@BeforeTest
	public void setup() {
		driver = base.setUp("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/");
	}
	
	@AfterTest
	public void quit() {
		base.quit();
	}
	@Test
	public void TC01login() {
		
		LoginPage p = new LoginPage(driver);
//		base.setUp("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/");
		System.out.println("drive=>"+" "+ driver);	
		p.enterEmail("msb6246@gmail.com");
			p.enterPasword("Babu@1234");
			p.clickSignIn();
	}
}
