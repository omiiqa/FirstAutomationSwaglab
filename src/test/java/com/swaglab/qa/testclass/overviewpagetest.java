package com.swaglab.qa.testclass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swaglab.qa.base.testbase;
import com.swaglab.qa.page.cartpage;
import com.swaglab.qa.page.checkoutpage;
import com.swaglab.qa.page.finishpage;
import com.swaglab.qa.page.homepage;
import com.swaglab.qa.page.labpage;
import com.swaglab.qa.page.loginpage;
import com.swaglab.qa.page.overviewpage;

public class overviewpagetest extends testbase{
	
	loginpage lpage;
	homepage hpage;
	cartpage cpage;
	labpage lbpage;
	checkoutpage chpage;
	overviewpage ovpage;
	finishpage fpage;

	public overviewpagetest(){
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
		ovpage=chpage.checkoutdetails();
		
	}
	
	@Test(priority=1)
	public void verifyproductdetailstest(){
		String detail=ovpage.verifyproductdetails();
		System.out.println("Product detais is=="+detail);
		Assert.assertEquals(detail, prop.getProperty("productname"));
		
	}
	
	@Test(priority=2)
	public void clickcancelbtntest(){
		hpage=ovpage.clickcancelbtn();
	}
	
	@Test(priority=3)
	public void clickfinishbtntest(){
		fpage=ovpage.clickfinishbtn();
	}
	

	@AfterMethod
	public void teardown(){
		driver.quit();
	}


}
