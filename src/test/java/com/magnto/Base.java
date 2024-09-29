package com.magnto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.util.ReadExcel;


public class Base {
	String URL = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/";

	protected RemoteWebDriver driver = null;
	public String fileName = "";
	
	@DataProvider(name="data")
	public String[][] dataProvider() {
		String[][] excelData = ReadExcel.getExcelData(fileName);
		return excelData;
	}

	@BeforeMethod
	public void startApp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	@AfterMethod
	public void closeApp() {
		driver.quit();
		
	}


}
