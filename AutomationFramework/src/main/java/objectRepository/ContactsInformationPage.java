package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInformationPage {
	public WebElement getContactsHeader() {
		return contactsHeader;
	}

	public ContactsInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactsHeader;
	
	
}