package com.singlestorefront.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.singlestorefront.actiondriver.Action;
import com.singlestorefront.base.BaseClass;


/**
 * This ExtentManager class contains
 * implematation of extent report
 * 
 * @version 1.0
 *  
 */

public class ExtentManager extends BaseClass{
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() {
		String dateName = Action.getCurrentDateTime();
		
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+ BaseClass.getOSPath("ExtentReport","TestReport_"+dateName+".html"));
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/src/main/resources/extent-config.xml");
		//htmlReporter.config().setDocumentTitle("Automation Test Report");
		//htmlReporter.config().setReportName("Test Automation Report"); 
		//htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		String os = System.getProperty("os.name");
		
		extent.setSystemInfo("HostName", "Stage");
		extent.setSystemInfo("ProjectName", "SSF");
		extent.setSystemInfo("QA_Engineer", "Zaid");
		extent.setSystemInfo("OS", os);
		//extent.setSystemInfo("Browser", "Chrome");
	}
	public static void endReport() {
		extent.flush();
	}
}
