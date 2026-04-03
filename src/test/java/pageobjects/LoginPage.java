package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testbase.Baseclass;

public class LoginPage extends basePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "input-email")
	WebElement loginemail;
	
	@FindBy(xpath ="//input[@name=\"password\"]")
	WebElement loginpassword;
	//my account
	@FindBy(xpath="//button[text()='Login']")
	WebElement loginbutton;
	//new url demo
	@FindBy(xpath="//input[@value=\"Login\"]")
	WebElement loginbtndemo;
	
	
	public void setloginemail(String email) {
		loginemail.sendKeys(email);
	}
	public void setloginpassword(String password) {
		loginpassword.sendKeys(password);
	}
	public void setloginbtn() {
		loginbutton.click();
	}
	public void setloginbtndemo() {
		loginbtndemo.click();
}
	}
