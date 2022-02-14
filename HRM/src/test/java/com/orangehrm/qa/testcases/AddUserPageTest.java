package com.orangehrm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangegrm.qa.constants.Constants;
import com.orangehrm.qa.utilities.ExcelRead;

public class AddUserPageTest extends BasePageTest{



	@Test(priority=1)
	public void verifySetUp() {

		loginpage.loginAction(Constants.username, Constants.password);   

		String dashBoardTitle=driver.getTitle();
		Assert.assertEquals(dashBoardTitle,  Constants.pagetitle);

		admin.addUser();
		adduser.checkAddUserPageElements();
	}

	@Test(dataProvider = "userData",priority=2)
	public void verifyaddUserActionTest(String emp_name1,String usr_name1,String pword1,String confrm_pwod1) throws InterruptedException {

		adduser.addUserDeatils(emp_name1, usr_name1, pword1, confrm_pwod1);

		String adduserurl=driver.getCurrentUrl();
		String expected="https://opensource-demo.orangehrmlive.com/index.php/admin/saveSystemUser";
	
		Assert.assertEquals(adduserurl, expected, "User is not added");
		sf.assertAll();

	}

	@Test(priority=3)
	public void verifyDelete() throws InterruptedException {

		adduser.deleteAllUsers();
		
		adduser.resultTableCheckboxDisplay();
		sf.assertEquals(adduser.resultTableCheckboxDisplay(), true, "Check box is displaying after deleting all users");
		
		adduser.resultTableCheckboxEnabled();
		sf.assertEquals(adduser.resultTableCheckboxEnabled(), true, "Check box is enabled after deleting all users");
		sf.assertAll();

	}


	@DataProvider()

	public Object[][] userData() throws InvalidFormatException, IOException{

		Object[][] data=ExcelRead.getDataFromExcel(Constants.dataProvider_filepath, "AddUserData");

		return data;
	}

}
