package PlatformLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

	private String fileName;
	private String sheetname;
	private int sheetindex;
	
	
	private ExcelDataReader(ExcelReaderBuilder excelreaderBuilder)
	{
		this.sheetname = excelreaderBuilder.sheetname;
		this.sheetindex = excelreaderBuilder.sheetindex;
		this.fileName = excelreaderBuilder.fileName;
		
	}
	public static class ExcelReaderBuilder
	{
//		enum typeofData
//		{
//			STRING,NUMERIC,BOOLEAN,BLANK;
//			public typeofData[] getcellTypeENUM()
//			{
//				typeofData t[] = typeofData.values();
//				return t;
//			}
//		}
		
		
		
		private String fileName;
		private String sheetname;
		private int sheetindex;
		public XSSFWorkbook book;
		public static HashMap<String,String> FetchExcelData	= null;
		private String put; 
		
		public ExcelReaderBuilder setFileLocation(String location) {
			this.fileName = location;
			return this;
		}

		public ExcelReaderBuilder setSheet(String sheetName) {
			this.sheetname = sheetName;
			return this;
		}

		public ExcelReaderBuilder setSheet(int index) {
			this.sheetindex = index;
			return this;
		}

		public ExcelDataReader build() {
			return new ExcelDataReader(this);
		}
		
		public XSSFWorkbook getWorkBook(String filepath) throws IOException
		{
			FileInputStream file = new FileInputStream(filepath);
			XSSFWorkbook book = new XSSFWorkbook(file);
			return book;
			
		}
		public XSSFSheet getWorksheetByName(String fileName, String sheetname) throws IOException
		{
			this.book  = getWorkBook(fileName);
			XSSFSheet name = this.book.getSheet(sheetname);
			return name;
			
		}
		public XSSFSheet getWorksheetByIndex(String fileName, int sheetindex) throws IOException
		{
			this.book  = getWorkBook(fileName);
			XSSFSheet index = this.book.getSheetAt(sheetindex);
			return index;
			
		}
		public HashMap getsheetData() throws IOException
		{
			XSSFSheet sheet;
			Object result;
			sheet = getWorksheetByName(fileName,sheetname);
			 int rowcount = sheet.getLastRowNum();
			 //int colcount = sheet.getRow(0).getLastCellNum();
			 for (int irow = 0;irow < rowcount;irow++)
			 {
				 int type = sheet.getRow(irow).getCell(1).getCellType();
				 
				switch (type)
				{
				case Cell.CELL_TYPE_NUMERIC:	
					result = sheet.getRow(irow).getCell(1).getNumericCellValue();
					break;
				case Cell.CELL_TYPE_STRING:
					result = sheet.getRow(irow).getCell(1).getStringCellValue();
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					result = sheet.getRow(irow).getCell(1).getBooleanCellValue();
					break;
				case Cell.CELL_TYPE_BLANK:
					result = "";
					break;
				default:
					throw new RuntimeException("There is no support for this type of 565656cell");
				} 	
				FetchExcelData.put(sheet.getRow(irow).getCell(0).getStringCellValue(), result.toString());
			 }
			return FetchExcelData ;
			
		}
	}
}
