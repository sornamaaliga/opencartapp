package testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import pageobjects.SearchPage;
import pageobjects.wishListPage;
import testbase.Baseclass;

public class TC005_WishList extends Baseclass{
	wishListPage wp;
    @Test
	public void verify_Testcase005() {
		SearchPage sp=new SearchPage(driver);
		sp.navtosearchfield("iphone");
		sp.TapOnSearchIcon();
		
		wp=new wishListPage(driver);
		wp.addproducttowishlist();
		String confimationmessage=wp.checkwishlistalert();
		System.out.println(confimationmessage);
		String message=confimationmessage.replace("×", "").trim();
		System.out.println(message);
		Assert.assertEquals(message, "You must login or create an account to save iPhone to your wish list!");
		String fullText=wp.checkwishlistcount("title");//title or textContent
		String count=fullText.substring((fullText.indexOf("(")+1),fullText.indexOf(")"));
		int actual_count_of_wishList=Integer.parseInt(count);
		System.out.println(actual_count_of_wishList);
		Assert.assertEquals(1,actual_count_of_wishList);	
		
		wp.TapOnWishList();
		
		LoginPage lp=new LoginPage(driver);
		lp.setloginemail(pro.getProperty("gmail"));
		lp.setloginpassword(pro.getProperty("password"));
		lp.setloginbtndemo();
		
		//verify My Wish List text is displayed
		List<String> actualdata=wp.firstrowvalue();
		System.out.println(actualdata);
		int columnCount = wp.getColumnCount();
		
		System.out.println("--- Starting Table Verification ---");
		for (int i = 0; i < columnCount; i++) {
	        String data = wp.getCellData(i);
	        System.out.println("Column " + i + ": " + data);

	        // Perform Assertions based on Index
	        switch (i) {
	            case 0:
	                Assert.assertEquals(data, "Image Present", "Image not found in Column 0");
	                break;
	            case 1:
	                Assert.assertEquals(data, "iPhone", "Product name mismatch!");
	                break;
	            case 2:
	                Assert.assertEquals(data, "product 11", "Model mismatch!");
	                break;
	            case 3:
	                Assert.assertEquals(data, "Out Of Stock", "Stock mismatch!");
	                break;
	            case 4:
	                Assert.assertEquals(data, "$123.20", "Price mismatch!");
	                break;
	            case 5:
	                Assert.assertEquals(data, "Actions Present", "Buttons not found in Column 5");
	                break;
	        }
	    }
	    System.out.println("--- Table Verification Completed ---");
	    
		
		
		
		
	}
}
