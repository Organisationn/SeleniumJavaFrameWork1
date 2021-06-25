package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {
	private static WebDriver driver = null;

	public static void main(String[] args) {
		googleSearchTest();
	}
	
	public static void googleSearchTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		GoogleSearchPageObjects seachPageObj = new GoogleSearchPageObjects(driver);
		seachPageObj.setTextInSearchBox("Automation Step By Step");

		driver.close();
	}

}
