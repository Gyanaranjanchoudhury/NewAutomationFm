package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getLastnameTextField() {
		return lastnameTextField;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getOrgplus() {
		return orgplus;
	}
	@FindBy(name="lastname")
	private WebElement lastnameTextField;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy (xpath ="//img[@src='themes/softed/images/select.gif']")
	private WebElement orgplus;
	}