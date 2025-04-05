package practics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ToReadDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		//Create obj of Fis
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
//Create obj Of Properties File
Properties prop = new Properties();
//Call Methods
prop.load(fis);
String URL = prop.getProperty("url");
String USERNAME = prop.getProperty("username");
String PASSWORD = prop.getProperty("password");
prop.getProperty("browser");

	}

}
