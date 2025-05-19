package Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchDataFromExcel 
{
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public FetchDataFromExcel(String excelPath,String sheetName) throws IOException
	{
		workbook=new XSSFWorkbook(excelPath);
		sheet=workbook.getSheet(sheetName);
		
	}
	
	public static Object getData(int x,int y)
	{
		DataFormatter formatter=new DataFormatter();
		Object value1=formatter.formatCellValue(sheet.getRow(x).getCell(y));
		return value1;
		
	}

}
