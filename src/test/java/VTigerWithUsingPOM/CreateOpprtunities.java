package VTigerWithUsingPOM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.ListenerImplimentation;
import CommonUtils.WebDriverUtil;
import Objects.OpportunitiesPage;

@Listeners(ListenerImplimentation.class)
public class CreateOpprtunities extends BaseClass{
	
	ExcelUtil eutil = new ExcelUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	JavaUtil jutil = new JavaUtil();
	OpportunitiesPage opppage = new OpportunitiesPage();
	
	@Test
	public void CreateOpprtunities01() throws EncryptedDocumentException, IOException, InterruptedException {
		
		PageFactory.initElements(cv, opppage);
		
		String OPPName = eutil.getdatafromExcel("Opportunity", 0, 1);
		String RELETATEDTO = eutil.getdatafromExcel("Opportunity", 1, 1);
		String TYPE = eutil.getdatafromExcel("Opportunity", 2, 1);
		String LEADSOURCE = eutil.getdatafromExcel("Opportunity", 3, 1);
		String ASSIGNTO = eutil.getdatafromExcel("Opportunity", 4, 1);
		String SALESTAGE = eutil.getdatafromExcel("Opportunity", 5, 1);
		String DESCRIPTION = eutil.getdatafromExcel("Opportunity", 7, 1);
		
		opppage.getOppModule().click();
		opppage.getPlusIcon().click();
		opppage.getOppName().sendKeys(OPPName+ " " +jutil.getRandomNumber());
		opppage.getPlusiconSelectOrg().click();
		
		wutil.windowSwitch(cv, "http://localhost:8888/index.php?module=Accounts&action=Popup&html=Popup_picker&form=vtlibPopupView&forfield=related_to&srcmodule=Potentials&forrecord=");
		
		opppage.getSearchOrg().sendKeys(RELETATEDTO);
		opppage.getOrgName().click();
		
		wutil.windowSwitch(cv, "http://localhost:8888/index.php?module=Potentials&action=EditView&return_action=DetailView&parenttab=Sales");
		
		opppage.getTypeDrop().sendKeys(TYPE);
		opppage.getLeadsourceDrop().sendKeys(LEADSOURCE);
		opppage.getGroupRedio().click();
		opppage.getAssignTodrop().sendKeys(ASSIGNTO);
		opppage.getSalesStagedrop().sendKeys(SALESTAGE);
		opppage.getProbabilityArea().sendKeys("96");
		opppage.getDescriptionArea().sendKeys(DESCRIPTION);
		
		
	}

}
