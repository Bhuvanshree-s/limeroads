package com.qa.testdata;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter
{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest xTest;
	public void onStart(ITestContext testContext) {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report" + timeStamp +".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/" +repName);
		htmlReporter.config().setDocumentTitle("Automation Testing");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Admin");
		extent.setSystemInfo("QA Name", "Bhuvanashree s");
		extent.setSystemInfo("OS", "Windows 10");
	}
	
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
	public void onTestSuccess(ITestResult tr) { 
		xTest  =extent.createTest(tr.getName()); 
		xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		   xTest.log(Status.PASS, "Test is Passed");
		//   String screenshotpath=System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
//			File file=new File(screenshotpath);
//			if(file.exists())
//			{
//				try {
//					xTest.pass("Screen shot for the test passed is: "+ xTest.addScreenCaptureFromPath(screenshotpath));
//				}
//				catch(IOException e) {
//					e.printStackTrace();
//				
//				}
//			}
	}
	public void onTestFailure(ITestResult tr) {
		xTest=extent.createTest(tr.getName());
		xTest.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		xTest.log(Status.FAIL, "Test is Failed");
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		File file=new File(screenshotpath);
		if(file.exists())
		{
			try {
				xTest.fail("Screen shot for the test failed is: "+ xTest.addScreenCaptureFromPath(screenshotpath));
			}
			catch(IOException e) {
				e.printStackTrace();
			
			}
		}
	}
	 public void onTestSkipped(ITestResult tr) {
		 xTest =extent.createTest(tr.getName()); 
		 xTest.log(Status.SKIP,
		MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		xTest.log(Status.SKIP, "Test is Skipped");
	 }
		 


}