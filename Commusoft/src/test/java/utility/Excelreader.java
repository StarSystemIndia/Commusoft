package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreader {
	
	XSSFWorkbook wb;
	XSSFSheet sh;
	FileOutputStream fileOutput;
	
	
	public Excelreader()
	{
		File src = new File("");
		
		try {
			FileInputStream frc = new FileInputStream(src);
			wb = new XSSFWorkbook();
			
			 fileOutput = new FileOutputStream(src);
			 wb.write(fileOutput);
				fileOutput.close();
			
		} catch (Exception e) {
			System.out.println("Can not able to read the Excel File:- " +e.getMessage());
		}
	}
	
		
		
		public String sheetIN(int sheetnum, int row, int cell)   //---Method Overloading----//
		{
			sh = wb.getSheetAt(sheetnum);
			DataFormatter formattor = new DataFormatter();
		return	 formattor.formatCellValue(sh.getRow(row).getCell(cell));
		//	return wb.getSheetAt(sheetnum).getRow(row).getCell(cell).getStringCellValue();
		}
		
		
		
//		public static void sheetout(int sheetnum, int row, int cell, String message)
//		{
//			sh = wb.getSheetAt(sheetnum);
//			DataFormatter formattor = new DataFormatter();
//		 sh.getRow(row).createCell(cell).setCellValue(message);
//		}
		
	

}
