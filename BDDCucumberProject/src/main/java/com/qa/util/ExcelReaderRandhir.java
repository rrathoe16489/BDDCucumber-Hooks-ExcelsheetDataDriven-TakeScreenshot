package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderRandhir {

	public static List<HashMap<String, String>> readvaluefromExcelSheet(String sheetName) {
		List<HashMap<String, String>> mapDatasList = new ArrayList<HashMap<String, String>>();
		try {
			File excelLocation = new File("src/test/resources/excelSheet/ExcelValues for Amazon login.xlsx");
			//String sheetName = "LoginCred";
			FileInputStream f = new FileInputStream(excelLocation);
			Workbook w = new XSSFWorkbook(f);
			Sheet sheet = w.getSheet(sheetName);

			Row headerRow = sheet.getRow(0);
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> mapDatas = new HashMap<String, String>();
				for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);

					switch (currentCell.getCellType()) {

					case STRING:
						mapDatas.put(headerRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
						break;

					case NUMERIC:
						mapDatas.put(headerRow.getCell(j).getStringCellValue(),
								String.valueOf(currentCell.getNumericCellValue()));
						break;
					}

				}
				mapDatasList.add(mapDatas);
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}

		return mapDatasList;

	}

}
