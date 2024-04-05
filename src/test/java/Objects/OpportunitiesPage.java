package Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunitiesPage {
	
		
		@FindBy(xpath="(//a[text()='Opportunities'])[1]") WebElement OppModule;
		@FindBy(xpath="//img[@alt='Create Opportunity...']") WebElement PlusIcon;
		@FindBy(xpath="//input[@name='potentialname']") WebElement OppName;
		@FindBy(xpath="(//img[@style='cursor:hand;cursor:pointer'])[1]") WebElement PlusiconSelectOrg;
		@FindBy(id="search_txt") WebElement SearchOrg;
		@FindBy(xpath="//a[text()='Pune01']") WebElement OrgName;
		@FindBy(xpath="//select[@name='opportunity_type']") WebElement TypeDrop;
		@FindBy(xpath="//select[@name='leadsource']") WebElement LeadsourceDrop;
		@FindBy(xpath="(//input[@name='assigntype'])[2]") WebElement GroupRedio;
		@FindBy(name="assigned_group_id") WebElement AssignTodrop;
		@FindBy(xpath="//select[@name='sales_stage']") WebElement SalesStagedrop;
		@FindBy(id="probability") WebElement probabilityArea;
		@FindBy(xpath="//textarea[@name='description']") WebElement DescriptionArea;

		public WebElement getOppModule() {
			return OppModule;
		}
		public void setOppModule(WebElement oppModule) {
			OppModule = oppModule;
		}
		public WebElement getPlusIcon() {
			return PlusIcon;
		}
		public void setPlusIcon(WebElement plusIcon) {
			PlusIcon = plusIcon;
		}
		public WebElement getOppName() {
			return OppName;
		}
		public void setOppName(WebElement oppName) {
			OppName = oppName;
		}
		public WebElement getPlusiconSelectOrg() {
			return PlusiconSelectOrg;
		}
		public void setPlusiconSelectOrg(WebElement plusiconSelectOrg) {
			PlusiconSelectOrg = plusiconSelectOrg;
		}
		public WebElement getSearchOrg() {
			return SearchOrg;
		}
		public void setSearchOrg(WebElement searchOrg) {
			SearchOrg = searchOrg;
		}
		public WebElement getOrgName() {
			return OrgName;
		}
		public void setOrgName(WebElement orgName) {
			OrgName = orgName;
		}
		public WebElement getTypeDrop() {
			return TypeDrop;
		}
		public void setTypeDrop(WebElement typeDrop) {
			TypeDrop = typeDrop;
		}
		public WebElement getLeadsourceDrop() {
			return LeadsourceDrop;
		}
		public void setLeadsourceDrop(WebElement leadsourceDrop) {
			LeadsourceDrop = leadsourceDrop;
		}
		public WebElement getGroupRedio() {
			return GroupRedio;
		}
		public void setGroupRedio(WebElement groupRedio) {
			GroupRedio = groupRedio;
		}
		public WebElement getAssignTodrop() {
			return AssignTodrop;
		}
		public void setAssignTodrop(WebElement assignTodrop) {
			AssignTodrop = assignTodrop;
		}
		public WebElement getSalesStagedrop() {
			return SalesStagedrop;
		}
		public void setSalesStagedrop(WebElement salesStagedrop) {
			SalesStagedrop = salesStagedrop;
		}
		public WebElement getProbabilityArea() {
			return probabilityArea;
		}
		public void setProbabilityArea(WebElement probabilityArea) {
			this.probabilityArea = probabilityArea;
		}
		public WebElement getDescriptionArea() {
			return DescriptionArea;
		}
		public void setDescriptionArea(WebElement descriptionArea) {
			DescriptionArea = descriptionArea;
		}



}
