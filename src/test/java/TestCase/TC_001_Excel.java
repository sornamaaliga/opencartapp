package TestCase;

import org.testng.Assert;

import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.homePage;
import testbase.Baseclass;

public class TC_001_Excel extends Baseclass {
	

	public void verify_loginDDT(String email,String password,String exp) {
		try {
	logger.info("***start the login testing***");
	
	homePage hmpage=new homePage(driver);
	hmpage.clickMyAccount();
	hmpage.clickloginbtn();
	
	logger.info("***Intiated Login***");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.setloginemail(email);
	loginpage.setloginpassword(password);
	//loginpage.setloginbtn();
	loginpage.setloginbtndemo();
	
//MyAccountPage ma=new MyAccountPage(driver);
//boolean target= ma.ismyAccountpageexist();//old one
	
	MyAccountPage ma=new MyAccountPage(driver);
	boolean target= ma.isMyAccountpagedemopage();//new url
	
	if(exp.equalsIgnoreCase("valid"))
	{
		
		if(target==true) {
			ma.logoutbtnde();
			
			Assert.assertTrue(true);
			
		}
		else {
			Assert.assertTrue(false);
		}
	}
	if(exp.equalsIgnoreCase("Invalid")) {
		if(target==true) {
			ma.logoutbtnde();
			Assert.assertTrue(false);
		}
		else {
			
			Assert.assertTrue(true);
		}
	}
	}
		catch (Exception e) {
			Assert.fail();
		}
		

	}
}
