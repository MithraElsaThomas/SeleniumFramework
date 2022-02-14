package com.orangehrm.qa.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangegrm.qa.constants.Constants;




public class WaitUtil {
	
	WebDriver driver;
	
	WebDriverWait wait;

	
	public WaitUtil(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	public void waitForPageTitle(String title) {
		
		 wait=new WebDriverWait(driver, Constants.timeout);
		wait.until(ExpectedConditions.titleIs(title));
			}

	public void waitForElementClick(WebElement  element) {
		wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
			}
	
	public void waitForElementVisibility(WebElement element) {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	
	}
	
	public void waitForElementvisibile(WebElement  element) {
		wait=new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
}