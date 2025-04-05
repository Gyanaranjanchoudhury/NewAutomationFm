package practics;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genaricUtility.ExcelFileUtility;
import genaricUtility.PropertyFileUtility;
import genaricUtility.WebDriverUtility;

public class Ruf {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
PropertyFileUtility putil=new PropertyFileUtility();
ExcelFileUtility eutil=new ExcelFileUtility();
WebDriverUtility wutil=new WebDriverUtility();
String BROWSER = putil.toReadDataFromPropertyFile("browser");
WebDriver driver = null;
if(BROWSER.contains("chrome")) {
	driver=new ChromeDriver();
}else if(BROWSER.contains("edge")) {
	driver=new EdgeDriver();
}else if(BROWSER.contains("firefox")) {
	driver=new FirefoxDriver();
}
	}

}
