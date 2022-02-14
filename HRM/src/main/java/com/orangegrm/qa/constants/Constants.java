package com.orangegrm.qa.constants;

public class Constants {


	public static final int timeout=60;

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;

	public static final String pagetitle="OrangeHRM";
	public static final String testData="\\src\\test\\resources\\ExcelTestData\\OrangeSiteData.xlsx";

	public static final String propertyConfig_File=System.getProperty("user.dir")+"\\Configuration\\config.properties";
	public static final String logo="//img[@src='/webres_6051af48107ce6.31500353/themes/default/images/login/logo.png']";

	public static final String username="Admin";
	public static final String password="admin123";

	public static final String dataProvider_filepath=System.getProperty("user.dir")+testData;	
	public static final String file_importdatapath=System.getProperty("user.dir")+"\\src\\test\\resources\\ExcelTestData\\importData.csv";
	
	public static final String screenShot_path= System.getProperty("user.dir") + "\\Screenshots\\";
	public static final String deleteUser_url="https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";
}
