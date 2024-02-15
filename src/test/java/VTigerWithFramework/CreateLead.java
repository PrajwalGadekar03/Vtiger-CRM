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
public class CreateLead extends BaseClass {

	PropertyFileUtil putil = new PropertyFileUtil();
	ExcelUtil eutil = new ExcelUtil();
	WebDriverUtil wutil = new WebDriverUtil();

	@Test
	public void CreateLead01() throws EncryptedDocumentException, IOException, InterruptedException {

		String FIRSTNAME = eutil.getdatafromExcel("LEAD", 0, 1);
		String LASTNAME = eutil.getdatafromExcel("LEAD", 1, 1);
		String COMPANY = eutil.getdatafromExcel("LEAD", 2, 1);
		String GROUP = eutil.getdatafromExcel("LEAD", 3, 1);

		cv.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();

		cv.findElement(By.cssSelector("img[title='Create Lead...']")).click();
		Thread.sleep(2000);
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

//			wutil.ScreenShot(cv, "LeadModule");

	}

}
