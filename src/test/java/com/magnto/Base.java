package com.magnto;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.magento.seleniumBase.SeleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.magento.pages.HomePage;
import com.magento.pages.LoginPage;
import com.magento.pages.ProductPage;
import com.magento.pages.SignUpPage;
import com.util.ReadExcel;


public class Base extends SeleniumBase {
	
	String URL = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/";
	
//	protected RemoteWebDriver driver = null;
	public String fileName = ".\\src\\test\\resources\\Test Data";
	
	@DataProvider(name="data")
	public String[][] dataProvider(Method method) {
		String sheet = method.getName().split("_")[0];
		String[][] excelData = ReadExcel.getExcelData(fileName, sheet);
		return excelData;
	}
	
	public LoginPage p;
	public SignUpPage signUp;
	public HomePage home;
	public ProductPage product;
	@BeforeMethod
	public void startApp() {
		
		driver = setUp(URL);
		driver.manage().deleteAllCookies();
		p = new LoginPage(driver, wait);
		signUp = new SignUpPage(driver, wait);
		home = new HomePage(driver, wait);
		product = new ProductPage(driver, wait);
	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public void closeApp() {
		driver.quit();
		
	}


}
