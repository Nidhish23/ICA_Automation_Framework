package Backup;

import test.Core.ReadProperties;


public  class Configuration {
	
	static ReadProperties rp= new ReadProperties();
	
	public static String ServerName()
	{
		return rp.Properties("ServerURL");
	
	}
	
	//public static String getBrowser()
//	{
		//return rp.Properties("Browsername");
	//}

	public static  String browser() 
	{
		// TODO Auto-generated method stub
		return rp.Properties("Browsername");
	}
	
	
}
