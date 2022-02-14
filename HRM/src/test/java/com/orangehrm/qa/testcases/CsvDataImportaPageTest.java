package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangegrm.qa.constants.Constants;

public class CsvDataImportaPageTest extends BasePageTest{



	@Test(priority=1 ,groups= {"sanity","regression"})
	public void verifySetUp() {

		loginpage.loginAction(Constants.username, Constants.password);    
		String dashBoardTitle=driver.getTitle();
		Assert.assertEquals(dashBoardTitle,  Constants.pagetitle);

	}

	@Test(priority=2,groups= {"sanity","regression"})
	public void verifyCsvDataUploadTest() {

		csvimport.dataImportFile();
		String dataImportPageTitle=driver.getTitle();
		Assert.assertEquals(dataImportPageTitle,  Constants.pagetitle);


	}


	@Test(priority=3,groups= {"sanity","regression"})
	public void verifyCsvDataDownloadTest() {

		csvimport.downloadFile();   
		String datadownloadPageTitle=driver.getTitle();
		Assert.assertEquals(datadownloadPageTitle,  Constants.pagetitle);


	}

}
