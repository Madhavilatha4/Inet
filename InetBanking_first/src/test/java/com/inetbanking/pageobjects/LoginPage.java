package com.inetbanking.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 static WebDriver ldriver;
 
public   LoginPage(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory. initElements(rdriver, this);
}

 @FindBy(name="uid")
 WebElement txtUsername;
 public void setUsername(String uname) {
		txtUsername.sendKeys(uname);
	}
 
	@FindBy(name="password")
	WebElement txtPassword; 
	public void setPassword(String pword) {
		txtPassword.sendKeys(pword);
	}
	
	@FindBy(name="btnLogin")
	WebElement login;
		public void Click() {
		login.sendKeys(Keys.RETURN);
	}
		@FindBy(linkText="Log out")
		WebElement logout;
		public void setlogout() {
			logout.click();
		}
		
}

