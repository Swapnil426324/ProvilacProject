package com.provilac.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] excelRead(String fileName, String sheetName) throws Exception {
		//"C:\\Users\\SwapnilAlaskar\\Desktop\\Test Data\\LoginData.xlsx"

		DataFormatter formatter = new DataFormatter();
		String path = System.getProperty("user.dir")+"/src/test/resources/"+fileName+".xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(path);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();

		String str[][] = new String[rowCount][colCount];

		for (int i = 0; i < rowCount; i++) {
			XSSFRow row = sheet.getRow(i + 1);

			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				str[i][j] = formatter.formatCellValue(cell);
			}
		}
		workbook.close();
		return str;
	}

}
