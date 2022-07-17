package com.mydemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mydemo.actiondriver.Action;
import com.mydemo.base.BaseClass;

public class IndexPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//a[@class='login']")
	WebElement SignInBtn;

	@FindBy(xpath = "//img[@alt='My Store']")
	WebElement MyStoreLogo;

	@FindBy(id = "search_query_top")
	WebElement SearchProductBox;

	@FindBy(name = "submit_search")
	WebElement SearchButton;

	public IndexPage() {
		PageFactory.initElements(driver, this);

	}

	public LoginPage clickOnSignIn() {
		action.fluentWait(driver, SignInBtn, 10);
		action.click(driver, SignInBtn);
		return new LoginPage();
	}

	public boolean validateLogo() {
		return action.isDisplayed(driver, MyStoreLogo);

	}

	public String getMystoreTitle() {
		String myStoreTitle = driver.getTitle();
		return myStoreTitle;

	}

	public SearchResultPage serchProduct(String productName) throws Throwable {
		action.scrollByVisibilityOfElement(driver, SearchButton);
		action.type(SearchProductBox, productName);
		action.click(driver, SearchButton);
		Thread.sleep(3000);
		return new SearchResultPage();

	}

}
