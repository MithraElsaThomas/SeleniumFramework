package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangegrm.qa.constants.Constants;

public class ConfigurePIMPageTest extends BasePageTest{



	@Test
	public void verifySetUp() {

		loginpage.loginAction(Constants.username, Constants.password);


		String loginTitle=driver.getTitle();
		Assert.assertEquals(loginTitle,  Constants.pagetitle);


	}

	@Test(priority=1)
	public void verifyConfigurePIMPageElementsTest() {

		pimconfigure.optionalFieldPageNav();
		pimconfigure.optionalFieldPageDisplay();

		sf.assertEquals(pimconfigure.optionalFieldPageDisplay(), true, "Configure PIM page header is missing");

		pimconfigure.checkBoxenabled();
		sf.assertEquals(pimconfigure.checkBoxenabled(),true, "check boxes are enabled");
		
		pimconfigure.countrySpecificInformationDisplay();
		sf.assertEquals(pimconfigure.countrySpecificInformationDisplay(), true, "Country Specific Information is missing");
		
		pimconfigure.showDeprecatedFieldsDisplay();	
		sf.assertEquals(pimconfigure.showDeprecatedFieldsDisplay(), true, "Show Deprecated Fields missing");
		sf.assertAll();
	}
	
	
	@Test(priority=2)
	public void verifyEditAllConfigurePIMPageTest() {
		
		pimconfigure.editAllConfigurePIM();
		pimconfigure.checkBoxenabled();
		sf.assertEquals(pimconfigure.checkBoxenabled(),true, "check boxes are enabled");
		sf.assertAll();
	}
	
	@Test(priority=3,enabled=false)
	public void verifyEditCountrySpecificOptionTest() {
		
		pimconfigure.editCountrySpecificInfo();
		pimconfigure.checkBoxenabled();
		sf.assertEquals(pimconfigure.checkBoxenabled(),true, "check boxes are enabled");
		sf.assertAll();
	}
	
	@Test(priority=4,enabled=false)
	public void verifyEditShowDeprecatedOptionTest() {
		
		pimconfigure.editShowDepricatedInfo();
		pimconfigure.checkBoxenabled();
		sf.assertEquals(pimconfigure.checkBoxenabled(),true, "check boxes are enabled");
		sf.assertAll();
	}
	
	@Test(priority=5)
	public void verifyEditShowAndCountryOptionTest() {
		
		pimconfigure.editShowandCountryInfo();
		pimconfigure.checkBoxenabled();
		sf.assertEquals(pimconfigure.checkBoxenabled(),true, "check boxes are enabled");
		sf.assertAll();
	}
}

