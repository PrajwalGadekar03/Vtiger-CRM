package VTigerWithFramework;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.ListenerImplimentation;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

@Listeners(ListenerImplimentation.class)
public class CreateOrganization extends BaseClass {

	PropertyFileUtil putil = new PropertyFileUtil();
	ExcelUtil eutil = new ExcelUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	JavaUtil jutil = new JavaUtil();

	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException, InterruptedException {

		String NAME = eutil.getdatafromExcel("Organization02", 0, 1);
		String GROUP = eutil.getdatafromExcel("Organization02", 1, 1);
		String INDUSTRY = eutil.getdatafromExcel("Organization02", 2, 1);

		cv.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		cv.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
		//To fail the script
//		Assert.assertEquals("Pune", "Deccan");

		cv.findElement(By.cssSelector("input[name='accountname']")).sendKeys(NAME + jutil.getRandomNumber());
		cv.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		WebElement dropdown = cv.findElement(By.name("assigned_group_id"));
		wutil.handleDropDown(dropdown, GROUP);
		WebElement dropdown02 = cv.findElement(By.cssSelector("select[name='industry']"));
		wutil.handleDropDown(dropdown02, INDUSTRY);

		cv.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		Thread.sleep(2000);
//		wutil.ScreenShot(cv, "Oraganization");
		
		

	}

}
