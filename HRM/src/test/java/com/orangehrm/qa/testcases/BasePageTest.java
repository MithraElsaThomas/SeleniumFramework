package com.orangehrm.qa.testcases;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.orangegrm.qa.constants.Constants;
import com.orangehrm.qa.listeners.ExtentReportManager;
import com.orangehrm.qa.pages.AddUserPage;
import com.orangehrm.qa.pages.AdminPage;
import com.orangehrm.qa.pages.AssignLeavePage;
import com.orangehrm.qa.pages.ConfigurePIMPage;
import com.orangehrm.qa.pages.CsvDataImportPage;
import com.orangehrm.qa.pages.CustomFieldsPage;
import com.orangehrm.qa.pages.DashBoardPage;
import com.orangehrm.qa.pages.DependentsPage;
import com.orangehrm.qa.pages.EditUserPage;
import com.orangehrm.qa.pages.LeaveEntitlementsPage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.MyInfoContactDetailsPage;
import com.orangehrm.qa.pages.MyInfoPage;
import com.orangehrm.qa.pages.PIMReportsPage;
import com.orangehrm.qa.utilities.ElementUtil;
import com.orangehrm.qa.utilities.WaitUtil;
import com.relevantcodes.extentreports.ExtentTest;



public class BasePageTest {

	public WebDriver driver;
	ElementUtil elementUtil=new ElementUtil();
	ExtentTest extentTest;
	WaitUtil wait;
	SoftAssert sf;
	public ExtentReportManager ob;
	public String baseUrl=elementUtil.getApplicationUrl();
	public String urname=elementUtil.getUserName();
	public String pword=elementUtil.getPassword(); 
	public LoginPage loginpage;
	public DashBoardPage dashboard;
	public AdminPage admin;
	public AddUserPage adduser;
	public CsvDataImportPage csvimport;
	public EditUserPage edituser;
	public AssignLeavePage assignleave;
	public MyInfoPage myinfo;
	public DependentsPage dependent;
	public MyInfoContactDetailsPage contactdetails;
	public LeaveEntitlementsPage leaveentitle;
	public ConfigurePIMPage pimconfigure;
	public CustomFieldsPage customfield;
	public PIMReportsPage pimreports;

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void setUp(String browsername) {

		String path=System.getProperty("user.dir");

		if(browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", path+ ElementUtil.getPropertyValue("chromepath"));
			driver=new ChromeDriver();
		}else if(browsername.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", path+ElementUtil.getPropertyValue("firefoxpath"));



			FirefoxOptions ff=new FirefoxOptions();
			ff.setAcceptInsecureCerts(true);
			driver=new FirefoxDriver(ff);

		}else if((browsername.equals("edge"))) {

			System.setProperty("webdriver.edge.driver",path+ ElementUtil.getPropertyValue("edgepath"));
			driver=new EdgeDriver();
		}		

		driver.manage().window().maximize();

		driver.get(baseUrl);
		sf=new SoftAssert();

		loginpage=new LoginPage(driver);
		dashboard=new DashBoardPage(driver);
		admin=new AdminPage(driver);
		adduser=new AddUserPage(driver);
		csvimport=new CsvDataImportPage(driver);
		edituser=new EditUserPage(driver);
		assignleave=new AssignLeavePage(driver);
		myinfo=new MyInfoPage(driver);
		dependent=new DependentsPage(driver);
		contactdetails=new MyInfoContactDetailsPage(driver);
		leaveentitle=new LeaveEntitlementsPage(driver);
		pimconfigure=new ConfigurePIMPage(driver);
		customfield=new CustomFieldsPage(driver);
		pimreports=new PIMReportsPage(driver);
		ob=new ExtentReportManager(driver);
		
	}



	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == iTestResult.FAILURE) {
			takeScreenShotOnFailure(iTestResult.getName());

		}
	}

	public String takeScreenShotOnFailure(String name) throws IOException {
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());


		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destination =Constants.screenShot_path + name + dateName + ".png";

		File finalDestination = new File(destination);

		FileUtils.copyFile(source, finalDestination);
		return destination;
	}


	@AfterClass

	public void tearDown() {

		driver.close();
	}










	//	@BeforeClass
	//	public void setUp() {
	//
	//		System.setProperty("webdriver.chrome.driver", elementUtil.getChromePath());
	//		driver=new ChromeDriver();
	//
	//		driver.manage().window().maximize();
	//		driver.manage().timeouts().implicitlyWait(WaitUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	//		driver.manage().timeouts().pageLoadTimeout(WaitUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	//		driver.get(baseUrl);
	//		loginpage=new LoginPage(driver);
	//
	//
	//
	//	}


}
