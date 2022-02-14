package com.orangehrm.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

public class LeaveEntitlementsPage {
	
	WebDriver driver;
	WaitUtil waitUtil;
	ElementUtil elementUtil;
	Alert al;
	@FindBy(id="menu_leave_viewLeaveModule")
	WebElement leaveTab;	

	@FindBy(id="menu_leave_Entitlements")
	WebElement entitlementdrop;
	
	@FindBy(id="menu_leave_addLeaveEntitlement")
	WebElement addEntitlementTab;
	
	@FindBy(xpath = "//h1[text()='Add Leave Entitlement']")
	WebElement addLeaveEntitlement_pageHeader;
	
	@FindBy(id="entitlements_employee_empName")
	WebElement employeeName;
	
	@FindBy(id="entitlements_leave_type")
	WebElement leave_type;
	
	@FindBy(id="period")
	WebElement leave_period;
	
	@FindBy(id="entitlements_entitlement")
	WebElement entitlement;
	
	@FindBy(xpath = "//input[@id='btnSave' and @value='Save']")
	WebElement savebtn_leave;
	
	@FindBy(xpath = "//input[@id='btnCancel' and @value='Cancel']")
	WebElement cancelbtn_leave;
	
	@FindBy(id="dialogUpdateEntitlementConfirmBtn")
	WebElement confirmbtn_SingleEmployee;
		
	@FindBy(id="entitlements_employee_empName")
	WebElement leaveSearchDisplay;
	
	@FindBy(id="entitlements_filters_bulk_assign")
	WebElement multipleCheckBox;
	
	@FindBy(id="entitlements_filters_location")
	WebElement locationDrop;
		
	@FindBy(id="entitlements_filters_subunit")
	WebElement subUnitDrop;
	
	@FindBy(id="dialogConfirmBtn")
	WebElement confirmbtn_Multiple;
	
	public LeaveEntitlementsPage(WebDriver driver) {
		
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitUtil=new WaitUtil(driver);
		elementUtil=new ElementUtil(driver);
	
		
	}
	
	public void addEntitlementNav() {
		
		elementUtil.mouseHover(leaveTab);		
		elementUtil.mouseHover(entitlementdrop);
		elementUtil.mouseHover(addEntitlementTab);
		waitUtil.waitForElementClick(addEntitlementTab);
		elementUtil.click(addEntitlementTab);
		
	}
	
	public void enterAddLeaveDetails(String employee,String entitle) throws InterruptedException {
		

		elementUtil.sendKeys(employeeName, employee);
		elementUtil.selectDropdown(leave_type, "index", "2");
		elementUtil.selectDropdown(leave_period, "index", "1");
		elementUtil.sendKeys(entitlement,entitle);
		elementUtil.sendKeys(employeeName, employee);
		elementUtil.scrollIntoView(savebtn_leave);
		elementUtil.click(savebtn_leave);
		
		waitUtil.waitForElementClick(confirmbtn_SingleEmployee);
		
		elementUtil.click(confirmbtn_SingleEmployee);
		
		
	}
	
	public void enterLeaveMultipleEmployees(String employee,String entitle) throws InterruptedException {
		
		elementUtil.click(multipleCheckBox);
		elementUtil.selectDropdown(locationDrop, "index", "6");
		elementUtil.selectDropdown(subUnitDrop, "index", "1");
		elementUtil.selectDropdown(leave_type, "index", "2");
		elementUtil.selectDropdown(leave_period, "index", "2");
		elementUtil.sendKeys(entitlement,entitle);
		elementUtil.click(savebtn_leave);	
		elementUtil.click(confirmbtn_Multiple);
	}
	
	public boolean pageheaderDisplayed() {
		
		boolean display_header=elementUtil.displayCheck(addLeaveEntitlement_pageHeader);
		return display_header;
	}
	
	public String leaveDisplay() {
		
		String employeeDisplay=elementUtil.displayCheckText(employeeName.getText());
		return employeeDisplay;
	}

}
