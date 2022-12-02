package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.TimeOutsProvider;


public class BaseClass {
	
	public Properties prop;
	
	FileInputStream ip;
	 WebDriver driver;
	public BaseClass()
	{
		prop=new Properties();
		try {
			ip=new FileInputStream("src\\test\\resources\\ConfigurationProperties\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebDriver initWebdriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			 WebDriverManager.chromedriver().setup();
			 ChromeOptions options=new ChromeOptions();
			 options.addArguments("window-size=1400,800");
			 options.addArguments("headless");
			 driver=new ChromeDriver();
			
			
			 
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			 WebDriverManager.firefoxdriver().setup();
//			 FirefoxOptions options=new FirefoxOptions();
//			 options.addArguments("window-size=1400,800");
//			 options.addArguments("headless");
			 driver=new FirefoxDriver();
			
			
			 
		}
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeOutsProvider.PAGETIMEOUT));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeOutsProvider.IMPLICITETIMEOUT));
		driver.get(prop.getProperty("url"));
		 return driver;
	}
}
