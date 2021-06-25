package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	WebDriver driver = null;

	@BeforeTest
	public void setUp() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "test1Data")
	public void test1(String userName, String passWord) throws InterruptedException {
		System.out.println(userName + "|" + passWord);
		driver.get("https://opensource-demo.orangehrmlive.com/");
//		Thread.sleep(10000);
		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
//		Thread.sleep(5000);
		driver.findElement(By.id("txtPassword")).sendKeys(passWord);

	}

	@DataProvider(name = "test1Data")
	public static Object[][] getData() {
		String excelPath = "C:/Users/manorsah/eclipse-workspace/SeleniumFW/SeleniumFramework/excel/data.xlsx";
		Object[][] data = testData(excelPath, "Sheet1");

		return data;
	}

	public static Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int colCount = excel.getColCount();
		int rowCount = excel.getRowCount();

		Object[][] data = new Object[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
//				System.out.print(cellData + " | ");
				data[i - 1][j] = cellData;
			}
		}

		System.out.println("before return :" + data.toString());
		return data;
	}

}
