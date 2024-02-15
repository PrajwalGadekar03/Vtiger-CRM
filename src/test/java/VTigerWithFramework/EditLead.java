package VTigerWithFramework;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtil;
import CommonUtils.ListenerImplimentation;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

@Listeners(ListenerImplimentation.class)
public class EditLead extends BaseClass {
	
	PropertyFileUtil putil = new PropertyFileUtil();
	ExcelUtil eutil = new ExcelUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	
	@Test
	public void editLead() throws EncryptedDocumentException, IOException {
		
		String LeadSource = eutil.getdatafromExcel("LEAD", 4, 1);
		String INDUSTRY = eutil.getdatafromExcel("LEAD", 5, 1);
		String EMAIL = eutil.getdatafromExcel("LEAD", 6, 1);
		String LeadStatus = eutil.getdatafromExcel("LEAD", 7, 1);
		String RATING = eutil.getdatafromExcel("LEAD", 8, 1);
		String DESCRIPTION = eutil.getdatafromExcel("LEAD", 9, 1);
		
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
