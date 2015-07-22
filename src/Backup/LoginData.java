// <summary>
//     LoginData
// </summary>
// <revision>
//     Author:	Nidhish Jain
//     Date:	07/14/2015		Action: Created
// </revision>


package Backup;
import java.util.Map; 

import test.Core.YmalReader;



public  class LoginData {
	
	
	public  String username;
	public  String password;
 	 static YmalReader reader = new YmalReader();
	
	@SuppressWarnings("rawtypes")
	
	public static LoginData Initialize(String key) 
	{
		 LoginData obj=new LoginData();
       Map map=  reader.YmalRead(key, "./TestData/login.yaml");
       obj.username= (String) map.get("UserName").toString();
       obj.password=  (String) map.get("Password").toString();
           
	return obj;
       
    }

	
	
	

}
