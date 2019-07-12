package com.swaglab.qa.testclass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swaglab.qa.base.testbase;
import com.swaglab.qa.page.homepage;
import com.swaglab.qa.page.loginpage;

public class loginpagetest extends testbase{
	
	loginpage lpage;
	homepage hpage;
	
	public loginpagetest(){
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		initialozation();
		lpage=new loginpage();
	}
	
	@Test(priority=1)
	public void loginpagetitletest(){
		String title=lpage.validateloginpagetitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@Test(priority=2)
	public void loginpagelogotest(){
		boolean flag=lpage.validateloginpagelogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void logintest(){
		hpage=lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}	
	
}
