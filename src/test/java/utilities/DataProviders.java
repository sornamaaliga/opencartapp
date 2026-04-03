package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="Logindata")
	public String[][] getData() throws IOException{
		String path=".\\testdata\\opencart_app.xlsx";
		 ExcelUtilityFile xlutil=new ExcelUtilityFile(path);
		 
		 int totalrows=xlutil.getRowcount("sheet1");
		 int totalcols=xlutil.getcellcount("sheet1", 1);
		 
		 String logindata[][]=new String [totalrows][totalcols];
		 for(int i=1;i<=totalrows;i++) {
			 for(int j=0;j<totalcols;j++)
			 {
				 logindata[i-1][j]=xlutil.getcellData("sheet1", i, j);
			 }
		 }
		 return logindata;//returning two dimensional array
		 
	}
}
