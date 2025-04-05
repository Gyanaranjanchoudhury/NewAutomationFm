package practics;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoscriptWithDDT {

	public static void main(String[] args) throws IOException {
		//To read data from properties file
		FileInputStream pfis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop = new Properties();
		prop.load(pfis);
		String BROWSER = prop.getProperty("browser");
		String URL= prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");

		//ToRead Data from Excel file
		FileInputStream efis = new FileInputStream(".\\src\\test\\resources\\testDataVtiger1.xlsx");
		Workbook wb =  WorkbookFactory.create(efis);
		String Lastname = wb.getSheet("Contact").getRow(1).getCell(2).toString();
		
		//Step 1:- Launch Browser
		WebDriver driver=null;
		if(BROWSER.equals("chrome")){
			driver=new ChromeDriver();
		}else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}else if (BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Step 2:- Login text
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		// Step 3 :-Navigate to contact link
		driver.findElement(By.linkText("Contacts")).click();
		
		// Step 4 :- Click on create contact link up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//Step 5:Create Contact With Mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(Lastname);
		
		// Step 6 :- Save and Verify
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				String lastname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (lastname.contains(Lastname)) {
					System.out.println(lastname + "---Passed");
				} else {
					System.out.println(lastname + "---Failed");
				}

				// Step 7 :- Logout the Application
				WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions action = new Actions(driver);
				action.moveToElement(logoutEle).perform();
				driver.findElement(By.linkText("Sign Out")).click();

				// Step 8 :-Close the Browser
				driver.quit();
				
	}

}
