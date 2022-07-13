package com.Vtiger_generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.cj.result.Row;

public class Data_fetch_Excel {
	public String dataFetch(String sheet,int row,int cell) throws Throwable, Throwable {
		FileInputStream fis=new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\SDET7_SUD\\src\\test\\java\\Generic_class\\Book1.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		String data=book.getSheet(sheet).getRow(row).getCell(cell).toString();
	   return data;
	}
}