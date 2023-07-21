package com.End2End.Test_Regression;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Bridge_Design extends BaseClass {
	
	@Parameters({ "Bridge" })
	@Test(testName = "Add Bridge design details", priority = 5, enabled = true)
	public void add_bridge_design() {
		logger = rep.startTest("Bridge design scenarios");
		System.out.println("//For Bridge design data!");
		bridge.bridge_deisgn_form(driver);
	}

}
