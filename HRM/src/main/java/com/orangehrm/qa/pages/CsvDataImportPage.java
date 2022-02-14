package com.orangehrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangegrm.qa.constants.Constants;
import com.orangehrm.qa.utilities.ElementUtil;

public class CsvDataImportPage {

	WebDriver driver;
	ElementUtil elemUtil;
	Select sel;
	Actions act;
	
	@FindBy(id = "pimCsvImportHeading")
	WebElement pageHeader;
	
	@FindBy(id  ="menu_pim_viewPimModule")
	WebElement PIMTab;
	
	@FindBy(id  ="menu_pim_Configuration")
	WebElement configurationDropdwn;
	
	@FindBy(id  ="menu_admin_pimCsvImport")
	WebElement dataImportLink;

	@FindBy(id  ="pimCsvImport_csvFile")
	WebElement chooseFile1;

	@FindBy(id = "btnSave")
	WebElement uploadBtn;


	@FindBy(xpath ="//a[@class='download']")
	WebElement downloadLink;
	
	
	public CsvDataImportPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elemUtil=new ElementUtil(driver);
		act=new Actions(driver);
	}
	
	
	public void dataImportFile() {
		//mousehover		
		act.moveToElement(PIMTab).moveToElement(configurationDropdwn).moveToElement(dataImportLink).click().build().perform();
		
		elemUtil.displayCheck(pageHeader);
		elemUtil.sendKeys(chooseFile1, Constants.file_importdatapath);
		elemUtil.click(uploadBtn);
	}
	
	
	public void downloadFile() {
		
		//mousehover
		
		act.moveToElement(PIMTab).moveToElement(configurationDropdwn).moveToElement(dataImportLink).click().build().perform();
		
		elemUtil.displayCheck(pageHeader);
		elemUtil.checkDownload(downloadLink);
	}
}
