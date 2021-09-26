package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.inetbanking.pageobjects.LoginPage;



public class TC_LoginTest_001 extends Baseclass
{
	@Test
	public void logintest() throws IOException {

		logger.info("URl is open");

		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Enter username");

		lp.setPassword(password);
		logger.info("Enter password");

		logger.info("Printing title");
		lp.Click();
		System.out.println(driver.getTitle());

		if(driver.getTitle().equals("Guru99 Bank Manager Home"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			captureScreen(driver,"logintest");
			logger.info("Logintest failed");
			Assert.assertTrue(false);
		}
	}

}
