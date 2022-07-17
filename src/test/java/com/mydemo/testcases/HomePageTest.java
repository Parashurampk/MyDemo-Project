package com.mydemo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mydemo.base.BaseClass;
import com.mydemo.pages.HomePage;
import com.mydemo.pages.IndexPage;
import com.mydemo.pages.LoginPage;

public class HomePageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void Setup() {

		launchApp();
	}

	@Test
	public void validateMyWishListTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateMyWishList();
		Assert.assertTrue(result);
	}

	@Test
	public void validateOrderHistoryTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateOrderHistory();
		Assert.assertTrue(result);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
