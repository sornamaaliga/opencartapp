package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends basePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	//old
	@FindBy(xpath = "//h1[text()='My Account']")
	WebElement MyAccountPage;
	//New
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement MyAccountdemo;
	
	@FindBy(xpath="//a[text()='Logout' and @class='dropdown-item']")
	WebElement LogoutBtn;
	//new
	@FindBy(xpath="//a[text()='Logout' and  @class=\"list-group-item\"]")
	WebElement logoutbtndemo;
	
	public boolean ismyAccountpageexist() {
		
		try {
			return(MyAccountPage.isDisplayed());
		}
		catch (Exception e) {
			return false;
		}
	}
	public boolean isMyAccountpagedemopage() {
		try {
			return(MyAccountdemo.isDisplayed());
		}
		catch (Exception e) {
			return false;
		}
	}
	public void loginbtn() {
		JavascriptExecutor jsl=(JavascriptExecutor) driver;
		 jsl.executeScript("arguments[0].scrollIntoView(true);", LogoutBtn);
		jsl.executeScript("arguments[0].click();", LogoutBtn);
		//LogoutBtn.click();
	}
	public void logoutbtnde() {
		JavascriptExecutor jsl=(JavascriptExecutor) driver;
		 jsl.executeScript("arguments[0].scrollIntoView(true);", logoutbtndemo);
		jsl.executeScript("arguments[0].click();",logoutbtndemo);
	}
}
