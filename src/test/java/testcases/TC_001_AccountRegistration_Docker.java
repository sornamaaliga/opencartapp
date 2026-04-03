package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.accountRegistrationPage;
import pageobjects.homePage;
import testbase.Baseclass;

public class TC_001_AccountRegistration_Docker extends Baseclass{
	
@Test
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
		validreg.setTelephone("8456210256");
		String password=randomAlphaNumeric();
		validreg.SetPassword(password);
		validreg.setconfirmpassword(password);
		validreg.agree();
		//validreg.continuebutton();
		validreg.conutinuebtnAppdemo();
		
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
