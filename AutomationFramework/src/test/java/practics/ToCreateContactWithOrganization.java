package practics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCreateContactWithOrganization {

	public static void main(String[] args) {
		//Step 1 :- Launch Browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		//Step 2 :-Login to application with valid credentials
				driver.get("http://localhost:8888/");
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("password");
				driver.findElement(By.id("submitButton")).click();
				
				// Step 3 :-Navigate to contact link
						driver.findElement(By.linkText("Contacts")).click();

						// Step 4 :- Click on create contact link up image
						driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
						
						//Step 5:Create Contact With Mandatory fields
						driver.findElement(By.name("lastname")).sendKeys("");

	}

}
