package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPage {
	private WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"header\"]/nav/div/div/div[2]/div/div/div[2]/a[2]")
	WebElement signUp;

	public FirstPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public RegisterPage clickOnSignUp()
	{
		signUp.click();
		return new RegisterPage(driver);
	}
	

}
