package com.swaglab.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.swaglab.qa.base.testbase;

public class finishpage extends testbase{
	
	@FindBy(xpath="//*[contains(text(),'THANK')]1")
	WebElement thanksmsg;

	@FindBy(xpath="//*[contains(text(),'THANK')]1")
	WebElement ordermsg;
	
	
	public finishpage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifythanksmsg(){
		return thanksmsg.getText();
	}

	public String verifyordersmsg(){
		return ordermsg.getText();
	}
}
