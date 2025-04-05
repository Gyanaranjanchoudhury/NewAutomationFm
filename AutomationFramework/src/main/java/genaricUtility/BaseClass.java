package genaricUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	PropertyFileUtility putil=new PropertyFileUtility();
	WebDriverUtility wutil= new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sDriver;
	@BeforeSuite(groups = {"Smoke","Regression"})
	public void bsConfig()
	{
		Reporter.log("---Database Connection Established---",true);
	}
	//@Parameters("browser")  //Only for Cross browser Testing
	//@BeforeTest  //Only for Cross browser Testing
	@BeforeClass(groups = {"Smoke","Regression"})
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		if (BROWSER.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.contains("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();
		}
		sDriver = driver;
		Reporter.log("Browser got Launched Sucessfully",true);
		wutil.toMaximize(driver);
		wutil.toWaitForElements(driver);
		driver.get(URL);
	}
	@BeforeMethod(groups = {"Smoke","Regression"})
	public void bmConfig() throws IOException
	{
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameTextfield().sendKeys(USERNAME);
		lp.getPasswordTextField().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		Reporter.log("Navigated to Vtiger HomePage Sucessfully",false);
	}
	@AfterMethod(groups = {"Smoke","Regression"})
	public void amConfig()
	{
		HomePage hp= new HomePage(driver);
		wutil.toMouseHover(driver, hp. getAdministration());
		hp.getSignoutLink().click();
		Reporter.log("Logged out Successfully",true);
	}
	@AfterClass(groups = {"Smoke","Regression"})
	public void acConfig()
	{
		Reporter.log("Browser got closed Successfully",true);
		driver.quit();
	}

	@AfterSuite(groups = {"Smoke","Regression"})
	public void asConfig()
	{
		Reporter.log("---Database Disconnected Sucessfully---",true);
}
}

