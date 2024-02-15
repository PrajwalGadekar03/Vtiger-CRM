package VTigerMain;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class DeleteOraganizationModule {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver cv;

		PropertyFileUtil putil = new PropertyFileUtil();
		WebDriverUtil wutil = new WebDriverUtil();

		String BROWSER = putil.getdatafromPropertyFile("browser");
		String URL = putil.getdatafromPropertyFile("url");
		String USERNAME = putil.getdatafromPropertyFile("username");
		String PASSWORD = putil.getdatafromPropertyFile("password");

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
		cv.findElement(By.xpath("(//a[text()='del'])[13]")).click();
//		cv.switchTo().alert().accept();

	}

}
