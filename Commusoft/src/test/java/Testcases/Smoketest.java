package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.Baseclass;
import utility.Screenshot;

public class Smoketest extends Baseclass {
	public  String customerurl;
	public  String joburl;
	public  String workaddress;
	public  String wjoburl;
	public  String supplier;
	public  String dashboard;
	public  String companyurl;
	public  int supinvoice = 70;
	
	
	@Test(priority = 0)
	public void login() throws InterruptedException, IOException 
	{
		//Login
		
		type("#logintype_clientid","17845");
		type("#logintype_username","ranjit");
		type("#logintype_password","welcome123");
		click("//span[@ng-hide='saving']");
		Thread.sleep(4000);
		dashboard = driver.getCurrentUrl();
		Thread.sleep(4000); 
//		test.log(LogStatus.PASS, "Logged in Successfully on stage");
//		test.log(LogStatus.INFO, "LOgIn INFO:- 16833 user Ranjit/welcome123");
		
	}

	
	@Test(priority = 1)
	public void Create_customer() throws InterruptedException
	{
		//Create Customer
				
				click("#customertypecustomer");
				selectdropdown("//select[@id='customertype_contacts_settingsTitlesid']","Mr");
				type("#customertype_contacts_name","Roman");
				type("#customertype_contacts_surname","Regins");
				type("#customertype_contacts_contactstelephone_1_telephonenumber","9856325698");
				type("#customertype_contacts_contactstelephone_0_telephonenumber","9856326598");
				type("#customertype_contacts_contactsemail_emailaddress","checkingvalidation");
				
				isdisplayed("//span[text()='Invaild email format ex: demo@gmail.com']/..");
				clear("#customertype_contacts_contactsemail_emailaddress");
				
				type("#customertype_contacts_contactsemail_emailaddress","ranjit@commusoft.co.uk");
				type("#customertype_addressline1","Madurai One");
				type("#customertype_addressline2","Madurai2");
				type("#customertype_town","Madurai JILLA");
			//	type("#customertype_county","Madurai");
				click("//span[@ng-hide='saving']");
				Thread.sleep(9000);
				customerurl = driver.getCurrentUrl();
				Thread.sleep(4000);
//				test.log(LogStatus.PASS, "Customer Created Successfully");
//				test.log(LogStatus.INFO, "Customer URL:-" + customerurl);
//				
	}
	
	@Test(priority = 2)
	public  void Edit_customer() throws InterruptedException
	{
		Thread.sleep(3000);
		
		//Edit Customer
		try
		{
		click("//span[text()='Edit customer']");
		}
		catch(Exception j)
		{
			click("//span[text()='Edit customer']");
		}
		
		selectdropdown("(//select[@id='title'])[1]","Lord");
		clear("#name");
		type("#name","Ranjit");
		clear("$customerDetails.surname");
		type("$customerDetails.surname","Aravind");
		clear("$customerLandlineNumber");
		type("$customerLandlineNumber","04522530178");
		clear("$customerMobileNumber");	
		type("$customerMobileNumber","7894561230");
		clear("$customerEmail");
		type("$customerEmail","ranjit@commusoft.co.uk");
		clear("$addressline1");
		type("$addressline1","Madurai");
		clear("$addressline2");
		type("$addressline2","Madurai Two");
		clear("$town");
		type("$town","Madurai-JILLA");
		click("//span[@ng-hide='updating']");
		Thread.sleep(4000);
	//	test.log(LogStatus.INFO, "Customer Has Been Edited Sucessfuly");
						
	}
	
	@Test(priority = 3)
	public  void Create_job() throws InterruptedException
	{
		driver.get(customerurl);
		Thread.sleep(5000);
		
		click("#newJob");
		isenabled("(//button[@type='submit'])[1]");
		type("#job_description","Job Description");
		type("#job_engineernotes","Notes Of Engineer");
		type("#job_quotedamount","5000");
		type("#job_ponumber","Customer Reference-316");
		click("(//button[@type='submit'])[1]");
		
		Thread.sleep(5000);
		joburl = driver.getCurrentUrl();
		Thread.sleep(3000);
		click("//span[text()=\"Add new diary event\"]/..");
		
		click("//button[text()='Daily']");
		Thread.sleep(3000);
		try {
			click("//a[text()='Today']");
			
			Thread.sleep(3000);
			
			click("(//div[@class='fc-row fc-week fc-widget-content'])[2]");
		}catch(Exception e)
		{
			Thread.sleep(3000);
			
			click("(//div[@class='fc-row fc-week fc-widget-content'])[2]");
		}
		Thread.sleep(2000);
		
		selectdropdown("//select[@ng-change=\"updateParentValues('allDayValue', allDayValue)\"]","Specific time");
		click("//a[@ng-click=\"loadNotificationData();openDiaryStep('notifications')\"]");
		
		Thread.sleep(2000);
		click("#top-input-in-notifications-step");
		
		selectdropdown("//select[@ng-if=\"notification_type == 'customer'\"]","Lord Ranjit Aravind");
		
		selectdropdown("//select[@ng-if=\"notification_type != 'engineer'\"]","Email");
		
		click("//button[@ng-click='saveDiaryEvent()']");
		Thread.sleep(3000);
		
	//	test.log(LogStatus.INFO, "Job Has Been Created Sucessfuly, JOB URL:-" + joburl);
		
	}
	
	@Test(priority = 4)
	public  void Edit_job() throws InterruptedException
	{
		Thread.sleep(5000);
		
		click("//a[@has-permission='Jobs,updateaccess']");
		clear("$job[description]");
		type("$job[description]","Job Description update");
		clear("//textarea[@ng-model='job.engineernotes']");
		type("//textarea[@ng-model='job.engineernotes']","Updated Text is present ");
		clear("$quoted_amount");
		type("$quoted_amount","5000");
		clear("//input[@ng-model='job.ponumber']");
		type("//input[@ng-model='job.ponumber']","Stone cold Reference-316");
		click("//span[@ng-hide='updating']");
		
		Thread.sleep(4000);
		click("(//a[text()='Edit'])[2]");
		
		Thread.sleep(4000);
		selectdropdown("(//select[@ng-change='updateHours(hours)'])[1]","09");
		
		selectdropdown("(//select[@ng-change='updateHours(hours)'])[3]","10");
		
		selectdropdown("//select[@name='engineer_name']","Ranjit Reigns");
		
		click("//input[@name='is_special_event']");
		
		selectdropdown("//select[@id='top-input-in-details-step']","30 mins");
		
		click("//button[@ng-click='saveDiaryEvent()']");
		
		Thread.sleep(2000);
		click("(//a[@id=\"cancel-panel-btn\"])[2]");
		Thread.sleep(4000);	
	}
	
	@Test(priority = 5)
	public  void OfficeTask() throws InterruptedException
	{
		driver.get(joburl);
		Thread.sleep(5000);
		
		click("(//span[@class='ng-scope'])[6]");
		
		type("~mention-input__input","office task");
		Thread.sleep(1000);
		
		typeenter("~mention-input__input");
		
		Thread.sleep(1000);
		type("~mention-input__input","#officetasknew");
		Thread.sleep(2000);
		
		typeenter("~mention-input__input");
		typeenter("~mention-input__input");
		Thread.sleep(5000);
	}

	@Test(priority = 6)
	public  void JobReminder() throws InterruptedException
	{
		driver.get(joburl);
		Thread.sleep(3000);
		
		click("(//span[text()='Reminders'])[1]");
		
		click("#addnewreminder");
		
		type("#reminder_remindernote","Enter the notes");
		
		Thread.sleep(2000);
		type("//input[@class='select2-input select2-default']","ran");
		Thread.sleep(2000);
		typeenter("(//input[contains(@id,'s2id_autogen')])[1]");
		
		click("//button[@type='submit']");
		
		Thread.sleep(4000);
	}	
	
	@Test(priority = 7)
	public  void EditJobReminder() throws InterruptedException
	{
		Thread.sleep(3000);
		
		click("//a[@has-permission='Jobreminders,updateaccess']");
		
		type("$reminder[remindernote]","Updated the text  ");
		Thread.sleep(2000);
		click("//ul[@class='select2-choices']");
		
		type("(//input[contains(@id,'s2id_autogen')])[1]","ran");
		
		typeenter("(//input[contains(@id,'s2id_autogen')])[1]");
		
		click("#saveEditReminder");
		
		Thread.sleep(4000);
	}	
	
	@Test(priority = 8)
	public  void AddAttachFile() throws InterruptedException, IOException
	{
		driver.get(joburl);
		Thread.sleep(5000);
		
		click("//span[text()='Attached files']");
		Thread.sleep(5000);
		
		click("//a[text()='Add new file']");
		Thread.sleep(5000);
		click("//button[@class='btn btn-primary fake-uploader']");
		
		Thread.sleep(2000);
		Runtime.getRuntime().exec("D:/image.exe");
		Thread.sleep(7000);
	}
	@Test(priority = 9)
	public  void Addinvoice_NoBreakDown() throws InterruptedException, IOException
	{
		driver.get(joburl);
		Thread.sleep(5000);
			
			click("(//span[@class='ng-scope'])[15]");
			
			Thread.sleep(3000);
			click("//a[@has-permission='Customerinvoicing,writeaccess']");
			
			type("$invoiceDescription","Description");
			
			type("#note","Enter the note");
			
			clear("$total_price");
			
			type("$total_price","500");
			
			click("//span[@ng-hide='saving']");
			Thread.sleep(4000);
	}
	
	@Test(priority = 10)
	public  void Editinvoice_NoBreakDown() throws InterruptedException, IOException
	{
			Thread.sleep(4000);
			
			click("(//a[@has-permission=\"Customerinvoicing,readaccess\"])[1]");
			
			Thread.sleep(2000);
			click("//a[@has-permission='Customerinvoicing,updateaccess']");
			
			clear("$invoiceDescription");
			
			type("$invoiceDescription","Updated Description");
			
			clear("$total_price");
			
			type("$total_price","1000");
			
			click("//div[@class='select2-container chosen-select full-width-select ng-pristine ng-valid ng-valid-required']");
			
			Thread.sleep(2000);
			type("//input[contains(@class,'select2-input select')]", "5");
			
			typeenter("//input[contains(@class,'select2-input select')]");
			
			click("(//span[@class='select2-chosen'])[2]");
			
			Thread.sleep(3000);
			type("(//input[@autocapitalize='off'])[3]","others");
			
			typeenter("(//input[@autocapitalize='off'])[3]");
			Thread.sleep(2000);
			click("//span[@ng-hide='saving']");
			Thread.sleep(3000);
	}
	
