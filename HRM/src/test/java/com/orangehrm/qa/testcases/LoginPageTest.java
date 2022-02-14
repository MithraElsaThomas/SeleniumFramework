package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangegrm.qa.constants.Constants;
import com.orangehrm.qa.pages.LoginPage;


public class LoginPageTest extends BasePageTest{
	
	 
	
  @Test(priority=1,groups = "sanity")
  public void verifyLoginPageTest() {
	  
	  loginpage.loginAction(urname, pword);
	  
	  String loginTitle=driver.getTitle();
	  Assert.assertNotEquals(loginTitle,  Constants.pagetitle);
	  
	  
	  
  }
  
  
}
