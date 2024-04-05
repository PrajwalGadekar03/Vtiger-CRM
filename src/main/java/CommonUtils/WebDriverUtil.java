package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {

	public void maximizeWindow(WebDriver driver) {

		driver.manage().window().maximize();
	}

	public void minimizeWindow(WebDriver driver) {

		driver.manage().window().minimize();

	}

	public void fillscreenWindow(WebDriver driver) {

		driver.manage().window().fullscreen();

	}

	public void waitWebElementToLoad(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void handleDropDown(WebElement target, String text) {

		Select s = new Select(target);
		s.selectByVisibleText(text);
	}

	public void handleDropDown(WebElement target, int index) {

		Select s = new Select(target);
		s.selectByIndex(index);

	}

	public void handleDropDownValue(WebElement target, String value) {

		Select s = new Select(target);
		s.selectByValue(value);

	}

	public void mouseHover(WebDriver driver, WebElement target) {

		Actions a = new Actions(driver);
		a.moveToElement(target);
		a.perform();

	}

	public void rightClick(WebDriver driver, WebElement target) {

		Actions a = new Actions(driver);
		a.contextClick(target);
		a.perform();

	}

	public void doubleClick(WebDriver driver, WebElement target) {

		Actions a = new Actions(driver);
		a.doubleClick(target);
		a.perform();

	}

	public void click(WebDriver driver, WebElement target) {

		Actions a = new Actions(driver);
		a.click(target);
		a.perform();

	}

	public void windowSwitch(WebDriver driver, String expectedurl) {
		Set<String> ids = driver.getWindowHandles();
		System.out.println(ids);
		for (String e : ids) {
			String actaulurl = driver.switchTo().window(e).getCurrentUrl();
			System.out.println(actaulurl);

			if (actaulurl.contains(expectedurl)) {

			}
		}

	}

	public String ScreenShot(WebDriver driver, String Screenshotname) throws IOException {

		LocalDateTime ldt = LocalDateTime.now();
		String timestramp = ldt.toString().replace(':', '-');
		TakesScreenshot ts = (TakesScreenshot) driver;
		File tempfile = ts.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("./ScrenShot/"+Screenshotname+".png");
		FileUtils.copyFile(tempfile, destinationfile);
		return destinationfile.getAbsolutePath();

	}

// JavaScript Popup's
	public void okpopup(WebDriver driver) {

		driver.switchTo().alert().accept();

	}

	public void cancelpopup(WebDriver driver) {

		driver.switchTo().alert().dismiss();

	}

	public void textpopup(WebDriver driver) {

		driver.switchTo().alert().getText();

	}

	public void valuepopup(WebDriver driver, String text) {

		driver.switchTo().alert().sendKeys(text);

	}

//Frame

	public void frames(WebDriver driver, int index) {

		driver.switchTo().frame(index);

	}

	public void frames(WebDriver driver, String name) {

		driver.switchTo().frame(name);

	}

	public void frames(WebDriver driver, WebElement element) {

		driver.switchTo().frame(element);

	}

//PageLoadTime

	public void pageload(WebDriver driver) {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

	}

	public void waitWebElementToDisplay(WebDriver driver, String Expectedurl) {

		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
		waits.until(ExpectedConditions.urlToBe(Expectedurl));

	}
	

}
