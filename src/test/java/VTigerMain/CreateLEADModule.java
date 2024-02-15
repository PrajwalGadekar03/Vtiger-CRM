package VTigerMain;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CommonUtils.ExcelUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class CreateLEADModule {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver cv;

		PropertyFileUtil putil = new PropertyFileUtil();
		ExcelUtil eutil = new ExcelUtil();
		WebDriverUtil wutil = new WebDriverUtil();

		String BROWSER = putil.getdatafromPropertyFile("browser");
		String URL = putil.getdatafromPropertyFile("url");
		String USERNAME = putil.getdatafromPropertyFile("username");
		String PASSWORD = putil.getdatafromPropertyFile("password");

		String FIRSTNAME = eutil.getdatafromExcel("LEAD", 0, 1);
		String LASTNAME = eutil.getdatafromExcel("LEAD", 1, 1);
		String COMPANY = eutil.getdatafromExcel("LEAD", 2, 1);
		String GROUP = eutil.getdatafromExcel("LEAD", 3, 1);

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

		cv.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();

		cv.findElement(By.cssSelector("img[title='Create Lead...']")).click();

		cv.findElement(By.cssSelector("input[name='firstname']")).sendKeys(FIRSTNAME);
		cv.findElement(By.cssSelector("input[name='lastname']")).sendKeys(LASTNAME);
		cv.findElement(By.cssSelector("input[name='company']")).sendKeys(COMPANY);

		cv.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		Thread.sleep(1000);
		WebElement dropd = cv.findElement(By.name("assigned_group_id"));
		wutil.handleDropDown(dropd, GROUP);

		Thread.sleep(2000);

		cv.findElement(By.cssSelector("input[class='crmButton small save']")).click();
		Thread.sleep(2000);

		wutil.ScreenShot(cv, "LeadModule");

		WebElement signouticon = cv.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		wutil.mouseHover(cv, signouticon);

		cv.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
