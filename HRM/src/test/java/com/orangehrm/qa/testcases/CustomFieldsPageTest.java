package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangegrm.qa.constants.Constants;

public class CustomFieldsPageTest extends BasePageTest {
	
	
	
  @Test(priority=1)
  public void verifySetUp() {
	  
		loginpage.loginAction(Constants.username, Constants.password);
		
		String loginTitle=driver.getTitle();
		Assert.assertEquals(loginTitle,  Constants.pagetitle);
  }
  
  @Test(priority=2)
  public void verifyCustomFieldPageNav() {
	  
	 
	  customfield.customFieldPageNav();

	  sf.assertEquals(customfield.definepageHeaderDisplay(), true, "definedCustomFields_pageHeaderis missing");
	  customfield.addField();
	  customfield.checkAddedField();
	  String customlurl=driver.getCurrentUrl();
	  sf.assertEquals(customlurl, "https://opensource-demo.orangehrmlive.com/index.php/pim/listCustomFields", "Custom field name is not added");
	  	  
	  sf.assertAll();
  }
  
  
  @Test(priority=3)
  public void verifyCustomFieldAddAndCancel() {
	  
	  customfield.customFieldPageNav();
	  customfield.definepageHeaderDisplay();
	  sf.assertEquals(customfield.definepageHeaderDisplay(), true, "definedCustomFields_pageHeaderis missing");
	  customfield.cancelField();
	  String customlurl=driver.getCurrentUrl();
	  sf.assertEquals(customlurl, "https://opensource-demo.orangehrmlive.com/index.php/pim/listCustomFields", "Custom field name is not cancelled");
	  	  
	  sf.assertAll();
  }
  
  
  @Test(priority=4)
  public void verifyEditCustomFieldAndSave() {
	  

	  customfield.addField();
	  
	  String sortDescurl=driver.getCurrentUrl();
	  String expected="https://opensource-demo.orangehrmlive.com/index.php/pim/listCustomFields";
	  
	  customfield.editCustomFieldActionSave();
	  customfield.addCustompageHeaderDisplay();	 
	  
	  sf.assertEquals(sortDescurl, expected, "Save failed");

	  sf.assertAll();
	  
	  
  }
  @Test(priority=5)
  public void verifyEditCustomFieldAndCancel() {
	 
	  customfield.customFieldPageNav();
	  
	  customfield.editCustomFieldActionCancel();
	  
	  
	  String sortDescurl=driver.getCurrentUrl();
	  String expected="https://opensource-demo.orangehrmlive.com/index.php/pim/listCustomFields/sort/name/order/DESC#";
	  sf.assertEquals(sortDescurl, expected, "Cancel failed");
	  sf.assertAll();
  }
  
  @Test(priority=6)
  public void verifyDeleteCustomersAndAdd() {
	 
	  customfield.customFieldPageNav();
	  
	  customfield.editCustomFieldActionCancel();
	  customfield.deleteAll();
	  
	  String deleteNavUrl=driver.getCurrentUrl();
	  String expected="https://opensource-demo.orangehrmlive.com/index.php/pim/listCustomFields";
	  sf.assertEquals(deleteNavUrl, expected, "delete all failed");
	  customfield.saveCustomField();
	  sf.assertAll();
	  
  }
  
  
}
