package com.meganexus.SIT_AutomationTesting.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("deprecation")
public class ExcelUtils {
	private static XSSFSheet xcelWSheet;
	private static XSSFWorkbook xcelWBook;
	private static XSSFCell cell;
	private static XSSFRow row;
	private static String fileName = "/Sit_Test_Data.xlsx";

	private static XSSFWorkbook rbacs_xcelWBook;
	private static XSSFSheet rbacs_xcelWSheet;
	private static XSSFCell rbacs_cell;
	private static XSSFRow rbacs_row;
	private static String rbacs_fileName = "/rbacs_data.xlsx";
	private static File rbacs_file = new File(System.getProperty("user.dir") + "/src/test/resources" + rbacs_fileName);
	private static InputStream rbacsinput = null;

	private static File file = new File(System.getProperty("user.dir") + "/src/test/resources" + fileName);
	private static InputStream input = null;

	public static void main(String args[]) {

		ExcelUtils ut = new ExcelUtils();
		System.out.println(ut.getRowNums("OffenderDetails", "SIT NO", "E2ESIT025"));
		/*
		 * int cellNum = ut.getCellNumber("OffenderDetails", "CRN NO");
		 * System.out.println(rowNum); System.out.println(cellNum); String data
		 * = ut.getData("OffenderDetails", rowNum, cellNum).trim();
		 * System.out.println(data); ut.writeExcellFile("OffenderDetails",
		 * rowNum, cellNum, "Tapan");
		 */
	}

	// To get the file path, file name and sheet name - Tapan Sahoo
	private void getSheetName(String sheetName, int rowNum) {
		try {
			// Log.info("Opening Sit Test Data file to get test data");
			input = new FileInputStream(file);
			xcelWBook = new XSSFWorkbook(input);
			xcelWSheet = xcelWBook.getSheet(sheetName);
			row = xcelWSheet.getRow(rowNum);
		} catch (FileNotFoundException e) {
			Log.error("Unable get the Sit test data file " + e.getMessage());
		} catch (IOException e) {
			Log.error("attempting to read from a file that does not exist " + e.getMessage());
		}
	}

