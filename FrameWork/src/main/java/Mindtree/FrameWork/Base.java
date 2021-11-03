package Mindtree.FrameWork;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public WebDriver InitializeBrowser() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\M1072987\\eclipse-workspace\\FrameWork\\Resorces\\First.properties");
			prop.load(fis);

			String browserName = prop.getProperty("browser");
			System.out.println(browserName);
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\M1072987\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equals("edge")) {

				System.setProperty("webdriver.edge.driver",
						"C:\\Users\\M1072987\\SeleniumDriver\\edgedriver_win64\\msedgedriver.exe");
				driver = new EdgeDriver();
			} else {
				System.out.println("No browser Driver Specified");

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return driver;

	}

	public void GetScreenshot() {
		try {
			File getss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(getss,
					new File("C:\\Users\\M1072987\\eclipse-workspace\\FrameWork\\Screenshot\\screenshot.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Base() {
		spark = new ExtentSparkReporter("ExtentedReport\\indexRep.html");
		extent = new ExtentReports();
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Test Report of QaClickAcedamy.com");
		spark.config().setReportName("Test Report QaClickAcedamy.com");
		extent.attachReporter(spark);
	}
}
