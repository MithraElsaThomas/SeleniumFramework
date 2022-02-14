package com.orangehrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

public class CustomFieldsPage {

	WebDriver driver;
	WaitUtil waitUtil;
	ElementUtil elementUtil;

	@FindBy(id  ="menu_pim_viewPimModule")
	WebElement PIMTab;

	@FindBy(id  ="menu_pim_Configuration")
	WebElement configurationDropdwn;

	@FindBy(id  ="menu_pim_listCustomFields")
	WebElement customeField;
	
	@FindBy(xpath = "//h1[text()='Add Custom Field']")
	WebElement addCustomFields_pageHeader;

	@FindBy(xpath = "//h1[text()='Defined Custom Fields']")
	WebElement definedCustomFields_pageHeader;

	@FindBy(id  ="buttonAdd")
	WebElement addBtn;

	@FindBy(id  ="buttonRemove")
	WebElement deleteBtn;

	@FindBy(xpath  ="//input[@id='customField_name' and @name='customField[name]']")
	WebElement fieldName;

	@FindBy(id  ="customField_screen")
	WebElement screenDrop;

	@FindBy(id  ="customField_type")
	WebElement typeDrop;

	@FindBy(xpath = "//input[@id='btnSave' and @value='Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//input[@id='btnCancel' and @value='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//table[@id='customFieldList']//thead//th[2]//a[text()='Custom Field Name']")
	WebElement sortDesc;

	@FindBy(xpath = "//table[@id='customFieldList']//tr[@class='odd']//td[2]//a")
	WebElement addedFeildName;

	@FindBy(xpath = "//h1[text()='Edit Custom Field']")
	WebElement editCustomField_pageHeader;



	@FindBy(id  ="allCheck")
	WebElement checkAll;	

	@FindBy(id  ="dialogDeleteBtn")
	WebElement ConfirmDelete;
	
	
	public CustomFieldsPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtil=new ElementUtil(driver);
		waitUtil=new WaitUtil(driver);

	}

	public void customFieldPageNav() {		

		elementUtil.mouseHover(PIMTab);
		elementUtil.mouseHover(configurationDropdwn);
		elementUtil.mouseHover(customeField);
		elementUtil.click(customeField);
	}
	
	public boolean addCustompageHeaderDisplay() {

		boolean addcustomPageheader=elementUtil.displayCheck(addCustomFields_pageHeader);
		return addcustomPageheader;
	}

	public boolean definepageHeaderDisplay() {

		boolean header=elementUtil.displayCheck(definedCustomFields_pageHeader);
		return header;
	}
	
	public void saveCustomField() {
		
		waitUtil.waitForElementvisibile(fieldName);
		elementUtil.sendKeys(fieldName, "Sample one");
		elementUtil.click(screenDrop);
		elementUtil.selectDropdown(screenDrop, "index", "1");
		elementUtil.click(typeDrop);
		elementUtil.selectDropdown(typeDrop, "index", "1");
		elementUtil.click(saveBtn);
		
	}

	public void addField() {
		
		waitUtil.waitForElementClick(addBtn);
		elementUtil.click(addBtn);
		
		waitUtil.waitForElementvisibile(fieldName);
		elementUtil.sendKeys(fieldName, "Sample one");
		elementUtil.click(screenDrop);
		elementUtil.selectDropdown(screenDrop, "index", "1");
		elementUtil.click(typeDrop);
		waitUtil.waitForElementvisibile(typeDrop);
		elementUtil.selectDropdown(typeDrop, "index", "1");
		elementUtil.click(saveBtn);
	}

	public void cancelField() {
		
		waitUtil.waitForElementClick(addBtn);
		elementUtil.click(addBtn);
		elementUtil.sendKeys(fieldName, "Sample one");
		waitUtil.waitForElementvisibile(screenDrop);
		elementUtil.selectDropdown(screenDrop, "index", "2");
		elementUtil.click(typeDrop);
		elementUtil.selectDropdown(typeDrop, "index", "1");
		elementUtil.click(cancelBtn);
	}

	public boolean checkAddedField() {		

		boolean fieldnameDisplayed=elementUtil.displayCheck(addedFeildName);
		return fieldnameDisplayed;
	}

	public void editCustomFieldActionSave() {
		
		waitUtil.waitForElementClick(sortDesc);
		elementUtil.click(sortDesc);
		elementUtil.click(addedFeildName);
		elementUtil.sendKeys(fieldName, "Sample edited");
		elementUtil.click(saveBtn);
	}

	public void editCustomFieldActionCancel() {
		
		
		elementUtil.click(sortDesc);
		elementUtil.click(addedFeildName);
		elementUtil.sendKeys(fieldName, "Sample edited");
		elementUtil.click(cancelBtn);
	}
	
	public void deleteAll() {
		
		elementUtil.click(checkAll);
		elementUtil.click(deleteBtn);
		elementUtil.click(ConfirmDelete);
	}
}
