/**
 * 
 */
package com.mydemo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mydemo.base.BaseClass;
import com.mydemo.pages.AccountCreationPage;
import com.mydemo.pages.IndexPage;
import com.mydemo.pages.LoginPage;

/**
 * @author Parashuram
 *
 */
public class AccountCreationPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;

	@BeforeMethod
	public void Setup() {

		launchApp();
	}

	@Test
	public void validateAcountCreatePageTest() {

		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		accountCreationPage = loginPage.createNewAcccount("jbxsbda@gmail.com");
		boolean result = accountCreationPage.validateAcountCreatePage();
		Assert.assertTrue(result);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}