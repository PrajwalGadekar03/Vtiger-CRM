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

public class EditLeadModule {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver cv;
		
		PropertyFileUtil putil = new PropertyFileUtil();
		ExcelUtil eutil = new  ExcelUtil();
		WebDriverUtil wutil = new WebDriverUtil();
		
		String BROWSER = putil.getdatafromPropertyFile("browser");
		String URL = putil.getdatafromPropertyFile("url");
		String USERNAME = putil.getdatafromPropertyFile("username");
		String PASSWORD = putil.getdatafromPropertyFile("password");
		
		String LeadSource = eutil.getdatafromExcel("LEAD", 4, 1);
		String INDUSTRY = eutil.getdatafromExcel("LEAD", 5, 1);
		String EMAIL = eutil.getdatafromExcel("LEAD", 6, 1);
		String LeadStatus = eutil.getdatafromExcel("LEAD", 7, 1);
		String RATING = eutil.getdatafromExcel("LEAD", 8, 1);
		String DESCRIPTION = eutil.getdatafromExcel("LEAD", 9, 1);

		if (BROWSER.equalsIgnoreCase("chrome")) {
			cv = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
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
		
		cv.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		cv.findElement(By.xpath("(//a[text()='edit'])[1]")).click();
		
		WebElement DDLeadSource = cv.findElement(By.cssSelector("select[name='leadsource']"));
		wutil.handleDropDown(DDLeadSource, LeadSource);
		
		WebElement DDIndutry = cv.findElement(By.cssSelector("select[name='industry']"));
		wutil.handleDropDown(DDIndutry, INDUSTRY);
		
		cv.findElement(By.id("email")).sendKeys(EMAIL);
		
		WebElement DDLeadStatus = cv.findElement(By.cssSelector("select[name='leadstatus']"));
		wutil.handleDropDown(DDLeadStatus, LeadStatus);
		
		WebElement DDRating = cv.findElement(By.cssSelector("select[name='rating']"));
		wutil.handleDropDown(DDRating, RATING);
		
		cv.findElement(By.cssSelector("textarea[name='description']")).sendKeys(DESCRIPTION);
		

	}

}
