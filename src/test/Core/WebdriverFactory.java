// <summary>
//    Webdriver Factory
// </summary>
// <revision>
//     Author:	Nidhish Jain
//     Date:	07/14/2015		Action: Created
// </revision>
package test.Core;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebdriverFactory {
	
	public static WebDriver driver;
	public static DesiredCapabilities dc;
	 String strUserAgent;
	 ChromeOptions option = new ChromeOptions();
	 
	 public WebDriver getDriver(String browser,String server,String port)
	 {	
		  switch (browser) {
        case "chrome":
        	System.setProperty("webdriver.chrome.driver", "Drivers/chromeDriver.exe");
        	dc= DesiredCapabilities.chrome();
        		dc.isJavascriptEnabled();
        	//driver=new ChromeDriver(dc);
        	break;
        case "firefox":
        	dc=DesiredCapabilities.firefox();
        	dc.isJavascriptEnabled();
        	//dc.setBrowserName("Firefox");
        	//driver=new FirefoxDriver(dc);
            break;
        
        case "iExplorer":
        	
        	dc=DesiredCapabilities.internetExplorer();
        	dc.isJavascriptEnabled();
        	//dc.setBrowserName("iExplorer");
        	//driver=new InternetExplorerDriver(dc);
            break;
         case "safari":
        	
        	dc=DesiredCapabilities.safari();
        	dc.isJavascriptEnabled();
        	//dc.setBrowserName("iExplorer");
        	//driver=new InternetExplorerDriver(dc);
            break;
         case "iPhone":
         	
        	  strUserAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/600.1.3 (KHTML, like Gecko) Version/8.0 Mobile/12A4345d Safari/600.1.4";
              option.addArguments("--user-agent=" + strUserAgent);
             // dc.setCapability("screenResolution", "375x667");
              dc = DesiredCapabilities.chrome();
              dc.setCapability(ChromeOptions.CAPABILITY , option);
             break; 
         case "iPad":
          	
        	  strUserAgent = "Mozilla/5.0 (iPad; CPU OS 7_0 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53";
              option.addArguments("--user-agent=" + strUserAgent);
             // dc.setCapability("screenResolution", "375x667");
              dc = DesiredCapabilities.chrome();
              dc.setCapability(ChromeOptions.CAPABILITY , option);
             break; 
                  
    }
		  try {
			driver = new RemoteWebDriver(new URL("http://"+server+":"+port+"/wd/hub"), dc);
					
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  // driver=new WebDriver(dc); 
	return driver;
   
  
		}
	 
}

