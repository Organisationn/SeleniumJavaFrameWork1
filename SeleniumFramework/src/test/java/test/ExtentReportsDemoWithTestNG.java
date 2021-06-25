package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemoWithTestNG {
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver = null;

	@BeforeSuite
	public void setUp() {
		// start reporters
		htmlReporter = new ExtentSparkReporter("extent.html");
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void test1() {
		ExtentTest test1 = extent.createTest("Google Search Test One",
				"This is a test to validate google search functionality");
		driver.get("https://www.google.com");
		test1.pass("Navigated to googles.com");

		test1.log(Status.INFO, "This step shows usage of log(status, details)");
		test1.info("This step shows usage of info(details)");
		test1.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot1.png").build());
		test1.addScreenCaptureFromPath("screenshot.png");
	}

	@Test
	public void test2() {
		ExtentTest test2 = extent.createTest("Google Search Test two",
				"This is a test to validate google search functionality");
		test2.log(Status.INFO, "This step shows usage of log(status, details)");
		test2.info("This step shows usage of info(details)");
		test2.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot2.png").build());
		test2.addScreenCaptureFromPath("screenshot.png");
	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

}
