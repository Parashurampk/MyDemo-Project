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
public class AccountCreationPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//h1[@class='page-heading']")
	private WebElement formTitle;

	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateAcountCreatePage() {
		return action.isDisplayed(driver, formTitle);
	}

}
