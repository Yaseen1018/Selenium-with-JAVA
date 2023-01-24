package com.inetBannking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class loginPage {
	WebDriver ldriver;
	
	public loginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUsername(String username) {
		txtUsername.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clcikLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
		
	}
	
	
	
	
}

	
	