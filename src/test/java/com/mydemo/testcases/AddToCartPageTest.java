/**
 * 
 */
package com.mydemo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mydemo.base.BaseClass;
import com.mydemo.pages.AddToCartPage;
import com.mydemo.pages.IndexPage;
import com.mydemo.pages.SearchResultPage;

/**
 * @author Parashuram
 *
 */
public class AddToCartPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	
	@BeforeMethod
	public void Setup() {

		launchApp();
	}
	
	@Test
	public void addToCartTest() throws Throwable {
		indexPage=new IndexPage();
		searchResultPage=indexPage.serchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuntity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickAddToCart();
		boolean result=	addToCartPage.validateAddToCart();
		Assert.assertTrue(result);
			
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}



