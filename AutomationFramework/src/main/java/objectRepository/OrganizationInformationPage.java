package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {

	public WebElement getOrginfo() {
		return orginfo;
	}

	public	OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orginfo;
}