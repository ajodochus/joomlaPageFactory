package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import tests.LoginTest;

public class BaseTest {
	private static Settings settings = new Settings();
	// final static Logger logger = Logger.getLogger(LoginTest.class);

	@BeforeSuite(alwaysRun = true)
	public static void beforeSuite() {
		System.out.println("before suite in basetest");
		BasePage.driver = settings.getDriver();

		BasePage.settings = settings;
		BasePage.driver.manage().deleteAllCookies();
		/*
		 * BasePage.driver.get(settings.getBaseUrl()); if
		 * (!settings.getBrowser().equals(BrowserType.HTMLUNIT))
		 * BasePage.driver.manage().window().maximize();
		 */
	}

	@AfterTest(alwaysRun = true)
	public static void afterClass2() {
		BasePage.driver.quit();
	}

	public String getPropeties(String key) {
		String value = "not set";

		String resourceName = "selenium.properties"; // could also be a constant
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties props = new Properties();
		try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			props.load(resourceStream);
			// get the property value and print it out
			System.out.println(props.getProperty(key));
			value = props.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;
	}

}
