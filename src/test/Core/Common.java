package test.Core;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

public class Common {
	
	public String locationpath;
	
	public static String  GetLocationPath()
	{
		return new File("").getAbsolutePath();
	}
	
public static String GetDate()

{
	Calendar dt = Calendar.getInstance();
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	return dateFormat.format(dt.getTime());
}

public static void CreateDirectory(String directoryName)
{
  File theDir = new File(directoryName);
 
  // if the directory does not exist, create it
  if (!theDir.exists())
  {
    theDir.mkdir();
  }
}
  public static void CopyDirectory(String source,String destination)
  {
    File sourceFile = new File(source);
    File destinationFile= new File(destination);
    
   
    // if the directory does not exist, create it
    
    try {
		FileUtils.copyDirectory(sourceFile, destinationFile);
		//FileUtils.deleteDirectory(sourceFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
    }
  }
  
  public static String GetLogReportFolderLocation()
  {
	 String strfoldername=Common.GetLocationPath()+"\\Log\\"+Common.GetDate();
		 		  
		  if (!new File(strfoldername).exists())
		  {
		    new File(strfoldername).mkdir();
		 
		  }
		  else 
		  {
			  for (int i=1;i<20;i++)
			  {
				
				  if(!new File(strfoldername+"_"+i).exists())
				  {
					  strfoldername=strfoldername+"_"+i;
					  new File(strfoldername).mkdir();
					  break;
				  }
			  }
		  }
	  
	  return strfoldername;
  }
  public static void DeleteDirectory()
  {
	  try {
		FileUtils.deleteDirectory(new File(GetLocationPath()+"\\test-output\\"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  }


