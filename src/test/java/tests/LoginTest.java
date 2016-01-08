package tests;

import static pages.BasicPage.initPage;
import static pages.UserBuilder.admin;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.BaseTeeeest;
import pages.BasicPage;
import pages.HomePage;
import pages.AuthorLoginPage;
import pages.AuthorProfilePage;
import pages.BasePage;
import pages.User;


public class LoginTest extends BaseTeeeest   {
	final static Logger logger = Logger.getLogger(LoginTest.class);
	private BasicPage basicPage;
	private AuthorLoginPage authorLoginPage;
	private AuthorProfilePage authorHomePage;
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
        authorHomePage = authorLoginPage.loginAs(user);
        Assert.assertEquals(authorHomePage.getH1Headline(), "Profile", "h1 headline *Profile* correct");
        logger.info(authorHomePage.getTitle());
    }
    @Test(groups={"test"})
    public void loggerTest(){
    //
    }
    public void incorrectLoginTest() {
        user.setPassword(user.getPassword() + user.getPassword());
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
