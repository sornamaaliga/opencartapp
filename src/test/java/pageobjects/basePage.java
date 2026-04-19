package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class basePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	public basePage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver,this);
	}
	
}

