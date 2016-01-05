package pages;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseTeeeest {

	private static Settings settings = new Settings();

	@BeforeSuite(alwaysRun = true)
	public static void beforeSuite() {
		System.out.println("before suite in basetest");
		BasePage.driver = settings.getDriver();
		
		BasePage.settings = settings;
		BasePage.driver.manage().deleteAllCookies();
		BasePage.driver.get(settings.getBaseUrl());
		if (!settings.getBrowser().equals(BrowserType.HTMLUNIT))
			BasePage.driver.manage().window().maximize();
	}

	@AfterTest(alwaysRun = true)
	public static void afterClass2() {
		BasePage.driver.quit();
	}

}
