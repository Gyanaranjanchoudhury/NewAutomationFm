package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
		public WebElement getContacts() {
		return contacts;
	}

	public WebElement getAdministration() {
		return administration;
	}

	public WebElement getOrganizations() {
		return organizations;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

		//constructor
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver,this);
			}
		
		@FindBy(linkText="Contacts")
		private WebElement contacts;

		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement administration;

		@FindBy(linkText = "Organizations")
		private WebElement organizations;
		
		@FindBy(linkText = "Sign Out")
		private WebElement signoutLink ;
		

}
