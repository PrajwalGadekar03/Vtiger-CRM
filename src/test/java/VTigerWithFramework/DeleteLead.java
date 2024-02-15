package VTigerWithFramework;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ListenerImplimentation;

@Listeners(ListenerImplimentation.class)
public class DeleteLead extends BaseClass {
	
	@Test
	public void deleteLead() {
		
		cv.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		cv.findElement(By.xpath("(//a[text()='del'])[18]")).click();
		cv.switchTo().alert().dismiss();
	}

}