	@Test(priority = 11)
	public  void View_NoBreakDown() throws InterruptedException, IOException
	{
		    Thread.sleep(3000);
			
			click("//a[@ng-click='showPrintInvoice()']");
			
			Thread.sleep(2000);
			click("//button[@ng-click='print()']");
			tab("tab");
			Thread.sleep(2000);
			click("//a[@ng-click='sendEmail()']");
			
			Thread.sleep(2000);
			selectdropdown("//select[@ng-model='email.selected_recipient_address']","ranjit@commusoft.co.uk");
			
			Thread.sleep(1000);
			click("(//a[@ng-click='sendEmail()'])[2]");
			
			Thread.sleep(4000);
	}
	@Test(priority = 12)
	public  void Payment_NoBreakDown() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		
		click("//div[@ng-if='job_invoice.grand_total-amountAllocated > 0']");
		
		type("//textarea[@ng-model='description']","Enter the Description");
		
		selectdropdownvalue("//select[@name='paymentMethod']","4");
		
		selectdropdown("//select[@name='nominalAccount']","Bank");
		
		clear("//input[@name='amount']");
		
		type("//input[@name='amount']","100");
			
		click("//button[@type='submit']");
		Thread.sleep(3000);
	}
	@Test(priority = 13)
	public  void Addinvoice_Breakdownbycategory() throws InterruptedException, IOException
	{
		driver.get(joburl);
		Thread.sleep(5000);
		
		click("(//span[@class='ng-scope'])[15]");
		
		Thread.sleep(3000);
		click("//a[@has-permission='Customerinvoicing,writeaccess']");
			
			type("$invoiceDescription","Description");
			
			type("#note","Enter the note");
			
			Thread.sleep(4000);
			click("(//input[@name='invoiceBreakdown'])[2]");
			
			Actions pg = new Actions(driver);
			pg.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(3000);
			click("//td[@class='overflow_handsontable select_icon afterHiddenColumn firstVisibleColumn htPlaceholder']");
			dclick("//td[text()='Please select']");
			Thread.sleep(3000);
			type("(//input[contains(@class,'select2-input')])[5]","parts");
			Thread.sleep(3000);
			typeenter("(//input[contains(@class,'select2-input')])[5]");
			
			dclick("//td[@class='afterHiddenColumn current highlight']");
			dclick("//td[@class='afterHiddenColumn current highlight']");
			Thread.sleep(3000);
			clear("//textarea[@class='handsontableInput']");
			type("//textarea[@class='handsontableInput']","300");
			typeenter("//textarea[@class='handsontableInput']");
			
			click("//span[@ng-hide='saving']");
			Thread.sleep(3000);
	}
	
	@Test(priority = 14)
	public  void Editinvoice_Breakdownbycategory() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		
		click("(//a[@has-permission='Customerinvoicing,readaccess'])[1]");
		Thread.sleep(2000);
		click("//a[@has-permission='Customerinvoicing,updateaccess']");
		
		clear("$invoiceDescription");
		
		type("$invoiceDescription","Updated Description");
		
		click("(//td[@class='afterHiddenColumn'])[1]");
		dclick("//td[@class='afterHiddenColumn current highlight']");
		dclick("//td[@class='afterHiddenColumn current highlight']");
		Thread.sleep(3000);
		clear("//textarea[@class='handsontableInput']");
		type("//textarea[@class='handsontableInput']","900");
		typeenter("//textarea[@class='handsontableInput']");
		
		click("//span[@ng-hide='saving']");
		Thread.sleep(3000);
		
	}
	@Test(priority = 15)
	public  void Payment_Breakdownbycategory() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		click("//div[@ng-if='job_invoice.grand_total-amountAllocated > 0']");
		
		type("//textarea[@ng-model='description']","Enter the Description");
		
		selectdropdownvalue("//select[@name='paymentMethod']","4");
		
		selectdropdown("//select[@name='nominalAccount']","Bank");
		
		clear("//input[@name='amount']");
		
		type("//input[@name='amount']","100");
			
		click("//button[@type='submit']");
		Thread.sleep(3000);
	}
	
	@Test(priority = 16)
	public  void Addinvoice_Fullbreakdown() throws InterruptedException, IOException
	{
		driver.get(joburl);
		Thread.sleep(5000);
		
		click("(//span[@class='ng-scope'])[15]");
		
		Thread.sleep(3000);
		click("//a[@has-permission='Customerinvoicing,writeaccess']");
			
			type("$invoiceDescription","Description");
			
			type("#note","Enter the note");
			
			Thread.sleep(4000);
			click("(//input[@name='invoiceBreakdown'])[3]");
			
			Actions pg = new Actions(driver);
			pg.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(3000);
			click("//td[@class='overflow_handsontable select_icon afterHiddenColumn firstVisibleColumn htPlaceholder']");
			dclick("//td[text()='Please Enter']");
			Thread.sleep(3000);
			type("(//input[contains(@class,'select2-input')])[5]","parts");
			Thread.sleep(3000);
			typeenter("(//input[contains(@class,'select2-input')])[5]");
			
			click("(//td[@class='overflow_handsontable'])[1]");
			dclick("//td[@class='overflow_handsontable current highlight']");
			dclick("//td[@class='overflow_handsontable current highlight']");
			Thread.sleep(3000);
			clear("//textarea[@class='handsontableInput']");
			type("//textarea[@class='handsontableInput']","300");
			typeenter("//textarea[@class='handsontableInput']");
			
			click("//span[@ng-hide='saving']");
			Thread.sleep(4000);
	}
			
	@Test(priority = 17)
	public  void Payment_Fullbreakdown() throws InterruptedException, IOException
			{		
		Thread.sleep(3000);
		
		click("(//a[@has-permission='Customerinvoicing,readaccess'])[1]");
		
		Thread.sleep(4000);
		click("//div[@ng-if='job_invoice.grand_total-amountAllocated > 0']");
		
		type("//textarea[@ng-model='description']","Enter the Description");
		
		selectdropdownvalue("//select[@name='paymentMethod']","4");
		
		selectdropdown("//select[@name='nominalAccount']","Bank");
		
		clear("//input[@name='amount']");
		type("//input[@name='amount']","100");
			
		click("//button[@type='submit']");
		Thread.sleep(3000);
	}
	@Test(priority = 18)
	public  void Addinvoice_Fullbreakdownbycategory() throws InterruptedException, IOException
	{
		driver.get(joburl);
		Thread.sleep(5000);
		
		click("(//span[@class='ng-scope'])[15]");
		
		Thread.sleep(3000);
		click("//a[@has-permission='Customerinvoicing,writeaccess']");
		
		type("$invoiceDescription","Description");
		
		type("#note","Enter the note");
		
		Thread.sleep(4000);
		click("(//input[@name='invoiceBreakdown'])[4]");
		
		Actions pg = new Actions(driver);
		pg.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		click("(//td[@class='overflow_handsontable select_icon afterHiddenColumn firstVisibleColumn htPlaceholder'])[1]");
		dclick("//td[text()='Please Enter']");
		Thread.sleep(3000);
		type("(//input[contains(@class,'select2-input')])[5]","parts");
		Thread.sleep(3000);
		typeenter("(//input[contains(@class,'select2-input')])[5]");
		
		click("(//td[@class='overflow_handsontable'])[1]");
		dclick("//td[@class='overflow_handsontable current highlight']");
		dclick("//td[@class='overflow_handsontable current highlight']");
		Thread.sleep(3000);
		clear("//textarea[@class='handsontableInput']");
		type("//textarea[@class='handsontableInput']","300");
		typeenter("//textarea[@class='handsontableInput']");
		
		click("//span[@ng-hide='saving']");
		Thread.sleep(3000);
	}
	
	@Test(priority = 19)
	public  void ConvertEstimateToJob() throws InterruptedException, IOException
	{
	Thread.sleep(3000);
	driver.get(customerurl);
	Thread.sleep(5000);
	
	click("#newEstimate");
	
	selectdropdown("//select[@name='estimate[templateid]']","General Works");		
	type("#estimate_engineernotes","Notes for Engineer");
	
	type("#estimate_customerreference","Customer Reference");
	
	click("//button[@type='submit']");
	
	click("#partsTab");
	
//	click("//a[@tabindex='1']");
	
	Thread.sleep(3000);
	click("//button[@class='button --primary']");
	
	Thread.sleep(3000);
	click("//button[text()='Save']");
	
	Thread.sleep(3000);
	click("~Select-placeholder");
    
	Thread.sleep(3000);
	type("//input[contains(@aria-activedescendant,'react-select-')]","Parts");
	Thread.sleep(4000);
	typeenter("//input[contains(@aria-activedescendant,'react-select-')]");
	Thread.sleep(3000);
	Thread.sleep(2000);
	type("//input[contains(@aria-activedescendant,'react-select-')]","items");
	Thread.sleep(4000);
	typeenter("//input[contains(@aria-activedescendant,'react-select-')]");
	Thread.sleep(3000);
	
	click("(//td[@class=\"supplier  \"])[2]");
	
	Thread.sleep(2000);
	click("(//td[@class=\"supplier  \"])[5]");
	
	Thread.sleep(2000);
	click("//a[@ng-if='!advanced_estimate']");
	
	Thread.sleep(2000);
	click("//span[text()='Add line items to estimate']");
	
	click("(//input[@class='inline-checkbox ng-scope'])[1]");
	
	click("(//input[@class='inline-checkbox ng-scope'])[2]");
	
	click("//a[@class='btn btn-primary ng-scope']");
	Thread.sleep(2000);
	click("#step-7-text");
	Thread.sleep(3000);
	click("(//span[text()='Accept / reject'])[1]");
	
	click("//input[@ng-checked='option.estimate_option_allow_check === true']");
	
	click("//button[@ng-click='estimateAccept(estimate_options)']");
	
	type("#confirm_delete_input","ACCEPT");
	
	click("(//button[text()='Accept'])[2]");
	Thread.sleep(3000);
	driver.get(customerurl);
	Thread.sleep(4000);
	
	click("(//a[@ng-show=\"'0' == '0' && estimate.additionalWorkId == null\"])[1]");
	Thread.sleep(2000);
	
	click("//span[text()='Send to customer']");
	
	click("//a[text()='Print estimate']");
	
	tab("y");
	
	
	
}
	
	@Test(priority = 19-1)
	public  void RejectEstimate() throws InterruptedException, IOException
	{
	Thread.sleep(3000);
	driver.get(customerurl);
	Thread.sleep(5000);
	
	click("#newEstimate");
	
	selectdropdown("//select[@name='estimate[templateid]']","General Works");		
	type("#estimate_engineernotes","Notes for Engineer");
	
	type("#estimate_customerreference","Customer Reference");
	
	click("//button[@type='submit']");
	
	click("#partsTab");
	
//	click("//a[@tabindex='1']");
	
	Thread.sleep(3000);
	click("//button[@class='button --primary']");
	
	Thread.sleep(3000);
	click("//button[text()='Save']");
	
	Thread.sleep(3000);
	click("~Select-placeholder");
    
	Thread.sleep(3000);
	type("//input[contains(@aria-activedescendant,'react-select-')]","Parts");
	Thread.sleep(4000);
	typeenter("//input[contains(@aria-activedescendant,'react-select-')]");
	Thread.sleep(3000);
	Thread.sleep(2000);
	type("//input[contains(@aria-activedescendant,'react-select-')]","items");
	Thread.sleep(4000);
	typeenter("//input[contains(@aria-activedescendant,'react-select-')]");
	Thread.sleep(3000);
	
	click("(//td[@class=\"supplier  \"])[2]");
	
	Thread.sleep(2000);
	click("(//td[@class=\"supplier  \"])[5]");
	
	Thread.sleep(2000);
	click("//a[@ng-if='!advanced_estimate']");
	
	Thread.sleep(2000);
	click("//span[text()='Add line items to estimate']");
	
	click("(//input[@class='inline-checkbox ng-scope'])[1]");
	
	click("(//input[@class='inline-checkbox ng-scope'])[2]");
	
	click("//a[@class='btn btn-primary ng-scope']");
	Thread.sleep(2000);
	click("#step-7-text");
	Thread.sleep(3000);
	click("(//span[text()='Accept / reject'])[1]");
	
	click("//input[@ng-checked='option.estimate_option_allow_check === true']");
	
	click("//button[@ng-click='estimateReject(estimate_options)']");
	Thread.sleep(4000);
	
	selectdropdown("//select[@required='required']", "Too expensive");
	
	type("#confirm_delete_input","REJECT");
	
	click("//button[@id='delete-button']");
	Thread.sleep(3000);
	driver.get(customerurl);
	Thread.sleep(4000);
	
	click("(//a[@ng-show=\"'0' == '0' && estimate.additionalWorkId == null\"])[1]");
	Thread.sleep(2000);
	
	click("//span[text()='Send to customer']");
	
	click("//a[text()='Print estimate']");
	
	tab("y");
	
}
	
	@Test(priority = 20)
	public  void CreateWorkAddress() throws InterruptedException, IOException
	{
		driver.get(customerurl);
		Thread.sleep(5000);
		
		click("#workAddressTab");
		
		click("#addNewBranch");
		
		type("#workaddress_contacts_name","Work Address Ranjit");
		
		type("#workaddress_contacts_surname","Aravind");
		
		type("#workaddress_contacts_contactstelephone_0_telephonenumber","9865326598");
		
		type("#workaddress_contacts_contactstelephone_1_telephonenumber","2530178");
		
		type("#workaddress_contacts_contactsemail_emailaddress","ranjittestinfgun@yopmail.com");
		
		type("#workaddress_addressline1","Madurai JILLA");
		click("//span[@ng-hide='saving']");
		Thread.sleep(4000);
		workaddress = driver.getCurrentUrl();
		Thread.sleep(3000);
	}
	
	@Test(priority = 21)
	public  void Edit_WorkAddress() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		
		click("//span[text()='Edit work address']");
		
		clear("//input[@name='customerDetails.name']");
		type("//input[@name='customerDetails.name']","Work Address Ranjit");
		
		clear("$customerDetails.surname");
		type("$customerDetails.surname","Aravind");
		clear("$addressline1");
		type("$addressline1","Madurai JILLA");
		click("//span[@ng-hide='updating']");
		Thread.sleep(4000);
	}
	
	@Test(priority = 22)
	public  void WorkAddressCreate_job() throws InterruptedException
	{
		driver.get(workaddress);
		Thread.sleep(5000);
		
		click("#newJob");
		isenabled("(//button[@type='submit'])[1]");
		type("#job_description","Job Description");
		type("#job_engineernotes","Notes Of Engineer");
		type("#job_quotedamount","5000");
		type("#job_ponumber","Customer Reference-316");
		click("(//button[@type='submit'])[1]");
		Thread.sleep(4000);
		wjoburl = driver.getCurrentUrl();
		Thread.sleep(3000);
		
		Thread.sleep(2000);
		click("//span[text()=\"Add new diary event\"]/..");
		
		Thread.sleep(3000);
		click("//button[text()='Daily']");
		
		Thread.sleep(3000);
		
		try {
			click("(//div[@class='fc-row fc-week fc-widget-content'])[2]");
		}catch (Exception k)
		{
			click("(//div[@class='fc-row fc-week fc-widget-content'])[2]");
		}
		
		selectdropdown("//select[@ng-change=\"updateParentValues('allDayValue', allDayValue)\"]","Specific time");
		click("//a[@ng-click=\"loadNotificationData();openDiaryStep('notifications')\"]");
		
		Thread.sleep(2000);
		click("(//input[@id='top-input-in-notifications-step'])[1]");
		
		selectdropdown("//select[@name='recipient']","- Work Address Ranjit Aravind");
		
		Thread.sleep(1000);
		selectdropdown("//select[@name='notification_method']","Email");
		click("(//input[@id='top-input-in-notifications-step'])[2]");
		Thread.sleep(1000);
		
		selectdropdown("(//select[@name='recipient'])[2]","Lord Ranjit Aravind");
		
		selectdropdown("(//select[@name='notification_method'])[2]","Email");
		
		click("//input[@ng-model='add_diary_event_form_inputs.notify_engineer']");
		
		selectdropdown("(//select[@name='notification_method'])[3]","Print");
		
		Thread.sleep(1000);
		click("//span[@ng-hide='saving_diary_event']");
		Thread.sleep(1000);
		tab("q");
		Thread.sleep(3000);
		
		Thread.sleep(4000);
		
	}
	
	@Test(priority = 23)
	public  void WorkAddressEdit_job() throws InterruptedException
	{
		driver.get(wjoburl);
		Thread.sleep(5000);
		
		try
		{
		click("(//a[text()='Edit'])[1]");
		}
		catch(Exception j)
		{
			click("(//a[text()='Edit'])[1]");
		}
		Thread.sleep(5000);
		
		clear("$job[description]");
		type("$job[description]","Job Description update");
		clear("//textarea[@ng-model='job.engineernotes']");
		type("//textarea[@ng-model='job.engineernotes']","Updated Text is present ");
		clear("$quoted_amount");
		type("$quoted_amount","5000");
		clear("//input[@ng-model='job.ponumber']");
		type("//input[@ng-model='job.ponumber']","Stone cold Reference-316");
		click("//span[@ng-hide='updating']");
		
		Thread.sleep(4000);
		click("//a[@has-permission='Diary,updateaccess']");
		
		Thread.sleep(4000);
		selectdropdown("(//select[@ng-change='updateHours(hours)'])[1]","09");
		
		selectdropdown("(//select[@ng-change='updateHours(hours)'])[3]","10");
		
		selectdropdown("//select[@name='engineer_name']","Ranjit Reigns");
		
		click("//input[@name='is_special_event']");
		
		selectdropdown("//select[@id='top-input-in-details-step']","30 mins");
		
		Thread.sleep(2000);
		click("//button[@ng-click='saveDiaryEvent()']");
		
		Thread.sleep(2000);
		click("(//a[@id=\"cancel-panel-btn\"])[2]");
		Thread.sleep(3000);	
	}
	
	@Test(priority = 24)
	public  void WorkAddressOfficeTask() throws InterruptedException
	{
		driver.get(wjoburl);
		Thread.sleep(5000);
		
		click("(//span[@class='ng-scope'])[6]");
		
		type("~mention-input__input","office task");
		Thread.sleep(1000);
		
		typeenter("~mention-input__input");
		
		Thread.sleep(1000);
		type("~mention-input__input","#officetasknew");
		Thread.sleep(2000);
		
		typeenter("~mention-input__input");
		typeenter("~mention-input__input");
		Thread.sleep(4000);
	}

	@Test(priority = 25)
	public  void WorkAddressJobReminder() throws InterruptedException
	{
		driver.get(wjoburl);
		Thread.sleep(5000);
		
		click("(//span[text()='Reminders'])[1]");
		
		click("#addnewreminder");
		
		type("#reminder_remindernote","Enter the notes");
		
		Thread.sleep(2000);
		type("//input[@class='select2-input select2-default']","ran");
		Thread.sleep(2000);
		typeenter("(//input[contains(@id,'s2id_autogen')])[1]");
		
		click("//button[@type='submit']");
		
		Thread.sleep(4000);
	}	
	
	@Test(priority = 26)
	public  void WorkAddressEditJobReminder() throws InterruptedException
	{
		Thread.sleep(3000);
		
		click("//a[@has-permission='Jobreminders,updateaccess']");
		
		type("$reminder[remindernote]","Updated the text  ");
		Thread.sleep(2000);
		click("//ul[@class='select2-choices']");
		
		type("(//input[contains(@id,'s2id_autogen')])[1]","ran");
		
		typeenter("(//input[contains(@id,'s2id_autogen')])[1]");
		
		click("#saveEditReminder");
		
		Thread.sleep(4000);
	}	
	
	@Test(priority = 27)
	public  void WorkAddressAddAttachFile() throws InterruptedException, IOException
	{
		driver.get(wjoburl);
		Thread.sleep(5000);
		
		click("//span[text()='Attached files']");
		
		Thread.sleep(5000);
		click("//a[text()='Add new file']");
		Thread.sleep(5000);
		click("//button[@class='btn btn-primary fake-uploader']");
		
		Thread.sleep(2000);
		Runtime.getRuntime().exec("D:/image.exe");
		Thread.sleep(8000);
	}
	@Test(priority = 28)
	public  void WorkAddressAddinvoice_NoBreakDown() throws InterruptedException, IOException
	{
		driver.get(wjoburl);
		Thread.sleep(5000);
			
			click("(//span[@class='ng-scope'])[15]");
			
			Thread.sleep(3000);
			click("//a[@has-permission='Customerinvoicing,writeaccess']");
			
			type("$invoiceDescription","Description");
			
			type("#note","Enter the note");
			
			clear("$total_price");
			
			type("$total_price","500");
			
			click("//span[@ng-hide='saving']");
			Thread.sleep(4000);
	}
	
	@Test(priority = 29)
	public  void WorkAddressEditinvoice_NoBreakDown() throws InterruptedException, IOException
	{
			Thread.sleep(3000);
			
			click("(//a[@has-permission=\"Customerinvoicing,readaccess\"])[1]");
			
			Thread.sleep(2000);
			click("//a[@has-permission='Customerinvoicing,updateaccess']");
			
			clear("$invoiceDescription");
			
			type("$invoiceDescription","Updated Description");
			
			clear("$total_price");
			
			type("$total_price","1000");
			
			click("//div[@class='select2-container chosen-select full-width-select ng-pristine ng-valid ng-valid-required']");
			
			Thread.sleep(2000);
			type("//input[contains(@class,'select2-input select')]", "5");
			
			typeenter("//input[contains(@class,'select2-input select')]");
			
			click("(//span[@class='select2-chosen'])[2]");
			
			Thread.sleep(3000);
			type("(//input[@autocapitalize='off'])[3]","others");
			
			typeenter("(//input[@autocapitalize='off'])[3]");
			Thread.sleep(2000);
			click("//span[@ng-hide='saving']");
			Thread.sleep(3000);
	}
	
	@Test(priority = 30)
	public  void WorkAddressView_NoBreakDown() throws InterruptedException, IOException
	{
		    Thread.sleep(3000);
			
			click("//a[@ng-click='showPrintInvoice()']");
			
			Thread.sleep(2000);
			click("//button[@ng-click='print()']");
			tab("tab");
			Thread.sleep(2000);
			click("//a[@ng-click='sendEmail()']");
			
			Thread.sleep(2000);
			selectdropdown("//select[@ng-model='email.selected_recipient_address']","ranjit@commusoft.co.uk");
			
			Thread.sleep(1000);
			click("(//a[@ng-click='sendEmail()'])[2]");
			
			Thread.sleep(4000);
	}
	@Test(priority = 31)
	public  void WorkAddressPayment_NoBreakDown() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		
		click("//div[@ng-if='job_invoice.grand_total-amountAllocated > 0']");
		
		type("//textarea[@ng-model='description']","Enter the Description");
		
		selectdropdownvalue("//select[@name='paymentMethod']","4");
		
		selectdropdown("//select[@name='nominalAccount']","Bank");
		
		clear("//input[@name='amount']");
		
		type("//input[@name='amount']","100");
			
		click("//button[@type='submit']");
		Thread.sleep(3000);
	}
	@Test(priority = 32)
	public  void WorkAddressAddinvoice_Breakdownbycategory() throws InterruptedException, IOException
	{
		driver.get(wjoburl);
		Thread.sleep(5000);
		
		click("(//span[@class='ng-scope'])[15]");
		
		Thread.sleep(3000);
		click("//a[@has-permission='Customerinvoicing,writeaccess']");
			
			type("$invoiceDescription","Description");
			
			type("#note","Enter the note");
			
			Thread.sleep(4000);
			click("(//input[@name='invoiceBreakdown'])[2]");
			
			
			Actions pg = new Actions(driver);
			pg.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(3000);
			click("//td[@class='overflow_handsontable select_icon afterHiddenColumn firstVisibleColumn htPlaceholder']");
			dclick("//td[text()='Please select']");
			Thread.sleep(3000);
			type("(//input[contains(@class,'select2-input')])[5]","parts");
			Thread.sleep(3000);
			typeenter("(//input[contains(@class,'select2-input')])[5]");
			
			Thread.sleep(3000);
			dclick("//td[@class='afterHiddenColumn current highlight']");
			dclick("//td[@class='afterHiddenColumn current highlight']");
			Thread.sleep(3000);
			clear("//textarea[@class='handsontableInput']");
			type("//textarea[@class='handsontableInput']","300");
			typeenter("//textarea[@class='handsontableInput']");
			
			click("//span[@ng-hide='saving']");
			Thread.sleep(3000);
	}
	
	@Test(priority = 33)
	public  void WorkAddressEditinvoice_Breakdownbycategory() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		
		click("(//a[@has-permission='Customerinvoicing,readaccess'])[1]");
		Thread.sleep(2000);
		click("//a[@has-permission='Customerinvoicing,updateaccess']");
		
		clear("$invoiceDescription");
		
		type("$invoiceDescription","Updated Description");
		
		click("(//td[@class='afterHiddenColumn'])[1]");
		dclick("//td[@class='afterHiddenColumn current highlight']");
		dclick("//td[@class='afterHiddenColumn current highlight']");
		Thread.sleep(3000);
		clear("//textarea[@class='handsontableInput']");
		type("//textarea[@class='handsontableInput']","900");
		typeenter("//textarea[@class='handsontableInput']");
		
		click("//span[@ng-hide='saving']");
		Thread.sleep(3000);
		
	}
	@Test(priority = 34)
	public  void WorkAddressPayment_Breakdownbycategory() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		
		click("//div[@ng-if='job_invoice.grand_total-amountAllocated > 0']");
		
		type("//textarea[@ng-model='description']","Enter the Description");
		
		selectdropdownvalue("//select[@name='paymentMethod']","4");
		
		selectdropdown("//select[@name='nominalAccount']","Bank");
		
		clear("//input[@name='amount']");
		
		type("//input[@name='amount']","100");
			
		click("//button[@type='submit']");
		Thread.sleep(3000);
	}
	
	@Test(priority = 35)
	public  void WorkAddressAddinvoice_Fullbreakdown() throws InterruptedException, IOException
	{
		driver.get(wjoburl);
		Thread.sleep(5000);
		
		click("(//span[@class='ng-scope'])[15]");
		
		Thread.sleep(3000);
		click("//a[@has-permission='Customerinvoicing,writeaccess']");
			
			type("$invoiceDescription","Description");
			
			type("#note","Enter the note");
			
			Thread.sleep(4000);
			click("(//input[@name='invoiceBreakdown'])[3]");
			
			Actions pg = new Actions(driver);
			pg.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(3000);
			click("//td[@class='overflow_handsontable select_icon afterHiddenColumn firstVisibleColumn htPlaceholder']");
			dclick("//td[text()='Please Enter']");
			Thread.sleep(3000);
			type("(//input[contains(@class,'select2-input')])[5]","parts");
			Thread.sleep(3000);
			typeenter("(//input[contains(@class,'select2-input')])[5]");
			
			click("//td[@class='overflow_handsontable']");
		//	dclick("//td[@class='overflow_handsontable current highlight']");
			dclick("//td[@class='overflow_handsontable current highlight']");
			Thread.sleep(3000);
			clear("//textarea[@class='handsontableInput']");
			type("//textarea[@class='handsontableInput']","300");
			typeenter("//textarea[@class='handsontableInput']");
			
			click("//span[@ng-hide='saving']");
			Thread.sleep(5000);
	}
			
	@Test(priority = 36)
	public  void WorkAddressPayment_Fullbreakdown() throws InterruptedException, IOException
			{
		Thread.sleep(3000);
		
		click("(//a[@has-permission='Customerinvoicing,readaccess'])[1]");
		
		Thread.sleep(4000);
		click("//div[@ng-if='job_invoice.grand_total-amountAllocated > 0']");
		
		type("//textarea[@ng-model='description']","Enter the Description");
		
		selectdropdownvalue("//select[@name='paymentMethod']","4");
		
		selectdropdown("//select[@name='nominalAccount']","Bank");
		
		clear("//input[@name='amount']");
		type("//input[@name='amount']","100");
			
		click("//button[@type='submit']");
		Thread.sleep(3000);
	}
	@Test(priority = 37)
	public  void WorkAddressAddinvoice_Fullbreakdownbycategory() throws InterruptedException, IOException
	{
		driver.get(wjoburl);
		Thread.sleep(5000);
		
		click("(//span[@class='ng-scope'])[15]");
		
		Thread.sleep(3000);
		click("//a[@has-permission='Customerinvoicing,writeaccess']");
		
		type("$invoiceDescription","Description");
		
		type("#note","Enter the note");
		
		Thread.sleep(4000);
		click("(//input[@name='invoiceBreakdown'])[4]");
		
		Actions pg = new Actions(driver);
		pg.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		click("(//td[@class='overflow_handsontable select_icon afterHiddenColumn firstVisibleColumn htPlaceholder'])[1]");
		dclick("//td[text()='Please Enter']");
		Thread.sleep(3000);
		type("(//input[contains(@class,'select2-input')])[5]","parts");
		Thread.sleep(3000);
		typeenter("(//input[contains(@class,'select2-input')])[5]");
		
		click("//td[@class='overflow_handsontable']");
//		dclick("//td[@class='overflow_handsontable current highlight']");
		dclick("//td[@class='overflow_handsontable current highlight']");
		Thread.sleep(3000);
		clear("//textarea[@class='handsontableInput']");
		type("//textarea[@class='handsontableInput']","300");
		typeenter("//textarea[@class='handsontableInput']");
		
		click("//span[@ng-hide='saving']");
		Thread.sleep(3000);
	}
	
	@Test(priority = 38)
	public  void CreateWorkAddressEstimate() throws InterruptedException, IOException
	{
	Thread.sleep(3000);
	driver.get(workaddress);
	Thread.sleep(4000);
	
	click("#newEstimate");
	
	selectdropdown("//select[@name='estimate[templateid]']","General Works");		
	type("#estimate_engineernotes","Notes for Engineer");
	
	type("#estimate_customerreference","Customer Reference");
	
	click("//button[@type='submit']");
	
	click("#partsTab");
	
//	click("//a[@tabindex='1']");
	
	Thread.sleep(3000);
	click("//button[@class='button --primary']");
	
	Thread.sleep(3000);
	click("//button[text()='Save']");
	
	Thread.sleep(3000);
	click("~Select-placeholder");
    
	Thread.sleep(3000);
	type("//input[contains(@aria-activedescendant,'react-select-')]","Parts");
	Thread.sleep(4000);
	typeenter("//input[contains(@aria-activedescendant,'react-select-')]");
	Thread.sleep(3000);
	Thread.sleep(2000);
	type("//input[contains(@aria-activedescendant,'react-select-')]","items");
	Thread.sleep(4000);
	typeenter("//input[contains(@aria-activedescendant,'react-select-')]");
	Thread.sleep(3000);
	
	click("(//td[@class=\"supplier  \"])[2]");
	
	Thread.sleep(2000);
	click("(//td[@class=\"supplier  \"])[5]");
	
	Thread.sleep(2000);
	click("//a[@ng-if='!advanced_estimate']");
	
	Thread.sleep(2000);
	click("//span[text()='Add line items to estimate']");
	
	click("(//input[@class='inline-checkbox ng-scope'])[1]");
	
	click("(//input[@class='inline-checkbox ng-scope'])[2]");
	
	click("//a[@class='btn btn-primary ng-scope']");
	Thread.sleep(2000);
	click("#step-7-text");
	Thread.sleep(3000);
	click("(//span[text()='Accept / reject'])[1]");
	
	click("//input[@ng-checked='option.estimate_option_allow_check === true']");
	
	click("//button[@ng-click='estimateAccept(estimate_options)']");
	
	type("#confirm_delete_input","ACCEPT");
	
	click("(//button[text()='Accept'])[2]");
	Thread.sleep(3000);
}
		
	@Test(priority = 39)
	public  void Diary_NormallEvent() throws InterruptedException, IOException
	{
		driver.get(dashboard);
		Thread.sleep(5000);
		
		click("//a[@ui-sref='loggedin.diary']");
		Thread.sleep(2000);
		click("//button[text()='Daily']");
		
		Thread.sleep(2000);
		try {
			click("//a[text()='Today']");
			
			Thread.sleep(3000);
			
			click("(//div[@class='fc-row fc-week fc-widget-content'])[2]");
		}catch(Exception e)
		{
			Thread.sleep(3000);
			
			click("(//div[@class='fc-row fc-week fc-widget-content'])[2]");
		}
		//Normal Event
		Thread.sleep(3000);
		
		selectdropdown("//select[@ng-change=\"updateParentValues('allDayValue', allDayValue)\"]","Specific time");
		
		type("//input[@ng-model='add_normal_event_inputs.description']","Enter the Description");
		click("//button[@ng-click='saveDiaryEvent()']");
		
		Thread.sleep(2000);
	}
	@Test(priority = 40)
	public  void Diary_EstimateEvent() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		click("//a[@ui-sref='loggedin.diary']");
		
		
		//Create Estimate with Existing Customer
		Thread.sleep(4000);
		click("//button[text()='Weekly']");
		
		//Create Job with Existing Customer
		Thread.sleep(3000);
		try {
			click("//a[text()='Today']");
			
			Thread.sleep(3000);
			
			click("(//div[@class='fc-row fc-week fc-widget-content'])[2]");
		}catch(Exception e)
		{
			Thread.sleep(3000);
			
			click("(//div[@class='fc-row fc-week fc-widget-content'])[2]");
		}
		Thread.sleep(2000);
		click("//a[@ng-click=\"setEventType('estimate', 'add_estimate_event_inputs')\"]");
		
		type("//input[@ng-model='propertySearchQuery']","Ranjit");
		Thread.sleep(2000);
		typeenter("//input[@ng-model='propertySearchQuery']");
		
		click("(//div[@class='flex flex-1 flex-column'])[1]");
		
		selectdropdown("//select[@name='allDayValue']","Specific time");
		
		selectdropdown("//select[@ng-change='setEstimateDescription()']","General Works");
		
		Thread.sleep(2000);
		click("//span[@ng-hide='saving_diary_event']");
		Thread.sleep(3000);
	}
	@Test(priority = 41)
	public  void Diary_JobEvent() throws InterruptedException, IOException
	{Thread.sleep(3000);
		
		click("//a[@ui-sref='loggedin.diary']");
		
		Thread.sleep(3000);
		click("//button[text()='Weekly']");
		
		//Create Job with Existing Customer
		Thread.sleep(3000);
			try {
			click("//a[text()='Today']");
			
			Thread.sleep(3000);
			
			click("(//div[@class='fc-row fc-week fc-widget-content'])[2]");
		}catch(Exception e)
		{
			Thread.sleep(3000);
			
			click("(//div[@class='fc-row fc-week fc-widget-content'])[2]");
		}
		Thread.sleep(2000);
		click("(//a[@ng-click=\"setEventType('job', 'add_job_event_inputs')\"])[1]");
		
		type("//input[@ng-model='propertySearchQuery']","Ranjit");
		Thread.sleep(2000);
		typeenter("//input[@ng-model='propertySearchQuery']");
		
		click("(//div[@class='flex flex-1 flex-column'])[1]");
		
		selectdropdown("//select[@name='allDayValue']","Specific time");
		
		type("//input[@ng-model='add_job_event_inputs.job.description']","Descrption Value");
		
		Thread.sleep(2000);
		click("(//span[@ng-hide=\"saving_diary_event\"])[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 42)
	public  void Diary_JobEventwithnewcustomer() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		
		click("//a[@ui-sref='loggedin.diary']");
		
		//Create Job with New Customer
		Thread.sleep(3000);
		
		click("//button[text()='Monthly']");
		Thread.sleep(4000);
		try {
			click("//a[text()='Today']");
			
			Thread.sleep(3000);
			
			click("(//td[contains(@class,'fc-day-top fc-thu fc-future')])[1]");
		}catch(Exception e)
		{
			Thread.sleep(3000);
			
			click("(//td[contains(@class,'fc-day-top fc-thu fc-future')])[1]");
		}
		Thread.sleep(2000);
		
		click("(//a[@ng-click=\"setEventType('job', 'add_job_event_inputs')\"])[1]");
		
		click("//a[@ng-click='addNewProperty(event_type)']");
		
		selectdropdown("//select[@id='new-property-type-input']","Customer");
		
		selectdropdownvalue("//select[@ng-change='setCustomerType()']","0");
		
		type("//input[@ng-model='add_new_customer_inputs.first_name']","Aravind");
		
		type("//input[@ng-model='add_new_customer_inputs.surname']","Reigns 316");
		
		type("//input[@ng-model='add_new_customer_inputs.email']","ranjit.aravind@yopmail.com");
		
		type("//input[@ng-model='add_new_customer_inputs.addrs_1']","Madurai JIlla");
		
		click("//button[@ng-show=\"selected_customer_type == 'new_customer'\"]");
		
		Thread.sleep(2000);
		selectdropdown("//select[@name='allDayValue']","Specific time");
		
		Thread.sleep(2000);
		type("//input[@ng-model='add_job_event_inputs.job.description']","Descrption Value");
		
		Thread.sleep(2000);
		click("(//span[@ng-hide=\"saving_diary_event\"])[1]");
		//Print Job Sheet
		
		Thread.sleep(4000);
		click("//span[text()='Print job sheets']");
		
		String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(windowHandle);
		logger.log(Status.INFO, "Job Sheet has been downloded Sucessfully");
		Thread.sleep(2000);
		click("//span[text()='Print summary sheets']");
		
		String windowHandle1 = driver.getWindowHandle();
		driver.switchTo().window(windowHandle1);
		logger.log(Status.INFO, "Summary Sheet has been downloded Sucessfully");
		Thread.sleep(3000);
	}
	
	@Test(priority = 43)
	public  void Create_Supplier() throws InterruptedException, IOException
	{
		driver.get(dashboard);
		//Supplier Screen
		Thread.sleep(4000);
		
		click("(//a[@class='ng-scope'])[3]");
		
		Thread.sleep(3000);
		click("#newSupplier");
		
		type("#suppliertype_contacts_companyname","Aravind Supplier");
		
		type("#suppliertype_addressline1","Madurai 1 ");
		
		type("#suppliertype_addressline2","Madurai 2 ");
		
		type("#suppliertype_addressline3","Madurai 3 ");
		
		type("#suppliertype_town","Madurai");
		
	//	type("#suppliertype_county","Madurai JILLA");
		
		type("#suppliertype_contacts_contactstelephone_0_telephonenumber","2530178");
		
		type("#suppliertype_contacts_contactsemail_emailaddress","ranjit@yopmail.com");
		Thread.sleep(2000);
		
		click("//span[@ng-hide='saving']");
		
		Thread.sleep(4000);
		supplier = driver.getCurrentUrl();
	}
	
	@Test(priority = 44)
	public  void Edit_Supplier() throws InterruptedException, IOException
	{
		//Supplier Screen
		Thread.sleep(3000);
		
		click("#editSupplier");
		
		Thread.sleep(3000);
		clear("$supplierName");
		type("$supplierName","Ranjit Supplier");
		
		clear("$emailaddress");
		type("$emailaddress","ranjit@commusoft.co.uk");
		Thread.sleep(2000);
		
		click("//span[@ng-hide='updating']");
		
		Thread.sleep(4000);
	}
	@Test(priority = 45)
	public  void Supplier_po() throws InterruptedException, IOException
	{
		driver.get(supplier);
		//Supplier PO
		Thread.sleep(4000);
		
		click("(//a[@class='btn btn-primary btn-small ng-scope'])[1]");
		
		Thread.sleep(3000);
		click("//td[text()='Please select']");
		
		dclick("//td[text()='Please select']");
		//dclick("//td[text()='Please select']");
		Thread.sleep(1000);
		type("//input[contains(@class,'select2-focused')]","parts");
		Thread.sleep(3000);
		typeenter("//input[contains(@class,'select2-focused')]");
		
		Thread.sleep(1000);
		click("(//td[@class='overflow_handsontable select_icon afterHiddenColumn htPlaceholder'])[1]");
		
		dclick("//td[@class='overflow_handsontable select_icon afterHiddenColumn htPlaceholder current highlight']");
		
		type("//input[contains(@class,'select2-focused')]","parts");
		typeenter("//input[contains(@class,'select2-focused')]");
		
		Thread.sleep(2000);
		click("//span[@ng-hide='saving']");
		
		Thread.sleep(3000);
	}
//	@Test(priority = 46)
//	public  void Supplier_Editpo() throws InterruptedException, IOException
//	{
//		driver.get(supplier);
//		Thread.sleep(4000);
//		{
//			driver.get("https://stage.commusoft.co.uk/suppliers/list_supplier/40/view/supplier_details");
//			Thread.sleep(4000);
//			click("(//a[@ui-sref='loggedin.list_supplier.view.purchase_order.details({ id: selectedId, purchaseOrderId: purchaseOrder.id})'])[1]");
//			Thread.sleep(3000);
//			
//			click("//span[text()='Edit']");
//			
//			Thread.sleep(2000);
//			click("(//td[@class='overflow_handsontable'])[1]");
//			dclick("//td[@class='overflow_handsontable current highlight']");
//			
//			Thread.sleep(2000);
//			clear("//textarea[@class='handsontableInput']");
//			Thread.sleep(1000);
//			type("//textarea[@class='handsontableInput']","5");
//			
//			typeenter("//textarea[@class='handsontableInput']");
//			Thread.sleep(1000);
//			dclick("//td[@class='overflow_handsontable current highlight']");
//			dclick("//td[@class='overflow_handsontable current highlight']");
//			clear("//textarea[@class='handsontableInput']");
//			Thread.sleep(1000);
//			type("//textarea[@class='handsontableInput']","800");
//			
//			typeenter("//textarea[@class='handsontableInput']");
//			
//			Thread.sleep(1000);
//			dclick("//td[@class='overflow_handsontable select_icon current highlight']");
//			dclick("//td[@class='overflow_handsontable select_icon current highlight']");
//			
//			clear("//input[contains(@class,'select2-input select2')]");
//			Thread.sleep(1000);
//			type("//input[contains(@class,'select2-input select2')]","5");
//			Thread.sleep(1000);
//			typeenter("//input[contains(@class,'select2-input select2')]");
//			
//			Thread.sleep(1000);
//			dclick("//td[@class='overflow_handsontable select_icon current highlight']");
//			dclick("//td[@class='overflow_handsontable select_icon current highlight']");
//			
//			clear("//input[contains(@class,'select2-input select2')]");
//			Thread.sleep(1000);
//			type("//input[contains(@class,'select2-input select2')]","rent");
//			
//			typeenter("//input[contains(@class,'select2-input select2')]");
//			
//			click("//span[@ng-hide='saving']");
//			Thread.sleep(3000);
//		}
//	}
		
	@Test(priority = 47)
	public  void Supplier_Invoice() throws InterruptedException, IOException
	{
		driver.get(supplier);
		//Invoice 
		Thread.sleep(4000);
		
		click("//a[text()='Add new invoice']");
		Thread.sleep(3000);
		
		type("//input[@check-exists='invoiceNumber']",""+supinvoice +"");
		
		click("//td[@class='overflow_handsontable select_icon afterHiddenColumn firstVisibleColumn htPlaceholder']");
		
		Thread.sleep(3000);
		click("//td[text()='Please select']");
		
		dclick("//td[text()='Please select']");
		//dclick("//td[text()='Please select']");
		Thread.sleep(1000);
		type("//input[contains(@class,'select2-focused')]","parts");
		Thread.sleep(3000);
		typeenter("//input[contains(@class,'select2-focused')]");
		
		click("(//td[@class='overflow_handsontable select_icon afterHiddenColumn htPlaceholder'])[1]");
		
		dclick("//td[@class='overflow_handsontable select_icon afterHiddenColumn htPlaceholder current highlight']");
		
		
		type("//input[contains(@class,'select2-focused')]","parts");
		typeenter("//input[contains(@class,'select2-focused')]");
		
		click("//span[@ng-hide='saving']");
		
		Thread.sleep(3000);
	}
	
	@Test(priority = 48)
	public  void Supplier_EditInvoice() throws InterruptedException, IOException
	{
	driver.get("https://stage.commusoft.net/suppliers/list_supplier/4/view/supplier_details");
	Thread.sleep(4000);
	
	click("(//a[@ui-sref='loggedin.list_supplier.view.invoice.details({ id: selectedId, invoiceId: supplierInvoice.id })'])[1]");
	click("//span[text()='Edit']");
	
	Thread.sleep(3000);
	click("(//td[@class='overflow_handsontable'])[1]");
	dclick("//td[@class='overflow_handsontable current highlight']");
	
	clear("//textarea[@class='handsontableInput']");
	Thread.sleep(1000);
	type("//textarea[@class='handsontableInput']","5");
	
	typeenter("//textarea[@class='handsontableInput']");
	dclick("//td[@class='overflow_handsontable current highlight']");
	dclick("//td[@class='overflow_handsontable current highlight']");
	clear("//textarea[@class='handsontableInput']");
	Thread.sleep(1000);
	type("//textarea[@class='handsontableInput']","800");
	
	typeenter("//textarea[@class='handsontableInput']");
	
	dclick("//td[@class='overflow_handsontable select_icon current highlight']");
	dclick("//td[@class='overflow_handsontable select_icon current highlight']");
	
	clear("//input[contains(@class,'select2-input select2')]");
	Thread.sleep(1000);
	type("//input[contains(@class,'select2-input select2')]","5");
	Thread.sleep(1000);
	typeenter("//input[contains(@class,'select2-input select2')]");
	
//	click("(//td[@class='overflow_handsontable select_icon afterHiddenColumn htPlaceholder'])[1]");
	
	dclick("//td[@class='overflow_handsontable select_icon afterHiddenColumn current highlight']");
	
	clear("//input[contains(@class,'select2-input select2')]");
	Thread.sleep(1000);
	type("//input[contains(@class,'select2-input select2')]","rent");
	
	typeenter("//input[contains(@class,'select2-input select2')]");
	
	click("//span[@ng-hide='saving']");
	Thread.sleep(3000);
	}
	@Test(priority = 49)
	public  void Supplier_creditnote() throws InterruptedException, IOException
	{
		
			driver.get("https://stage.commusoft.net/suppliers/list_supplier/4/view/supplier_details");
			//Credit Note
			Thread.sleep(4000);
			
			click("(//a[@has-permission='Creditsnote,writeaccess'])[1]");
			Thread.sleep(4000);
			type("//input[@name='creditNoteNumber']",""+supinvoice+"");
			
			Thread.sleep(1000);
			Actions pg = new Actions(driver);
			pg.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(3000);
			click("//td[@class='afterHiddenColumn firstVisibleColumn']");
			
			dclick("//td[@class='afterHiddenColumn firstVisibleColumn current highlight']");
			Thread.sleep(1000);
			type("//textarea[@class='handsontableInput']","parts");
			Thread.sleep(3000);
			click("(//td[@class='overflow_handsontable'])[4]");
			
			dclick("//td[@class='overflow_handsontable current highlight']");
			
//			driver.findElement(By.xpath("(//textarea[@class='handsontableInput'])[1]")).sendKeys(Keys.BACK_SPACE);
//			
			dclick("//td[@class='overflow_handsontable current highlight']");
			
			Thread.sleep(2000);
			type("(//textarea[@class='handsontableInput'])[2]","200");
			
			click("(//td[@class='overflow_handsontable select_icon afterHiddenColumn htPlaceholder'])[2]");
			
			dclick("//td[@class='overflow_handsontable select_icon afterHiddenColumn htPlaceholder current highlight']");
			
			Thread.sleep(2000);
			type("//input[contains(@class,'select2-focused')]","parts");
			typeenter("//input[contains(@class,'select2-focused')]");
			Thread.sleep(1000);
	//		dclick("//td[@class='overflow_handsontable select_icon htPlaceholder current highlight']");
			dclick("//td[@class='overflow_handsontable select_icon htPlaceholder current highlight']");
			Thread.sleep(4000);
			typeenter("//input[contains(@class,'select2-focused')]");
				
			Thread.sleep(3000);
			click("//span[@ng-hide='saving']");
			Thread.sleep(3000);
		}
	@Test(priority = 50)
	public  void Create_Company() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		driver.get("https://stage.commusoft.net/customers");
		Thread.sleep(5000);
		
		click("//span[text()='New Company']");
		Thread.sleep(3000);
		
		type("#company_contacts_companyname","Aravind Company");
		
		type("#company_addressline1","Madurai Address1");
		
		type("#company_contacts_companylandline_telephonenumber","5555555");
		
		type("#company_contacts_contactsemail_emailaddress","ranjittest316@yopmail.com");
		
		click("//span[@ng-hide='saving']");
		Thread.sleep(3000);
		companyurl = driver.getCurrentUrl();
		
	}
	@Test(priority = 51)
	public  void Edit_Company() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		
		click("//span[text()='Edit customer']");
		Thread.sleep(3000);
		
		clear("$customerDetails.companyname");
		
		type("$customerDetails.companyname","Ranjit Company");
		
		clear("$customerLandlineNumber");
		type("$customerLandlineNumber","6666666");
		
		clear("$customerDetails.emailAddress");
		type("$customerDetails.emailAddress","ranjit316@yopmail.com");
		
		click("//span[@ng-hide='updating']");
		Thread.sleep(2000);
		
	}
	@Test(priority = 52)
	public  void Create_Companyjob() throws InterruptedException
	{
		
		Thread.sleep(4000);
		
		click("#newJob");
		isenabled("(//button[@type='submit'])[1]");
		type("#job_description","Job Description");
		type("#job_engineernotes","Notes Of Engineer");
		type("#job_quotedamount","5000");
		type("#job_ponumber","Customer Reference-316");
		click("(//button[@type='submit'])[1]");
		
		Thread.sleep(3000);
		
	}
	@Test(priority = 53)
	public  void Company_WorkAddress() throws InterruptedException, IOException
	{
		driver.get(companyurl);
		Thread.sleep(5000);
		
		click("#workAddressTab");
		
		click("#addNewBranch");
		
		type("#workaddress_contacts_name","Work Address Ranjit");
		
		type("#workaddress_contacts_surname","Aravind");
		
		type("#workaddress_contacts_contactstelephone_0_telephonenumber","9865326598");
		
		type("#workaddress_contacts_contactstelephone_1_telephonenumber","2530178");
		
		type("#workaddress_contacts_contactsemail_emailaddress","ranjittestinfgun@yopmail.com");
		
		type("#workaddress_addressline1","Madurai JILLA");
		click("//span[@ng-hide='saving']");
		Thread.sleep(4000);
		
	}
	@Test(priority = 54)
	public  void SolarSearch() throws InterruptedException, IOException
	{
		type("#search-input","ranjit");
		typeenter("#search-input");
		Thread.sleep(3000);
			
		click("(//a[@class='ng-scope ng-binding'])[1]");
		
		
		
	}
	@Test(priority = 55)
	public  void Customer_AfterSalesCare() throws InterruptedException
	{
		driver.get(customerurl);
		click("//a[@id='remindersTab']");
		
		click("(//a[@has-permission='Setupdefaultoptionsforaftersalescare,updateaccess'])[2]");
		
		selectdropdown("//select[@ng-model='notificationValue']", "On");
		click("(//span[text()='Save'])[1]");
		Thread.sleep(3000);
		
		click("//span[text()='Property']");
		Thread.sleep(2000);
		
		click("#newJob");
		isenabled("(//button[@type='submit'])[1]");
		type("#job_description","Job Description");
		type("#job_engineernotes","Notes Of Engineer");
		type("#job_quotedamount","5000");
		type("#job_ponumber","Customer Reference-316");
		click("(//button[@type='submit'])[1]");
		
		Thread.sleep(3000);
		click("//span[text()='Quick links']");
		
		click("//a[text()='Free of charge job']");
		Thread.sleep(3000);
		
		selectdropdown("//select[@id='freeofchargeandabortjob_reason']", "Admin error");
		
		click("//button[@type='submit']");
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		try
		{
		driver.findElement(By.xpath("//p[@ng-if='information.help_text']")).isDisplayed();
		logger.log(Status.INFO, "After Sales Care Mail Been Sent Successfully");
		
		}catch(Exception k)
		{
			logger.log(Status.INFO, "After Sales Care Mail doesn't Sent Successfully");	
		}
	}
	@Test(priority = 56)
		public  void service_reminder() throws InterruptedException
		{
			driver.get(customerurl);
			Thread.sleep(3000);
			
			click("#remindersTab");
			Thread.sleep(2000);
			
			click("#AddNewServiceReminder");
			Thread.sleep(3000);
			selectdropdown("//select[@id='servicereminder_propertyservicereminderid']","Manuall reminder");
			
			selectdropdown("//select[@id='servicereminder_contactid']", "Lord Ranjit Aravind - Phone call, SMS, Email, Letter");
			
			click("//span[text()='Add service reminder']");
			Thread.sleep(3000);
			
			click("(//a[text()='Customers'])[1]");
			Thread.sleep(4000);
			click("//a[text()='View all service reminders']");
			Thread.sleep(3000);
			click("(//span[@class='ss-calendar'])[1]");
			
			click("(//a[@ng-click='selectRange(dateFilterOption)'])[1]");
			Thread.sleep(4000);
//			selectdropdown("//select[@id='selectedServiceReminder']", "Manuall reminder");
//			Thread.sleep(4000);
			
			click("//span[@class='ss-check']");
			Thread.sleep(2000);
			
			click("(//span[text()='Process reminders'])[1]");
			Thread.sleep(6000);
			click("//a[@id='printscreen']");
			Thread.sleep(3000);
		}
	@Test(priority = 57)
	public  void Customer_NotesCommunication() throws InterruptedException
	{
		driver.get(customerurl);
		Thread.sleep(5000);
		
	//Create a New Notes	
		click("//span[text()='Notes & communications']");
		Thread.sleep(4000);
		
		click("//span[text()='Add new note']");
		Thread.sleep(2000);
		
		type("#communication_communicationsnote_title", "Title");
		
		type("#communication_communicationsnote_note", "If you Smell What THE ROCK is Cooking");
		
		click("(//span[text()='Save'])[1]");
		Thread.sleep(2000);
	//Send new Email
		click("(//span[text()='Send new email'])[1]");
		Thread.sleep(2000);
		
		selectdropdown("//select[@ng-model='email.selected_recipient_address']", "ranjit@commusoft.co.uk");
		
		type("//input[@ng-model='email.subject']", "Notes and Communication Email Subject");
		
		click("(//a[@ng-click='sendEmail()'])[2]");
		Thread.sleep(2000);
	}
	@Test(priority = 58)
	public  void Customer_Createcontact() throws InterruptedException
	{
		driver.get(customerurl);
		Thread.sleep(3000);
		
		click("//span[text()='Contacts']");
		Thread.sleep(2000);
		
		click("//a[text()='Add new contact']");
		
		type("#contact_name", "Aravind");
		type("#contact_surname", "Reigns");
		type("#contact_contactsemail_emailaddress","rara@yopmail.com");
		
		Thread.sleep(1000);
		click("//span[@class='number-type-toggle ng-binding']");
		
		click("//li[text()='Mobile']");
		type("$contact[contactstelephone][0][telephonenumber]", "9856325698");
		click("//span[text()='Add phone number']");
		
		click("//span[text()='Add contact']");
			
	}
	
	@Test(priority = 59)
	public  void EstimateStatusCheck_accept_TRIAG4316() throws InterruptedException, IOException
	{
	Thread.sleep(3000);
	driver.get(customerurl);
	Thread.sleep(5000);
	
	click("#newEstimate");
	
	selectdropdown("//select[@name='estimate[templateid]']","General Works");		
	type("#estimate_engineernotes","Notes for Engineer");
	
	type("#estimate_customerreference","Customer Reference");
	
	click("//button[@type='submit']");
	
	click("#partsTab");
	
//	click("//a[@tabindex='1']");
	
	Thread.sleep(3000);
	click("//button[@class='button --primary']");
	
	Thread.sleep(3000);
	click("//button[text()='Save']");
	
	Thread.sleep(3000);
	click("~Select-placeholder");
    
	Thread.sleep(3000);
	type("//input[contains(@aria-activedescendant,'react-select-')]","Parts");
	Thread.sleep(4000);
	typeenter("//input[contains(@aria-activedescendant,'react-select-')]");
	Thread.sleep(3000);
	Thread.sleep(2000);
	type("//input[contains(@aria-activedescendant,'react-select-')]","items");
	Thread.sleep(4000);
	typeenter("//input[contains(@aria-activedescendant,'react-select-')]");
	Thread.sleep(3000);
	
	click("(//td[@class=\"supplier  \"])[2]");
	
	Thread.sleep(2000);
	click("(//td[@class=\"supplier  \"])[5]");
	
	Thread.sleep(4000);
	
	String temp = driver.getCurrentUrl();
	Thread.sleep(3000);
	click("//a[text()='Reporting']");
	Thread.sleep(6000);
	click("//a[@id='side-bar']");
	Thread.sleep(1000);
	click("//a[@has-root-permission='estimateReports']");
	
	Thread.sleep(2000);
	click("(//a[@has-permission=\"Basicestimatereports,readaccess\"])[1]");
	Thread.sleep(6000);
	type("//input[@data-ng-model='activeTag.value_label']", "Date created");
	
	click("//a[text()='Date created']"); 
	
	click("(//a[@ng-click='selectRange(dateFilterOption)'])[1]");
	Thread.sleep(2000);
	click("(//a[text()='Apply filters'])[2]");
	Thread.sleep(4000);
	int xpathCount= driver.findElements(By.xpath("//span[@data-column='Estimate Status']")).size();
	System.out.println(xpathCount);
	Thread.sleep(3000);
	String status = driver.findElement(By.xpath("(//span[@data-column='Estimate Status'])["+xpathCount+"]")).getText();
	Thread.sleep(2000);
	System.out.println(status);
	if (status == "ongoing")
	{
		logger.log(Status.PASS, "Status in Report is fine as Estimate Status");
		System.out.println("Ongoing status is fine");
	}else
	{
		logger.log(Status.FAIL, "Status in Report is not fine as Estimate Status");
	}
	Thread.sleep(2000);
	driver.get(temp);
	Thread.sleep(4000);
	click("//a[@ng-if='!advanced_estimate']");
	
	Thread.sleep(2000);
	click("//span[text()='Add line items to estimate']");
	
	click("(//input[@class='inline-checkbox ng-scope'])[1]");
	
	click("(//input[@class='inline-checkbox ng-scope'])[2]");
	
	click("//a[@class='btn btn-primary ng-scope']");
	Thread.sleep(2000);
	click("#step-7-text");
	Thread.sleep(3000);
	
	click("//span[text()='Send to customer']");
	
	Thread.sleep(4000);
	click("//a[text()='Email estimate']");
	Thread.sleep(2000);
	
	selectdropdown("//select[@ng-model='email.selected_recipient_address']", "ranjit@commusoft.co.uk");
	
	click("(//a[@ng-click='sendEmail()'])[2]");
	Thread.sleep(2000);
	
	Thread.sleep(3000);
	click("//a[text()='Reporting']");
	Thread.sleep(6000);
	click("//a[@id='side-bar']");
	Thread.sleep(1000);
	click("//a[@has-root-permission='estimateReports']");
	
	Thread.sleep(2000);
	click("(//a[@has-permission=\"Basicestimatereports,readaccess\"])[1]");
	Thread.sleep(6000);
	type("//input[@data-ng-model='activeTag.value_label']", "Date created");
	
	click("//a[text()='Date created']"); 
	
	click("(//a[@ng-click='selectRange(dateFilterOption)'])[1]");
	Thread.sleep(2000);
	click("(//a[text()='Apply filters'])[2]");
	Thread.sleep(4000);
//	int xpathCount= driver.findElements(By.xpath("//span[@data-column='Estimate Status']")).size();
//	System.out.println(xpathCount);
	Thread.sleep(3000);
	String status1 = driver.findElement(By.xpath("(//span[@data-column='Estimate Status'])["+xpathCount+"]")).getText();
	Thread.sleep(2000);
	System.out.println(status1);
	if (status1.startsWith("waiting"))
	{
		logger.log(Status.PASS, "Status in Report is fine as Estimate Status");
		System.out.println("waiting for customer status is fine");
	}else
	{
		logger.log(Status.FAIL, "Status in Report is not fine as Estimate Status");
		System.out.println("Change");
	}
	Thread.sleep(2000);
	driver.get(temp);
	Thread.sleep(4000);
		
	click("(//span[text()='Accept / reject'])[1]");
	
	click("//input[@ng-checked='option.estimate_option_allow_check === true']");
	
	click("//button[@ng-click='estimateAccept(estimate_options)']");
	
	type("#confirm_delete_input","ACCEPT");
	
	click("(//button[text()='Accept'])[2]");
	Thread.sleep(3000);
//	driver.get(customerurl);
	
	Thread.sleep(3000);
	click("//a[text()='Reporting']");
	Thread.sleep(6000);
	click("//a[@id='side-bar']");
	Thread.sleep(1000);
	click("//a[@has-root-permission='estimateReports']");
	
	Thread.sleep(2000);
	click("(//a[contains(text(),'Estimates')])[2]");
	Thread.sleep(6000);
	type("//input[@data-ng-model='activeTag.value_label']", "Date created");
	
	click("//a[text()='Date created']"); 
	
	Thread.sleep(2000);
	click("(//a[@ng-click='selectRange(dateFilterOption)'])[1]");
	Thread.sleep(2000);
	click("(//a[text()='Apply filters'])[2]");
	Thread.sleep(4000);
//	int xpathCount= driver.findElements(By.xpath("//span[@data-column='Estimate Status']")).size();
//	System.out.println(xpathCount);
	Thread.sleep(3000);
	String status2 = driver.findElement(By.xpath("(//span[@data-column='Estimate Status'])["+xpathCount+"]")).getText();
	Thread.sleep(2000);
	System.out.println(status2);
	if (status2.contains("accepted"))
	{
		logger.log(Status.PASS, "Status in Report is fine as Estimate Status");
		System.out.println("accepted is fine");
	}else
	{
		logger.log(Status.FAIL, "Status in Report is not fine as Estimate Status");
		System.out.println("Change- accept");
	}
	
}
	@Test(priority = 60)
	public  void EstimateStatusCheck_reject_TRIAG4316() throws InterruptedException, IOException
	{
	Thread.sleep(3000);
	driver.get(customerurl);
	Thread.sleep(5000);
	
	click("#newEstimate");
	
	selectdropdown("//select[@name='estimate[templateid]']","General Works");		
	type("#estimate_engineernotes","Notes for Engineer");
	
	type("#estimate_customerreference","Customer Reference");
	
	click("//button[@type='submit']");
	
	click("#partsTab");
	
//	click("//a[@tabindex='1']");
	
	Thread.sleep(3000);
	click("//button[@class='button --primary']");
	
	Thread.sleep(3000);
	click("//button[text()='Save']");
	
	Thread.sleep(3000);
	click("~Select-placeholder");
    
	Thread.sleep(3000);
	type("//input[contains(@aria-activedescendant,'react-select-')]","Parts");
	Thread.sleep(4000);
	typeenter("//input[contains(@aria-activedescendant,'react-select-')]");
	Thread.sleep(3000);
	Thread.sleep(2000);
	type("//input[contains(@aria-activedescendant,'react-select-')]","items");
	Thread.sleep(4000);
	typeenter("//input[contains(@aria-activedescendant,'react-select-')]");
	Thread.sleep(3000);
	
	click("(//td[@class=\"supplier  \"])[2]");
	
	Thread.sleep(2000);
	click("(//td[@class=\"supplier  \"])[5]");
	
	Thread.sleep(4000);
	
	String temp = driver.getCurrentUrl();
	Thread.sleep(3000);
	click("//a[text()='Reporting']");
	Thread.sleep(6000);
	click("//a[@id='side-bar']");
	Thread.sleep(1000);
	click("//a[@has-root-permission='estimateReports']");
	
	Thread.sleep(2000);
	click("(//a[@has-permission=\"Basicestimatereports,readaccess\"])[1]");
	Thread.sleep(6000);
	type("//input[@data-ng-model='activeTag.value_label']", "Date created");
	
	click("//a[text()='Date created']"); 
	
	click("(//a[@ng-click='selectRange(dateFilterOption)'])[1]");
	Thread.sleep(2000);
	click("(//a[text()='Apply filters'])[2]");
	Thread.sleep(4000);
	int xpathCount= driver.findElements(By.xpath("//span[@data-column='Estimate Status']")).size();
	System.out.println(xpathCount);
	Thread.sleep(3000);
	String status = driver.findElement(By.xpath("(//span[@data-column='Estimate Status'])["+xpathCount+"]")).getText();
	Thread.sleep(2000);
	System.out.println(status);
	if (status == "ongoing")
	{
		logger.log(Status.PASS, "Status in Report is fine as Estimate Status");
		System.out.println("Ongoing status is fine");
	}
	else
	{
		logger.log(Status.FAIL, "Status in Report is not fine as Estimate Status");
	}
	Thread.sleep(2000);
	driver.get(temp);
	Thread.sleep(4000);
	click("//a[@ng-if='!advanced_estimate']");
	
	Thread.sleep(2000);
	click("//span[text()='Add line items to estimate']");
	
	click("(//input[@class='inline-checkbox ng-scope'])[1]");
	
	click("(//input[@class='inline-checkbox ng-scope'])[2]");
	
	click("//a[@class='btn btn-primary ng-scope']");
	Thread.sleep(2000);
	click("#step-7-text");
	Thread.sleep(3000);
	
	click("//span[text()='Send to customer']");
	
	Thread.sleep(4000);
	click("//a[text()='Email estimate']");
	Thread.sleep(2000);
	
	selectdropdown("//select[@ng-model='email.selected_recipient_address']", "ranjit@commusoft.co.uk");
	
	click("(//a[@ng-click='sendEmail()'])[2]");
	Thread.sleep(2000);
	
	Thread.sleep(3000);
	click("//a[text()='Reporting']");
	Thread.sleep(6000);
	click("//a[@id='side-bar']");
	Thread.sleep(1000);
	click("//a[@has-root-permission='estimateReports']");
	
	Thread.sleep(2000);
	click("(//a[@has-permission=\"Basicestimatereports,readaccess\"])[1]");
	Thread.sleep(6000);
	type("//input[@data-ng-model='activeTag.value_label']", "Date created");
	
	click("//a[text()='Date created']"); 
	
	click("(//a[@ng-click='selectRange(dateFilterOption)'])[1]");
	Thread.sleep(2000);
	click("(//a[text()='Apply filters'])[2]");
	Thread.sleep(4000);
//	int xpathCount= driver.findElements(By.xpath("//span[@data-column='Estimate Status']")).size();
//	System.out.println(xpathCount);
	Thread.sleep(3000);
	String status1 = driver.findElement(By.xpath("(//span[@data-column='Estimate Status'])["+xpathCount+"]")).getText();
	Thread.sleep(2000);
	System.out.println(status1);
	if (status1.startsWith("waiting"))
	{
		logger.log(Status.PASS, "Status in Report is fine as Estimate Status");
		System.out.println("waiting for customer status is fine");
	}else
	{
		logger.log(Status.FAIL, "Status in Report is not fine as Estimate Status");
		System.out.println("Change");
	}
	Thread.sleep(2000);
	driver.get(temp);
	Thread.sleep(4000);
		
	click("(//span[text()='Accept / reject'])[1]");
	
	click("//input[@ng-checked='option.estimate_option_allow_check === true']");
	
	click("//button[@ng-click='estimateReject(estimate_options)']");
	Thread.sleep(4000);
	
	selectdropdown("//select[@required='required']", "Too expensive");
	
	type("#confirm_delete_input","REJECT");
	
	click("//button[@id='delete-button']");
	Thread.sleep(3000);
//	driver.get(customerurl);
	
	Thread.sleep(3000);
	click("//a[text()='Reporting']");
	Thread.sleep(6000);
	click("//a[@id='side-bar']");
	Thread.sleep(1000);
	click("//a[@has-root-permission='estimateReports']");
	
	Thread.sleep(2000);
	click("(//a[contains(text(),'Estimates')])[2]");
	Thread.sleep(6000);
	type("//input[@data-ng-model='activeTag.value_label']", "Date created");
	
	click("//a[text()='Date created']"); 
	
	Thread.sleep(2000);
	click("(//a[@ng-click='selectRange(dateFilterOption)'])[1]");
	Thread.sleep(2000);
	click("(//a[text()='Apply filters'])[2]");
	Thread.sleep(4000);
//	int xpathCount= driver.findElements(By.xpath("//span[@data-column='Estimate Status']")).size();
//	System.out.println(xpathCount);
	Thread.sleep(3000);
	String status2 = driver.findElement(By.xpath("(//span[@data-column='Estimate Status'])["+xpathCount+"]")).getText();
	Thread.sleep(2000);
	System.out.println(status2);
	if (status2.contains("rejected"))
	{
		logger.log(Status.PASS, "Status in Report is fine as Estimate Status");
		System.out.println("rejected is fine");
	}else
	{
		logger.log(Status.FAIL, "Status in Report is not fine as Estimate Status");
		System.out.println("Change- accept");
	}
	
	
	
}
	@Test(priority = 60)
	public  void EstimateStatusCheck_1() throws InterruptedException, IOException
	{
		System.out.println("Rathiga");
	}
	
}
