package organizationTest;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genaricUtility.BaseClass;
import genaricUtility.ExcelFileUtility;
import genaricUtility.WebDriverUtility;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;
@Listeners(genaricUtility.ListenersImplementations .class)
public class ToCreateOrgWithIndustryTest extends BaseClass{
	@Test(groups = "Regression")
	public void toCreateOrg_003() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getOrganizations().click();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getLookupimgorg().click();
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		ExcelFileUtility eutil = new ExcelFileUtility();
		Random r = new Random();
		int random = r.nextInt(1000);
		String ORGNAME = eutil.toReadDataFromExcel("Organization", 1, 2);
		cop.getOrgname().sendKeys(ORGNAME + random);
		
        WebDriverUtility wutil = new WebDriverUtility();
		wutil.toHandleDropdown("Chemicals", cop.getIndustryDropdown());
		cop.getSaveorg().click();
		//Assert.fail();														//Listeners
		
		OrganizationInformationPage oo = new OrganizationInformationPage(driver);
		String	orgname= oo.getOrginfo().getText();
	
		Assert.assertTrue(orgname.contains(ORGNAME));
}
}
