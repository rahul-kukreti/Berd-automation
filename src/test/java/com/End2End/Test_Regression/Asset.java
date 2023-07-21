
package com.End2End.Test_Regression;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.LogStatus;

public class Asset extends BaseClass {

	@Test(testName = "Open url", priority = 1, enabled = true)
	public void open_url() {
		logger = rep.startTest("Asset scenarios");
		System.out.println("//For opening url!");
		asset.validate_url_page(driver);
		logger.log(LogStatus.INFO, "Website opened successfully!");
	}

	@Parameters({ "Project" })
	@Test(testName = "Add asset details", priority = 2, enabled = true)
	public void add_asset() throws FilloException, InterruptedException {
		System.out.println("//Add asset details for Project");
		asset.Asset_form(driver);

		asset.add_asset_details(driver, "New");
		commFunc.Click(driver, By.xpath("(//mat-expansion-panel-header//child::mat-icon[contains(text(),'add')])"));
		Thread.sleep(9000);
		
		
		String project_id = record.getField("project_ID");
		commFunc.put_field_data(driver, "project id", project_id);
		
		
		String project_label = record.getField("project_Label");
		commFunc.put_field_data(driver, "project label", project_label);
		String date = record.getField("Date");
		commFunc.put_field_data(driver, "project letting date", date);
		String description = record.getField("Description");
		commFunc.put_field_data(driver, "project description", description);
		commFunc.dropdown_data(driver, "maintenance and protection of traffic", "stage construction");
		String Contract_number = record.getField("Contract number");
		commFunc.put_field_data(driver, "contract number", Contract_number);
	//@Parameters({ "Bridge" })
	//@Test(testName = "Add asset details for Bridge", priority = 3, enabled = true)
	//public static void add_assetBridge() throws FilloException, InterruptedException {
		//Thread.sleep(3000);
		commFunc.Click(driver, By.xpath("(//mat-expansion-panel-header//child::mat-icon[contains(text(),'add')])"));
		String Bridge_id = record.getField("Bridge_ID");
		commFunc.put_field_data(driver, "bridge ID", Bridge_id);

		String low_bid = record.getField("Estimation_bid");
		commFunc.put_field_data(driver, "bridge. price . low bid estimate", low_bid);
		String structure_type = record.getField("Structure_type");
		commFunc.dropdown_data(driver,"structure type",structure_type);
		String super_structure_type = record.getField("Super_structure");
		commFunc.dropdown_data(driver,"superstructure type",super_structure_type);
		String abutment = record.getField("Abutment");
		commFunc.dropdown_data(driver,"abutment type",abutment);
		String wingwall = record.getField("Wingwall");
		commFunc.dropdown_data(driver,"wingwall length longer than 65 ft",wingwall);
		String piles = record.getField("Piles");
		commFunc.dropdown_data(driver,"pile type",piles);
		String width = record.getField("Width");
		commFunc.put_field_data(driver, "bridge width", width);
		String Span = record.getField("Span");
		commFunc.put_field_data(driver, "number of spans", Span);
		String Length = record.getField("Length");
		commFunc.put_field_data(driver, "bridge length", Length);
		String Skew = record.getField("Skew");
		commFunc.put_field_data(driver, "skew", Skew);
		String bridge_estimate = record.getField("Bridge estimate");
		commFunc.put_field_data(driver, "bridge estimate per deck area", bridge_estimate);
		asset.save_btn(driver);
//		String project_labels = record.getField("project_Label");
//		asset.validate_asset(driver, project_labels);
//		logger.log(LogStatus.INFO, "Asset data added successfully!");

	}

	@Test(testName = "Edit asset details", priority = 3, enabled = false)
	public void edit_details() throws FilloException, InterruptedException {

		System.out.println("//For editing asset");
		asset.editing_asset(driver);
		asset.add_asset_details(driver, "View");
		asset.add_asset_details(driver, "Edit");
		commFunc.Click(driver, By.xpath("(//mat-expansion-panel-header//child::mat-icon[contains(text(),'add')])"));
		Thread.sleep(2000);
		String project_label_updated = record.getField("project_Label_updated");
		commFunc.put_field_data(driver, "project label", project_label_updated);
		asset.update_btn(driver);
		asset.validate_update_btn(driver, project_label_updated);

	}

	@Test(testName = "Delete asset details", priority = 4, enabled = false)

	public void delete_asset() {
		System.out.println("//For deleting asset");
		asset.editing_asset(driver);
		asset.add_asset_details(driver, "Delete");
		commFunc.Click(driver, By.xpath("//button//span[contains(text(),'Yes')]"));
	}

}
