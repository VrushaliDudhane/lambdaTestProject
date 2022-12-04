package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.TimeOutsProvider;


public class BaseClass {
	
	public Properties prop;
	
	FileInputStream ip;
	
//	public String username = "vrushaliyadav";
//    public String accesskey = "uDO9mrV48ifoqXBCU8zMrkQoWe5wD4xxgzXPgs0x5noVzPGUxD";
//    public static RemoteWebDriver driver = null;
//    public String gridURL = "@hub.lambdatest.com/wd/hub";
//    boolean status = false;
	
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
		//DesiredCapabilities capabilities = new DesiredCapabilities();
		if(browser.equalsIgnoreCase("chrome"))
		{
			 WebDriverManager.chromedriver().setup();
			 ChromeOptions options=new ChromeOptions();
			 //options.addArguments("window-size=1400,800");
			 options.addArguments("headless");
			 driver=new ChromeDriver(options);
			
//			ChromeOptions browserOptions = new ChromeOptions();
//			browserOptions.setPlatformName("Windows 10");
//			browserOptions.setBrowserVersion("106.0");
//			
//		//	browserOptions.addArguments("window-size=1400,800");
//		//	 browserOptions.addArguments("headless");
//			 
//			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//			ltOptions.put("username", "vrushaliyadav");
//			ltOptions.put("accessKey", "uDO9mrV48ifoqXBCU8zMrkQoWe5wD4xxgzXPgs0x5noVzPGUxD");
//			ltOptions.put("build", "ChromeTestSel4");
//			ltOptions.put("project", "FireFoxWindow10");
//			ltOptions.put("w3c", true);
//			browserOptions.setCapability("LT:Options", ltOptions);
//			
//			capabilities.merge(browserOptions);	
//			
			
			 
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			 WebDriverManager.firefoxdriver().setup();
			 FirefoxOptions options=new FirefoxOptions();
			 //options.addArguments("window-size=1400,800");
			 options.addArguments("headless");
			 driver=new FirefoxDriver(options);
			
//			FirefoxOptions browserOptions = new FirefoxOptions();
//			browserOptions.setPlatformName("Windows 10");
//			browserOptions.setBrowserVersion("107.0");
//			
////			browserOptions.addArguments("window-size=1400,800");
////			browserOptions.addArguments("headless");
//			 
//			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//			ltOptions.put("username", "vrushaliyadav");
//			ltOptions.put("accessKey", "uDO9mrV48ifoqXBCU8zMrkQoWe5wD4xxgzXPgs0x5noVzPGUxD");
//			ltOptions.put("build", "FireFoxTestSel4");
//			ltOptions.put("project", "FireFoxWindow10");
//			ltOptions.put("w3c", true);
//			browserOptions.setCapability("LT:Options", ltOptions);
//			capabilities.merge(browserOptions);	
			 
//		}
//		
//		 try {
//	            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
//	        } catch (MalformedURLException e) {
//	            System.out.println("Invalid grid URL");
//	        } catch (Exception e) {
//	            System.out.println(e.getMessage());
	        }
		// driver.manage().deleteAllCookies();
		// driver.manage().window().maximize();
//		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeOutsProvider.PAGETIMEOUT));
//		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeOutsProvider.IMPLICITETIMEOUT));
		driver.get(prop.getProperty("url"));
		 return driver;
	}
}
