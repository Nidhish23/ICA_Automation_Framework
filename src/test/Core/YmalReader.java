// <summary>
//     YMAL Reader Classs
// </summary>
// <revision>
//     Author:	Nidhish Jain
//     Date:	07/14/2015		Action: Created
// </revision>


package test.Core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class  YmalReader 
{
	
	@SuppressWarnings({ "rawtypes" })
	public Map YmalRead(String key,String fileLocation)
	{
	
	 Yaml reader = new Yaml();

        InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(fileLocation));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Map map = (Map) reader.load(inputStream);
         Map storage = (Map)map.get(key);
   return storage;
	}
	}

