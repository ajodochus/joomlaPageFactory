package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.BasePage;
import utils.IPages;


public class GtaLoginStartPage extends BasePage implements IPages {

	@FindBy(how = How.TAG_NAME, using="h1")
	 private WebElement txt_headline;
	@FindBy(how = How.TAG_NAME, using="öjjkökökjö")
	 private WebElement txtöjöjöjjö;
	
	@Override
	public String UrlExpected() {
		String url="https://app.gotoassist.com/support?product=g2ap";
		return url;		
	}

}
