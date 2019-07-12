package com.swaglab.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.qa.base.testbase;

public class checkoutpage extends testbase{
	
	@FindBy(xpath="//*[@id='first-name']")
	WebElement firstname;
	
	@FindBy(xpath="//*[@id='last-name']")
	WebElement lastname;
	
	@FindBy(xpath="//*[@id='postal-code']")
	WebElement zipcode;
	
	@FindBy(xpath="//*[@value='CONTINUE']")
	WebElement continuebtn;
	
	@FindBy(xpath="//*[contains(text(),'CANCEL')]")
	WebElement cancelbtn;
	
	public checkoutpage(){
		PageFactory.initElements(driver, this);
	}
	
	public overviewpage checkoutdetails(){
		firstname.sendKeys("omi");
		lastname.sendKeys("pdre");
		zipcode.sendKeys("431707");
		continuebtn.click();
		
		return new overviewpage();
	}
	
	public cartpage clickcancelbtn(){
		cancelbtn.click();
		return new cartpage();
		
	}

}
