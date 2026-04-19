package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class wishListPage extends basePage {

	public wishListPage(WebDriver driver) {
		super(driver);
	}

     @FindBy(xpath="//button[contains(@data-original-title,' Wish')]")
     WebElement TaponWishList;
     
     @FindBy(xpath = "//div[contains(@class,'alert-success ')]")
     WebElement wishlistAlert;
	
	 @FindBy(id ="wishlist-total")
	 WebElement WishListcount;
	 
	 @FindBy(id ="wishlist-total")
	 WebElement clickWishList;
	 
	 @FindBy(xpath = "//table[@class=\"table table-bordered table-hover\"]//thead//tr//td")
	 List<WebElement> getfirstrow;
	 
	 @FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody/tr[1]/td")
	 List<WebElement> firstRowCells;
	 
	 public void addproducttowishlist() {
		 TaponWishList.click();
	 }
	 public String checkwishlistalert() {
		 return wishlistAlert.getText();
	 }
	 public String checkwishlistcount(String WishListCount) {
		 return WishListcount.getAttribute(WishListCount);
	 }
	 public void TapOnWishList() {
		 clickWishList.click();
	 }
	 public List<String> firstrowvalue() {
		 List<String> cellrows=new ArrayList<>();
		 for(WebElement cell: getfirstrow) {
			 cellrows.add(cell.getText().trim());
		 }
		 return cellrows;
	 }
       // This method handles the extraction logic
	    public String getCellData(int index) {
	        WebElement cell = firstRowCells.get(index);
	        String text = cell.getText().trim();
	        
	        if (!text.isEmpty()) {
	            return text;
	        } else if (cell.findElements(By.tagName("img")).size() > 0) {
	            return "Image Present";
	        } else if (cell.findElements(By.tagName("button")).size() > 0 || cell.findElements(By.tagName("a")).size() > 0) {
	            return "Actions Present";
	        }
	        return "EMPTY";
	    }
	    public int getColumnCount() {
	        return firstRowCells.size();
	    }
}
