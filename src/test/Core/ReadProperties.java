// <summary>
//     Read configuration properties
// </summary>
// <revision>
//     Author:	Nidhish Jain
//     Date:	07/14/2015		Action: Created
// </revision>


package test.Core;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
public class ReadProperties  {
 
    static Properties prop = new Properties();
    
 public static String Properties(String propertyName)	 
 {
	 
      	try {
			prop.load(new FileInputStream(Common.GetLocationPath()+"/config.properties"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	 return prop.getProperty(propertyName).toString(); 
 }
}