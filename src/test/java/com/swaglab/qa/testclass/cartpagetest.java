package com.swaglab.qa.testclass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swaglab.qa.base.testbase;
import com.swaglab.qa.page.cartpage;
import com.swaglab.qa.page.checkoutpage;
import com.swaglab.qa.page.homepage;
import com.swaglab.qa.page.labpage;
import com.swaglab.qa.page.loginpage;

public class cartpagetest extends testbase{
	loginpage lpage;
	homepage hpage;
	cartpage cpage;
	labpage lbpage;
	checkoutpage chpage;
	
	public cartpagetest(){
		super();
	}
		@BeforeMethod
		public void setup(){
			initialozation();
			//cpage=new cartpage();
			//lbpage=new labpage();
			lpage=new loginpage();
			hpage=lpage.login(prop.getProperty("username"), prop.getProperty("password"));
			lbpage=hpage.productlist(prop.getProperty("productname"));
			cpage=lbpage.addtocartbtn();
			
		}
	
	@Test(priority=1)
	public void verifyproductdetailstest(){
		String details=cpage.verifyproductdetails();
		System.out.println("the given product details are:"+details);
		Assert.assertEquals(details, prop.getProperty("productname"));
	}
	
	@Test(priority=2)
	public void clickcontinueshopingbtntest(){
		hpage=cpage.clickcontinueshopingbtn();
	}
	
	@Test(priority=3,dependsOnMethods={"verifyproductdetailstest"})
	public void clickcheckoutbtntest(){
		chpage=cpage.clickcheckoutbtn();
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
