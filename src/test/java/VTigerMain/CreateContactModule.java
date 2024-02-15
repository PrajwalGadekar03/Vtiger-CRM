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


public class CreateContactModule {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver cv;
		
		PropertyFileUtil putil = new PropertyFileUtil();
		ExcelUtil eutil = new ExcelUtil();
		WebDriverUtil wutil = new WebDriverUtil();
		
		String BROWSER = putil.getdatafromPropertyFile("browser");
		String URL = putil.getdatafromPropertyFile("url");
		String USERNAME = putil.getdatafromPropertyFile("username");
		String PASSWORD = putil.getdatafromPropertyFile("password");
		
		String FIRSTNAME = eutil.getdatafromExcel("Contact02", 0, 1);
	    String LASTNAME = eutil.getdatafromExcel("Contact02", 1, 1);
	    String GROUP = eutil.getdatafromExcel("Contact02", 2, 1);
	    String NAME = eutil.getdatafromExcel("Contact02", 3, 1);
	    

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
		
		cv.findElement(By.xpath("//a[text()='Contacts']")).click();
		cv.findElement(By.cssSelector("img[title='Create Contact...']")).click();

		cv.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		cv.findElement(By.name("lastname")).sendKeys(LASTNAME);
		cv.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		Thread.sleep(2000);
		WebElement dropd = cv.findElement(By.name("assigned_group_id"));
		wutil.handleDropDown(dropd, GROUP);
		
		cv.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		wutil.windowSwitch(cv, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		cv.findElement(By.id("search_txt")).sendKeys(NAME);
		cv.findElement(By.xpath("(//input[@name='search'])[1]")).click();
		Thread.sleep(3000);
		cv.findElement(By.xpath("//a[text()='Pune01']")).click();
		wutil.windowSwitch(cv, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");	
		cv.findElement(By.id("jscal_field_birthday")).sendKeys("2024-01-01");
		Thread.sleep(2000);

		cv.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		Thread.sleep(3000);
		
		WebElement mouse = cv.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		wutil.mouseHover(cv, mouse);
		Thread.sleep(1000);
		cv.findElement(By.xpath("//a[text()='Sign Out']")).click();
		

		
		
		
		
		
		
		
	}

	

}
