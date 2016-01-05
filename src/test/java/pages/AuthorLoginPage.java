package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;




public class AuthorLoginPage extends BasePage {
	
	final static Logger logger = Logger.getLogger(AuthorLoginPage.class);
	 @FindBy(how = How.ID, using = "username")
	    private WebElement tf_username;
	 @FindBy(how = How.ID, using = "password")
	    private WebElement tf_password;
	 @FindBy(how = How.XPATH, using = "//*[contains(text(),'Log in')]")
	    private WebElement btn_submit;
	 @FindBy(how=How.ID, using="remember")
	 	private WebElement chkb_remember;

	    public AuthorHomePage loginAs(User user) {
	    	logger.info("input username");
	    	tf_username.sendKeys(user.getUsername());
	    	logger.info("input username");
			tf_password.sendKeys(user.getPassword());
			logger.info("input username");
			btn_submit.submit();
	        return initPage(AuthorHomePage.class);		
	        
	    }

//	    public RegisterPage registerNewUser() {
//	        registerLink.click();
//	        return initPage(RegisterPage.class);
//	    }

	    public static final String USER_NAME_TEXT_FIELD_XPATH = "//input[@id='j_username']";
	    public static final String UPASSWORD_TEXT_FIELD_XPATH = "//input[@id='j_password']";
	    public static final String ULOGIN_BUTTON_XPATH = "//div[@class='form']/form/input";
	    public static final String REGISTER_LINK_XPATH = "//a[contains(text(),'Register')]";
}
