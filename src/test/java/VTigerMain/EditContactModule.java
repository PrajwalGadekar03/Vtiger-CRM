package VTigerMain;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CommonUtils.ExcelUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class EditContactModule {

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
		
		String LeadSource = eutil.getdatafromExcel("Contact02", 4, 1);
//		String OfficePhone = eutil.getdatafromExcel("Contact02", 5, 1);
		String DEPARTMENT = eutil.getdatafromExcel("Contact02", 6, 1);
		String EMAIL = eutil.getdatafromExcel("Contact02", 7, 1);
		String DESCRIPTION = eutil.getdatafromExcel("Contact02", 8, 1);
		
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
		
		cv.findElement(By.xpath("//a[text()='Contacts']")).click();
		cv.findElement(By.xpath("(//a[text()='edit'])[1]")).click();
		
		Thread.sleep(1000);
		WebElement Ddown = cv.findElement(By.cssSelector("select[name='leadsource']"));
		wutil.handleDropDown(Ddown, LeadSource);
		Thread.sleep(1000);
		cv.findElement(By.id("department")).sendKeys(DEPARTMENT);
		cv.findElement(By.id("email")).sendKeys(EMAIL);
		
		cv.findElement(By.xpath("(//img[@alt='Select'])[2]")).click();
		Set<String> Ids = cv.getWindowHandles();
		System.out.println(Ids);
		for(String e : Ids) {
			String actualurl = cv.switchTo().window(e).getCurrentUrl();
			System.out.println(actualurl);
		}
		cv.findElement(By.xpath("(//a[text()='Prajwal Gadekar'])[1]")).click();
		wutil.windowSwitch(cv, "http://localhost:8888/index.php?module=Contacts&action=Popup&html=Popup_picker&popuptype=specific&form=EditView&recordid=12");
		
		cv.findElement(By.cssSelector("input[name='emailoptout']")).click();
		cv.findElement(By.cssSelector("input[name='donotcall']")).click();
		cv.findElement(By.cssSelector("input[name='notify_owner']")).click();
		cv.findElement(By.cssSelector("textarea[name='description']")).sendKeys(DESCRIPTION);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
