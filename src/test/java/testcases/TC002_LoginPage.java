package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.homePage;
import testbase.Baseclass;

public class TC002_LoginPage extends Baseclass{

	@Test(groups={"sanity","Master"})
	public void verify_login() {
		try {
		logger.info("***start the login testing***");
		
		homePage hmpage=new homePage(driver);
		hmpage.clickMyAccount();
		hmpage.clickloginbtn();
		
		logger.info("***Intiated Login***");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.setloginemail(pro.getProperty("gmail"));
		loginpage.setloginpassword(pro.getProperty("password"));
		//loginpage.setloginbtn(); it is for old url
		loginpage.setloginbtndemo();
		
//		MyAccountPage ma=new MyAccountPage(driver);
//		boolean target= ma.ismyAccountpageexist();
//		Assert.assertEquals(target, true);
		MyAccountPage ma=new MyAccountPage(driver);
		boolean target= ma.isMyAccountpagedemopage();
		Assert.assertEquals(target, true);
		
	}
	catch (Exception e) {
		 logger.error("Test failed due to an exception: " + e.getMessage());
	
		    Assert.fail("Test failed in catch block: " + e.getMessage());
		
	}
		
	}
}
