package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {

	WebDriver driver = null;

	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	// WebElement declarations

	By textbox_search = By.name("q");
	By button_search = By.name("btnk");

	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text, Keys.RETURN);
	}
}
