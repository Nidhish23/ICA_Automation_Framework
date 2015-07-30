package test.Core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class Log extends TestListenerAdapter {
	
	public String strfileName;
	public String strmessages;
	static Action Action =new Action();
	public  static Logger log;
	public String strfoldername;
	public Log(String name)
	{
		// configure log4j properties file
	PropertyConfigurator.configure("Log4j.properties");
	 log = Logger.getLogger(Log.class.getName());
	 strfoldername=Common.GetLocationPath()+"\\Log\\"+Common.GetDate();
	 
	}
	
	@Override
	public void onTestStart(ITestResult tr) {
		
		Info("****************************************************************************************");
		 
		Info("****************************************************************************************");
	 
		Info("$$$$$$$$$$$$$$                 "+tr.getName()+ "       $$$$$$$$$$$$$$$$$$$$$");
	 
		Info("****************************************************************************************");
	 
		Info("****************************************************************************************");
	 
		Action.DeleteAllCookies();
	}

      public Log()
      {
    	
      }
      
	@Override
	public void onTestSuccess(ITestResult tr) {

		Info("Test '" + tr.getName() + "' PASSED");
		

		// This will print the class name in which the method is present
				// This will print the priority of the method.
		// If the priority is not defined it will print the default priority as
		// 'o'
		

		System.out.println("..................................FINISH.......................................");
		Action.DeleteAllCookies();
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		
		Error("Test '" + tr.getName() + "' FAILED");
		System.out.println(".............................................................................");
		Action.TakeScreenshot(tr.getName());
		Action.DeleteAllCookies();
		
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		Info("Test '" + tr.getName() + "' SKIPPED");
		System.out.println(".....");
	   
	}

	private void log(String methodName) {
		System.out.println(methodName);
		
		//WriteToLogFile(methodName);
	}

	private void log(IClass testClass) {
		System.out.println(testClass);
		
		//WriteToLogFile(testClass.toString());
		
	}
	
		
//Create a log file for every run , if we re run the test cases on same day it will replace the file with latest log.
public String CreateLogFile()
{
	strfileName=Common.GetLocationPath()+"\\Log"+"\\"+Common.GetDate()+".txt";
	File file = new File(strfileName);
	
	try {
		file.createNewFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return strfileName;
}

public void GenerateReportsLog()
{
	
Common.CopyDirectory(Common.GetLocationPath()+"\\test-output\\",Common.GetLogReportFolderLocation());

}


public  void Info(String message) {
	 
	log.info(message);

	}

public void Warn(String message) {

log.warn(message);

}

public void Error(String message) {

log.error(message);

}

public  void fatal(String message) {

log.fatal(message);

}

public  void debug(String message) {

log.debug(message);

}





}

	
