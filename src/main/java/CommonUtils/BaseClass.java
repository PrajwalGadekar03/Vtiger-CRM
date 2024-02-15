package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public WebDriver cv;
	public static WebDriver op;
	PropertyFileUtil putil = new PropertyFileUtil();
	ExcelUtil eutil = new ExcelUtil();
	WebDriverUtil wutil = new WebDriverUtil();

	@BeforeSuite
	public void BS() {
		System.out.println("Connect to data base");

	}

	@BeforeClass
	public void BC() throws IOException {

		String BROWSER = putil.getdatafromPropertyFile("browser");
		String URL = putil.getdatafromPropertyFile("url");

		if (BROWSER.equalsIgnoreCase("Chrome")) {
			cv = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			cv = new EdgeDriver();
		} else {
			cv = new FirefoxDriver();
		}

		op = cv;

		wutil.maximizeWindow(cv);
		wutil.waitWebElementToLoad(cv);

		cv.get(URL);
	}

	@BeforeMethod
	public void BM() throws IOException {

		String USERNAME = putil.getdatafromPropertyFile("username");
		String PASSWORD = putil.getdatafromPropertyFile("password");

		cv.findElement(By.name("user_name")).sendKeys(USERNAME);
		cv.findElement(By.name("user_password")).sendKeys(PASSWORD);
		cv.findElement(By.id("submitButton")).click();
	}

	@AfterMethod
	public void AM() throws InterruptedException {

		WebElement mouse = cv.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		wutil.mouseHover(cv, mouse);

		Thread.sleep(1000);
		cv.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

	@AfterClass
	public void AC() {
		cv.quit();
	}

	@AfterSuite
	public void AS() {
		System.out.println("Disconnect to data base");
	}

}
