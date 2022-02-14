package com.orangehrm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangegrm.qa.constants.Constants;
import com.orangehrm.qa.utilities.ExcelRead;

public class PIMReportsPageTest extends BasePageTest{



	@Test(priority=1)
	public void verifySetUp() {

		loginpage.loginAction(Constants.username, Constants.password);

		String loginTitle=driver.getTitle();
		Assert.assertEquals(loginTitle,  Constants.pagetitle);
	}

	@Test(dataProvider ="enterAddReports",priority=2)
	public void verifyAddReportTest(String report_name1) {

		pimreports.reportsPageNav();
		pimreports.addReport(report_name1);

		String actualUrl=driver.getCurrentUrl();
		String Expected="https://opensource-demo.orangehrmlive.com/index.php/core/viewDefinedPredefinedReports";

		sf.assertEquals(actualUrl, Expected, "Report Missing");
		sf.assertAll();

	}


	@Test(priority=3)
	public void verifySortReportAndEditTest() {

		pimreports.reportsPageNav();
		pimreports.customReports();
		pimreports.editReports();
		
		String editedUrl=driver.getCurrentUrl();
		String expected="https://opensource-demo.orangehrmlive.com/index.php/core/viewDefinedPredefinedReports";
		sf.assertEquals(editedUrl, expected, "Editing failed");
		pimreports.runReports();
		
		
		sf.assertAll();
	}

	
	

	@Test(priority=4)
	public void verifyDelete() throws InterruptedException {

		pimreports.deleteAllUsers();

		pimreports.checkNoRecordsAfterDeleteall();
		sf.assertEquals(pimreports.checkNoRecordsAfterDeleteall(), true, "Reports are displaying after deleting all Reports");

		
		sf.assertAll();

	}












	@DataProvider

	public Object[][] enterAddReports() throws InvalidFormatException, IOException{

		Object[][] data=ExcelRead.getDataFromExcel(Constants.dataProvider_filepath, "DefneReportData");

		return data;
	}
}
