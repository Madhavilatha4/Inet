package com.inetbanking.utilites;

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
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting  extends TestListenerAdapter {
public ExtentSparkReporter reporter;
public ExtentReports extent;
public ExtentTest test;


public void onStart(ITestContext testcontext) {
	
	try {
		String timeStamp=new SimpleDateFormat("yyyy.mm.dd.HH.ss").format(new Date());
		String repname="Test-Report-"+timeStamp	;
		reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repname);
		 reporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Hostname","Localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user", "Madhavi");
		
		reporter.config().setDocumentTitle("InetBanking Test Project");
		reporter.config().setReportName("Functional Test Report");
		reporter.config().setTheme(Theme.DARK);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
}
public void onTestSuccess(ITestResult tr){
	test=extent.createTest(tr.getName());
	test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
}
	
public void onTestFailure(ITestResult tr) {
	test=extent.createTest(tr.getName());
	test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	String screenshotpath=System.getProperty("user.dir")+"/screenshots/"+tr.getName()+".png";
System.out.println(screenshotpath);
test.addScreenCaptureFromPath(screenshotpath);
	File f=new File(screenshotpath);
	if(f.exists()) {
		test.fail("screenshot is below: "+test.addScreenCaptureFromPath(screenshotpath));
	}
}public void onTestSkipped(ITestResult tr) {
	test=extent.createTest(tr.getName());
	test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	
}
public void onFinish(ITestContext testcontext) {
	
	extent.flush();
}

}

	


