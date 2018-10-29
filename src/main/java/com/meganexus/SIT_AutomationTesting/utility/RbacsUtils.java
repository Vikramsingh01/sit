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



public class RbacsUtils {
	
	@SuppressWarnings("deprecation")

	private static XSSFSheet xcelWSheet;
	private static XSSFWorkbook xcelWBook;
	private static XSSFCell cell;
	private static XSSFRow row;
	private static String fileName = "/rbacs_data.xlsx";
	private static File file = new File(System.getProperty("user.dir") + "/src/test/resources" + fileName);
	private static InputStream input = null;
	
	RbacsUtils rt = new RbacsUtils();
	//System.out.println(ut.getRowNums("credentails", "SIT NO", "E2ESIT025"));
	
	@SuppressWarnings("unused")
	private void getSheetName(String sheetName, int rowNum, int colnum ) {
		try {
			//Log.info("Opening rbacs test Data file to get test data");
			input = new FileInputStream(file);
			xcelWBook = new XSSFWorkbook(input);
			xcelWSheet = xcelWBook.getSheet(sheetName);
			row = xcelWSheet.getRow(rowNum);
			
			int colnum1 = -1;
 
             for(int i=0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals("UserName"))
            	colnum1 = i;
        }
             
             for(int j=0; j < row.getLastCellNum(); j++)
             {
                 if(row.getCell(j).getStringCellValue().trim().equals("Password"))
                 	colnum1 = j;
             }
			
						
		} catch (FileNotFoundException e) {
			Log.error("Unable get the rbacs test data file " + e.getMessage());
		} catch (IOException e) {
			Log.error("attempting to read from a file that does not exist " + e.getMessage());
		}

	}
	
	

    }
	



