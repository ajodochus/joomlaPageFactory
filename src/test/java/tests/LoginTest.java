package tests;

import static pages.BasicPage.initPage;
import static utils.UserBuilder.admin;
import static utils.UserBuilder.invalidUser;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.BasicPage;
import pages.HomePage;
import utils.BasePage;
import utils.BaseTest;
import utils.User;
import pages.AuthorLoginPage;
import pages.AuthorProfilePage;


public class LoginTest extends BaseTest   {
	final static Logger logger = Logger.getLogger(LoginTest.class);
	private BasicPage basicPage;
	private AuthorLoginPage authorLoginPage;
	private AuthorProfilePage authorProfilePage;
	private User user;
	
	
    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
       // basicPage = initPage(BasicPage.class);       
        //authorLoginPage = basicPage.klick_AuthorLogin();   
    }

    @Test(groups={"login"})
    public void correctLoginTest() {
    	
    	BasePage.driver.get(getPropeties("urlAuthorLogin"));
    	authorLoginPage = initPage(AuthorLoginPage.class);
    	user = admin();
    	authorProfilePage = authorLoginPage.loginAs(user);
        Assert.assertEquals(authorProfilePage.getH1Headline(), "Profile", "h1 headline *Profile* not correct");
        
        logger.info(authorProfilePage.getTitle());
        
       
        
    }
    
    
    @Test(groups={"test"})
    public void loggerTest(){
    //
    }
    public void incorrectLoginTest() {
    	BasePage.driver.get(getPropeties("urlAuthorLogin"));
    	authorLoginPage = initPage(AuthorLoginPage.class);
        user = invalidUser();
        authorLoginPage.loginAs(user);
        
        
        //assertThat(isElementPresent(basicPage.flash)).isTrue();
       //assertThat(basicPage.getFlashMessage()).isEqualTo("You have entered an invalid username or password!");
    }

    
    public void incorrectThenCorrectTest() {
        user.setPassword(user.getPassword() + user.getPassword());
        authorLoginPage.loginAs(user);
        user.setPassword(admin().getPassword());
        authorLoginPage.loginAs(user);
        assertHeader(user);
    }

    private void assertHeader(User user){
        //assertThat(authorHomePage.getWelcomeMessage()).isEqualTo("Welcome " + user.getFname() + " " + user.getLname());
    }


}
