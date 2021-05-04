package com.qa.testscript;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import com.qa.page.Limeroadpages;

public class LimeroadTestdata {

	
		WebDriver driver;
		Limeroadpages lime;
		@Parameters({"Browser","Url"})
		@BeforeMethod
		public void setup(String Browser, String Url) {
		if(Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
			}
		else if(Browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.msedge.driver", "C:\\driver\\msedgedriver.exe");
		
		driver = new EdgeDriver();
		
			}
		else if(Browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
			}
		else if(Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.IE.driver", "C:\\driver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
			}
		driver.get(Url);
		driver.manage().window().maximize();
		lime=new Limeroadpages(driver);
		
		}
		
		
		 @AfterMethod
		 public void tearDown() {
			 driver.quit();
					
		}
		 public void captureScreenshot (WebDriver driver, String tname) throws IOException {
			 TakesScreenshot ts = (TakesScreenshot)driver;
			File Source= ts.getScreenshotAs(OutputType.FILE);
			 File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
			 FileUtils.copyFile(Source,target);
			 System.out.println("Screenshot is captured");
		 }
}
