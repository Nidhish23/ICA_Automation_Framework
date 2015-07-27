// <summary>
//     Action Class (Selenium commands)
// </summary>
// <revision>
//     Author:	Nidhish Jain
//     Date:	07/14/2015		Action: Created
// </revision>
package test.Core;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import test.Core.Log;




import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.apache.james.mime4j.field.datetime.DateTime;
import org.apache.xml.utils.StringComparable;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;




import test.Core.*;
public class Action {

	public static  WebDriver driver;
	public  WebElement element;
	
	//public Actions act = new Actions(driver);
	
	By by;
	private WebDriverWait WebDriverWait;
	Log log ;
	//Paramaterized constuctor to assign the driver instance 
	public Action(WebDriver iDriver)
	{
	driver=iDriver;
   	}
	//Constructor
	public Action() {
		// TODO Auto-generated constructor stub
		
			}

// <summary>
//  Open URL
//</summary>
//Paramters: URL 	
//<revision>
//  Author:	Nidhish Jain
//  Date:	07/14/2015		Action: Created
//</revision>
	public  Action OpenURl(String url)
	{
		System.out.println(url);
		driver.navigate().to(url);
		return this;
	}
	
// <summary>
//  Enter the text
//</summary>
//Paramters: URL 	
//<revision>
//  Author:	Nidhish Jain
//  Date:	07/14/2015		Action: Created
//</revision>
	public  Action enterText(LocatorObject locator,String text)
	{
		driverwait(10);
		FindElement(locator).sendKeys(text);
		return this;
	}
	
// <summary>
//  Enter the text
//</summary>
//Paramters: URL 	
//<revision>
//  Author:	Nidhish Jain
//  Date:	07/14/2015		Action: Created
//</revision>
	public  Action Click(LocatorObject locator)
	{
		driverwait(10);
		FindElement(locator).click();
		return this;
	}
	
	// <summary>
//  Wait
//</summary>
//Paramters: URL 	
//<revision>
//  Author:	Nidhish Jain
//  Date:	07/14/2015		Action: Created
//</revision>
	public  Action driverwait(long time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		return this;
	}
	// <summary>
//  Verify Element Present
//</summary>
//Paramters: URL 	
//<revision>
//  Author:	Nidhish Jain
//  Date:	07/14/2015		Action: Created
//</revision>
	public Action verifyElementPresent(LocatorObject locator)
	{
	
		// element.findElement(By.id(locator));
		 if (IsElementPresent(locator))
		 {
			 ActionLog(locator.objectDescription + "find successfully");
	}
		 else
		 {
			 AssertFail(locator.objectDescription + "Element not present on the page");
		 }
			return this; 
}

// <summary>
//  Verify Element Present
//</summary>
//Paramters: URL 	
//<revision>
//  Author:	Nidhish Jain
//  Date:	07/21/2015		Action: Created
//</revision>
	public boolean IsElementPresent(LocatorObject locator)
	{
	
		// element.findElement(By.id(locator));
		 if (FindElement(locator).isDisplayed())
		 {
			 ActionLog(locator.objectDescription + "element present");
			 return true ;
	}
		 else
		 {
			 ActionLog(locator.objectDescription + "element not present");
			 return false;
			
		 }
			
}
	
