package com.swaglab.qa.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.qa.base.testbase;

public class homepage extends testbase{
	
	
	
	@FindBy(xpath="//div[@class='inventory_list']//div/descendant::div[@class='inventory_item_name']")
	List<WebElement> allproduct;
	
	public homepage(){
		PageFactory.initElements(driver, this);
		
		}
	
	public String verifyhomepagetitle(){
		return driver.getTitle();
	}
	
	
	
	public labpage productlist(String productn){
		System.out.println("List of All Product==>" +allproduct.size());
		
		for(int i=0;i<allproduct.size();i++){
		   System.out.println(allproduct.get(i).getText());
			if(allproduct.get(i).getText().contains(productn)){
				allproduct.get(i).click();
				}
			}
		return new labpage();
		
	}

}
