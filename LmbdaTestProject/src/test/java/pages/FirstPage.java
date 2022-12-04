package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPage {
	private WebDriver driver;
	
	@FindBy(xpath="//div[@id=\"m_class\"]/following-sibling::*")
	             
	WebElement signUp;

	public FirstPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public RegisterPage clickOnSignUp()
	{
		//WebDriverWait wait=new WebDriverWait(driver,Duration.of)
		//signUp.click();
		//driver.findElement(By.xpath("//div[@id=\"m_class\"]/following-sibling::*")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement signOn=(WebElement)js.executeScript("return  document.querySelector(\"a[href='https://accounts.lambdatest.com/register']\")");
		signOn.click();
		return new RegisterPage(driver);
	}
	

}
