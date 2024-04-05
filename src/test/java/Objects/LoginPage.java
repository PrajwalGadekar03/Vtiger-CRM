package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver cv;
	public LoginPage(WebDriver d){
		cv = d;
		PageFactory.initElements(cv, this);
	}
	
	@FindBy (name="user_name") WebElement username;
	@FindBy (name="user_password") WebElement pass;
	@FindBy (id="submitButton") WebElement subbutton;

	public WebElement getUsername() {
		return username;
	}
	public WebElement getPass() {
		return pass;
	}
	public WebElement getSubbutton() {
		return subbutton;
	}
}
