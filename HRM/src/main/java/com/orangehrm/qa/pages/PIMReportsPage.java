package com.orangehrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

public class PIMReportsPage {

	WebDriver driver;
	WaitUtil waitUtil;
	ElementUtil elementUtil;

	@FindBy(id  ="menu_pim_viewPimModule")
	WebElement PIMTab;

	@FindBy(id  ="menu_core_viewDefinedPredefinedReports")
	WebElement reportsTab;

	@FindBy(id  ="btnAdd")
	WebElement addBtn;

	@FindBy(xpath  ="//h1[text()='Define Report']")
	WebElement defineReportsPage;

	@FindBy(id  ="report_report_name")
	WebElement reportName;

	@FindBy(id  ="report_criteria_list")
	WebElement selectionCriteria;

	@FindBy(id  ="report_include_comparision")
	WebElement selectedCriteriaInclude;

	@FindBy(id  ="report_display_groups")
	WebElement displayFieldGroupsDropdwn;

	@FindBy(id  ="btnAddDisplayGroup")
	WebElement addBtn_displayFieldGroupsDropdwn;

	@FindBy(id  ="display_group_1")
	WebElement checkBox_displayGroup1;

	@FindBy(xpath = "//input[@id='btnSave' and @value='Save']")
	WebElement saveBtn;

	@FindBy(id  ="btnDelete")
	WebElement deleteBtn;

	@FindBy(id  ="btnAddDisplayField")
	WebElement displayFieldAdd;

	@FindBy(xpath  ="//input[@id='ohrmList_chkSelectAll' and @name='chkSelectAll']")
	WebElement allReports;

	@FindBy(xpath  ="//table[@id='resultTable']//thead//tr//th[2]//a")
	WebElement sortReports;

	@FindBy(xpath  ="//table[@id='resultTable']//td[3]/a")
	WebElement runLink;

	@FindBy(xpath = "//h1[text()='Report Name : Report demo']")
	WebElement reportDemo_pageHeader;

	@FindBy(xpath = "//table[@id='resultTable']//tbody//tr[@class='odd' or @class='even']")
	WebElement report_CheckBox;

	@FindBy(xpath = "//input[@id='ohrmList_chkSelectAll' and  @name='chkSelectAll']")
	WebElement selectAll;
	
	@FindBy(xpath = "//table[@id='resultTable']//tbody//tr[1]//td[4]//a[1]")
	WebElement editLink;

	@FindBy(id = "dialogDeleteBtn")
	WebElement confirmDelete;
	

	@FindBy(xpath = "//table[@id='resultTable']//tbody//td[text()='No Records Found']")
	WebElement noRecordsFound;

	public PIMReportsPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtil=new ElementUtil(driver);
		waitUtil=new WaitUtil(driver);

	}


	public void reportsPageNav() {		

		elementUtil.mouseHover(PIMTab);
		elementUtil.click(reportsTab);
	}

	public void addReport(String report_name) {

		elementUtil.click(addBtn);
		elementUtil.sendKeys(reportName, report_name);
		elementUtil.selectDropdown(selectionCriteria, "index", "1");
		elementUtil.click(displayFieldAdd);
		elementUtil.click(saveBtn);
	}

	public void customReports() {

		elementUtil.doubleClick(sortReports);
	}
	public void runReports() {
		
		elementUtil.doubleClick(sortReports);
		elementUtil.click(runLink);
		elementUtil.navigateBack();
		
	}
	public void deleteAllUsers() {

		waitUtil.waitForElementClick(selectAll);
		elementUtil.click(selectAll);
		elementUtil.click(deleteBtn);
		elementUtil.click(confirmDelete);

	}
	
	public void editReports() {
		
		elementUtil.click(editLink);
		elementUtil.sendKeys(reportName, "edited");
		waitUtil.waitForElementvisibile(defineReportsPage);
		elementUtil.click(saveBtn);
	}
	
	
	public boolean checkNoRecordsAfterDeleteall() {

		boolean enableResultTable=elementUtil.enableCheck(noRecordsFound);
		return enableResultTable;
	}

	
}
