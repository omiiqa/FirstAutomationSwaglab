package com.swaglab.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.qa.base.testbase;

public class cartpage extends testbase{
	
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	WebElement productdesc;
	
	@FindBy(xpath="//*[contains(text(),'CHECKOUT')]")
	WebElement checkoutbtn;
	
	@FindBy(xpath="//*[contains(text(),'Continue Shopping')]")
	WebElement continueshopingbtn;
	
	
	public cartpage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyproductdetails(){
		return productdesc.getText();
	}
	
	public checkoutpage clickcheckoutbtn(){
		checkoutbtn.click();
		return new checkoutpage();
	}
	
	public homepage clickcontinueshopingbtn(){
		continueshopingbtn.click();
		return new homepage();
	}

}
