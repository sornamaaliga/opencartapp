package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.SearchPage;
import pageobjects.homePage;
import testbase.Baseclass;


public class TC004_Search_content extends Baseclass {
	@Test
  public void verify_search() {
		homePage hmpage=new homePage(driver);
		hmpage.clickMyAccount();
		hmpage.clickloginbtn();
		
		logger.info("***Intiated Login***");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.setloginemail(pro.getProperty("gmail"));
		loginpage.setloginpassword(pro.getProperty("password"));
		//loginpage.setloginbtn();
		loginpage.setloginbtndemo();
	
		logger.info("***Intiated Search***");
        SearchPage search=new SearchPage(driver);
        search.navtosearchfield("iphone");
        search.TapOnSearchIcon();
        search.AddToCart();
       String toast= search.CheckToast();
       System.out.println(toast);
    // Removes the 'x' character often found at the end of these Bootstrap alerts
       String cleanMessage = toast.replace("×", "").trim();
       System.out.println(cleanMessage);
      // Assert.assertEquals(cleanMessage, "Success: You have added iPhone to your shopping cart!");
       if(cleanMessage.equals("Success: You have added iPhone to your shopping cart!")){
    	   Assert.assertTrue(true);
       }
       else {
    	    logger.error("Test failed");
			logger.debug(" Debugging...");
			Assert.assertTrue(false);
       }
    	
     
	}

          
}
