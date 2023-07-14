package com.End2End.PagesObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.End2End.Test_Regression.BaseClass;

public class Asset_ObjectPage extends BaseClass {
	
	
	By fast_form_tab = By.xpath("//button//span[contains(text(),'Fast Form')]");
	By static_form_bttn = By.xpath("//div[@class='formListIcon']//following-sibling::div[contains(text(),'Static Form')]");
	By Bridge_owner_btn = By.xpath("//div[@class='dbIcon']//following-sibling::div[contains(text(),'Bridge Owner')]");
	By asset_data_btn = By.xpath("//div[@class='dbIcon']//following-sibling::div[contains(text(),'Asset Data')]");
	By confirm_data = By.xpath("//button//span[contains(text(),'Yes')]");
	By save_btn = By.xpath("//button//span[text()='Save']");
	By update_btn = By.xpath("//button//span[text()='Update']");
	
	public void validate_url_page(WebDriver driver) {

		String actual_url = "http://berdnxdev.iworklab.com/";

		String expected_url = driver.getCurrentUrl();
		
		if(actual_url.contentEquals(expected_url)) {
			System.out.println("WebSite opened!");
		}
		else {
			System.err.println("WebSite not opened!");
		}
	}
	
	public void Asset_form(WebDriver driver) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commFunc.Click(driver, fast_form_tab);
		commFunc.Click(driver, static_form_bttn);
		commFunc.Click(driver, Bridge_owner_btn);
		commFunc.Click(driver, asset_data_btn);
		
		
	}
	
	public void add_asset_details(WebDriver driver,String name) {
		commFunc.Click(driver,By.xpath("//button//span[text()='"+name+"']"));
	}
	
	public void save_btn(WebDriver driver) {
		commFunc.Explicitywait(driver, save_btn);
		commFunc.Click(driver, save_btn);
		commFunc.Click(driver, confirm_data);
	}
	
	public void update_btn(WebDriver driver) {
		commFunc.Explicitywait(driver, update_btn);
		commFunc.Click(driver, update_btn);
		commFunc.Click(driver, confirm_data);
	}
	
	public void validate_asset(WebDriver driver, String name) throws InterruptedException {
		
		Thread.sleep(3000);
		List<WebElement> columnNames = driver.findElements(By.xpath("//table[contains(@role,'table')]//child::tbody//tr//td"));
		
		int count_column = columnNames.size();
		for(int i = 0; i<count_column; i++) {
			String value = driver.findElement(By.xpath("(//tbody[@role='rowgroup']//tr//td)[3]")).getText();
			if(value.equalsIgnoreCase(name)) {
				System.out.println("Asset data added successfully");
				break;
			}
			else{
				System.err.println("Asset data not found");
			}
		}
	}
	
	
	public void validate_update_btn(WebDriver driver,String name) throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> columnNames = driver.findElements(By.xpath("//table[contains(@role,'table')]//child::tbody//tr//td"));
		
		int count_column = columnNames.size();
		for(int i = 0; i<count_column; i++) {
			String value = driver.findElement(By.xpath("(//tbody[@role='rowgroup']//tr//td)[3]")).getText();
			if(value.equalsIgnoreCase(name)) {
				System.out.println("Asset data updated successfully");
				break;
			}
			else{
				System.err.println("Asset data are not updated successfully");
			}
		}
		
	}
	
	public void editing_asset(WebDriver driver) {
		commFunc.Click(driver, By.xpath("(//tbody[@role='rowgroup']//tr//td)[3]"));
	}
}
