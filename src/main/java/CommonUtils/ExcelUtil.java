package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public String getdatafromExcel(String sheetname, int rownum, int cellnum)
			throws EncryptedDocumentException, IOException {

		FileInputStream file01 = new FileInputStream("src\\test\\resources\\Home.xlsx");
		Workbook work = WorkbookFactory.create(file01);
		String value = work.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;
	}

}