	/// <summary>
    ///    wait for text present in element
    /// </summary>
    /// <revision>
    ///     Author:	Nidhish Jain
    ///     Date:	07/21/2015		Action: Created
    /// </revision>
    /// <returns></returns>
    public Action WaitForTextPresentInElement(LocatorObject locator, String text)
    {
    	IsTextPresentInElement(locator,text);
    	

        return this;
    }
	
    
  /// <summary>
    ///    wait for text present in element
    /// </summary>
    /// <revision>
    ///     Author:	Nidhish Jain
    ///     Date:	07/21/2015		Action: Created
    /// </revision>
    /// <returns></returns>
    public boolean IsTextPresentInElement(LocatorObject locator, String text)
    {
        int flag = 0;

        for (int sec = 0; sec < 15; sec++)
        {
            if (GetText(locator).contains(text))
            {
                flag = 1;
                break;
            }
        }

        if (flag == 0)
        {
            ActionLog(text + " not found in the locator " + locator.objectDescription);
            return false;
            
        }
        else
        {
            ActionLog(text + " verified successfully in the locator " + locator.objectDescription);
            return true;
        }

        
    }
    
    
  /// <summary>
    ///     Verifying the text present in element
    /// </summary>
    /// <revision>
    ///     Author:	Nidhish Jain
    ///     Date:	07/21/2015		Action: Created
    /// </revision>
    /// <returns></returns>
    public Action VerifyTextPresentInElement(LocatorObject locator, String textToVerify)
    {
        WaitForTextPresentInElement(locator, textToVerify);

        return this;
    }
    
 // <summary>
//  Is text present on page
//</summary>
//<revision>
//  Author:	Nidhish Jain
//  Date:	07/21/2015		Action: Created
//</revision>
    
    public boolean IsTextPresent(String text)
    {        
            try
            {
            	return(driver.getPageSource().contains(text))  ;             	
            	
            }
            catch (Exception ex)
            {
                AssertFail(ex.getMessage());

                return false;
            }
        }
 // <summary>
//  Is text present on page
//</summary>
//<revision>
//  Author:	Nidhish Jain
//  Date:	07/21/2015		Action: Created
//</revision>
    
    public Action VerifyTextPresent(String text)
    {        
        WaitForTextPresent(text);
        	return this;
        }  
   
    
 // <summary>
//  Is text present on page
//</summary>
//<revision>
//  Author:	Nidhish Jain
//  Date:	07/21/2015		Action: Created
//</revision>
    
    public Action WaitForTextPresent(String text)
    {        
    	int flag = 0;

        for (int sec = 0; sec < 20; sec++)
        {
            if (IsTextPresent(text))
            {
                flag = 1;
                break;
            }
        }

        if (flag == 0)
        {
            AssertFail( text + " Not found in page ");
        }
        else
        {
            ActionLog(text + " verified successfully on page" );
        }

        return this;
        }
    
// <summary>
//  Find Element
//</summary>
//Paramters: URL 	
//<revision>
//  Author:	Nidhish Jain
//  Date:	07/14/2015		Action: Created
//</revision>
	
	public WebElement FindElement(LocatorObject locator) 
	{
		//	try
		//{
		//	WebDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(locator.locatorValue)));	
		//	}
		// catch (org.openqa.selenium.ElementNotVisibleException ex)
		//  {
            //Handling exception if the element is not visible
		//    AssertFail("ElementNotVisibleException: " + locator.objectDescription +
		//         " Not Visible in the current Page. " + ex.getMessage());
                       //  }
				
                       //  catch (org.openqa.selenium.NoSuchElementException ex)
                       //  {
            //Handle exception if the element is not found 
                       //    AssertFail("NoSuchElementException: The Object " + locator.objectDescription + " not found! " + ex.getMessage());
                       //  }
                       //  catch (org.openqa.selenium.StaleElementReferenceException ex)
                       //   {
		//	WebDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(locator.locatorValue)));
		//    return driver.findElement(locator.locatorValue);
		//     }
        //Handle any unexpected exception 
       		
		return driver.findElement(locator.locatorValue);
		
	}
	
