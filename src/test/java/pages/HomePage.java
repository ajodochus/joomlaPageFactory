package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.BasePage;

public class HomePage extends BasePage {

	@FindBy(xpath = LOGO_IMG)
		    WebElement userNameTextField;
	
	 public static final String LOGO_IMG = "//input[@id='j_username']";
	   

}
