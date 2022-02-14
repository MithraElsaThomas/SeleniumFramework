package com.orangehrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;

public class LoginPage {

	WebDriver driver;
	ElementUtil elementUtil;
	WaitUtil waitUtil;

	@FindBy(xpath = "//img[@src=\"/webres_61eea9f1357e52.82110479/themes/default/images/login/logo.png\"]")
	WebElement logo;

	@FindBy(id="txtUsername")
	WebElement username;

	@FindBy(id="txtPassword")
	private WebElement password;

	@FindBy(id="btnLogin")
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this );
		elementUtil=new ElementUtil();
		waitUtil=new WaitUtil(driver);
	}


	public void loginAction(String urname,String pword) {

		//elementUtil.displayCheck(logo);
		elementUtil.sendKeys(username, urname);
		elementUtil.sendKeys(password, pword);
		waitUtil.waitForElementClick(loginBtn);
		elementUtil.click(loginBtn);
		

	



	}
}
