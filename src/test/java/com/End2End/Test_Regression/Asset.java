
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
		System.out.println("//For openinf url!!");
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
		
	}

	@Parameters({ "Bridge" })
	@Test(testName = "Add asset details for Bridge", priority = 3, enabled = true)
	public static void add_assetBridge() throws FilloException, InterruptedException {
		Thread.sleep(3000);
		commFunc.Click(driver, By.xpath("(//mat-expansion-panel-header//child::mat-icon[contains(text(),'add')])"));
		String Bridge_id = record.getField("Bridge_ID");
		commFunc.put_field_data(driver, "bridge ID", Bridge_id);
		String Bridge_Label = record.getField("Bridge_Label");
		commFunc.put_field_data(driver, "bridgeLabel", Bridge_Label);
//		String date = record.getField("Date");
//		commFunc.put_field_data(driver, "lettingDate", date);
//		commFunc.dropdown_data(driver, "country", "India");
//		String description = record.getField("Description");
//		commFunc.put_field_data(driver, "description", description);
//		String low_bid = record.getField("Estimation_bid");
//		commFunc.put_field_data(driver, "lowBidEstimate", low_bid);
//		String Structure_type = record.getField("Structure_type");
//		commFunc.put_field_data(driver, "structureType", Structure_type);
//		String Super_structure = record.getField("Super_structure");
//		commFunc.put_field_data(driver, "superstructureType", Super_structure);
//		String Audment = record.getField("Audment");
//		commFunc.put_field_data(driver, "adutmentType", Audment);
//		String Wingwall = record.getField("Wingwall");
//		commFunc.put_field_data(driver, "wingwallType", Wingwall);
//		String piles = record.getField("Piles");
//		commFunc.put_field_data(driver, "pilesType", piles);
//		commFunc.dropdown_data(driver, "maintenance", "FALSE");
//		String Width = record.getField("Width");
//		commFunc.put_field_data(driver, "totalWidth", Width);
//		String Span = record.getField("Span");
//		commFunc.put_field_data(driver, "numberOfSpans", Span);
//		String Length = record.getField("Length");
//		commFunc.put_field_data(driver, "totalLength", Length);
//		String Skew = record.getField("Skew");
//		commFunc.put_field_data(driver, "skew", Skew);
//		asset.save_btn(driver);
//		String project_labels = record.getField("project_Label");
//		asset.validate_asset(driver, project_labels);
//		logger.log(LogStatus.INFO, "Asset data added successfully!");

	}

	@Test(testName = "Edit asset details", priority = 4, enabled = false)
	public void edit_details() throws FilloException, InterruptedException {

		System.out.println("//For editing asset");
		asset.editing_asset(driver);
		asset.add_asset_details(driver, "View");
		asset.add_asset_details(driver, "Edit");
		commFunc.Click(driver, By.xpath("(//mat-expansion-panel-header//child::mat-icon[contains(text(),'add')])"));
		Thread.sleep(2000);
		String project_label_updated = record.getField("project_Label_updated");
		commFunc.put_field_data(driver, "projectLabel", project_label_updated);
		asset.update_btn(driver);
		asset.validate_update_btn(driver, project_label_updated);

	}

	@Test(testName = "Delete asset details", priority = 5, enabled = false)

	public void delete_asset() {
		System.out.println("//For deleting asset");
		asset.editing_asset(driver);
		asset.add_asset_details(driver, "Delete");
		commFunc.Click(driver, By.xpath("//button//span[contains(text(),'Yes')]"));
	}

}
