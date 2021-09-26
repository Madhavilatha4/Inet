package com.inetbanking.testcases;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import com.inetbanking.utilites.Readconfig;

public class Baseclass {
	Readconfig read=new Readconfig();
 public String url=read.geturl();
 public String username=read.getusername();
 public String password=read.getpassword();
 static WebDriver driver;
 public static Logger logger;
 @Parameters("browser")
 @BeforeClass
 public void setup(String browser) {
	 logger=LogManager.getLogger(Baseclass.class);
	//PropertyConfigurator.configure("Log4j2.properties");
	 if(browser.equals("edge")){
			System.out.println("Open Firefox Driver");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if(browser.equals("chrome")){
			System.out.println("Open Chrome Driver");
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// logger=LogManager.getLogger(Baseclass.class);
		 driver.get(url);
 }
 @AfterClass
 public void close() {
	 driver.quit();
 }
 public  void captureScreen(WebDriver driver,String tname) throws IOException {
	 TakesScreenshot ts= (TakesScreenshot) driver;
	 
	 File source = ts.getScreenshotAs(OutputType.FILE);
	 File target = new File(System.getProperty("user.dir")+ "/Screenshots/" + tname + ".png");
	
	 FileUtils.copyFile(source, target.getAbsoluteFile());
	 System.out.println("Screenshot taken");
	
	 }
}
