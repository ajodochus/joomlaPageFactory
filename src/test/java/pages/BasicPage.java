package pages;

import static pages.BasicPage.initPage;
import static utils.BasePage.initPage;
import static utils.Utils.isElementPresent;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.BasePage;



public class BasicPage extends BasePage {
	final static Logger logger = Logger.getLogger(BasicPage.class);
	
	 @FindBy(how = How.LINK_TEXT, using = "Author Login")
	    private WebElement lnk_AuthorLogin;
	 

    
    public AuthorLoginPage klick_AuthorLogin(){
    	logger.info("goto Author Login Page by Header link");
    	lnk_AuthorLogin.click();
		return initPage(AuthorLoginPage.class);
    	
    }


    
    
//
//    public String getFlashMessage() {
//        if (isElementPresent(flash)) {
//            return driver.findElement(flash).getText();
//        }
//        return null;
//    }
}
