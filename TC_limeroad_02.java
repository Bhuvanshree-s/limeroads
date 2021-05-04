package com.qa.testscript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.testdata.Utility;

public class TC_limeroad_02 extends LimeroadTestdata {
	@Test(dataProvider="getData")
	public void negative(String Input) throws Exception { 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		lime.getShopwomen().click();
		lime.getCart().click();
		lime.getContinue().click();
        lime.getSearch().click();
		lime.getSearchbox().clear();
		lime.getSearchbox().sendKeys(Input+"\n");
		lime.getLowprice().click();
		lime.getColor().click();
		lime.getBlack().click();
     	lime.getPricerange().click();
        lime.getPricerange1().click();
     	Reporter.log(driver.getTitle());
     	driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL+"t");
        driver.get("https://www.google.com/");
        driver.navigate().back();
        Reporter.log(driver.getTitle());
}
	
	@DataProvider
	public String[][] getData() throws IOException {
		
		String xpath="C:\\Users\\Admin\\eclipse-workspace\\Selenium.Automatio\\src\\test\\java\\com\\qa\\testdata\\Testdata.xlsx";
		String xSheet="Sheet1";
		int rowCount=Utility.getRowCount(xpath, xSheet);
		int cellCount=Utility.getCellCount(xpath, xSheet, rowCount);
		String[][] data= new String[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j]=Utility.getCellData(xpath, xSheet, i, j);
				
			}
		}
		return data;
	}
}