package genaricUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of methods related to propertyFile
 */
public class PropertyFileUtility {
	/**
	 * This Methods is used to read Data from property file provided key
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String toReadDataFromPropertyFile(String key)throws IOException{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
		
		
}
	
}
