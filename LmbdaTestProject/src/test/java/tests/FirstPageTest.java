package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.FirstPage;


public class FirstPageTest extends BaseClass {

	private WebDriver driver;
	private FirstPage objFirstPage;
	public Logger logger=Logger.getLogger( FirstPageTest.class.getName());
	
	public FirstPageTest() {
		super();
		
	}
	
	@Parameters("Browser")
	@BeforeMethod
	void initFirstPage(String browser)
	{
		driver=initWebdriver(browser);
		objFirstPage=new FirstPage(driver);
		//driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	void test1()
	{
		objFirstPage.clickOnSignUp();
		System.out.println("SignUpPageOpened");
		logger.info("SignUp Page Opened");
	}
	
	

}
