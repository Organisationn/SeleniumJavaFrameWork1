package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;

public class FluentWaitDemo {

	@Test
	public void test() throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https:google.com");
		driver.findElement(By.name("q")).sendKeys("abcd", Keys.RETURN);
//		driver.findElement(By.linkText("ABCD - NIMH Data Archive - NIH")).click();

		Wait wait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement lnkElement = driver.findElement(By.linkText("ABCD - NIMH Data Archive - NIH"));
				if (lnkElement.isEnabled()) {
					System.out.println("Element found");
				}
				return lnkElement;
			}
		});

		element.click();

		Thread.sleep(3000);
		driver.close();
		driver.quit();

	}

}
