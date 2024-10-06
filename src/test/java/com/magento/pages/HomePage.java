package com.magento.pages;

import java.util.List;

import org.magento.seleniumBase.Locators;
import org.magento.seleniumBase.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends SeleniumBase{
	
	private String singInLoc = "//div[@class='panel header']//li[@class='authorization-link']//a";
	private String creatAccountLoc = "//div[@class='panel header']//a[text()='Create an Account']";
	private String searchBoxLocId = "//input[@id='search']";
	private String whatsNewPageLoc = "//span[text()=\"What's New\"]";
	private String WomanCategoryLoc = "//span[text()='Women']";
	private String menCategoryLoc = "//span[text()='Men']";
	private String GearCategoryLoc = "//span[text()='Gear']";
	private String TrainingCategoryLoc = "//span[text()='Training']";
	private String SaleCategoryLoc = "//span[text()='Sale']";
	private String productsLoc = "//strong[@class='product-item-name']";
	private String productNameLoc =  "//a[@title='Fusion Backpack']";
	private String logoLoc = "//a[@class='logo']";
	private String searchDropDownLoc = "//span[@class='qs-option-name']";
	private String myCartLoc = "//div[@class='minicart-wrapper']";
	private String addToCartLoc = "//span[@class='counter-number']";
	private String proceedToCheckOutLoc = "top-cart-btn-checkout";
	
	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void navigateToHomePage() {
		click(element(Locators.xpath, logoLoc));
	}
	public void clickSignIn() {
		click(element(Locators.xpath, singInLoc));
	}
	
	public void createAccount() {
		click(element(Locators.xpath, creatAccountLoc));
	}

	public void typeSearchBox(String productName) {
		click(element(Locators.xpath, searchBoxLocId));
		type(element(Locators.xpath, searchBoxLocId), productName);
	}
	
	public void clickwhatsNewPage() {
		click(element(Locators.xpath, whatsNewPageLoc));
	}
	
	public void clickWomanCategory() {
		click(element(Locators.xpath, WomanCategoryLoc));
	}
	
	public void clickMenCategory() {
		click(element(Locators.xpath, menCategoryLoc));
	}
	
	public void clickGearCategory() {
		click(element(Locators.xpath, GearCategoryLoc));
	}
	
	public void clickTrainingCategory() {
		click(element(Locators.xpath, TrainingCategoryLoc));
	}

	public void clickSaleCategoryLoc() {
		click(element(Locators.xpath, SaleCategoryLoc));
	}
	public void selectProduct(String productName) {
		List<WebElement> products =  driver.findElements(By.xpath(productsLoc));
		
		click(element(Locators.xpath, "//a[@title='"+productName+"']"));
				
			
		
	}
	
	public void selectSearchDropDown(String productName) {
		
		List<WebElement> dropDownList = driver.findElements(By.xpath(searchDropDownLoc));
		for(WebElement dropDown:dropDownList) {
//			System.out.println(productName);
			if(dropDown.getText().equalsIgnoreCase(productName)) {
			System.out.println(dropDown.getText());
			click(element(Locators.xpath, "//span[text()=' "+productName+"']"));
			break;
			}
		}
	}
	
	public void selectMyCart() throws InterruptedException {
		WebElement ele = isElementVisible(element(Locators.xpath, myCartLoc));
		click(ele);
	}
	
	public String getCartCount() {
		return getText(element(Locators.xpath, addToCartLoc));
	}
	
	public void clickProceedToCheckOut() {
		click(element(Locators.id, proceedToCheckOutLoc));
	}

}
