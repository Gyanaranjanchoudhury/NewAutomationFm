package practics;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ToCreateOrganizationEnergy {

	public static void main(String[] args) {
		//Step-1 Launch Browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
								
				//Step-2 Login to application with valid credential
				driver.get("http://localhost:8888/");
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("password");
				driver.findElement(By.id("submitButton")).click();
						
				//Step-3 Navigate to Oganisation link
				driver.findElement(By.linkText("Organizations")).click();
						
				//Step-4 Click on create Organisation look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
						
				//Step-5 Create Organisation with manadatory field
				Random r=new Random();
				int randomValue = r.nextInt(1000);
				driver.findElement(By.name("accountname")).sendKeys("Grc"+randomValue);
				
				//Step-6 Select "Energy" in industry dropdown
				WebElement industry = driver.findElement(By.name("industry"));
				
				Select energy = new Select(industry);
				energy.selectByValue("Energy");
				
				//Step-7 Select "Customer" in Type dropdown
				WebElement type = driver.findElement(By.name("accounttype"));
				
				Select customer = new Select (type);
				customer.selectByValue("Customer");
				
				//Step-8 Save and Verify
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		        String organisationname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				
				if (organisationname.contains("Grc"+randomValue)) {
					System.out.println(organisationname +"... Passed");
				}else {
					System.out.println(organisationname + "...Failed");
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
