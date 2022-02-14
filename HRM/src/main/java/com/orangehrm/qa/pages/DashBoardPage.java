package com.orangehrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;



public class DashBoardPage {

	WebDriver Driver;
	ElementUtil elemutil;
	WaitUtil waitUtil;

	@FindBy(xpath = "//h1[text()='Dashboard']")
	WebElement dashbard_pageHeader;

	@FindBy(id="menu_dashboard_index")
	WebElement dashBoardTab;

	@FindBy(xpath = "//span[@class='quickLinkText' and text()='Assign Leave']")
	WebElement assign_leave;

	@FindBy(xpath = "//span[@class='quickLinkText' and text()='Leave List']")
	WebElement leaveList;

	@FindBy(xpath = "//span[@class='quickLinkText' and text()='Timesheets']")
	WebElement timesheets;

	@FindBy(xpath = "//span[@class='quickLinkText' and text()='Apply Leave']")
	WebElement ApplyLeave;

	@FindBy(xpath = "//span[@class='quickLinkText' and text()='My Leave']")
	WebElement myLeave;

	@FindBy(xpath = "//span[@class='quickLinkText' and text()='My Timesheet']")
	WebElement myTimesheet;

	@FindBy(xpath = "//legend[ text()='Employee Distribution by Subunit']")
	WebElement employeeDistrbutionBox;

	@FindBy(xpath = "//legend[ text()='Legend']")
	WebElement legendBox;

	@FindBy(xpath = "//legend[ text()='Pending Leave Requests']")
	WebElement pendingLeaveBox ;

	@FindBy(id = "welcome")
	WebElement welocome_Dropdown;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;


	public DashBoardPage(WebDriver driver) {

		this.Driver=driver;
		PageFactory.initElements(driver, this);
		elemutil=new ElementUtil(driver);
		waitUtil=new WaitUtil(driver);

	}


	public void DashBoardPageElements(WebDriver driver) {

		elemutil.displayCheck(dashbard_pageHeader);

		elemutil.enableCheck(dashBoardTab);
		elemutil.displayCheck(assign_leave);
		elemutil.displayCheck(leaveList);
		elemutil.displayCheck(timesheets);
		elemutil.displayCheck(ApplyLeave);
		elemutil.displayCheck(myLeave);
		elemutil.displayCheck(timesheets);
		elemutil.displayCheck(employeeDistrbutionBox);
		elemutil.displayCheck(legendBox);
		elemutil.displayCheck(pendingLeaveBox);
	}

	public void checkEnabledCase() {

		elemutil.enableCheck(dashBoardTab);
	}


	public void logoutAction() {


		elemutil.click(welocome_Dropdown);
		elemutil.mouseHover(logout);
		waitUtil.waitForElementClick(logout);
		elemutil.click(logout);

	}
}
