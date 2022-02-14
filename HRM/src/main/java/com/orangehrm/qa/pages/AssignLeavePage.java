package com.orangehrm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.qa.utilities.ElementUtil;

public class AssignLeavePage {


	WebDriver driver;
	Actions act;
	Select sel;
	JavascriptExecutor js;
	ElementUtil elementUtil;

	@FindBy(id = "menu_leave_viewLeaveModule")
	WebElement leaveTab;

	@FindBy(id  ="menu_leave_assignLeave")
	WebElement assignLeaveTab;

	@FindBy(xpath = "//h1[text()='Assign Leave']")
	WebElement assinLeave_pageHeader;

	@FindBy(id = "assignleave_txtEmployee_empName")
	WebElement empName;

	@FindBy(id = "assignleave_txtLeaveType")
	WebElement leaveType;

	@FindBy(id = "assignleave_leaveBalance")
	WebElement displayleaveBalance;

	@FindBy(id = "leaveBalance_details_link")
	WebElement viewDetailsLink;

	@FindBy(xpath = "//div[@id='balance_details']//div[@class='modal-footer']//input[@id='closeButton' and  @value='Ok']")
	WebElement leaveOk;

	@FindBy(id = "assignleave_txtFromDate")
	WebElement fromdate;

	@FindBy(id = "assignleave_txtToDate")
	WebElement toDate;

	@FindBy(id = "assignleave_duration_duration")
	WebElement durationDrpdwn;

	@FindBy(id = "assignleave_txtComment")
	WebElement commentBox;

	@FindBy(id = "assignBtn")
	WebElement assignBtn;

	public AssignLeavePage(WebDriver driver) {

		this.driver =driver;
		PageFactory.initElements(driver,this);
		elementUtil=new ElementUtil(driver);
		act=new Actions(driver);

	}

	public void assignPageNav() {
		
		
		elementUtil.mouseHover(leaveTab);
		elementUtil.mouseHover(assignLeaveTab);
		elementUtil.click(assignLeaveTab);
	}

	public void assignLeaveDetail(String employee_name,String from_date,String to_date,String leave_comment) {


		elementUtil.sendKeys(empName, employee_name);
		elementUtil.selectDropdown(leaveType, "index", "1");
	
		elementUtil.sendKeys(fromdate, from_date);
//		elementUtil.dateSelect(toDate,to_date);
		elementUtil.sendKeys(toDate, to_date);
		elementUtil.selectDropdown(durationDrpdwn, "index", "0");
		elementUtil.sendKeys(commentBox, leave_comment);
		elementUtil.click(empName);
		elementUtil.click(assignBtn);
	}


	public boolean checkAssignTabEnabled() {

		boolean assignTab=elementUtil.enableCheck(assignLeaveTab);
		return assignTab;	

	}

	public boolean checkVeiwLinkDisplay() {

		boolean viewLink=elementUtil.displayCheck(viewDetailsLink);
		return viewLink;	

	}
	

	public boolean checkAssignBtnEnable() {

		boolean assignbtn=elementUtil.displayCheck(assignBtn);
		return assignbtn;	

	}
}
