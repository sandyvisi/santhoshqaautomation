package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderCucumber {

	static String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "vinothQaAutomation.xlsx";

	static File excelFile = new File(filePath);

	public static Map<String, String> getCellData(String sheetName, String testCaseID)
			throws EncryptedDocumentException, IOException {
		Map<String, String> data = new LinkedHashMap<>();

		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet(sheetName);

		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		int rowCount = sheet.getPhysicalNumberOfRows();

		for (int a = 1; a < rowCount; a++) {

			String tcId = sheet.getRow(a).getCell(0).toString();

			if (tcId.equals(testCaseID))

				for (int b = 0; b < colCount; b++) {
					String key = sheet.getRow(0).getCell(b).toString();
					String value = sheet.getRow(a).getCell(b).toString();
					data.put(key, value);

				}
		}
		wb.close();
		fis.close();
		return data;
	}
}
