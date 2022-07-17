/**
 * 
 */
package com.mydemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mydemo.actiondriver.Action;
import com.mydemo.base.BaseClass;

/**
 * @author Parashuram
 *
 */
public class SearchResultPage extends BaseClass {
	Action action = new Action();

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	WebElement productResult;

	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isProductAvailable() {
		return action.isDisplayed(driver, productResult);

	}
	
	public AddToCartPage clickOnProduct() {
		action.click(driver, productResult);
		return new AddToCartPage();
	}

}
