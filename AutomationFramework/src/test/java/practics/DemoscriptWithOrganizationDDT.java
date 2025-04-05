package practics;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoscriptWithOrganizationDDT {

	public static void main(String[] args) throws IOException {
		//To read data from properties file
				FileInputStream pfis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
				Properties prop = new Properties();
				prop.load(pfis);
				String BROWSER = prop.getProperty("browser");
				String URL = prop.getProperty("url");
				String USERNAME = prop.getProperty("username");
				String PASSWORD = prop.getProperty("password");

				//ToRead Data from Excel file
				FileInputStream efis = new FileInputStream(".\\src\\test\\resources\\Copy of testDataVtiger.xlsx");
				Workbook wb =  WorkbookFactory.create(efis);
				String Lastname = wb.getSheet("Contact").getRow(1).getCell(2).toString();
				
				//Step 1:- Launch Browser
				WebDriver driver=null;
				if(BROWSER.equals("Chrome")) {
					driver=new ChromeDriver();
				}else if (BROWSER.equals("edge")) {
					driver=new EdgeDriver();
				}else if (BROWSER.equals("firefox")) {
					driver=new FirefoxDriver();
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				//Step 2:- Login textfild
				driver.get("URL");
				driver.findElement(By.name("user_name")).sendKeys("USERNAME");
				driver.findElement(By.name("user_password")).sendKeys("PASSWORD");
				driver.findElement(By.id("submitButton")).click();
				//Step 3:- Click on Organization link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step-4 Click on create Organisation look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step-5 Create Organisation with manadatory field
				Random r=new Random();
				int randomValue = r.nextInt(1000);
				driver.findElement(By.name("accountname")).sendKeys("Grc"+randomValue);
				
				
				//Step-6 Save and Verify
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				String organisationname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				
				if (organisationname.contains("Grc"+randomValue)) {
					System.out.println(organisationname +"...Passed");
				}else {
					System.out.println(organisationname +"...Failed");
					}
				
				//Step-7 Logout the appliocation
				WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				
				Actions action = new Actions (driver);
				action.moveToElement(logoutEle).perform();
				
				driver.findElement(By.linkText("Sign Out")).click();
				
				//Step-8 Close the browser
				driver.quit();
				
	}

}
