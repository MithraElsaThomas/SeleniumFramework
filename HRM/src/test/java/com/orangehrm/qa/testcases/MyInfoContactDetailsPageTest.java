package com.orangehrm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.orangegrm.qa.constants.Constants;
import com.orangehrm.qa.utilities.ExcelRead;

public class MyInfoContactDetailsPageTest extends BasePageTest{



	@Test(priority=1)
	public void setUp() {


		loginpage.loginAction(Constants.username, Constants.password);    
		String loginTitle=driver.getTitle();
		Assert.assertEquals(loginTitle,  Constants.pagetitle);
	}

	@Test(priority=2)
	public void verifyContactDetailsPageNav() {

		contactdetails.contactDetailsNav();

		sf.assertEquals(contactdetails.pageHeaderDispay(), true);
		sf.assertAll();
	}

	@Test(dataProvider ="contactDetailsTest",priority=3)
	public void verifySaveContactDetailsTest(String adressstreet1,String Address_2,String city1,String state1,String workemail1,String otheremail1) {

		contactdetails.enterContactDeatils(adressstreet1, Address_2, city1, state1, workemail1, otheremail1);
		sf.assertEquals(contactdetails.contactDetailsLinkEnabled(), true);
		sf.assertAll();
	}

	@Test(priority=4)
	public void verifyContactAttachmentsTest() throws InterruptedException {
		
		Assert.assertEquals(contactdetails.contactAttachmentsDisplay(), true, "Attachment tab is not displayed");
		
		contactdetails.contactAddAttachments();
		contactdetails.contactEditAttachments();
		contactdetails.contactDeleteAttachments();
		
		
		sf.assertEquals(contactdetails.isAttachmentAdded(), true, "Not added");
		sf.assertAll();
	}

	
	
	
	
	@DataProvider

	public Object[][] contactDetailsTest() throws InvalidFormatException, IOException{

		Object[][] data=ExcelRead.getDataFromExcel(Constants.dataProvider_filepath, "ContactDetails");
		return data;
	}
}
