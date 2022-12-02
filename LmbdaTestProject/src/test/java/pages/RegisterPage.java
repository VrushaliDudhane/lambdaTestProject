package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	private WebDriver driver;
	
	@FindBy(id="name")
	WebElement fullName;
	
	@FindBy(id="email")
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
	WebElement pleaseEnterYourEmail;
	
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
	
	public void registerTheUser(String[] data)
	{
		fullName.sendKeys(data[0]);
		businessEmail.sendKeys(data[1]);
		desiredPassword.sendKeys(data[2]);
		phone.sendKeys(data[3]);
		agreement.click();
		freeSignUp.click();
	}
	
	public String registerTheUserWithBlankFullName(String[] data)
	{
		
		businessEmail.sendKeys(data[1]);
		desiredPassword.sendKeys(data[2]);
		phone.sendKeys(data[3]);
		agreement.click();
		freeSignUp.click();
		 return pleaseEnterYourEmail.getText();
	}

}
