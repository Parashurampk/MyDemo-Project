/**
 * 
 */
package com.mydemo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mydemo.base.BaseClass;
import com.mydemo.pages.IndexPage;
import com.mydemo.pages.LoginPage;
import com.mydemo.utility.Log;

/**
 * @author Parashuram
 *
 */
public class IndexPageTest extends BaseClass {

	private IndexPage indexPage;
	LoginPage loginPage;

	@BeforeMethod
	public void Setup() {

		launchApp();
	}

	@Test
	public void verifyLogo() {
		Log.startTestCase("verifyLogo");
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}

	@Test
	public void verifyMystoreTitle() {
		Log.startTestCase("verifyTitle");
		String actTitle = indexPage.getMystoreTitle();
		Assert.assertEquals(actTitle, "My Store");
		Log.endTestCase("verifyTitle");
	}

	@Test
	public void verifyserchProduct() throws Throwable {
		indexPage = new IndexPage();
		indexPage.serchProduct("Printed Chiffon Dress");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
