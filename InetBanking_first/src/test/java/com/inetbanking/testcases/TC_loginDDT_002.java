package com.inetbanking.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.utilites.ExcelUtils;

public class TC_loginDDT_002 extends Baseclass
{
	@Test(dataProvider="login")
	public  void loginDDT(String user,String Pwd) throws InterruptedException {
		
		LoginPage lp =new LoginPage(driver);
		lp.setUsername(user);
		logger.info("username provided");
		lp.setPassword(Pwd);
		logger.info("password provided");
		lp.Click();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();//close Alert
			driver.switchTo().defaultContent();
			logger.warn("Login failed");
			Assert.assertTrue(false);
			
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login passed");
		lp.setlogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		}
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try {
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="login")
	public String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testdata/Logindata.xlsx";

	int rownum=ExcelUtils.getRowCount(path, "Sheet1");
	System.out.println("no.of rows"+rownum);
	int cellnum=ExcelUtils.getCellcount(path, "Sheet1", 1);
	System.out.println("no.of cells"+cellnum);
	String logindata[][]=new String[rownum][cellnum];
	for(int i=1;i<=rownum;i++) {
		for (int j=0;j<cellnum;j++) {
			logindata[i-1][j]=ExcelUtils.getcellData(path, "Sheet1",i,j);
		}	
		}
	return logindata;
	
	
	
	}
	
}
