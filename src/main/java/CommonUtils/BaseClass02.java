package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass02 {

	public WebDriver cv;
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

		// To Launch Browser
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			cv = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			cv = new EdgeDriver();
		} else {
			cv = new FirefoxDriver();
			System.out.println("Default Browser");
		}
		wutil.maximizeWindow(cv);
		wutil.waitWebElementToLoad(cv);
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//				
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

	@AfterSuite
	public void AS() {
		System.out.println("Disconnect to the data base");
	}

}
