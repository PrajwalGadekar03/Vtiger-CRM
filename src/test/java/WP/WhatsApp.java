package WP;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WhatsApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver sc = new ChromeDriver();
		sc.get("https://web.whatsapp.com/");
		sc.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		sc.manage().window().maximize();
		Thread.sleep(20000);
		
		

	}

}
