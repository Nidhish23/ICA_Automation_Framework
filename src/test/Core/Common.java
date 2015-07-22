package test.Core;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
}

