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

public class CreateOpportunity {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver cv;
		
		PropertyFileUtil putil = new PropertyFileUtil();
		ExcelUtil eutil = new ExcelUtil();
		WebDriverUtil wutil = new WebDriverUtil();
		JavaUtil jutil = new JavaUtil();
		
		String BROWSER = putil.getdatafromPropertyFile("browser");
		String URL = putil.getdatafromPropertyFile("url");
		String USERNAME = putil.getdatafromPropertyFile("username");
		String PASSWORD = putil.getdatafromPropertyFile("password");
		
		String OPPName = eutil.getdatafromExcel("Opportunity", 0, 1);
		String RELETATEDTO = eutil.getdatafromExcel("Opportunity", 1, 1);
		String TYPE = eutil.getdatafromExcel("Opportunity", 2, 1);
		String LEADSOURCE = eutil.getdatafromExcel("Opportunity", 3, 1);
		String ASSIGNTO = eutil.getdatafromExcel("Opportunity", 4, 1);
		String SALESTAGE = eutil.getdatafromExcel("Opportunity", 5, 1);
//		String PROBABILITY = eutil.getdatafromExcel("Opportunity", 6, 1);
		String DESCRIPTION = eutil.getdatafromExcel("Opportunity", 7, 1);
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			cv = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			cv = new EdgeDriver();
		}
		else {
			cv = new FirefoxDriver();
		}
		
		wutil.maximizeWindow(cv);
		wutil.waitWebElementToLoad(cv);
		
		cv.get(URL);
		cv.findElement(By.name("user_name")).sendKeys(USERNAME);
		cv.findElement(By.name("user_password")).sendKeys(PASSWORD);
		cv.findElement(By.id("submitButton")).click();
		
		cv.findElement(By.xpath("(//a[text()='Opportunities'])[1]")).click();
		cv.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		
		Thread.sleep(1500);
		cv.findElement(By.xpath("//input[@name='potentialname']")).sendKeys(OPPName + " "+ jutil.getRandomNumber());
		cv.findElement(By.xpath("(//img[@style='cursor:hand;cursor:pointer'])[1]")).click();
		Thread.sleep(1500);
		
		wutil.windowSwitch(cv, "http://localhost:8888/index.php?module=Accounts&action=Popup&html=Popup_picker&form=vtlibPopupView&forfield=related_to&srcmodule=Potentials&forrecord=");
		cv.findElement(By.id("search_txt")).sendKeys(RELETATEDTO);
		cv.findElement(By.xpath("//a[text()='Pune01']")).click();
		Thread.sleep(2000);
		
		wutil.windowSwitch(cv, "http://localhost:8888/index.php?module=Potentials&action=EditView&return_action=DetailView&parenttab=Sales");
		WebElement drop = cv.findElement(By.cssSelector("select[name='opportunity_type']"));
		wutil.handleDropDown(drop, TYPE);
		Thread.sleep(1500);
		
		WebElement drop2 = cv.findElement(By.cssSelector("select[name='leadsource']"));
		wutil.handleDropDown(drop2, LEADSOURCE);
		cv.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		Thread.sleep(2000);
		WebElement drop3 = cv.findElement(By.name("assigned_group_id"));
		wutil.handleDropDown(drop3, ASSIGNTO);
		
		WebElement drop4 = cv.findElement(By.cssSelector("select[name='sales_stage']"));
		wutil.handleDropDown(drop4, SALESTAGE);
		cv.findElement(By.id("probability")).sendKeys("95");
		Thread.sleep(1500);
		
		cv.findElement(By.cssSelector("textarea[name='description']")).sendKeys(DESCRIPTION);
		
		cv.findElement(By.xpath("(//input[@name='button'])[3]")).click();
		Thread.sleep(3000);
		
		WebElement mouse = cv.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		wutil.mouseHover(cv, mouse);
		Thread.sleep(1000);
		cv.findElement(By.xpath("//a[text()='Sign Out']")).click();
		cv.quit();
		
		

	}

}
