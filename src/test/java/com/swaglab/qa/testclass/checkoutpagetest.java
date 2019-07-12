package com.swaglab.qa.testclass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swaglab.qa.base.testbase;
import com.swaglab.qa.page.cartpage;
import com.swaglab.qa.page.checkoutpage;
import com.swaglab.qa.page.homepage;
import com.swaglab.qa.page.labpage;
import com.swaglab.qa.page.loginpage;
import com.swaglab.qa.page.overviewpage;

public class checkoutpagetest extends testbase{
	
	loginpage lpage;
	homepage hpage;
	cartpage cpage;
	labpage lbpage;
	checkoutpage chpage;
	overviewpage ovpage;
	
	public checkoutpagetest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialozation();
		lpage=new loginpage();
		hpage=lpage.login(prop.getProperty("username"), prop.getProperty("password"));
		lbpage=hpage.productlist(prop.getProperty("productname"));
		cpage=lbpage.addtocartbtn();
		chpage=cpage.clickcheckoutbtn();
		
	}
	
	@Test(priority=1)
	public void checkoutdetailstest(){
		ovpage=chpage.checkoutdetails();
	}
	
	@Test(priority=2)
	public void clickcancelbtntest(){
		cpage=chpage.clickcancelbtn();
	}
	
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
