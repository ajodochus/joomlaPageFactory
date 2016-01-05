package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthorHomePage extends BasePage {
	
	@FindBy(how = How.XPATH, using = ".//*[@id='users-profile-core']/legend")
    private static WebElement txt_profileheader;
	@FindBy(how=How.LINK_TEXT, using = "Log out")
	private static WebElement lnk_logout;
	
	public String getH1Headline(){
		return txt_profileheader.getText();
		
	}
}
