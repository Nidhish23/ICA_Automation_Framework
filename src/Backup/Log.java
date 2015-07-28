package Backup;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

private static Logger _logger;
private static final String fileName = "Log";
private static final String dateAndTimeFormat = "MM-dd-yyyy_hh.mm.ss";
private static final String logProperttFilePath = "./Log4j.properties";

static {
    /**
     * This is the static block which appends the log file name with the
     * timestamp to make it unique
     */
    try {
       // String dateTime =Common.GetDate();
        String FileName = fileName + "-" + dateTime + ".log";
        File file = new File("Log/" + FileName);
         
        if (file.createNewFile()) {
            Properties props = new Properties();
            props.load(new FileInputStream(logProperttFilePath));
            props.setProperty("log4j.appender.File.File", "Log/"
                    + FileName);
            LogManager.resetConfiguration();
            PropertyConfigurator.configure(props);
            System.out.println("Property log4j.appender.File.File = logs/"
                    + FileName);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
        System.out.print("IO Exception in static method of Logger Class. "
                + ex.getMessage());
        System.exit(-1);
    }
    
}

/**
 * This method creates instance of the Logger class coming from log4j jar by
 * implementing a singelton
 * 
 * @return _logger - new instance if no instance exist else an existing
 *         instance if the method is invoked previously
 */
public static Logger createLogger() 
{
    if (_logger == null) {
        _logger = LogManager.getLogger(Log.class);
        return _logger;
    } else
        return _logger;
}
public static void startTestCase(String sTestCaseName)
{
	 
	_logger.info("****************************************************************************************");
 
	_logger.info("****************************************************************************************");
 
	_logger.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
 
	_logger.info("****************************************************************************************");
 
	_logger.info("****************************************************************************************");
 
	}
 
	//This is to print log for the ending of the test case
 
 public static void endTestCase(String sTestCaseName){
 
	 _logger.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
 
	 _logger.info("X");
 
	 _logger.info("X");
 
	 _logger.info("X");
 
	 _logger.info("X");
 
	}
 public static void info(String message) {
	 
		Log.info(message);

		}

public static void warn(String message) {

 Log.warn(message);

	}

public static void error(String message) {

 Log.error(message);

	}

public static void fatal(String message) {

 Log.fatal(message);

	}

public static void debug(String message) {

 Log.debug(message);

	}

}