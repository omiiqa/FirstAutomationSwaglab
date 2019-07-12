package com.swaglab.qa.testclass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swaglab.qa.base.testbase;
import com.swaglab.qa.page.cartpage;
import com.swaglab.qa.page.homepage;
import com.swaglab.qa.page.labpage;
import com.swaglab.qa.page.loginpage;

public class homepagetest extends testbase{
	
	loginpage lpage;
	homepage hpage;
	cartpage cpage;
	labpage lbpage;

	public homepagetest() {
		super();
		}

	@BeforeMethod
	public void setup(){
		initialozation();
		//cpage=new cartpage();
		lbpage=new labpage();
		lpage=new loginpage();
		hpage=lpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyhomepagetitletest(){
		String title=hpage.verifyhomepagetitle();
		Assert.assertEquals(title, "Swag Labs","home page title not mached");
	}
	
	
	@Test(priority=2)
	public void productlisttest(){
		lbpage=hpage.productlist(prop.getProperty("productname"));
		
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}	
	
	
}