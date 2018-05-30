package PlatformLayer;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelORReader {
	public static Map<String, String> ORLoader() {
	
		
		HashMap<String, String> OR=new HashMap<String, String>();
		//File file= new File();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\OR.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet wSheet = workbook.getSheet("OR");
			int rowCount=wSheet.getLastRowNum();
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return OR;	
	}
	
	

	
	
}
