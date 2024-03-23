package Utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BasePackage.BaseClass;

public class ExtentReportManager implements ITestListener
{
	
	    //UI of the report
		public ExtentSparkReporter sparkReporter;
		
		//Common information of report
		public ExtentReports extent;
		
		//Creating test cases of report & update status of report
		public ExtentTest test;
	 
		String repName;
	 
		public void onStart(ITestContext testContext) 
		{
			
			//Time stamp
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			repName = "Test-Report-" + timeStamp + ".html";
			
			//Specify location of the report
			sparkReporter = new ExtentSparkReporter(".\\Report\\" + repName);
			
			//Title of report
			sparkReporter.config().setDocumentTitle("Hackathon Automation Report");
			
			//Name of the report
			sparkReporter.config().setReportName("Hackathon Websites Testing");
			
			
			sparkReporter.config().setTheme(Theme.DARK);
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Application", "Coursera");
			extent.setSystemInfo("Module", "Hackathon Project");
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			extent.setSystemInfo("Environemnt", "QA");
			String os = testContext.getCurrentXmlTest().getParameter("os");
			extent.setSystemInfo("Operating System", os);
			String browser = testContext.getCurrentXmlTest().getParameter("browser");
			extent.setSystemInfo("Browser", browser);
			List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
			if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
			}
			
		}
	 
		
		public void onTestSuccess(ITestResult result) 
		{
			
			//To display groups in report
			test = extent.createTest(result.getTestClass().getName() + result.getMethod());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.PASS, result.getName()+" got successfully executed");
			try 
			{
				
				String imgPath = new BaseClass().captureScreen(result.getName());
				test.addScreenCaptureFromPath(imgPath);
			
			} 
			catch (IOException e1) 
			{
				
				e1.printStackTrace();
			
			}
			
		}
	 
		
		public void onTestFailure(ITestResult result) 
		{
			
			test = extent.createTest(result.getTestClass().getName() + result.getMethod());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.FAIL,result.getName()+" got failed");
			test.log(Status.INFO, result.getThrowable().getMessage());
			try 
			{
				
				String imgPath = new BaseClass().captureScreen(result.getName());
				test.addScreenCaptureFromPath(imgPath);
			
			}
			catch (IOException e1) 
			{
				
				e1.printStackTrace();
			
			}
		
		}
	 
		
		public void onTestSkipped(ITestResult result) 
		{
			
			test = extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP, result.getName()+" got skipped");
			test.log(Status.INFO, result.getThrowable().getMessage());
		
		}
	 
		public void onFinish(ITestContext testContext) 
		{
			
			extent.flush();
			String pathOfExtentReport = System.getProperty("user.dir")+"\\Report\\"+repName;
			File extentReport = new File(pathOfExtentReport);
			try 
			{
				
				Desktop.getDesktop().browse(extentReport.toURI());
			} 
			catch (IOException e) 
			{
				
				e.printStackTrace();
			
			}
	 
		
		}
}
