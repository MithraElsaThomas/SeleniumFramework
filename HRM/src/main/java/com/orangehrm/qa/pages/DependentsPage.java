package com.orangehrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

public class DependentsPage {

	WebDriver driver;
	ElementUtil elementUtil;
	Actions act;
	WaitUtil waitUtil;

	@FindBy(xpath = "//h1[text()='Add Dependent']")
	WebElement addDep_pageHeader;

	@FindBy(id = "menu_pim_viewMyDetails")
	WebElement myInfoTab;

	@FindBy(xpath = "//ul[@id='sidenav']//li[4]//a")
	WebElement dependents_link;

	@FindBy(id = "btnAddDependent")
	WebElement addDepBtn;

	@FindBy(id = "dependent_name")
	WebElement dependent_name;

	@FindBy(id = "dependent_relationshipType")
	WebElement relationship;

	@FindBy(id = "dependent_relationship")
	WebElement specify_textbox;

	@FindBy(xpath = "//input[@id='dependent_dateOfBirth']")
	WebElement dob;

	@FindBy(id = "btnSaveDependent")
	WebElement saveDep_btn;	

	@FindBy(id = "btnSaveDependent")
	WebElement cancelEditDep_btn;

	@FindBy(xpath = "//h1[text()='Assigned Dependents']")
	WebElement assignedDep_pageHeader;

	@FindBy(xpath = "//td[@class='check']//input[@type='checkbox' and @value='1']")
	WebElement select_assignedDep;

	@FindBy(xpath = "//tr[@class='odd']//td[2]//a")
	WebElement nav_assignedep;

	@FindBy(xpath = "//h1[text()='Edit Dependent']")
	WebElement editDep_pageHeader;

	@FindBy(id = "checkAll")
	WebElement selectall_deps;

	@FindBy(id = "delDependentBtn")
	WebElement delete_depBtn;

	public DependentsPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtil=new ElementUtil(driver);
		waitUtil=new WaitUtil(driver);
	}


	public void AddDependentsPageNav(String dep_name,String Dob,String edit_name) {

		waitUtil.waitForElementClick(myInfoTab);
		elementUtil.click(myInfoTab);
		elementUtil.click(dependents_link);
		elementUtil.click(addDepBtn);
		elementUtil.sendKeys(dependent_name, dep_name);

		elementUtil.displayCheck(addDep_pageHeader);
		elementUtil.selectDropdown(relationship, "index", "1");
		//		elementUtil.dateSelect(dob,"Dob");
		elementUtil.sendKeys(dob, Dob);
		elementUtil.click(saveDep_btn);

	}


	public void cancelDependent() {

		elementUtil.click(dependents_link);
		elementUtil.click(select_assignedDep);
		elementUtil.click(nav_assignedep);
		elementUtil.click(cancelEditDep_btn);

		elementUtil.click(selectall_deps);
		elementUtil.click(delete_depBtn);
	}

	public void editDependent(String dep_name,String Dob,String editname) {
		elementUtil.click(dependents_link);
		elementUtil.click(select_assignedDep);
		elementUtil.click(nav_assignedep);
		elementUtil.sendKeys(dependent_name, editname);
		elementUtil.displayCheck(editDep_pageHeader);
		elementUtil.click(saveDep_btn);

	}

	public void checkPageheaderDisplay() {


		elementUtil.displayCheck(assignedDep_pageHeader);

	}

}
