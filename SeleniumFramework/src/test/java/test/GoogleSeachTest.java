package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

public class GoogleSeachTest {
	private static WebDriver driver = null;

	public static void main(String[] args) {
		googleSearch();
	}

	public static void googleSearch() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// go to google.com
		driver.get("https://google.com");

		// enter text is search textbox
//		driver.findElement(By.name("q")).sendKeys("Automation Step by Step", Keys.RETURN);
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step by Step", Keys.RETURN);

		// Click on search button
//		driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);
//		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);

		// close browser
		driver.close();

		System.out.println("Test completed successfully");
	}

}
