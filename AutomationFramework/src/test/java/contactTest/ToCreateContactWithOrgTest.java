package contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genaricUtility.BaseClass;
import genaricUtility.ExcelFileUtility;
import genaricUtility.WebDriverUtility;
import objectRepository.ContactsInformationPage;
import objectRepository.ContactsPage;
import objectRepository.CreateContactPage;
import objectRepository.HomePage;
@Listeners(genaricUtility.ListenersImplementations .class)
public class ToCreateContactWithOrgTest extends BaseClass {
	@Test

	public void ToCreateContactWithOrgTest__005() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getContacts().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactIcon().click();
		ExcelFileUtility eutil=new ExcelFileUtility();
		String LASTNAME = eutil.toReadDataFromExcel("contact", 1, 2);
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTextField().sendKeys(LASTNAME);
		ccp.getOrgplus().click();
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.toSwitchWindow(driver, "Accounts");
		driver.findElement(By.xpath("//a[text()='Grc']")).click();
		wutil.toSwitchWindow(driver, "contacts");
		//ContactsInformationPage ci = new ContactsInformationPage(driver);
		//String lastname = ci.getContactsHeader().getText();
		ccp.getSaveButton().click();
		Assert.fail();															//Listeners
		ContactsInformationPage cip = new ContactsInformationPage(driver);
		String Lastname = cip.getContactsHeader().getText();
		Assert.assertTrue(true, Lastname);
}
}
