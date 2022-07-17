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
public class LoginPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(name="email_create")
	WebElement emailForNewAccount;

	@FindBy(name="SubmitCreate")
	WebElement creatNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
     
	public HomePage login(String uname, String pswd) {
		
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(driver, signInBtn);
		return new HomePage();	
	}
	 public AccountCreationPage createNewAcccount(String newEmail){
		 action.type(emailForNewAccount, newEmail);
		 action.click(driver, creatNewAccountBtn);
		 return new AccountCreationPage();
	 }
		
}
