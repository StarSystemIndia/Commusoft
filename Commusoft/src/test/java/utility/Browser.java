package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {


	public static WebDriver startapp(WebDriver driver,String browsername, String appURL)
	{
	  if(browsername.equals("Chrome"))
		{
		//  System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		  driver = new ChromeDriver();
		 
		}
	  else if(browsername.equals("Firefox"))
		{
		  driver = new FirefoxDriver();
		}
	  else if(browsername.equals("IE"))
		{
		  driver = new InternetExplorerDriver();
		}else
		{
			System.out.println("Browser is Invalid");
		}
	  
	  driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(appURL);
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  return driver;

	}
	
	
	
	
	
}