	 public Action ActionLog(String message)
     {
         System.out.println(message);
       //  log.WriteToLogFile(message);
        

         return this;
     }

public void AssertFail(String message)
{
    String tempMessage = "|| Expected Result : " + " ---|| Actual Result: " + message + " || ";
   System.out.println(tempMessage);
 Log.Error(message);
   //log.WriteToLogFile(tempMessage);
    
    try {
		throw new Exception(tempMessage);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

// <summary>
//GetText:get text of a locator object
//</summary>
//Paramters: URL 	
//<revision>
//Author:	Nidhish Jain
//Date:	07/14/2015		Action: Created
//</revision>
public String GetText(LocatorObject locator)
{
    String value = null;

     value= FindElement(locator).getText();
   
    return value;
}

/// <summary>
///     To Right Click on any particular object locator
/// </summary>
/// <revision>
///     Author:	Nidhish Jain
///     Date:	03/21/2015		Action: Created
/// </revision>
/// <returns></returns>
public Action RightClick(LocatorObject locator)
{
    
 new org.openqa.selenium.interactions.Actions(driver).contextClick(FindElement(locator)).build().perform();
   

    return this;
}

/// <summary>
///    Clear text field
/// </summary>
/// <revision>
///     Author:	Nidhish Jain
///     Date:	03/21/2015		Action: Created
/// </revision>
/// <returns></returns>

public Action ClearText(LocatorObject locator)
{
   FindElement(locator).clear();
	return this;
}

/// <summary>
///     To Right Click on any particular object locator
/// </summary>
/// <revision>
///     Author:	Nidhish Jain
///     Date:	03/21/2015		Action: Created
/// </revision>
/// <returns></returns>

public Action SelectRadio(LocatorObject locator)
{
   element = FindElement(locator);

    element.click();
    return this;
}

/// <summary>
///     SelectdropdrownValueByVisibleText
/// </summary>
/// <revision>
///     Author:	Nidhish Jain
///     Date:	03/21/2015		Action: Created
/// </revision>
/// <returns></returns>

public Action SelectdropdrownValueByVisibleText(LocatorObject locator,String Text)
{
	Select dropdown = new Select(FindElement(locator));
	dropdown.selectByVisibleText(Text);
	return this;
}

/// <summary>
///    SelectdropdrownValueByIndex
/// </summary>
/// <revision>
///     Author:	Nidhish Jain
///     Date:	03/21/2015		Action: Created
/// </revision>
/// <returns></returns>

public Action SelectdropdrownValueByIndex(LocatorObject locator,int index)
{
	Select dropdown = new Select(FindElement(locator));
	dropdown.selectByIndex(index);
	return this;
}

/// <summary>
///    SelectdropdrownValueByValue
/// </summary>
/// <revision>
///     Author:	Nidhish Jain
///     Date:	05/21/2015		Action: Created
/// </revision>
/// <returns></returns>

public Action SelectdropdrownValueByValue(LocatorObject locator,String value)
{
	Select dropdown = new Select(FindElement(locator));
	dropdown.selectByValue(value);
	return this;
}

/// <summary>
///    SelectdropdrownValueByValue
/// </summary>
/// <revision>
///     Author:	Nidhish Jain
///     Date:	05/21/2015		Action: Created
/// </revision>
/// <returns></returns>

public Action TakeScreenshot(String screenShotName)
{
	String location  = Common.GetLocationPath() +"\\test-output\\"+ Common.GetDate();
 Common.CreateDirectory(location);
	   
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destFile=new File(location+"\\"+screenShotName+".jpg");
	ActionLog("Failed Screenshot Saved at :"+location+"\\"+screenShotName+".jpg");
	try {
		FileUtils.copyFile(scrFile,destFile );
	} catch (IOException e) {
		// TODO Auto-generated catch block
	e.printStackTrace();
	}
    return this;
}


/// <summary>
///     To Delete all the cookies present in the browser
/// </summary>
/// <revision>
///     Author:	Nidhish Jain
///     Date:	21/07/2015		Action: Created
/// </revision>
public Action DeleteAllCookies()
{
    try
    {     
         driver.manage().deleteAllCookies();
                //if (driver instanceof InternetExplorerDriver)
             //   {
                 //   DeleteIECookies();
             // }
       
        ActionLog("Cookie deleted successfully");
    }
    catch (Exception ex)
    {
        ActionLog("Cookie deletion failed. " + ex.getMessage());
    }

    return this;
}

public boolean IsVisible(LocatorObject locator)
{
  if(driver.findElements(locator.locatorValue).size()>0)
  {
	return true;
  }
	else
	{
		return false;
	}
}
}





