/**
 * 
 */
package com.mydemo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mydemo.base.BaseClass;
import com.mydemo.dataprovider.DataProviders;
import com.mydemo.pages.HomePage;
import com.mydemo.pages.IndexPage;
import com.mydemo.pages.LoginPage;
import com.mystore.utility.Log;

/**
 * @author Parashuram
 *
 */
public class LoginPageTest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void Setup() {

		launchApp();
	}

	@Test
	public void loginTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();

		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		String actualURL = homePage.getCurrURL();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualURL, expectedURL);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
