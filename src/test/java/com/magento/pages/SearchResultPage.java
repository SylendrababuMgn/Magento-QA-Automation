package com.magento.pages;

import org.magento.seleniumBase.Locators;
import org.magento.seleniumBase.SeleniumBase;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends SeleniumBase {
	
	private String TitleLoc = "//h1";
	private String sortByDropDownIdLoc = "sorter";
	private String sortByOrder = "(//a[@title='Set Ascending Direction'])[1]";
	
	
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getTitle() {
		return getText(element(Locators.xpath,TitleLoc));
	}
	
	public void selectSortBy(String dropDownValue) {
		selectText(element(Locators.xpath,sortByDropDownIdLoc), dropDownValue);
	}
}
