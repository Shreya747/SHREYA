package Mindtree.FrameWork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogInAutomation extends Base {
	public static Logger log = LogManager.getLogger(LogInAutomation.class.getName());
	@BeforeMethod
	public void demo() {
		driver = InitializeBrowser();
		driver.get(prop.getProperty("url"));

	}

	@Test(dataProvider = "getData")
	public void login(String UserName, String Password) throws InterruptedException {
		POMLogIn pom = new POMLogIn(driver);
		pom.getLogin().click();
		pom.getUsername().sendKeys(UserName);
		pom.getPassword().sendKeys(Password);
		pom.getloggingin().click();

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] objData = new Object[3][2]; // Access the elements like 2D array.
		objData[0][0] = "FirstUsername";
		objData[0][1] = "FirstPass";
		objData[1][0] = "SecondUsername";
		objData[1][1] = "SecondPass";
		objData[2][0] = "ThirdUSername";
		objData[2][1] = "ThirdPass";
		return objData;
	}
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
	

}
