package com.orangehrm.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

public class AdminPage {

	WebDriver driver;
	ElementUtil elementUtil;
	Select sel;
	WaitUtil waitUtil;

	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement adminTab;

	@FindBy(xpath  ="//a[@class='toggle tiptip']")
	WebElement systemUsersToggle;

	@FindBy(xpath = "//a[@class='toggle tiptip activated']")
	WebElement sysToggleActive;

	@FindBy(id = "btnAdd")
	WebElement addBtn;

	@FindBy(id = "btnDelete")
	WebElement deleteBtn;

	@FindBy(id = "searchSystemUser_userType")
	WebElement userRoleDropdown;

	@FindBy(id = "searchSystemUser_status")
	WebElement statusDropdown;

	@FindBy(id = "searchBtn")
	WebElement searchBtn;

	@FindBy(xpath ="//table[@id='resultTable']//thead//th//child::input")
	WebElement checkAllUser;

	@FindBy(id ="dialogDeleteBtn")
	WebElement okDeleteBtn;


	public AdminPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtil=new ElementUtil(driver);
		waitUtil=new WaitUtil(driver);

	}

	public void adminTabElements() {

		elementUtil.click(adminTab);

		elementUtil.enableCheck(adminTab);
		elementUtil.displayCheck(systemUsersToggle);
		elementUtil.displayCheck(addBtn);
		elementUtil.displayCheck(deleteBtn);

	}

	public void systemUsersAction() {

		elementUtil.enableCheck(systemUsersToggle);
		elementUtil.selectDropdown(userRoleDropdown, "index", "1");
		elementUtil.selectDropdown(statusDropdown, "index", "1");

		elementUtil.click(searchBtn);	
		elementUtil.click(systemUsersToggle);

	}
	public void deleteUser() throws InterruptedException {

		waitUtil.waitForElementClick(checkAllUser);
		elementUtil.click(checkAllUser);
		elementUtil.click(deleteBtn);
		elementUtil.click(okDeleteBtn);

	}
	public void addUser() {
		elementUtil.click(adminTab);
		elementUtil.click(addBtn);

	}
}
