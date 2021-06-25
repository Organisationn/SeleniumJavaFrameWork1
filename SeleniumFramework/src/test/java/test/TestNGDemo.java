package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class TestNGDemo {

	WebDriver driver = null;
	public static String browserName = null;

	@BeforeTest
	public void setUp() {
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

	}

	@Test
	public void googleSearch() throws InterruptedException {

		// go to google.com
		driver.get("https://google.com");
		Thread.sleep(5000);
		// enter text is search textbox
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step", Keys.RETURN);
		Thread.sleep(5000);

		// Click on search button
//		driver.findElement(By.name("btnk")).click();
	}

	@AfterTest
	public void tearDown() {
		// close browser
		driver.close();
//		driver.quit();
		System.out.println("Test completed successfully");
		PropertiesFile.setProperties();
	}

}
