package com.End2End.PagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.End2End.Test_Regression.BaseClass;

public class BridgeDesign_Objectpage extends BaseClass {


	By Bridge_owner_btn = By.xpath("//div[@class='dbIcon']//following-sibling::div[contains(text(),'Designer')]");
	By Bridge_design_form = By.xpath("//div[@class='dbIcon']//following-sibling::div[contains(text(),'Bridge Design Data')]");
	
	public void bridge_deisgn_form(WebDriver driver) {
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	commFunc.Click(driver, Bridge_owner_btn);
	commFunc.Click(driver, Bridge_design_form);
	}
}
