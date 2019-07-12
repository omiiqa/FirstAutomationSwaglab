package com.swaglab.qa.testclass;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.swaglab.qa.base.testbase;
import com.swaglab.qa.page.cartpage;
import com.swaglab.qa.page.checkoutpage;
import com.swaglab.qa.page.finishpage;
import com.swaglab.qa.page.homepage;
import com.swaglab.qa.page.labpage;
import com.swaglab.qa.page.loginpage;
import com.swaglab.qa.page.overviewpage;
import com.swaglab.qa.utils.TestUtil;

public class finishpagetest extends testbase{
	loginpage lpage;
	homepage hpage;
	cartpage cpage;
	labpage lbpage;
	checkoutpage chpage;
	overviewpage ovpage;
	finishpage fpage;
	ExtentReports extent;
	ExtentTest test;
	
	
	
	public finishpagetest(){
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
		fpage=ovpage.clickfinishbtn();
		
		
		
		
	}
	
	@Test(priority=1)
	public void verifythanksmsgtest(){
		String thmsg=fpage.verifythanksmsg();
		System.out.println(thmsg);
	}
	
	@Test(priority=2)
	public void verifyordermsgtest(){
		String ormsg=fpage.verifyordersmsg();
		System.out.println(ormsg);
	}
	
	
	
	

	@AfterMethod
	public void teardown(ITestResult result){
		
	
		if(ITestResult.FAILURE==result.getStatus())
		{
			try{
				String temp=TestUtil.takeScreenshotAtEndOfTest();
				
				System.out.println("Screenshot captured successfully"+temp);
				
				
			}catch(IOException e){
				System.out.println("Exception while taking screenshot"+e.getMessage());
				
			}
		}
		extent.flush();
		driver.quit();
		
		
		
		
	}
	
	
	
	

}
