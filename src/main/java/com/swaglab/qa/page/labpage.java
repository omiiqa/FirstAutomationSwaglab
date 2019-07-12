package com.swaglab.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.qa.base.testbase;

public class labpage extends testbase{
	
	@FindBy(xpath="//div[@class='inventory_details_name']")
	WebElement productdetails;
	
	@FindBy(xpath="//div[@class='inventory_details_price']")
	WebElement productprice;
	
	@FindBy(xpath="//*[contains(text(),'ADD TO CART')]")
	WebElement addtocartbtn;
	
	@FindBy(xpath="//*[contains(@class,'svg-inline--fa fa-shopping-cart fa-w-18 fa-3x ')]")
	WebElement cartbtn;
	
	
	public labpage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyproductdetails(){
		return productdetails.getText();
	}

	public String verifyproductprice(){
		return productprice.getText();
	}
	
	public cartpage addtocartbtn(){
		addtocartbtn.click();
		cartbtn.click();
		
		return new cartpage();
	}


}
