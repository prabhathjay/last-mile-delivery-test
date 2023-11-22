package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static String projectPath = "C:/Users/Dell/git/LMD-testing-selenium/automation-dms";
	static XSSFWorkbook workbook;
	static XSSFSheet sheet = null;

	public ExcelUtils(String excelPath) {
		try {
			workbook = new XSSFWorkbook(projectPath+excelPath);
			sheet = workbook.getSheet("Worksheet");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int getRowCount() {
		int rowCount = sheet.getPhysicalNumberOfRows();
		//				System.out.println(rowCount);
		return rowCount;
	}

	public String getCellData(int rowNum, int colNum) {
		String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		//System.out.println(cellData);
		return cellData;
	}

}
