package com.End2End.Test_Regression;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.End2End.PagesObjects.Asset_ObjectPage;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import com.utility.*;

public class BaseClass {
	public static WebDriver driver;

	// ExtentReport;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest logger;
	public static Recordset record;
	String sheetNameProject = "assetproject";
	String sheetNameBridge = "assetbridge";
	public static CommonFunctions commFunc = new CommonFunctions();;
	public static BrowserFactory browserSelect = new BrowserFactory();
	public DataInput input = new DataInput();
	public static Asset_ObjectPage asset = new Asset_ObjectPage();
	public static BaseClass base = new BaseClass();

	@Parameters({ "enviroment" })
	@BeforeSuite(description = "initializing Driver", alwaysRun = true)
	public void initializeDriver(String enviroment) throws InterruptedException {
		driver = browserSelect.openChromeIncongnito();
		driver.manage().window().maximize();
		driver.get("http://berdnxdev.iworklab.com/");

	}

	@Parameters({ "testCaseID" })
	@BeforeMethod(description = "initializing DataInput", alwaysRun = true)
	public void initializeInpuData1(String testCaseID) throws FilloException {

		// Get data from sheet
		if (testCaseID.contains("Project")) {
			record = input.asset_projectfromsheet(sheetNameProject, testCaseID);
		}
		if (testCaseID.contains("Bridge")) {
			record = input.asset_projectfromsheet(sheetNameBridge, testCaseID);

		}

	}

}