	// To get The cell value - Tapan Sahoo
	public String getData(String sheetName, int rowNum, int cellNum) {
		String data = "";
		getSheetName(sheetName, rowNum);
		try {
			cell = row.getCell(cellNum);

			if (cell != null) {
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					data = cell.getBooleanCellValue() + "\t\t";
					break;
				case Cell.CELL_TYPE_NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
						data = formatter.format(cell.getDateCellValue()).trim();

					} else {
						data = cell.getRawValue().trim();
					}
					break;
				case Cell.CELL_TYPE_STRING:
					data = cell.getStringCellValue().trim() + "\t\t";
					break;
				}
			} else {

				data = "";
			}

		} catch (Exception e) {
			Log.error("Unableto get test data from cell " + e.getMessage());
		}
		return data;
	}

	// To get the cell Number -Tapan Sahoo
	public int getCellNumber(String sheetName, String matchingColumn) {
		try {
			int colLength = xcelWSheet.getRow(0).getLastCellNum();

			for (int i = 0; i <= colLength; i++) {
				String columnName = getData(sheetName, 0, i);

				if (columnName != null && matchingColumn.equals(columnName.trim())) {
					int matchingColNumber = i;
					return matchingColNumber;
				}
			}
		} catch (Exception n) {
			Log.error("Unable to get cell number from sit test data " + n.getMessage());

		}

		return -1;
	}

	// To write cell value -Tapan Sahoo
	public void writeExcellFile(String sheetName, int rowNum, int cellNum, String writeData) {
		getSheetName(sheetName, rowNum);
		FileOutputStream fileOut;
		try {
			row = xcelWSheet.getRow(rowNum);
			cell = row.getCell(cellNum);
			if (cell != null) {
				cell.setCellValue(writeData);
			} else {
				row = xcelWSheet.getRow(rowNum);
				cell = row.createCell(cellNum);
				cell.setCellValue(writeData);
			}
			fileOut = new FileOutputStream(file);
			xcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (FileNotFoundException e) {

			Log.error("Unableto get the file to write data into Excell sheet " + e.getMessage());
		} catch (Exception e) {

			Log.error("Unableto to write data into Excell sheet " + e.getMessage());
		}

	}

	// To get all The Row Number which match with your sit scenario -Tapan Sahoo
	private List<Integer> getAllMatchingRowNums(String sheetName, String matchingColumn, String dataToBeMatched) {
		int rowNum = 0;
		getSheetName(sheetName, rowNum);
		List<Integer> rowNumList = new ArrayList<>();
		try {
			int matchingColNumber = -1;

			matchingColNumber = getrbacsCellNumber(sheetName, matchingColumn);

			if (matchingColNumber > -1) {
				int rowLength = xcelWSheet.getLastRowNum();

				for (int rowCount = 0; rowCount <= rowLength; rowCount++) {
					String colData = getData(sheetName, rowCount, matchingColNumber).trim();
					if (colData.equals(dataToBeMatched)) {
						rowNumList.add(rowCount);
					}
				}
			}
		} catch (NullPointerException n) {
			Log.error("getting null values for all the row number " + n.getMessage());

		}
		return rowNumList;
	}

	// To get Row Number which match with your sit scenario and status column is
	// NO
	// -Tapan Sahoo

	public int getRowNumsWithStatusToDo(String sheetName, String matchingColumn, String dataToBeMatched) {

		try {
			input = new FileInputStream(file);
			xcelWBook = new XSSFWorkbook(input);
			xcelWSheet = xcelWBook.getSheet(sheetName);
			int cellNum = getCellNumber(sheetName, "Status");
			for (Integer rowNumElement : getAllMatchingRowNums(sheetName, matchingColumn, dataToBeMatched)) {
				String data = getData(sheetName, rowNumElement, cellNum).trim();
				if (data.trim().equals("TO DO"))
					return rowNumElement;
			}

		} catch (Exception e) {
			Log.error("Unable to get row number " + e.getMessage());
		}

		return -1;
	}

	// To get Row Number which match with your sit scenario
	public int getRowNums(String sheetName, String matchingColumn, String dataToBeMatched) {
		int rowNum = 0;
		getSheetName(sheetName, rowNum);
		try {
			int matchingColNumber = -1;

			matchingColNumber = getCellNumber(sheetName, matchingColumn);

			if (matchingColNumber > -1) {
				int rowLength = xcelWSheet.getLastRowNum();

				for (int rowCount = 0; rowCount <= rowLength; rowCount++) {
					String colData = getData(sheetName, rowCount, matchingColNumber).trim();
					if (colData.equals(dataToBeMatched)) {
						return rowCount;
					}
				}
			}
		} catch (NullPointerException n) {
			Log.error("Unable to get row number " + n.getMessage());

		}
		return -1;
	}

	// rbacs related functions
	// *********************************************************************************************//
	private void getrbacsSheetName(String sheetName, int rowNum) {
		try {
			// Log.info("Opening Sit Test Data file to get test data");
			input = new FileInputStream(rbacs_file);
			rbacs_xcelWBook = new XSSFWorkbook(input);
			rbacs_xcelWSheet = rbacs_xcelWBook.getSheet(sheetName);
			rbacs_row = rbacs_xcelWSheet.getRow(rowNum);
		} catch (FileNotFoundException e) {
			Log.error("Unable get the Sit test data file " + e.getMessage());
		} catch (IOException e) {
			Log.error("attempting to read from a file that does not exist " + e.getMessage());
		}
	}

	public int getrbacsRowNumsWithStatusToDo(String sheetName, String matchingColumn, String dataToBeMatched) {
		try {
			input = new FileInputStream(rbacs_file);
			rbacs_xcelWBook = new XSSFWorkbook(input);
			rbacs_xcelWSheet = rbacs_xcelWBook.getSheet(sheetName);
			int cellNum = getrbacsCellNumber(sheetName, "Status");
			for (Integer rowNumElement : getAllrbacsMatchingRowNums(sheetName, matchingColumn, dataToBeMatched)) {
				String data = getrbacsData(sheetName, rowNumElement, cellNum).trim();
				if (data.trim().equals("TO DO"))
					return rowNumElement;
			}
		} catch (Exception e) {
			Log.error("Unable to get row number " + e.getMessage());
		}
		return -1;
	}

	public int getrbacsRowNums(String sheetName, String matchingColumn, String dataToBeMatched) {
		int rowNum = 0;
		getrbacsSheetName(sheetName, rowNum);
		try {
			int matchingColNumber = -1;

			matchingColNumber = getrbacsCellNumber(sheetName, matchingColumn);

			if (matchingColNumber > -1) {
				int rowLength = rbacs_xcelWSheet.getLastRowNum();

				for (int rowCount = 0; rowCount <= rowLength; rowCount++) {
					String colData = getrbacsData(sheetName, rowCount, matchingColNumber).trim();
					if (colData.equals(dataToBeMatched)) {
						return rowCount;
					}
				}
			}
		} catch (NullPointerException n) {
			Log.error("Unable to get row number " + n.getMessage());

		}
		return -1;
	}

	public int getrbacsCellNumber(String sheetName, String matchingColumn) {
		try {
			int colLength = rbacs_xcelWSheet.getRow(0).getLastCellNum();

			for (int i = 0; i <= colLength; i++) {
				String columnName = getrbacsData(sheetName, 0, i);

				if (columnName != null && matchingColumn.equals(columnName.trim())) {
					int matchingColNumber = i;
					return matchingColNumber;
				}
			}
		} catch (Exception n) {
			Log.error("Unable to get cell number from sit test data " + n.getMessage());
		}
		return -1;
	}

	public String getrbacsData(String sheetName, int rowNum, int cellNum) {
		String data = "";
		getrbacsSheetName(sheetName, rowNum);
		try {
			rbacs_cell = rbacs_row.getCell(cellNum);
			if (rbacs_cell != null) {
				switch (rbacs_cell.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					data = rbacs_cell.getBooleanCellValue() + "\t\t";
					break;
				case Cell.CELL_TYPE_NUMERIC:
					if (DateUtil.isCellDateFormatted(rbacs_cell)) {
						SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
						data = formatter.format(rbacs_cell.getDateCellValue()).trim();

					} else {
						data = rbacs_cell.getRawValue().trim();
					}
					break;
				case Cell.CELL_TYPE_STRING:
					data = rbacs_cell.getStringCellValue().trim() + "\t\t";
					break;
				}
			} else {
				data = "";
			}
		} catch (Exception e) {
			Log.error("Unable to get test data from cell " + e.getMessage());
		}
		return data;
	}

	private List<Integer> getAllrbacsMatchingRowNums(String sheetName, String matchingColumn, String dataToBeMatched) {
		int rowNum = 0;
		getSheetName(sheetName, rowNum);
		List<Integer> rowNumList = new ArrayList<>();
		try {
			int matchingColNumber = -1;

			matchingColNumber = getrbacsCellNumber(sheetName, matchingColumn);

			if (matchingColNumber > -1) {
				int rowLength = rbacs_xcelWSheet.getLastRowNum();

				for (int rowCount = 0; rowCount <= rowLength; rowCount++) {
					String colData = getrbacsData(sheetName, rowCount, matchingColNumber).trim();
					if (colData.equals(dataToBeMatched)) {
						rowNumList.add(rowCount);
					}
				}
			}
		} catch (NullPointerException n) {
			Log.error("getting null values for all the row number " + n.getMessage());

		}
		return rowNumList;
	}

	public void writerbacsExcellFile(String sheetName, int rowNum, int cellNum, String writeData) {
		getrbacsSheetName(sheetName, rowNum);
		FileOutputStream fileOut;
		try {
			rbacs_row = rbacs_xcelWSheet.getRow(rowNum);
			rbacs_cell = rbacs_row.getCell(cellNum);
			if (rbacs_cell != null) {
				rbacs_cell.setCellValue(writeData);
			} else {
				rbacs_row = rbacs_xcelWSheet.getRow(rowNum);
				rbacs_cell = rbacs_row.createCell(cellNum);
				rbacs_cell.setCellValue(writeData);
			}
			fileOut = new FileOutputStream(file);
			rbacs_xcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (FileNotFoundException e) {
			Log.error("Unable to get the file to write data into Excell sheet " + e.getMessage());
		} catch (Exception e) {
			Log.error("Unableto to write data into Excell sheet " + e.getMessage());
		}

	}
}
