package com.swaglab.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.qa.base.testbase;

public class loginpage extends testbase{
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//*[contains(@class,'btn_action')]")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[contains(@class,'login_logo')]")
	WebElement logo;
	
	
	public loginpage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateloginpagetitle(){
		return driver.getTitle();
	}
	public Boolean validateloginpagelogo(){
		return logo.isDisplayed();
	}
	
	public homepage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new homepage();
		
	}
}
