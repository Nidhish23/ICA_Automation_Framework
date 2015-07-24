// <summary>
//     Locator Object Class (Locator Object)
// </summary>
// <revision>
//     Author:	Nidhish Jain
//     Date:	07/14/2015		Action: Created
// </revision>

package test.Core;

import org.openqa.selenium.*;

public class LocatorObject {

	
	public  String objectValue;
	public String objectDescription;
	By locatorValue ;
	//Selenium Locator object Identifier 
	public static String ID="ID";
	public 	static String CSS="CSS";
	public static String XPATH="XPATH";
	public static String LINKTEXT="LINKTEXT";
	public static String CLASS="CLASS";
	public 	static String NAME="NAME";
	public static String TAGNAME="TAGNAME";
	
	
	//public LocatorObject() {
		// TODO Auto-generated constructor stub
	//}
	public LocatorObject(String object,String LocatorDescription,String locatorType) 
	{
		this.objectValue=object;
		this.locatorValue= GetLocatorObject(object,locatorType);
		   this.objectDescription=LocatorDescription;
	}
	
	
	//Method to identified the locator object type
	public By GetLocatorObject(String locator,String locatorType)
	{
				
		 switch (locatorType) {
	        case "ID":
	        	locatorValue = By.id(locator);
	            break;
	        case "CSS":
	        	locatorValue =By.cssSelector(locator);
	            break;
	        case "XPATH":
	        	locatorValue=By.xpath(locator);
	         break;
	         
	        case "LINKTEXT":
	        	locatorValue= By.linkText(locator);
	         break;
	         
	        case "CLASS":
	        	locatorValue =By.className(locator);
	         break;
	        case "NAME":
	        	locatorValue =By.name(locator);
	         break;
	        case "TAGNAME":
	        	locatorValue=By.tagName(locator);
	         break;
	         
	    }
		return locatorValue;
	}
	
	public LocatorObject Replace(String number)
	{
		 objectValue= objectValue.replace("[*]",number);
		  return this;
	}
	}
	
	

