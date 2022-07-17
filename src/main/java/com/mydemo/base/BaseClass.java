package com.mydemo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.mydemo.actiondriver.Action;
import com.mydemo.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Parashuram:
 * 
 */
public class BaseClass {
	public static WebDriver driver;
	public Properties prop;

	@BeforeSuite
	public void loadConfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");

		if (browserName.contains("Chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.contains("Firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.contains("IE")) {
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),
				TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
