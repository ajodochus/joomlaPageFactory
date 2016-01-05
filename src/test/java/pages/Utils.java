package pages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.util.StringTokenizer;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    private static WebDriver driver = BasePage.driver;

    public static void waitForElementPresent(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static boolean isElementPresent(String xpath) {
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

    public static boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

    public static String getText(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().substring(0,5);
    }
	public static void storeCookies(WebDriver driver){
		
		File f = new File("browser.data");
	    try{
	         f.delete();
	         f.createNewFile();
	         FileWriter fos = new FileWriter(f);
	         BufferedWriter bos = new BufferedWriter(fos);

	         for(Cookie ck : driver.manage().getCookies()) {
	        	    bos.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()
	        	    	    +";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
	        	    bos.newLine();
	         }
	         bos.flush();
	         bos.close();
	         fos.close();
	     }catch(Exception ex){
	         ex.printStackTrace();
	     }
		
		
	}
	public static void replaceCookie(WebDriver driver){
		try{
		     File f2 = new File("browser.data");
		     FileReader fr = new FileReader(f2);
		     BufferedReader br = new BufferedReader(fr);
		     String line;
		     while((line=br.readLine())!=null){
		         StringTokenizer str = new StringTokenizer(line,";");
		         while(str.hasMoreTokens()){
		             String name = str.nextToken();
		             String value = str.nextToken();
		             String domain = str.nextToken();
		             String path = str.nextToken();
		             Date expiry = null;
		             String dt;
		             /*if(!(dt=str.nextToken()).equals("null")){
		                 expiry = new Date(dt);
		             }*/
		             boolean isSecure = new Boolean(str.nextToken()).booleanValue();
		             Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
		             driver.manage().addCookie(ck);
		         }
		     }
		}catch(Exception ex){
		     ex.printStackTrace();
		}
		
	}
}
