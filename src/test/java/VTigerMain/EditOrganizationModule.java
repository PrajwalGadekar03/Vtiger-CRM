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

public class EditOrganizationModule {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver cv;
		
		PropertyFileUtil putil = new PropertyFileUtil();
		ExcelUtil eutil = new ExcelUtil();
		WebDriverUtil wutil = new WebDriverUtil();
		
		String BROWSER = putil.getdatafromPropertyFile("browser");
		String URL = putil.getdatafromPropertyFile("url");
		String USERNAME = putil.getdatafromPropertyFile("username");
		String PASSWORD = putil.getdatafromPropertyFile("password");
		
		String WEBSITE = eutil.getdatafromExcel("Organization02", 3, 1);
//		String PHONE = eutil.getdatafromExcel("Organization02", 4, 1);
		String EMAIL = eutil.getdatafromExcel("Organization02", 5, 1);
		String RATING = eutil.getdatafromExcel("Organization02", 6, 1);
//		String AnnualRevenue = eutil.getdatafromExcel("Organization02", 7, 1);
		String BillingAdd = eutil.getdatafromExcel("Organization02", 8, 1);
		String BillingCity = eutil.getdatafromExcel("Organization02", 9, 1);
		String BillingState = eutil.getdatafromExcel("Organization02", 10, 1);
//		String BillingPostalCode = eutil.getdatafromExcel("Organization02", 11, 1);
		String BillingCountry = eutil.getdatafromExcel("Organization02", 12, 1);
		String ShippingAdd = eutil.getdatafromExcel("Organization02", 13, 1);
		String ShippingCity = eutil.getdatafromExcel("Organization02", 14, 1);
		String ShippingState = eutil.getdatafromExcel("Organization02", 15, 1);
//		String ShippingPostalCode = eutil.getdatafromExcel("Organization02", 16, 1);
		String ShippingCountry = eutil.getdatafromExcel("Organization02", 17, 1);
		String DESCRIPTION = eutil.getdatafromExcel("Organization02", 18, 1);
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			cv = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			cv = new EdgeDriver();
		}else {
			cv = new FirefoxDriver();
		}
		
		wutil.maximizeWindow(cv);
		wutil.waitWebElementToLoad(cv);
		
		cv.get(URL);
		cv.findElement(By.name("user_name")).sendKeys(USERNAME);
		cv.findElement(By.name("user_password")).sendKeys(PASSWORD);
		cv.findElement(By.id("submitButton")).click();
		
		cv.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		cv.findElement(By.xpath("(//a[text()='edit'])[1]")).click();
		Thread.sleep(2000);
		cv.findElement(By.xpath("(//input[@class='detailedViewTextBox'])[3]")).sendKeys(WEBSITE);
//		cv.findElement(By.id("phone")).sendKeys(PHONE);
		cv.findElement(By.id("email1")).sendKeys(EMAIL);
		Thread.sleep(1500);
		WebElement Ddown = cv.findElement(By.cssSelector("select[name='rating']"));
		wutil.handleDropDown(Ddown, RATING);
		Thread.sleep(1500);
		cv.findElement(By.cssSelector("input[name='emailoptout']")).click();
//		cv.findElement(By.cssSelector("input[name='annual_revenue']")).sendKeys(AnnualRevenue);
		cv.findElement(By.cssSelector("input[name='notify_owner']")).click();
		
		cv.findElement(By.cssSelector("textarea[name='bill_street']")).sendKeys(BillingAdd);
		cv.findElement(By.id("bill_city")).sendKeys(BillingCity);
		cv.findElement(By.id("bill_state")).sendKeys(BillingState);
//		cv.findElement(By.id("bill_code")).sendKeys(BillingPostalCode);
		cv.findElement(By.id("bill_country")).sendKeys(BillingCountry);
		
		cv.findElement(By.cssSelector("textarea[name='ship_street']")).sendKeys(ShippingAdd);
		cv.findElement(By.id("ship_city")).sendKeys(ShippingCity);
		cv.findElement(By.id("ship_state")).sendKeys(ShippingState);
//		cv.findElement(By.id("ship_code")).sendKeys(ShippingPostalCode);
		cv.findElement(By.id("ship_country")).sendKeys(ShippingCountry);
		
		cv.findElement(By.cssSelector("textarea[name='description']")).sendKeys(DESCRIPTION);

		

	}

}
