package VTigerWithFramework;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.ListenerImplimentation;
import CommonUtils.WebDriverUtil;

@Listeners(ListenerImplimentation.class)
public class CreateOppotunities extends BaseClass{
	
	ExcelUtil eutil = new ExcelUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	JavaUtil jutil = new JavaUtil();
	
	@Test
	public void CreateOpportunities() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String OPPName = eutil.getdatafromExcel("Opportunity", 0, 1);
		String RELETATEDTO = eutil.getdatafromExcel("Opportunity", 1, 1);
		String TYPE = eutil.getdatafromExcel("Opportunity", 2, 1);
		String LEADSOURCE = eutil.getdatafromExcel("Opportunity", 3, 1);
		String ASSIGNTO = eutil.getdatafromExcel("Opportunity", 4, 1);
		String SALESTAGE = eutil.getdatafromExcel("Opportunity", 5, 1);
		String DESCRIPTION = eutil.getdatafromExcel("Opportunity", 7, 1);
		
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
		
	}

}
