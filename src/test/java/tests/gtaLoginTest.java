package tests;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import utils.Utils;
import static utils.UserBuilder.gta_user;
import pages.GtaHomePage;
import pages.GtaLoginStartPage;
import utils.BasePage;
import utils.BaseTest;
import utils.User;
import static pages.BasicPage.initPage;


public class gtaLoginTest extends BaseTest {
	final static Logger logger = Logger.getLogger(BaseTest.class);
	private GtaHomePage gtaHomePage;
	private GtaLoginStartPage gtaLoginStartPage;
	private User user;

	@Test(groups = { "gta" })
	public void signInToG2aRemotePage() {
		logger.info("call urlGta Homepage");
		BasePage.driver.get(getPropeties("urlGta"));
		logger.info("init urlGta Homepage");
		gtaHomePage = gtaHomePage.initPage(GtaHomePage.class);
		logger.info("set user gta_user");
		user = gta_user();
		logger.info("login goes to LoginStartPage");
		gtaLoginStartPage = gtaHomePage.loginAs(user);
	}

}
