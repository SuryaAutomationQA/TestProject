package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase
{
    public static long PAGE_LOAD_TIMEOUT=20;
    public static long IMPLICIT_WAIT=10;
    static Workbook book;
    static Sheet sheet;
    
    public static String Test_Data_Sheet_Path="D:\\Selenium\\Workspace1\\MavenCRMPRoject\\src\\main\\java\\com\\crm\\qa\\testdata\\FREECRMDATA.xlsx";

public static Object[][] getTestData(String sheetName)
{
	
	FileInputStream file =null;
	try 
	  {
		file= new FileInputStream(Test_Data_Sheet_Path);
	  }
	catch(FileNotFoundException e)
	  {
	  e.printStackTrace();
	  }
	try 
	  {
		book =WorkbookFactory.create(file);
	  }
	catch(IOException e)
	{
		e.printStackTrace();
	}
	sheet =book.getSheet(sheet);
	object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<mysheet.getLastRowNum();i++)
	{
    for(int j=0;j<mysheet.getLastRowNum();i++)
    {
    	data[i][k]=mysheet.getRow(i+1).getcell(k).toString();
    	
    }
	}
	
	return data;
	
	
}




}
