package VTigerWithUsingPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Objects.LoginPage;

public class CreateContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver cv = new ChromeDriver();
		cv.manage().window().maximize();
		cv.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LoginPage logpg = new LoginPage(cv);
		
		cv.get("http://localhost:8888");
		logpg.getUsername().sendKeys("admin");
		logpg.getPass().sendKeys("root");
		logpg.getSubbutton().click();

	}

}
