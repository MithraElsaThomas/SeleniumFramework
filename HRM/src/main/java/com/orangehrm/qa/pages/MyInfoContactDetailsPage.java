package com.orangehrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangegrm.qa.constants.Constants;
import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

public class MyInfoContactDetailsPage {
	
	
	WebDriver driver;
	WaitUtil waitUtil;
	ElementUtil elementUtil;
	Select sel;
	
	@FindBy(id = "menu_pim_viewMyDetails")
	WebElement myInfoTab;
	
	@FindBy(xpath = "//ul[@id='sidenav']//a[text()='Contact Details']")
	WebElement contactDetailsLink;
	
	@FindBy(xpath = "//h1[text()='Contact Details']")
	WebElement contactDetails_pageHeader;

	@FindBy(xpath = "//input[@id='btnSave' and @value='Edit']")
	WebElement editBtn;
	
	@FindBy(id = "contact_street1")
	WebElement adrress1;

	@FindBy(id = "contact_street2")
	WebElement address2;

	@FindBy(id = "contact_city")
	WebElement city;

	@FindBy(id = "contact_province")
	WebElement state;

	@FindBy(id = "contact_country")
	WebElement countyDropdown;

	@FindBy(id = "contact_emp_work_email")
	WebElement workEmail;
	
	@FindBy(id = "contact_emp_oth_email")
	WebElement otherEmail;

	@FindBy(xpath = "//input[@id='btnSave' and @value='Save']")
	WebElement savebtn_contact;
	
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

	@FindBy(xpath = "//table[@id='tblAttachments']//tbody//tr[1][@class='odd']//child::td[8]//a")
	WebElement edit_Attachment;

	@FindBy(id = "cancelButton")
	WebElement edit_cancel;

	@FindBy(id = "btnDeleteAttachment")
	WebElement delete_attachment;
	
	@FindBy(id = "attachmentsCheckAll")
	WebElement selct_allAttachment;
	
public MyInfoContactDetailsPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
	waitUtil=new WaitUtil(driver);
	elementUtil=new ElementUtil(driver);
	
	
}

public boolean pageHeaderDispay() {
	
	boolean contact=elementUtil.displayCheck(contactDetails_pageHeader);
	return contact;
}

public boolean contactDetailsLinkEnabled() {
	
	boolean contactLink=elementUtil.enableCheck(contactDetailsLink);
	return contactLink;
}

public void contactDetailsNav() {
	
	elementUtil.click(myInfoTab);
	waitUtil.waitForElementClick(contactDetailsLink);
	elementUtil.click(contactDetailsLink);
	elementUtil.scrollIntoView(editBtn);
	elementUtil.click(editBtn);
}

public void enterContactDeatils(String adress_street1,String Address2,String city_1,String state_1,String work_email,String other_email) {
	
	

	elementUtil.scrollIntoView(adrress1);
	elementUtil.sendKeys(adrress1, "adress_street1");
	elementUtil.sendKeys(address2, Address2);
	elementUtil.sendKeys(city, city_1);
	elementUtil.sendKeys(state, state_1);
	elementUtil.click(countyDropdown);
	elementUtil.selectDropdown(countyDropdown, "visibletext", "Andorra");
	elementUtil.sendKeys(workEmail, work_email);
	elementUtil.sendKeys(otherEmail, other_email);
	elementUtil.click(savebtn_contact);
	
	
}
public boolean contactAttachmentsDisplay() {

	boolean attach=elementUtil.displayCheck(attachments_Header);
	return attach;
}
public void contactAddAttachments() {

	elementUtil.click(addAttachmnetbtn);
	elementUtil.sendKeys(choose_Attchment, Constants.dataProvider_filepath);
	elementUtil.sendKeys(addComment, "attachment");	
	elementUtil.click(upload_Attachment);

}
public void contactEditAttachments() throws InterruptedException {

//	waitUtil.waitForElementVisibility(edit_Attachment);
//	waitUtil.waitForElementClick(edit_Attachment);
	elementUtil.click(edit_Attachment);
	elementUtil.click(edit_cancel);

}

public void contactDeleteAttachments() throws InterruptedException {
	elementUtil.click(selct_allAttachment);
	elementUtil.click(delete_attachment);
	
	
}

public boolean isAttachmentAdded() {
	
	boolean attachment=Constants.dataProvider_filepath.contains("OrangeSiteData.xlsx");
	return attachment;
}

}
