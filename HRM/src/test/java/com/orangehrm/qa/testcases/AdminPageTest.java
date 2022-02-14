package com.orangehrm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangegrm.qa.constants.Constants;

public class AdminPageTest extends BasePageTest {


	@Test(priority=1,groups= {"sanity","regression"})
	public void verifySetUp() {

		loginpage.loginAction(Constants.username, Constants.password);    
		String loginTitle=driver.getTitle();
		Assert.assertEquals(loginTitle,  Constants.pagetitle);
	}

	@Test(priority=2,groups= {"sanity","regression"})
	public void verifyAdminPageAction() {

		admin.adminTabElements();
        admin.systemUsersAction();
		String adminPageTitle=driver.getTitle();
		Assert.assertEquals(adminPageTitle, Constants.pagetitle);
		admin.addUser();
	}



	@Test(priority=3,groups= {"sanity","regression"})
	public void verifyAdminPageAddUser() {

		admin.adminTabElements();

		String adminPageTitle=driver.getTitle();
		Assert.assertEquals(adminPageTitle, Constants.pagetitle);

		admin.addUser();

		String addUserHeader=driver.findElement(By.xpath("//h1[@id='UserHeading']")).getText();
		Assert.assertEquals(addUserHeader, "Add User");

	}

	@Test(priority=4,groups= {"sanity","regression"})
	public void verifyAdminDeleteUser() throws InterruptedException {  

		admin.adminTabElements();
		
			admin.deleteUser();
		
		String actualDeleteUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualDeleteUrl, Constants.deleteUser_url);


	}


}
