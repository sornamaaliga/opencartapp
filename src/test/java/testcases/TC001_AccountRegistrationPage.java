package testcases;

import java.time.Duration;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.accountRegistrationPage;
import pageobjects.homePage;
import testbase.Baseclass;

public class TC001_AccountRegistrationPage extends Baseclass {

//	
//	@BeforeClass
//	public void setup() {
//		driver=new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		driver.get("https://tutorialsninja.com/demo/");
//		driver.manage().window().maximize();
//	}
//	@AfterClass
//	public void teardown() {
//		driver.quit();
//	}
	@Test(groups={"Regression","Master"})
	public void verify_account_registration(){
		try {
		logger.info("*****started account registration*****");
		homePage hompage=new homePage(driver);
		logger.info("*****opened driver*****");
		hompage.clickMyAccount();
		logger.info("*****clicked on Myaccount tab*****");
		hompage.clickRegistration();
		logger.info("*****clicked resgistration button*****");
		
		accountRegistrationPage validreg=new accountRegistrationPage(driver);
		
		logger.info("*****Providing customer information*****");
		validreg.SetFirstname(randomestrString().toUpperCase());
		validreg.SetLaststname(randomestrString().toUpperCase());
		validreg.SetEmail(randomestrString()+"@gmail.com");
		
		String password=randomAlphaNumeric();
		validreg.SetPassword(password);
		validreg.agree();
		validreg.continuebutton();
		
		logger.info("*****validating expected message*****");
		String confirmtext=validreg.getconfirmationtest();
		if(confirmtext.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);;
		}
		else {
			logger.error("Test failed");
			logger.debug(" Debugging...");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confirmtext, "Your Account Has Been Created!");
		}
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("****finished testing****");
	}
	
	
	
}
