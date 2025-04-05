package genaricUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of methods related to Excel file
 */
public class ExcelFileUtility {
	/**
	 * This method is used to read data from excel file provided sheet name, row and cell
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
			public String toReadDataFromExcel(String sheetname, int row, int cell)throws EncryptedDocumentException,IOException{
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Copy of testDataVtiger.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			String value = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
			return value;
			
			
			
			
}

	
	}

	
