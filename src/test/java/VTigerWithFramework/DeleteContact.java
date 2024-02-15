package VTigerWithFramework;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ListenerImplimentation;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

@Listeners(ListenerImplimentation.class)
public class DeleteContact extends BaseClass{
	
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	
	@Test
	public void deleteContact() {
		
		cv.findElement(By.xpath("//a[text()='Contacts']")).click();
		cv.findElement(By.xpath("(//a[text()='del'])[16]")).click();
		cv.switchTo().alert().dismiss();
		
	}

}
