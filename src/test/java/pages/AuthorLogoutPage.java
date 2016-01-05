package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;




public class AuthorLogoutPage extends BasePage {
	
	final static Logger logger = Logger.getLogger(AuthorLogoutPage.class);
	 @FindBy(how = How.ID, using = "txt_logout")
	    private WebElement tf_username;



}
