package test.Core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Log extends TestListenerAdapter {
	
	public String fileName;
	public String messages;
	static Action Action =new Action();
	
	@Override
	public void onTestStart(ITestResult tr) {
		log("Test Started :"+ tr.getName());
		Action.DeleteAllCookies();
	}

	@Override
	public void onTestSuccess(ITestResult tr) {

		log("Test '" + tr.getName() + "' PASSED");

		// This will print the class name in which the method is present
		log(tr.getTestClass());

		// This will print the priority of the method.
		// If the priority is not defined it will print the default priority as
		// 'o'
		log("Priority of this method is " + tr.getMethod().getPriority());

		System.out.println("......FINISH.....");
		Action.DeleteAllCookies();
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		
		log("Test '" + tr.getName() + "' FAILED");
		log("Priority of this method is " + tr.getMethod().getPriority());
		System.out.println(".....");
		Action.TakeScreenshot(tr.getName());
		Action.DeleteAllCookies();
		tr.getStatus();
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		log("Test '" + tr.getName() + "' SKIPPED");
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
	fileName=Common.GetLocationPath()+"\\Log"+"\\"+Common.GetDate()+".txt";
	File file = new File(fileName);
	
	try {
		file.createNewFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return fileName;
}

public void WriteToLogFile(String messageLog)
{
	
	String message = null;
	//message.concat(messageLog);
	
	//FileWriter fw = null;
	//try {
	//	fw = new FileWriter(fileName);
	//} catch (IOException e) {
		// TODO Auto-generated catch block
	//	e.printStackTrace();
	//}
  //  BufferedWriter bw = new BufferedWriter(fw);
  //
	//	e.printStackTrace();
	//}
  //  try {
	//	bw.close();
//	} catch (IOException e) {
		// TODO Auto-generated catch block
	//	e.printStackTrace();
//	}
 //   return this;
}

}

	
