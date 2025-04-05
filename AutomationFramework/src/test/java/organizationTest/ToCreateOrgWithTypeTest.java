package organizationTest;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genaricUtility.BaseClass;
import genaricUtility.ExcelFileUtility;
import genaricUtility.WebDriverUtility;
import objectRepository.CreateOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;

public class ToCreateOrgWithTypeTest extends BaseClass {
	@Test
	public void toCreateOrgWithTypeDropdown_004() throws EncryptedDocumentException, IOException {
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
		wutil.toHandleDropdown("Energy", cop.getIndustryDropdown());
		wutil.toHandleDropdown("Customer", cop.getTypeDropdown());		
		cop.getSaveorg().click();
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String orgname = oip.getOrginfo().getText();
		/*
	if (orgname.contains(ORGNAME)) {
			System.out.println(orgname + "---Passed");
		} else {
			System.out.println(orgname + "---Failed");

		}*/
	Assert.assertTrue(orgname.contains(ORGNAME));
	Reporter.log("Organization created with type dropdown successfully",true);

	}
}
