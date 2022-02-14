package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangegrm.qa.constants.Constants;
import com.orangehrm.qa.pages.DashBoardPage;

public class DashBoardPageTest extends BasePageTest{
	
	
	
  @Test(priority=1,groups = {"sanity"})
  public void verifyDashbBoardElementsDisplayAndLogin() {
	  
	  loginpage.loginAction(Constants.username, Constants.password);
	  
	  dashboard.DashBoardPageElements(driver);
	  dashboard.checkEnabledCase();
	  
	  String loginTitle=driver.getTitle();
	Assert.assertEquals(loginTitle,  Constants.pagetitle);
	
  }
  
  @Test(priority=2,groups = {"sanity"})
  public void verifyLogOutAction() {
	  
 
 dashboard.logoutAction();
	  
	  String logoutTitle=driver.getTitle();
	  Assert.assertEquals(logoutTitle,  Constants.pagetitle);
	
  }
  
}
