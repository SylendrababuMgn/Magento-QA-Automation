package com.magento.pages;

import org.magento.seleniumBase.Locators;
import org.magento.seleniumBase.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends SeleniumBase{

	private String productNameLoc = "//h1[@class='page-title']";
	private String productPriceLoc = "//span[@id='product-price-6']//span[@class='price']";
	private String QtyLoc = "//input[@type='number']";
	private String AddToCartBtnLoc = "//button[@title='Add to Cart']";
	public ProductPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public String getProductName() {
		
		return getText(element(Locators.xpath, productNameLoc));
	}
	
	
	public String getProductPrice() {
		return getText(element(Locators.xpath, productPriceLoc));
	}
	
	public void enterQTY(String noOfQty) {
		 type(element(Locators.xpath,QtyLoc), noOfQty);
	}
	
	public void clickAddToCart() {
		click(element(Locators.xpath, AddToCartBtnLoc));
	}
	
	
}