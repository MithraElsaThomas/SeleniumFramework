package com.orangehrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.qa.utilities.ElementUtil;

public class EditUserPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	Actions act;
	Select sel;
	
	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement admin1Tab;
	
	@FindBy(id  ="menu_admin_UserManagement")
	WebElement userMangementDropdwn;
	
	@FindBy(id  ="menu_admin_viewSystemUsers")
	WebElement users;
	
	@FindBy(id  ="ohrmList_chkSelectRecord_10")
	WebElement usernameCheckBox;
	
	@FindBy(xpath ="//table[@id='resultTable']//tbody//td//a")
	WebElement userNameLink;
	
	@FindBy(id ="systemUser_userType")
	WebElement selectUserRole;
	

	@FindBy(id ="systemUser_employeeName_empName")
	WebElement employeeName;

	@FindBy(id ="systemUser_userName")
	WebElement userName;

	@FindBy(id ="systemUser_status")
	WebElement status;
	

	@FindBy(id ="btnSave")
	WebElement editBtn;
	
	@FindBy(id ="UserHeading")
	WebElement editUser_header;
	
	@FindBy(xpath ="//li[@class='checkChangePassword']//input[@id='systemUser_chkChangePassword']")
	WebElement changePwod_Checkbox;
	
	@FindBy(id = "systemUser_password")
	WebElement password;

	@FindBy(id = "systemUser_confirmPassword")
	WebElement confirmPassword;

	@FindBy(id = "btnSave")
	WebElement saveUser;
	
	@FindBy(id = "btnCancel")
	WebElement cancelBtn;
	
public EditUserPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
	elementUtil=new ElementUtil(driver);
	act=new Actions(driver);
		
}


public void tabAdmin() {
	

	elementUtil.mouseHover(admin1Tab);
	elementUtil.mouseHover(userMangementDropdwn);
	elementUtil.mouseHover(users);
	
	elementUtil.click(users);


	elementUtil.click(userNameLink);
	
	elementUtil.click(editBtn);
}

public boolean checkUserNameEnabled() {
	
	return elementUtil.enableCheck(usernameCheckBox);
}




public void editUserDataAction(String usern,String passwrd,String confrim_pwd) {

	elementUtil.selectDropdown(selectUserRole, "index", "0");
	
	
	
	elementUtil.sendKeys(userName, usern);
	elementUtil.click(changePwod_Checkbox);
	elementUtil.sendKeys(password, passwrd);	
	elementUtil.sendKeys(confirmPassword, confrim_pwd);
	
	elementUtil.click(saveUser);
}




public boolean editUserPageHeader() {
	
	boolean edituserpage_header=elementUtil.displayCheck(editUser_header);
	return edituserpage_header;
}






}
