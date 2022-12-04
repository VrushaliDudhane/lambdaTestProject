package pages;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReadingXLS;

public class RegisterPage {
	private WebDriver driver;
	
	@FindBy(id="name")
	WebElement fullName;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement businessEmail;
	
	@FindBy(id="userpassword")
	WebElement desiredPassword;
	
	@FindBy(id="phone")
	WebElement phone;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/form/div[5]/label/samp")
	WebElement agreement;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/form/div[6]/button")
	WebElement freeSignUp;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/form/div[1]/p")
	WebElement pleaseEnterYourName;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/form/div[2]/p")
	WebElement pleaseEnterYourEmail;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div/form/div[2]/p")
	WebElement emailAlreadyRegistered;
	
	@FindBy(xpath="//p[@class='error-mass  text-red-80 xxxl:text-size-12 xxl:text-size-11 text-size-10 tracking-custom']")
	WebElement shortPassword;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/form/div[4]/div[2]/p")
	WebElement agreeTermsAndConditions;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/form/div[5]/label/div")
	WebElement enterYourPhone;
	
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public boolean fullNameFieldDisplayed()
	{
		return fullName.isDisplayed();
	}
	
	
	public boolean businessEmailFieldDisplayed()
	{
		return businessEmail.isDisplayed();
	}
	
	public boolean desiredPasswordFieldDisplayed()
	{
		return desiredPassword.isDisplayed();
	}
	
	public boolean phoneFieldDisplayed()
	{
		return phone.isDisplayed();
	}
	
	public boolean agreementFieldDisplayed()
	{
		return agreement.isDisplayed();
	}
	
	public boolean freeSignUpButtonDisplayed()
	{
		return freeSignUp.isDisplayed();
	}
	
	public String registerTheUser(Row row)
	{
		String data[]=ReadingXLS.readingXlsFile(row);
		fullName.sendKeys(data[0]);
		businessEmail.sendKeys(data[1]);
		desiredPassword.sendKeys(data[2]);
		phone.sendKeys(data[3]);
		agreement.click();
		freeSignUp.click();
		return driver.getCurrentUrl();
		
	}
	
	public String registerTheUserWithBlankFullName(Row row)
	{
		String data[]=ReadingXLS.readingXlsFile(row);
		businessEmail.sendKeys(data[1]);
		desiredPassword.sendKeys(data[2]);
		phone.sendKeys(data[3]);
		agreement.click();
		freeSignUp.click();
		 return pleaseEnterYourName.getText();
	}

	public String registerTheUserWithBlankEmail(Row row)
	{
		String data[]=ReadingXLS.readingXlsFile(row);
		fullName.sendKeys(data[0]);
		
	 desiredPassword.sendKeys(data[2]);
		phone.sendKeys(data[3]);
		agreement.click();
		freeSignUp.click();
		 return pleaseEnterYourEmail.getText();
	}
	
	public String registerTheUserExistingkEmail(Row row)
	{
		String data[]=ReadingXLS.readingXlsFile(row);
		fullName.sendKeys(data[0]);
		businessEmail.sendKeys(data[1]);
	    desiredPassword.sendKeys(data[2]);
		phone.sendKeys(data[3]);
		agreement.click();
		freeSignUp.click();
		 return emailAlreadyRegistered.getText();
	}
	
	public String registerTheUserWithShortPassword(Row row)
	{
		String data[]=ReadingXLS.readingXlsFile(row);
		fullName.sendKeys(data[0]);
		businessEmail.sendKeys(data[1]);
	    desiredPassword.sendKeys(data[2]);
		phone.sendKeys(data[3]);
		agreement.click();
		freeSignUp.click();
		 return shortPassword.getText();
	}

	public String registerTheUserWithBlankPassword(Row row) {
		String data[]=ReadingXLS.readingXlsFile(row);
		fullName.sendKeys(data[0]);
		businessEmail.sendKeys(data[1]);
	    desiredPassword.sendKeys(data[2]);
		agreement.click();
		freeSignUp.click();
		 return enterYourPhone.getText();
	}

	public String registerTheUserWithoutAcceptingTerms(Row row) {
		String data[]=ReadingXLS.readingXlsFile(row);
		fullName.sendKeys(data[0]);
		businessEmail.sendKeys(data[1]);
	    desiredPassword.sendKeys(data[2]);
		phone.sendKeys(data[3]);
		
		freeSignUp.click();
		 return agreeTermsAndConditions.getText();
	}

}
