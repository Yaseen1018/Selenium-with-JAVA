package com.inetBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBannking.pageObjects.loginPage;

public class TC001_LoginTest extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		//driver.get(baseURL);
		
		logger.info("Url is opened");

		loginPage lp = new loginPage(driver);
		lp.setUsername(Username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clcikLogin();
		logger.info("Logged in successfully");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Tes Failed");
		}
		
		
		
	}
		
		
	
}


