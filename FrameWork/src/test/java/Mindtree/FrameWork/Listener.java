package Mindtree.FrameWork;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;


public class Listener extends Base  implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			
			Base p = new Base();
			p.GetScreenshot();
			ExtentTest test = extent.createTest(driver.getTitle());
			test.fail("Test Failed");
			test.addScreenCaptureFromPath("C:\\Users\\M1072987\\eclipse-workspace\\FrameWork\\Screenshot\\screenshot.png");
			extent.flush();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTest test = extent.createTest(driver.getTitle());
		test.pass("Test Passed");
		extent.flush();
	}
}
