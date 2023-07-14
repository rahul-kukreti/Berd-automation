package com.End2End.Test_Regression;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.End2End.PagesObjects.Asset_ObjectPage;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import com.utility.*;

public class BaseClass {
	public static WebDriver driver;
	
	//ExtentReport;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest logger;
	public static Recordset record;
	public static Recordset record1;
	String sheetName = "assetproject";
	String sheetNameBridge = "assetbridge";
	public static CommonFunctions commFunc = new CommonFunctions();;
	public static BrowserFactory browserSelect = new BrowserFactory();
	public  DataInput input = new DataInput();
	public static Asset_ObjectPage asset = new Asset_ObjectPage();
	
	@Parameters({"enviroment"})
	@BeforeSuite(description = "initializing Driver", alwaysRun= true)
	public void initializeDriver(String enviroment) throws InterruptedException {
			driver = browserSelect.openChromeIncongnito();
			driver.manage().window().maximize();
			driver.get("http://berdnxdev.iworklab.com/");
			
	}
	@Parameters({ "testCaseID" })
	@BeforeTest(description = "initializing DataInput", alwaysRun = true)
	public void initializeInpuData1(String testCaseID) throws FilloException {

		// Get data from sheet
		record =this.input.asset_projectfromsheet("assetproject", testCaseID);
		
	}
	
	@Parameters({ "testCaseID2" })
	@BeforeTest(description = "initializing DataInput", alwaysRun = true)
	public void initializeInpuData(String testCaseID) throws FilloException {

		// Get data from sheet
		record1 =this.input.asset_projectfromsheet("assetbridge", testCaseID);
		String date = record1.getField("Date");
		System.out.println(date);
		
	}
	
	

	}
