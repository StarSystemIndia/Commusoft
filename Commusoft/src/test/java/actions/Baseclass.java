package actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.Browser;
import utility.ConfigDataprovider;
import utility.Excelreader;
import utility.Screenshot;

public class Baseclass {

    public 	Excelreader exl;
    public ConfigDataprovider config;
    public WebDriver driver; 
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setup()
	{
		exl = new Excelreader();
		config = new ConfigDataprovider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Reports/Smoke.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		logger = report.createTest("Smoke Test");
		
	}
	
	@BeforeClass
	public void startup()
	{
		driver = Browser.startapp(driver,config.getbrowser(),config.geturl());
	}
	
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, "Method Been Executed Sucessfully:-" +result.getName());
		}else 
			if(ITestResult.FAILURE==result.getStatus())
		{
				logger.log(Status.FAIL, "Method Been Failed:-" +result.getName());
		//		logger.log(Status.FAIL,logger.addScreenCaptureFromPath(Screenshot.capture(driver))+result.getName());
				logger.fail("Test Failed :- " +result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(Screenshot.capture(driver)).build());
				
			//	logger.log(Status.FAIL,logger.addScreenCaptureFromPath( capture(driver)) +"  Method Name:- " + result.getName());
			
		}else
		{
			logger.log(Status.SKIP, "Method been Skiped");
		}
		report.flush();
	}
	
	@AfterClass
	public  void endTest()
	{
	//	report.flush();
	}
	
	
	
	public void type(String xpath, String value)
	{
		{
			 if(xpath.contains("$"))
			 {
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).sendKeys(value);
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).sendKeys(value); 
			 }
			 else if(xpath.contains("~"))
			 {
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).sendKeys(value);
			 }
			 else
			 {
				 driver.findElement(By.xpath(xpath)).sendKeys(value);
			 }
	}
	}
	
	
	public void click(String option)
	{
		{
			 if(option.contains("$"))
			 {
				 option = option.replace("$", "");
				 driver.findElement(By.name(option)).click();
				 
			 }
			 else if(option.contains("#"))
			 {
				 option = option.replace("#", "");
				driver.findElement(By.id(option)).click(); 
			 }
			 else if(option.contains("~"))
			 {
				  option = option.replace("~", "");
				 driver.findElement(By.className(option)).click();
			 }
			 else
			 {
				 //option = option.replace("//", "");
				 driver.findElement(By.xpath(option)).click();
			 }
	}
	}
	
	
	
	
	
	
	public void clear(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 iwait();
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).clear();
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 iwait();
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).clear(); 
			 }
			 else if(xpath.contains("~"))
			 {
				 iwait();
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).clear();
			 }
			 else
			 {
				 iwait();
				 //xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).clear();
			 }
	}
	}
	
	
	public void selectdropdown(String xpath, String value)
	{
		iwait();
		Select fcc = new Select(driver.findElement(By.xpath(xpath)));
		fcc.selectByVisibleText(value);
		iwait();
	}
	public void selectdropdownvalue(String xpath, String value)
	{
		iwait();
		Select fcc = new Select(driver.findElement(By.xpath(xpath)));
		fcc.selectByValue(value);
		iwait();
	}
	public void selectdropdownindex(String xpath, int value)
	{
		iwait();
		Select fcc = new Select(driver.findElement(By.xpath(xpath)));
		fcc.selectByIndex(value);
		iwait();
	}
	
	public void deselectdropdown(String xpath, String value)
	{
		iwait();
		Select fcc = new Select(driver.findElement(By.xpath(xpath)));
		fcc.deselectByVisibleText(value);
		iwait();
	}
	
	public void isdisplayed(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 iwait();
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).isDisplayed();
				
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 iwait();
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).isDisplayed(); 
				
			 }
			 else if(xpath.contains("~"))
			 {
				 iwait();
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).isDisplayed();
				
			 }
			 else
			 {
				 iwait();
				// xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).isDisplayed();
				
			 }
         }
	}
	public void isenabled(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).isEnabled();
				
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).isEnabled(); 
		
			 }
			 else if(xpath.contains("."))
			 {
				  xpath = xpath.replace(".", "");
				 driver.findElement(By.className(xpath)).isEnabled();
				
			 }
			 else
			 {
				// xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).isEnabled();
				
			 }
         }
	}
	public void isselected(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).isSelected();
			
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).isSelected(); 
		
			 }
			 else if(xpath.contains("~"))
			 {
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).isSelected();
				
			 }
			 else
			 {
				// xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).isSelected();
			
			 }
         }
	}
	public void getattribute(String xpath , String attributename, String value )
	
	{
		{
			 if(xpath.contains("$"))
			 {
				 xpath = xpath.replace("$", "");
				 String temp;
				 temp = driver.findElement(By.name(xpath)).getAttribute(attributename);
				 			 
				 if(temp.equals(value))
				 {
					 System.out.println("Value is Fine");
				 }else
				 {
					 System.out.println("Need to check the validation");
				 }
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 xpath = xpath.replace("#", "");
				 String temp;
				 temp = driver.findElement(By.id(xpath)).getAttribute(attributename);
				 			 
				 if(temp.equals(value))
				 {
					 System.out.println("Value is Fine");
				 }else
				 {
					 System.out.println("Need to check the validation");
				 }
			 }else if(xpath.contains("~"))
			 {
				 xpath = xpath.replace("~", "");
				 String temp;
				 temp = driver.findElement(By.className(xpath)).getAttribute(attributename);
				 			 
				 if(temp.equals(value))
				 {
					 System.out.println("Value is Fine");
				 }else
				 {
					 System.out.println("Need to check the validation");
				 }
			 }else
			 {
				 //xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).isDisplayed();
				
			 }
        }
	}
	public void framein(String value)
	{
		iwait();
		driver.switchTo().frame(value);
		iwait();
	}
	public void frameout()
	{
		iwait();
		driver.switchTo().defaultContent();
		iwait();
	}
	
	


	public void typeenter(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 iwait();
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).sendKeys(Keys.ENTER);
				 iwait();
			 }
			 else if(xpath.contains("#"))
			 {
				 iwait();
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).sendKeys(Keys.ENTER); 
				iwait();
			 }
			 else if(xpath.contains("~"))
			 {
				 iwait();
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).sendKeys(Keys.ENTER);
				 iwait();
			 }
			 else
			 {
				 iwait();
				 //xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
			 }
	}
	}
	
	public void iwait()
	{
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}
	public void dclick(String xpath)
	{
		iwait();
		if(xpath.contains("$"))
		 {
			 xpath = xpath.replace("$", "");
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.name(xpath));
		actions.doubleClick(elementLocator).perform();
		iwait();
		 }
		else if(xpath.contains("#"))
		 {
			iwait();
			 xpath = xpath.replace("#", "");
			 Actions actions = new Actions(driver);
				WebElement elementLocator = driver.findElement(By.id(xpath));
				actions.doubleClick(elementLocator).perform(); 
		 }
		 else if(xpath.contains("~"))
		 {
			 xpath = xpath.replace("~", "");
			 Actions actions = new Actions(driver);
				WebElement elementLocator = driver.findElement(By.className(xpath));
				actions.doubleClick(elementLocator).perform();
		 }
		 else
		 {
			 //xpath = xpath.replace("//", "");
			 Actions actions = new Actions(driver);
				WebElement elementLocator = driver.findElement(By.xpath(xpath));
				actions.doubleClick(elementLocator).perform();
		 }
	}
		public String geturl(String value)
		{
			value = driver.getCurrentUrl();
		
		return geturl(value);
		}

		public void dd(String one, String two )
		{
			WebElement from = driver.findElement(By.xpath("+one+"));
			WebElement	To = driver.findElement(By.xpath("+two+"));
			
			Actions drag = new Actions(driver);
			drag.dragAndDrop(from,To).build().perform();
		}
		public void tab(String windowHandle1)
		{
			windowHandle1 = driver.getWindowHandle();
			driver.switchTo().window(windowHandle1);
			
		}

	
	
	
}
