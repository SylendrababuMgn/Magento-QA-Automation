package com.magnto;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.pages.LoginPage;
import com.magento.pages.SignUpPage;

public class SignUpTestCase extends Base {


	public SignUpPage signUp;
	@BeforeMethod
	public void startApp() {
		driver = setUp(URL);
		signUp = new SignUpPage(driver, wait);
		
	}
	
@Test
public void TC01_valid_login() {
	signUp.signUp("Babu", "M", "Babu@gmail.com", "abc@1234", "abc@1234");
}

@Test
public void TC02_valid_login() {
	signUp.signUp("Sylu", "M", "Sylu@gmail.com", "abc@1234", "abc@1234");
}
}
