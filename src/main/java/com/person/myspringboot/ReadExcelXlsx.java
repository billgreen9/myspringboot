package com.person.myspringboot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelXlsx {

	public static void main(String[] args) throws IOException {
		List<String[]> list = getDataList("d:/files/test.xls");
		for (String[] str : list) {
			for (String it : str) {
				System.out.print(it + ",");
			}
			System.out.println();
		}
	}

	public static String[] getHeader(String file) throws IOException {
		Workbook book = null;
		book = getExcelWorkbook(file);
		Sheet sheet = book.getSheetAt(0);
		Row row = sheet.getRow(0);
		if (row != null) {
			String line[] = new String[row.getLastCellNum()];
			Cell cell = null;
			for (int j = 0; j <= line.length; j++) {
				cell = row.getCell(j);
				if (cell != null) {
					line[j] = getValue(cell);
				}
			}
			return line;
		}
		return null;
	}

	public static List<String[]> getDataList(String file) throws IOException {
		List<String[]> list = new ArrayList<>();
		Workbook book = null;
		book = getExcelWorkbook(file);
		Sheet sheet = book.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		for (int i = 0; i <= lastRowNum; i++) {
			Row row = null;
			row = sheet.getRow(i);
			if (row != null) {
				String line[] = new String[row.getLastCellNum()];
				Cell cell = null;
				for (int j = 0; j <= line.length; j++) {
					cell = row.getCell(j);
					if (cell != null) {
						line[j] = getValue(cell);
					}
				}
				list.add(line);
			}
		}
		return list;
	}

	private static String getValue(Cell hssfCell) {
		if (hssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			return String.valueOf(hssfCell.getNumericCellValue());
		} else {
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}

	public static Workbook getExcelWorkbook(String filePath) throws IOException {
		Workbook book = null;
		File file = null;
		FileInputStream fis = null;

		try {
			file = new File(filePath);
			if (!file.exists()) {
				throw new RuntimeException("文件不存在");
			} else {
				fis = new FileInputStream(file);
				book = WorkbookFactory.create(fis);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
		return book;
	}

}