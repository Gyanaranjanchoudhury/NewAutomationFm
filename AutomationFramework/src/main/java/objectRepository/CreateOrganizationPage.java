package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	public WebElement getTypeDropdown() {
		return TypeDropdown;
	}

	public void setTypeDropdown(WebElement typeDropdown) {
		TypeDropdown = typeDropdown;
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getSaveorg() {
		return saveorg;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
		}
	
		@FindBy(name="accountname")
		private WebElement orgname;

		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveorg;

		@FindBy(name="industry")
		private WebElement industryDropdown;
		
		@FindBy(name="accounttype")
		private WebElement TypeDropdown;

		
		}
