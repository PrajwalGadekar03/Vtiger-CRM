package VTigerMain;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class CreateOrganizationModule {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver cv;

		PropertyFileUtil putil = new PropertyFileUtil();
		ExcelUtil eutil = new ExcelUtil();
		WebDriverUtil wutil = new WebDriverUtil();
		JavaUtil jutil = new JavaUtil();

		String BROWSER = putil.getdatafromPropertyFile("browser");
		String URL = putil.getdatafromPropertyFile("url");
		String USERNAME = putil.getdatafromPropertyFile("username");
		String PASSWORD = putil.getdatafromPropertyFile("password");

		String NAME = eutil.getdatafromExcel("Organization02", 0, 1);
		String GROUP = eutil.getdatafromExcel("Organization02", 1, 1);
		String INDUSTRY = eutil.getdatafromExcel("Organization02", 2, 1);

		if (BROWSER.equalsIgnoreCase("chrome")) {
			cv = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			cv = new EdgeDriver();
		} else {
			cv = new FirefoxDriver();
		}

		wutil.maximizeWindow(cv);
		wutil.waitWebElementToLoad(cv);

		cv.get(URL);
		cv.findElement(By.name("user_name")).sendKeys(USERNAME);
		cv.findElement(By.name("user_password")).sendKeys(PASSWORD);
		cv.findElement(By.id("submitButton")).click();

		cv.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		cv.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

		cv.findElement(By.cssSelector("input[name='accountname']")).sendKeys(NAME + jutil.getRandomNumber());
		cv.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		WebElement dropdown = cv.findElement(By.name("assigned_group_id"));
		wutil.handleDropDown(dropdown, GROUP);
		WebElement dropdown02 = cv.findElement(By.cssSelector("select[name='industry']"));
		wutil.handleDropDown(dropdown02, INDUSTRY);

		cv.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		Thread.sleep(2000);

		WebElement signouticon = cv.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		wutil.mouseHover(cv, signouticon);
		Thread.sleep(2000);

		cv.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
