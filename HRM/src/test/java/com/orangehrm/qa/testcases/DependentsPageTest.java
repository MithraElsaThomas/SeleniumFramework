package com.orangehrm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangegrm.qa.constants.Constants;
import com.orangehrm.qa.utilities.ExcelRead;
import com.orangehrm.qa.utilities.WaitUtil;

public class DependentsPageTest extends BasePageTest {
	@Test(priority=1,groups= {"sanity","regression"})
	public void verifySetUp() {

		loginpage.loginAction(Constants.username, Constants.password);    
		String myInfoPageTitle=driver.getTitle();
		Assert.assertEquals(myInfoPageTitle,  Constants.pagetitle);
	}

	@Test(dataProvider ="depData",priority =2,enabled=false)
	public void verifyAddDepAction(String dep_name1,String Dob1,String editname1) {

		
		dependent.AddDependentsPageNav(dep_name1, Dob1,editname1);
		String currentUrl=driver.getCurrentUrl();
		String expectedurl="https://opensource-demo.orangehrmlive.com/index.php/pim/viewDependents/empNumber/7";
		Assert.assertEquals(currentUrl, expectedurl);
		dependent.cancelDependent();
		dependent.checkPageheaderDisplay();
		
	}

	
	@Test(dataProvider ="editDepData",priority =3,groups= {"sanity","regression"})
	public void verifyEditDepAction(String dep_name1,String Dob1,String editname1) throws InterruptedException {
		dependent.AddDependentsPageNav(dep_name1, Dob1,editname1);
		dependent.checkPageheaderDisplay();
		dependent.editDependent(dep_name1, Dob1,editname1);
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[@class='dependentName']//a")).getText(), editname1);

		dependent.cancelDependent();
		String editPageTitle=driver.getTitle();
		Assert.assertEquals(editPageTitle,  Constants.pagetitle);
	}



	@DataProvider

	public Object[][] depData() throws InvalidFormatException, IOException{

		Object[][] data=ExcelRead.getDataFromExcel(Constants.dataProvider_filepath, "DependentData");

		return data;
	}
	
	@DataProvider

	public Object[][] editDepData() throws InvalidFormatException, IOException{

		Object[][] data=ExcelRead.getDataFromExcel(Constants.dataProvider_filepath, "DependentData");

		return data;
	}
}
