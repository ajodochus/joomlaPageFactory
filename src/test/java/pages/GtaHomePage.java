package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.log4testng.Logger;

import utils.BasePage;
import utils.IPages;
import utils.User;

public class GtaHomePage extends BasePage implements IPages{
	 @FindBy(how = How.ID, using="emailAddress")
	 private WebElement if_username;
	 @FindBy(how = How.ID, using="password")
	 private WebElement if_password;
	 @FindBy(how = How.ID, using="submit")
	 private WebElement btn_submit;
	 
	 
	 public static Logger logger = Logger.getLogger(GtaHomePage.class);
	 
	 public GtaLoginStartPage loginAs(User user) {
	    	logger.info("input username");
	    	if_username.sendKeys(user.getUsername());
	    	logger.info("input password");
			if_password.sendKeys(user.getPassword());
			logger.info("click submit");
			btn_submit.submit();
	        return initPage(GtaLoginStartPage.class);		
	        
	    }

	 @Override
		public String UrlExpected() {
			String url="https://";
			return url;
		}

}
