package com.orangehrm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangegrm.qa.constants.Constants;
import com.orangehrm.qa.utilities.ExcelRead;

public class AssignLeavePageTest extends BasePageTest{


	@Test(priority=1)
	public void setUp() {

		loginpage.loginAction(Constants.username, Constants.password);   

		String dashBoardTitle=driver.getTitle();
		Assert.assertEquals(dashBoardTitle,  Constants.pagetitle);
		assignleave.assignPageNav();

		String assignleaveTitle=driver.getTitle();
		Assert.assertEquals(assignleaveTitle,  Constants.pagetitle);

		boolean aleave=assignleave.checkAssignTabEnabled();
		Assert.assertTrue(aleave, "Assignleave tab is enabled");

	}


	@Test(dataProvider ="leaveReason",priority=2)
	public void verifyAssignpageTest(String employee_name1,String from_date1,String to_date1,String leave_comment1) {

		assignleave.assignLeaveDetail(employee_name1, from_date1, to_date1, leave_comment1);
		assignleave.checkAssignBtnEnable();


		Assert.assertTrue(assignleave.checkAssignBtnEnable(), "Assign button is displayed");


	}


	@DataProvider(name="leaveReason")

	public Object[][] leaveData() throws InvalidFormatException, IOException{

		Object[][] data=ExcelRead.getDataFromExcel(Constants.dataProvider_filepath, "LeaveTestData");

		return data;

	}
}
