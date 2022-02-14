package com.orangehrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

public class AddUserPage {

	WebDriver driver;
	ElementUtil elemUtil;
	Select sel;
	WaitUtil waitUtil;

	@FindBy(id = "systemUser_userType")
	WebElement userRole;

	@FindBy(id  ="systemUser_employeeName_empName")
	WebElement employeeName;

	@FindBy(id = "systemUser_userName")
	WebElement userName;

	@FindBy(id = "systemUser_status")
	WebElement status;

	@FindBy(id = "systemUser_password")
	WebElement password;

	@FindBy(id = "systemUser_confirmPassword")
	WebElement confirmPassword;

	@FindBy(id = "btnSave")
	WebElement saveUser;

	@FindBy(id = "btnCancel")
	WebElement cancelBtn;

	@FindBy(xpath = "//input[@id='ohrmList_chkSelectAll' and @name='chkSelectAll']")
	WebElement selectAll;

	@FindBy(id = "btnDelete")
	WebElement deleteBtn;

	@FindBy(id = "dialogDeleteBtn")
	WebElement confirmDelete;

	@FindBy(xpath = "//table[@id='resultTable']//tbody//tr[@class='odd' or @class='even']")
	WebElement users_CheckBox;


	public AddUserPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
		elemUtil=new ElementUtil(driver);
		waitUtil=new WaitUtil(driver);
	}

	public void checkAddUserPageElements() {

		elemUtil.displayCheck(saveUser);
		elemUtil.displayCheck(cancelBtn);
	}

	public void addUserDeatils(String emp_name,String usr_name,String pword,String confrm_pwod) {

		elemUtil.click(userRole);
		elemUtil.selectDropdown(userRole, "index", "1");

		elemUtil.sendKeys(employeeName, emp_name);
		elemUtil.sendKeys(userName, usr_name);

		elemUtil.click(status);
		elemUtil.selectDropdown(status, "index", "1");

		elemUtil.sendKeys(password, pword);
		elemUtil.sendKeys(confirmPassword, confrm_pwod);

		elemUtil.click(saveUser);
		

	}

	public void deleteAllUsers() {
		
		waitUtil.waitForElementClick(selectAll);
		elemUtil.click(selectAll);
		elemUtil.click(deleteBtn);
		elemUtil.click(confirmDelete);

	}

	public boolean resultTableCheckboxEnabled() {

		boolean enableResultTable=elemUtil.enableCheck(users_CheckBox);
		return enableResultTable;
	}

	public boolean resultTableCheckboxDisplay() {


		boolean displayResultTable=elemUtil.displayCheck(users_CheckBox);
		return displayResultTable;
	}
}
