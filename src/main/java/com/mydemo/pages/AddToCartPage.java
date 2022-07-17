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
public class AddToCartPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath ="//*[@id=\"quantity_wanted\"]")
	WebElement quantity;
	
	@FindBy(name = "group_1")
	WebElement size;
	
	@FindBy(xpath = "//*[@id=\"color_13\"]")
	WebElement colour;
	
	@FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]//h2/i")
	WebElement addToCartMessag;
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]//a/span")
	WebElement proceedTocheckOutBtn;
	
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);

	}
	
	public void enterQuntity(String quantity1) {
		action.type(quantity, quantity1);
	}

	public void selectSize(String size1) {
		action.selectByVisibleText(size1, size);
	}
	
	public void clickAddToCart() {
		action.click(driver, addToCartBtn);
	}
	
	public boolean validateAddToCart() {
		action.fluentWait(driver, addToCartMessag, 10);
		return action.isDisplayed(driver, addToCartMessag);
	}
	
	public OrderPage clickOnCheckOut() {
		action.JSClick(driver, proceedTocheckOutBtn);
		return new OrderPage();
	}
}

