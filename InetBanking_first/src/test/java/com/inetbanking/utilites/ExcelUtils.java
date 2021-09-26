package com.inetbanking.utilites;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
public  static FileInputStream fi;
public static FileOutputStream fo;
public static XSSFWorkbook wb;
public static XSSFSheet sheet;
public static  XSSFRow row;
public static XSSFCell cell;


public static int getRowCount(String xlfile,String xlsheet) throws IOException {
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	sheet=wb.getSheet(xlsheet);
	int rowcount=sheet.getLastRowNum();
	return rowcount;
}

public static int getCellcount(String xlfile,String xlsheet,int rownum) throws IOException 
{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	sheet=wb.getSheet(xlsheet);
	row=sheet.getRow(rownum);
	int cellcount=row.getLastCellNum();
	return cellcount;
}
public static String getcellData(String xlfile,String xlsheet,int rownum,int cellnum) throws IOException {

	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	sheet=wb.getSheet(xlsheet);
	row=sheet.getRow(rownum);
	cell=row.getCell(cellnum);
	String data;
	try {
	DataFormatter formatter=new DataFormatter();
	String celldata= formatter.formatCellValue(cell);
	return celldata;
	}catch(Exception e)
	{
		data=" ";
	}
	wb.close();
	fi.close();
	return data;
		
		
	}
}
