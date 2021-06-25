package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDemo2 {

	WebDriver driver = null;

	@BeforeTest
	public void setUp() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void googleSearch2() throws InterruptedException {

		// go to google.com
		driver.get("https://google.com");
		Thread.sleep(5000);
		// enter text is search textbox
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step", Keys.RETURN);
		Thread.sleep(5000);

		// Click on search button
//		driver.findElement(By.name("btnk")).click();
	}

	@Test
	public void googleSearch3() throws InterruptedException {

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
		driver.quit();
		System.out.println("Test completed successfully");

	}

}
