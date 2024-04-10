package VTigerWithFramework;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtil;
import CommonUtils.ListenerImplimentation;

import CommonUtils.WebDriverUtil;

@Listeners(ListenerImplimentation.class)
public class CreateContact extends BaseClass {
	
	ExcelUtil eutil = new ExcelUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	
	@Test
	public void CreateContact01() throws EncryptedDocumentException, IOException, InterruptedException{
		
		String FIRSTNAME = eutil.getdatafromExcel("Contact02", 0, 1);
	    String LASTNAME = eutil.getdatafromExcel("Contact02", 1, 1);
	    String GROUP = eutil.getdatafromExcel("Contact02", 2, 1);
	    String NAME = eutil.getdatafromExcel("Contact02", 3, 1);
	    
	    cv.findElement(By.xpath("//a[text()='Contacts']")).click();
		cv.findElement(By.cssSelector("img[title='Create Contact...']")).click();

		cv.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		cv.findElement(By.name("lastname")).sendKeys(LASTNAME);
		cv.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		Thread.sleep(2000);
		WebElement dropd = cv.findElement(By.name("assigned_group_id"));
		wutil.handleDropDown(dropd, GROUP);
		
//		Assert.assertEquals("Pune", "Deccan");
		
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
		Thread.sleep(2000);
		
	}

}
