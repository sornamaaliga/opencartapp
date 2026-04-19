package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPage extends basePage{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
    @FindBy(css  = "input[type='text']")
    WebElement searchField;
    
    @FindBy(xpath ="//div[@id='search']//button")
    WebElement searchIcon;
    
    @FindBy(xpath ="(//button//i[@class=\"fa fa-shopping-cart\"])[2]")
    WebElement Addingtheprodtocart;
    
    @FindBy(xpath="//div[contains(@class, 'alert-success')]")
    WebElement Toastmessage;
    
    public void navtosearchfield(String searchvalue) {
    	searchField.sendKeys(searchvalue);
    }
    public void TapOnSearchIcon() {
    	searchIcon.click();
    }
    public void AddToCart() {
    	JavascriptExecutor jsl=(JavascriptExecutor) driver;
		 jsl.executeScript("arguments[0].scrollIntoView(true);", Addingtheprodtocart);
		jsl.executeScript("arguments[0].click();", Addingtheprodtocart);
    	
    }
    public String CheckToast() {
    return Toastmessage.getText();
    }
}
