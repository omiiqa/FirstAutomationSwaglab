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

public class labpagetest extends testbase{
	loginpage lpage;
	homepage hpage;
	cartpage cpage;
	labpage lbpage;
	
	public labpagetest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialozation();
		cpage=new cartpage();
		lbpage=new labpage();
		lpage=new loginpage();
		hpage=lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		lbpage=hpage.productlist(prop.getProperty("productname"));
	}
	
	@Test(priority=1)
	public void verifyproductdetailstest(){
		
		String details=lbpage.verifyproductdetails();
		Assert.assertEquals(details, prop.getProperty("productname"));
	}
	
	@Test(priority=2)
	public void verifyproductpricetest(){
		System.out.println(lbpage.verifyproductprice());
	}
	
	@Test(priority=3)
	public void addtocartbtntest(){
		cpage=lbpage.addtocartbtn();
	}
	
	

	@AfterMethod
	public void teardown(){
		driver.quit();
	}	

}
