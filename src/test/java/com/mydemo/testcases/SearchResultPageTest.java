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
import com.mydemo.pages.SearchResultPage;

/**
 * @author Parashuram
 *
 */
public class SearchResultPageTest extends BaseClass {
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	
	@BeforeMethod
	public void Setup() {

		launchApp();
	}
	
	@Test
	public void productAvailabilityTest() throws Throwable {
		indexPage=new IndexPage();
		searchResultPage=indexPage.serchProduct("t-shirt");
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
	} 
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
