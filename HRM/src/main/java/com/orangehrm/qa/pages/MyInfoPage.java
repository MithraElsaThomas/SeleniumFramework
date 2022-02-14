package com.orangehrm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangegrm.qa.constants.Constants;
import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

public class MyInfoPage {


	WebDriver driver;
	ElementUtil elementUtil;
	Select sel;
	JavascriptExecutor js;
	Actions act;
	WaitUtil waitUtil;

	@FindBy(id = "menu_pim_viewMyDetails")
	WebElement myInfoTab;

	@FindBy(xpath = "//h1[text()='Personal Details']")
	WebElement myInfo_pageHeader;

	@FindBy(id = "profile-pic")
	WebElement profilePic;

	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	WebElement profile_name;

	@FindBy(xpath = "//li[@class='selected']//a")
	WebElement sideNav;

	@FindBy(xpath = "//input[@id='btnSave' and @value='Edit']")
	WebElement editBtn;

	@FindBy(xpath = "//input[@id='btnSave' and @value='Save']")
	WebElement savebtn_personal;

	@FindBy(xpath = "//input[@id='btnEditCustom' and @value='Edit']")
	WebElement edit_CustomBtn;

	@FindBy(xpath = "//input[@id='btnEditCustom' and @value='Save']")
	WebElement customSaveBtn;

	@FindBy(id = "personal_txtEmpFirstName")
	WebElement FullName;

	@FindBy(id = "personal_txtEmpLastName")
	WebElement lastName;

	@FindBy(id = "personal_txtEmployeeId")
	WebElement empId;

	@FindBy(id = "personal_txtOtherID")
	WebElement otherId;

	@FindBy(id = "personal_txtLicenNo")
	WebElement licenseNum;

	@FindBy(id = "personal_txtLicExpDate")
	WebElement licenseExdate;

	@FindBy(name = "custom1")
	WebElement customDropDown;

	@FindBy(xpath = "//h1[text()='Attachments']")
	WebElement attachments_Header;

	@FindBy(id = "btnAddAttachment")
	WebElement addAttachmnetbtn;

	@FindBy(id = "ufile")
	WebElement choose_Attchment;

	@FindBy(id = "txtAttDesc")
	WebElement addComment;

	@FindBy(id = "btnSaveAttachment")
	WebElement upload_Attachment;

	@FindBy(xpath = "//table[@id='tblAttachments']//tbody//tr//child::td[8]//a")
	WebElement edit_Attachment;

	@FindBy(id = "cancelButton")
	WebElement edit_cancel;

	@FindBy(id = "btnDeleteAttachment")
	WebElement delete_attachment;
	
	@FindBy(id = "attachmentsCheckAll")
	WebElement selct_allAttachment;

	public MyInfoPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtil=new ElementUtil(driver);
		act=new Actions(driver);
		waitUtil=new WaitUtil(driver);
	}
	
	public void myInfoTabNav() {
		
		
		elementUtil.click(myInfoTab);
		elementUtil.scrollIntoView(editBtn);
		elementUtil.click(editBtn);
		
		
	}

	public void enterMyInfoPersonalDetails(String full_name,String Last_name,String Emp_id,
			String other_id,String license_num)  {
		
		elementUtil.sendKeys(FullName, full_name);
		elementUtil.sendKeys(lastName, Last_name);
		elementUtil.sendKeys(empId, Emp_id);
		elementUtil.sendKeys(otherId, other_id);
		elementUtil.sendKeys(licenseNum, license_num);
		elementUtil.sendKeys(FullName, "a"+full_name);
		elementUtil.click(savebtn_personal);
	}

	public void editCustomeFieldsData(){
		
		waitUtil.waitForElementVisibility(edit_CustomBtn);
		elementUtil.click(edit_CustomBtn);
		elementUtil.click(customDropDown);
		
		elementUtil.sendKeys(customDropDown, "sample");
		
		elementUtil.click(customSaveBtn);
	}

	
	
	
	public boolean myInfoAttachmentsDisplay() {

		boolean attach=elementUtil.displayCheck(attachments_Header);
		return attach;
	}

	public void myInfoAddAttachments() {
		elementUtil.scrollBottom(addAttachmnetbtn);
		elementUtil.click(addAttachmnetbtn);
		elementUtil.sendKeys(choose_Attchment, Constants.dataProvider_filepath);
		elementUtil.sendKeys(addComment, "attachment");	
		elementUtil.click(upload_Attachment);

	}
	public void myInfoEditAttachments()  {
		elementUtil.scrollIntoView(edit_Attachment);
		waitUtil.waitForElementClick(edit_Attachment);
	
		elementUtil.click(edit_Attachment);
		elementUtil.click(edit_cancel);

	}

	public void myInfoDeleteAttachments(){
		elementUtil.click(selct_allAttachment);
		elementUtil.click(delete_attachment);
		
		
	}

	public boolean checkEnabled() {

		boolean sideMenu=elementUtil.enableCheck(sideNav);
		System.out.println(sideMenu);
		return sideMenu;

	}
	
	public boolean customDropEnabled() {
		
		boolean dropdownenabled=elementUtil.enableCheck(customDropDown);
		return dropdownenabled;
	}

}
