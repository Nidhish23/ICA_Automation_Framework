// <summary>
//     Test Base 
// </summary>
// <revision>
//     Author:	Nidhish Jain
//     Date:	07/14/2015		Action: Created
// </revision>

package test.Core;

import java.io.File;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.testng.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;




import test.Core.*;
public  class TestBase {
	
	 
	public static  WebDriver driver=null;
	static WebdriverFactory   driverFactory = new WebdriverFactory();
	  public static StringBuffer verificationErrors = new StringBuffer();
	 static Log log;
	  Action Action ;
	 
	  @BeforeSuite
	  public static void BeforeSuit()
	  {
		Common.CreateDirectory(Common.GetLocationPath()+"\\Log\\"+Common.GetDate());
		 log=new Log("Log file Created");
	      
		
	  }
	
	@BeforeTest
	@Parameters({"Browser"})
	 

	public static void beforeTest(@Optional String Browser) {
		
		try
		{
		if (Browser==null)
		{
		
		driver = driverFactory.getDriver(ReadProperties.Properties("Browsername"),ReadProperties.Properties("SeleniumServer"),ReadProperties.Properties("ServerPort"));
		}
		else
		{
		driver = driverFactory.getDriver(Browser,ReadProperties.Properties("SeleniumServer"),ReadProperties.Properties("ServerPort"));
		}
		 new Action(driver);
		// System.out.println(driver);
		// driver.manage().window().maximize(); 
		 if(Browser.contains("iPhone"))
		 {
			 driver.manage().window().setSize(new Dimension(375,667));
		 }
		 else if(Browser.contains("iPad"))
		 {
			 driver.manage().window().setSize(new Dimension(667,375));
		 }
		 else
		 {
			 driver.manage().window().maximize(); 
		 }
			 
		 log.Info("Test case started");
		}
		catch(Exception ex)
		{
			log.Error(ex.getMessage());
		}
		
	  }
	  
	  @AfterTest
	  public static void afterTest()
	  {
		  driver.manage().deleteAllCookies();
		  driver.quit();
		  // String verificationErrorString = Log2.verificationErrors.toString();
		   // if (!"".equals(verificationErrorString)) {
		   //   Assert.fail(verificationErrorString);
		  //  }
	  }
	  @AfterSuite
	  public static void AfterSuit()
	  {
		log.GenerateReportsLog();
	      
		
	  }
	  

	  }
	

