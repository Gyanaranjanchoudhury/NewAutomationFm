package contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genaricUtility.BaseClass;
import genaricUtility.ExcelFileUtility;
import objectRepository.ContactsInformationPage;
import objectRepository.ContactsPage;
import objectRepository.CreateContactPage;
import objectRepository.HomePage;
@Listeners(genaricUtility.ListenersImplementations .class)
public class ToCreateContactTest extends BaseClass{
@Test(groups = "Smoke")
public void toCreateContact_001() throws EncryptedDocumentException, IOException
{
	HomePage hp=new HomePage(driver);
	hp.getContacts().click();
	ContactsPage cp= new ContactsPage(driver);
	cp.getCreateContactIcon().click();
	CreateContactPage ccp=new CreateContactPage(driver);
	ExcelFileUtility eutil=new ExcelFileUtility();
	String LASTNAME = eutil.toReadDataFromExcel("Contact", 1, 2);
	ccp.getLastnameTextField().sendKeys(LASTNAME);
	ccp.getSaveButton().click();
	//Fail
	Assert.fail();															//Listeners
	ContactsInformationPage cip=new ContactsInformationPage(driver);
	String lastname=cip.getContactsHeader().getText();
	Assert.assertTrue(true, lastname);
	
}
}
