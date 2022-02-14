package com.orangehrm.qa.testcases;




import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangegrm.qa.constants.Constants;
import com.orangehrm.qa.utilities.ExcelRead;


public class MyInfoPageTest extends BasePageTest{



	@Test(priority=1,groups= {"sanity","regression"})
	public void setUp() {

		loginpage.loginAction(Constants.username, Constants.password);    
		String loginTitle=driver.getTitle();
		Assert.assertEquals(loginTitle,  Constants.pagetitle);
	}

	
	

	@Test(dataProvider="enterPersonalData",priority=2,groups= {"sanity","regression"})
	public void verifyEnterMyinfoTabTest(String full_name1,String Last_name1,String Emp_id1,String other_id1,String license_num1
			 ) {
		
		myinfo.myInfoTabNav();
		myinfo.enterMyInfoPersonalDetails(full_name1, Last_name1, Emp_id1, other_id1, license_num1);
//		myinfo.checkEnabled();
		Assert.assertEquals(myinfo.checkEnabled(), true, "Myinfo tab is not enabled");

	}
	
	@Test(priority=3,groups= {"regression"},enabled=false)
	public void verifyEditCustomField(){
		
		myinfo.myInfoTabNav();
		myinfo.editCustomeFieldsData();
		myinfo.customDropEnabled();	
		Assert.assertEquals(myinfo.customDropEnabled(), false, "Custom dropdown is not enabled");

	}
	
	
	@Test(priority=4,groups= {"regression"})
	public void addAttachment(){
		
		myinfo.myInfoTabNav();
		myinfo.myInfoAddAttachments();
		Assert.assertEquals(myinfo.myInfoAttachmentsDisplay(), true, "not displayed");
		myinfo.myInfoEditAttachments();
		myinfo.myInfoDeleteAttachments();
	}
						

	
	@DataProvider()
	
	public Object[][] enterPersonalData() throws InvalidFormatException, IOException{
		
		Object[][] data=ExcelRead.getDataFromExcel(Constants.dataProvider_filepath, "MyInfoPageData");
		return data;
	}
		
		
		
	}


