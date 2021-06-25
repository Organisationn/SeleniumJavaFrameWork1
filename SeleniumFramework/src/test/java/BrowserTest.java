import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserTest {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath" + projectPath);
//		System.setProperty("webdriver.gecko.driver",
//				projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		System.setProperty("webdriver.ie.driver", projectPath + "/drivers/iedriver/IEDriverServer.exe");
//		WebDriver driver = new InternetExplorerDriver();
//		driver.get("http://seleniumhq.org/");
		driver.get("http://google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("abcd");
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		System.out.println("size of listOfInputElements: " + listOfInputElements.size());

		System.out.println("closing driver");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
//		driver.quit();
	}
}
