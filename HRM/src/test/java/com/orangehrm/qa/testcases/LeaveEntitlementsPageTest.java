package com.orangehrm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangegrm.qa.constants.Constants;
import com.orangehrm.qa.utilities.ExcelRead;

public class LeaveEntitlementsPageTest extends BasePageTest {


	@Test(priority=1)
	public void verifySetUp() {


		loginpage.loginAction(Constants.username, Constants.password);

		String loginTitle=driver.getTitle();
		Assert.assertEquals(loginTitle,  Constants.pagetitle);
	}


	
	@Test(dataProvider = "addLeaveEntitle",priority=2,enabled=false)
	public void verifyEnterAddLeaveDetails(String employee1,String entitle1) throws InterruptedException {

		leaveentitle.addEntitlementNav();

		sf.assertEquals(leaveentitle.pageheaderDisplayed(), true,"Pageheader is not displayed");
		leaveentitle.enterAddLeaveDetails(employee1, entitle1);
		
		sf.assertEquals(leaveentitle.leaveDisplay(), true,"Employee is not displaying in searh tab by default after leave");
		sf.assertAll();
	}

	@Test(dataProvider = "addLeaveMultipleEmployee",priority=3)
	public void verifyEnterLeaveMultipleEmployees(String employee1,String entitle1) throws InterruptedException {
		
		leaveentitle.addEntitlementNav();

		sf.assertEquals(leaveentitle.pageheaderDisplayed(), true,"Pageheader is not displayed");
		leaveentitle.enterLeaveMultipleEmployees(employee1, entitle1);
		String searchUrl=driver.getCurrentUrl();
		sf.assertEquals(searchUrl, "https://opensource-demo.orangehrmlive.com/index.php/leave/addLeaveEntitlement","Entitlement is not updated");
		sf.assertAll();
	}



	@DataProvider

	public Object[][] addLeaveEntitle() throws InvalidFormatException, IOException{

		Object[][] data=ExcelRead.getDataFromExcel(Constants.dataProvider_filepath, "AddLeaveEntitlementData");
		return data; 
	}

	@DataProvider

	public Object[][] addLeaveMultipleEmployee() throws InvalidFormatException, IOException{

		Object[][] data=ExcelRead.getDataFromExcel(Constants.dataProvider_filepath, "AddLeaveEntitlementData");
		return data; 
	}








}
