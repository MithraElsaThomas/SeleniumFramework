package com.orangehrm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

public class ConfigurePIMPage {

	WebDriver driver;
	WaitUtil waitUtil;
	ElementUtil elementUtil;
	Select sel;

	@FindBy(id  ="menu_pim_viewPimModule")
	WebElement PIMTab;

	@FindBy(id  ="menu_pim_Configuration")
	WebElement configurationDropdwn;

	@FindBy(id  ="menu_pim_configurePim")
	WebElement optional_field;
	
	@FindBy(xpath = "//h1[text()='Configure PIM']")
	WebElement configurePIM_pageHeader;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement checkBox_enabled;
	
	@FindBy(xpath = "//h2[text()='Show Deprecated Fields']")
	WebElement showDeprecated_fields;
	
	@FindBy(xpath = "//h2[text()='Country Specific Information']")
	WebElement countrySpecific_information;
	
	@FindBy(xpath = "//input[@id='btnSave' and @value='Edit']")
	WebElement editBtn;
	
	@FindBy(id  ="configPim_chkDeprecateFields")
	WebElement showDeprecated_checkbox;

	@FindBy(id  ="configPim_chkShowSIN")
	WebElement sin_checkBox;
	
	@FindBy(id  ="configPim_chkShowSSN")
	WebElement ssn_checkBox;
	
	@FindBy(id  ="configPim_chkShowTax")
	WebElement usTax_checkBox;
	
	@FindBy(xpath = "//input[@type='checkbox' and @checked='checked']")
	List<WebElement> countrySpecific_info;
	
	@FindBy(xpath = "//input[@id='btnSave' and @value='Save']")
	WebElement saveBtn;
	
	public ConfigurePIMPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);
		waitUtil=new WaitUtil(driver);
		elementUtil=new ElementUtil(driver);


	}

	public void optionalFieldPageNav() {

		elementUtil.mouseHover(PIMTab);
		elementUtil.mouseHover(configurationDropdwn);
		elementUtil.mouseHover(optional_field);
		elementUtil.click(optional_field);
				
	}

	public boolean optionalFieldPageDisplay() {

		boolean displayed=elementUtil.displayCheck(configurePIM_pageHeader);
		return displayed;
	}
	
	public boolean showDeprecatedFieldsDisplay() {

		boolean displayed=elementUtil.displayCheck(showDeprecated_fields);
		return displayed;
	}
	
	public boolean countrySpecificInformationDisplay() {

		boolean displayed=elementUtil.displayCheck(countrySpecific_information);
		return displayed;
	}
	
	public boolean checkBoxenabled() {

		boolean checkbox_enabled=elementUtil.displayCheck(checkBox_enabled);
		return checkbox_enabled;
	}
	
	
	public void editAllConfigurePIM() {
		
		elementUtil.click(editBtn);
		elementUtil.clickCheckbox(countrySpecific_info);
		elementUtil.click(saveBtn);
		
		
	}
	
public void editCountrySpecificInfo() {
		
		elementUtil.click(editBtn);
		elementUtil.click(ssn_checkBox);
		elementUtil.click(saveBtn);
		
	}

public void editShowDepricatedInfo() {
	
	elementUtil.click(editBtn);
	elementUtil.click(showDeprecated_checkbox);
	elementUtil.click(saveBtn);
		
}


public void editShowandCountryInfo() {
	
	elementUtil.click(editBtn);
	elementUtil.click(showDeprecated_checkbox);
	elementUtil.click(ssn_checkBox);
	elementUtil.click(saveBtn);
	
	
}
}
