package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageobjects.basePage;

public class BasicUtils extends basePage {
	
	public BasicUtils(WebDriver driver) {
		super(driver);
	}
	
	public boolean isAlertPresent() {
		try {
		wait.until(ExpectedConditions.alertIsPresent());
		return true;
		}
		catch (Exception e) {
			return  false;
		}
	}
	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}
	
  
	
}
