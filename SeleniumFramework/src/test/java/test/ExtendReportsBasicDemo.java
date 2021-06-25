package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportsBasicDemo {
	private static WebDriver driver = null;

	public static void main(String[] args) {
		// start reporters
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentHtmlReport.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("Google Search Test One",
				"This is a test to validate google search functionality");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		test1.log(Status.INFO, "Starting test case");

		driver.manage().window().maximize();
		driver.get("https://google.com");
		test1.pass("navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("Automation", Keys.RETURN);
		test1.pass("pressed keyboard enter key");

		driver.close();
		driver.quit();
		test1.info("Test completed");

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test2 = extent.createTest("Google Search Test Two",
				"This is a test to validate google search functionality");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		test2.log(Status.INFO, "Starting test case");

		driver.manage().window().maximize();
		driver.get("https://google.com");
		test2.pass("navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("Automation", Keys.RETURN);
		test2.fail("pressed keyboard enter key");

		driver.close();
		driver.quit();
		test2.info("Test completed");

		// calling flush writes everything to the log file
		extent.flush();
	}

}
