package tests;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import commons.DataProviderForRegistration;
import pages.FirstPage;
import pages.RegisterPage;

public class RegisterPageTest extends BaseClass {
	private WebDriver driver;
	private FirstPage objFirstPage;
	private RegisterPage objRegisterPage;
	public Logger logger=Logger.getLogger( RegisterPageTest.class.getName());
	
	public RegisterPageTest() {
		super();
	}
	
	@Parameters("Browser")
	@BeforeMethod
	void initRegisterPage(String browser)
	{
		driver=initWebdriver(browser);
		objFirstPage=new FirstPage(driver);
		objRegisterPage=objFirstPage.clickOnSignUp();	
		
	}

	@Test(enabled=false)
	void testFunction2()
	{
		boolean functionDisplayed=objRegisterPage.fullNameFieldDisplayed();
		if( functionDisplayed==true)
		{
			System.out.println( "Full Name field displayed ");
			logger.info("Full Name field displayed ");
		}
		else
		{
			System.out.println( "Full Name field not displayed ");
			logger.error("Full Name field not displayed ");
		}
	}
	
	@Test(enabled=false)
	void testFunction3()
	{
		boolean functionDisplayed=objRegisterPage.businessEmailFieldDisplayed();
	
		if( functionDisplayed==true)
		{
			System.out.println( "businessEmail field displayed: ");
			logger.info("businessEmail field displayed: ");
		}
		else
		{
			System.out.println( "businessEmail field not displayed: ");
			logger.error("businessEmail field not displayed");
		}
	
	}
	
	@Test(enabled=false)
	void testFunction4()
	{
		boolean functionDisplayed=objRegisterPage.desiredPasswordFieldDisplayed();
		
		if( functionDisplayed==true)
		{
			System.out.println( "Desired Password field displayed ");
			logger.info("Desired Password field displayed ");
		}
		else
		{
			System.out.println( "Desired Password field is not displayed: ");
			logger.error("Desired Password field is not displayed: ");
		}
		
	}
	
	@Test(enabled=false)
	void testFunction5()
	{
		boolean functionDisplayed=objRegisterPage.phoneFieldDisplayed();
		
		if( functionDisplayed==true)
		{
			System.out.println( "Phone number field displayed ");
			logger.info("Phone number field displayed ");
		}
		else
		{
			System.out.println( "Phone number field is not displayed: ");
			logger.error("Phone number field is not displayed: ");
		}
	}
	
	@Test(enabled=false)
	void testFunction6()
	{
		boolean functionDisplayed=objRegisterPage.agreementFieldDisplayed();
	
		if( functionDisplayed==true)
		{
			System.out.println( "Terms and Privacy Policy field displayed ");
			logger.info("Terms and Privacy Policy field displayed ");
		}
		else
		{
			System.out.println( "Terms and Privacy Policy field is not displayed: ");
			logger.error("Terms and Privacy Policy field is not displayed: ");
		}
	}
	
	@Test(enabled=false)
	void testFunction7()
	{
		boolean functionDisplayed=objRegisterPage.freeSignUpButtonDisplayed();
		
	
		if( functionDisplayed==true)
		{
			System.out.println( "Free Signup button displayed ");
			logger.info("Free Signup button displayed ");
		}
		else
		{
			System.out.println( "Free Signup button is not displayed: ");
			logger.error("Free Signup button is not displayed: ");
		}
	}
	
	@Test(dataProvider="RegistrationData",dataProviderClass=DataProviderForRegistration.class)
	public void providingValidRegistrationData(Row row)
	{
		String data[]=new String[row.getLastCellNum()];
		int i=0;
		Iterator<Cell> cellItr=row.cellIterator();
		while(cellItr.hasNext())
		{
			Cell cell=cellItr.next();
			switch(cell.getCellType())
			{
			case NUMERIC:
				 Integer val=(int) cell.getNumericCellValue();
					data[i]= val.toString();
					i++;
					break;
				 case STRING:
					 data[i]=cell.getStringCellValue();
					 i++;
					 break;
				 default:
					break;
			}
		}
		
		objRegisterPage.registerTheUser(data);
		
	}
	
	@Test(dataProvider="RegistrationData",dataProviderClass=DataProviderForRegistration.class)
	public void providingblankUserName(Row row)
	{
		String data[]=new String[row.getLastCellNum()];
		int i=0;
		Iterator<Cell> cellItr=row.cellIterator();
		while(cellItr.hasNext())
		{
			Cell cell=cellItr.next();
			switch(cell.getCellType())
			{
			case NUMERIC:
				 Integer val=(int) cell.getNumericCellValue();
					data[i]= val.toString();
					i++;
					break;
				 case STRING:
					 data[i]=cell.getStringCellValue();
					 i++;
					 break;
				 default:
					break;
			}
		}
		String desiredMessage="Please enter your name";
		String actualMessage=objRegisterPage.registerTheUserWithBlankFullName(data);
		Assert.assertEquals(actualMessage, desiredMessage);
		
	}
	
	@AfterMethod
	void tearDownRegisterPage()
	{
		//driver.quit();
	}
}
