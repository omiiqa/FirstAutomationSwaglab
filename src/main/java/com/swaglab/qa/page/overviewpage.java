package com.swaglab.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.qa.base.testbase;

public class overviewpage extends testbase{
	
	@FindBy(xpath="//*[@class='inventory_item_name']")
	WebElement productdetail;
	
	@FindBy(xpath="//*[contains(text(),'FINISH')]")
	WebElement finishbtn;
	
	@FindBy(xpath="//*[contains(text(),'CANCEL')]")
	WebElement cancelbtn;
	
	
	public overviewpage(){
		PageFactory.initElements(driver, this);
	}

	
	public String verifyproductdetails(){
		return productdetail.getText();
	}
	
	public homepage clickcancelbtn(){
		cancelbtn.click();
		return new homepage();
		}
	
	public finishpage clickfinishbtn(){
		finishbtn.click();
		return new finishpage();
	}
}
