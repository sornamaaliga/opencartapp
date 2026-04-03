package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePage{

	public homePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement InMyAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement InRegistration;
	
	@FindBy(linkText = "Login")
	WebElement loginpage;
	public void clickMyAccount(){
		 InMyAccount.click();
	}
	public void clickRegistration() {
		InRegistration.click();
	}
	
	public void clickloginbtn() {
		loginpage.click();
	}
}
