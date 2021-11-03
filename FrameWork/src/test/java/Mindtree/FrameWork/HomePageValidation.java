package Mindtree.FrameWork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class HomePageValidation extends Base{
	public static Logger log = LogManager.getLogger(HomePageValidation.class.getName());
	@BeforeMethod 
	public void demo() {
		driver = InitializeBrowser();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void HomePage() {
		POMHomePage pomhg = new POMHomePage(driver);
		Assert.assertEquals(pomhg.getTitleToCheckCorrectOrNot().getText(),"FEATURED COURSESS");
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
	

}
