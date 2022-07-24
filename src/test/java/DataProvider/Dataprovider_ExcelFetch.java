package DataProvider;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider_ExcelFetch {
	ExcelUtility excelUtility = new ExcelUtility();
	@Test(dataProvider = "getValue")
	public void test1(String src,String dest) {

		System.out.println(src+" --> "+dest);

	}

	@DataProvider
	public Object[][] getValue() throws EncryptedDocumentException, IOException {

		int rowcount=	excelUtility.getLastRowcount("../SDET7_SUD/MMT.xlsx", "Sheet1");
		Object [][] arr = new Object [rowcount+1][2];

		for (int i = 0; i <rowcount+1; i++)
		{
			arr[i][0]= excelUtility.readDataFromExcel("../SDET7_SUD/MMT.xlsx", "Sheet1",  i, 0);
			arr[i][1]= excelUtility.readDataFromExcel("../SDET7_SUD/MMT.xlsx", "Sheet1",  i, 1);
			//return arr;
		}
		return arr;

	}


}

