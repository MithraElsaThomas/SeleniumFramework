package com.orangehrm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.orangegrm.qa.constants.Constants;
import com.orangehrm.qa.utilities.ExcelRead;


public class EditUserPageTest extends BasePageTest {

	SoftAssert sf;

	@Test(priority=1)
	public void verifySetUp() {

		loginpage.loginAction(Constants.username, Constants.password);    
		String loginTitle=driver.getTitle();
		Assert.assertEquals(loginTitle,  Constants.pagetitle);

		

	}

	@Test(priority=2)
	public void userPageNavigation() {
		
		edituser.tabAdmin();
	}


	
	@Test(dataProvider="editUserDetails",priority=3)
	public void verifyEditUserPageTest(String user1,String passwrd1,String confrim_pwd1) {
		
		edituser.editUserDataAction(user1,passwrd1,confrim_pwd1);
		boolean pageHeader=edituser.editUserPageHeader();

		sf=new SoftAssert();
		sf.assertTrue(pageHeader, "edit user page header is wrong");
		sf.assertAll();

	}



	@DataProvider(name="editUserDetails")

	public Object[][] userEditData() throws InvalidFormatException, IOException{

		Object[][] data=ExcelRead.getDataFromExcel(Constants.dataProvider_filepath, "EditUserData");

		return data;
	}








}
