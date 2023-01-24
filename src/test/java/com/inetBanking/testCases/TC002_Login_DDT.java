package com.inetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.utilities.XLUtils;
import com.inetBannking.pageObjects.loginPage;

public class TC002_Login_DDT extends BaseClass  {
	
	@Test(dataProvider = "LoginDatas")
	public void loginDDT(String uname, String pwd) throws InterruptedException
	{
		loginPage lp = new loginPage(driver);
		lp.setUsername(uname);
		logger.info("Username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clcikLogin();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{

			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("LoggedIn Failed");
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("LoggedIn Passed");
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginDatas")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginDatas.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindatas[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindatas[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindatas;
	}
		
		
		
	}
	
	


