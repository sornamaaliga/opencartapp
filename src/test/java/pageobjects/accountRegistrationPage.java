package pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class accountRegistrationPage extends basePage {

	public accountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	 
	@FindBy(xpath="//input[@id=\"input-firstname\"]")
	WebElement enterFirstName;
	
	@FindBy(xpath="//input[@id=\"input-lastname\"]")
	WebElement enterLastName;

	@FindBy(xpath="//input[@id=\"input-email\"]")
	WebElement enterEmail;
	
	@FindBy(xpath="//input[@placeholder=\"Password\"]")
	WebElement enterPassword;
	//newly added
	@FindBy(xpath="//input[@id=\"input-telephone\"]")
	WebElement Telephonenum;
	//newly added
	@FindBy(xpath="//input[@placeholder=\"Password Confirm\"]")
	WebElement confirmpass;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agreeToggle;
	//old localhost
	@FindBy(xpath="//button[@class=\"btn btn-primary\"]")
	WebElement continuebtn;
	//new demo app
	@FindBy(xpath="//input[@class=\"btn btn-primary\"]")
	WebElement contniuedemoAppbtn;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement confirmationmsg;
	
	public void SetFirstname(String fname) {
		enterFirstName.sendKeys(fname);
	}	
	public void SetLaststname(String lname) {
		enterLastName.sendKeys(lname);
	}
	
	public void SetEmail(String email) {
		enterEmail.sendKeys(email);
	}
	
	public void SetPassword(String pwd) {
		enterPassword.sendKeys(pwd);
	}
	
	public void setTelephone(String telenum) {
		Telephonenum.sendKeys(telenum);
	}
	public void setconfirmpassword(String pwd) {
		confirmpass.sendKeys(pwd);
	}
	public void agree() {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", agreeToggle);
	    wait.until(ExpectedConditions.elementToBeClickable(agreeToggle));
	    js.executeScript("arguments[0].click();", agreeToggle);	
	}
	public void continuebutton() {
		continuebtn.click();
	}
	public void conutinuebtnAppdemo() {
		contniuedemoAppbtn.click();
	}
	public String getconfirmationtest() {
		try {
			return (confirmationmsg.getText());	
		}
		catch (Exception e) {
			return (e.getMessage());
		}
		
		
	}
}
