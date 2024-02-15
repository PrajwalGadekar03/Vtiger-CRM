package VTigerWithFramework;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ListenerImplimentation;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

@Listeners(ListenerImplimentation.class)
public class DeleteOrganization extends BaseClass {
	
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	
	@Test
	public void deleteOraganization() {
		
		cv.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		cv.findElement(By.xpath("(//a[text()='del'])[13]")).click();
		cv.switchTo().alert().dismiss();
		
	}

}
