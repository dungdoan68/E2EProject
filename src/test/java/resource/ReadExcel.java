package resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	
	public void testDataExcel() throws IOException {
		ArrayList<String> a = readDataExcel("D:\\Desktop\\GITDemo\\E2EProject","dataTest.xlsx","Account");	
		System.out.println(a);

	}
	
	public Sheet getFileExcel(String filePath, String fileName, String sheetName) throws IOException {
		File file = new File(filePath,fileName);
		FileInputStream fis = new FileInputStream(file);
		Workbook fileExcel = null ;
		
		String fileNameExtention = fileName.substring(fileName.indexOf("."));
		if(fileNameExtention.equals(".xlsx"))
		{
			fileExcel = new XSSFWorkbook(fis);
		}
		else if (fileNameExtention.equals(".xls")) 
		{
			fileExcel = new HSSFWorkbook(fis);
			
		}

		Sheet sheename = fileExcel.getSheet(sheetName);

		return sheename;
	}
	
	public ArrayList<String> readDataExcel(String path, String fileName, String sheetName) throws IOException{
		ArrayList<String> data = new ArrayList<String>();
		ReadExcel r= new ReadExcel();
		Sheet dataExcel = r.getFileExcel(path,fileName,sheetName);
		int rowCount = dataExcel.getLastRowNum() - dataExcel.getFirstRowNum();
		for (int i=1; i<rowCount+1;i++) {
			Row row = dataExcel.getRow(i);
			Iterator<Cell> cellRow  = row.cellIterator();
			while(cellRow.hasNext())
			{ 
				Cell cell = cellRow.next();
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case _NONE:	
					System.out.println("");
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case STRING:
					System.out.println(cell.getStringCellValue());
					data.add(cell.getStringCellValue());
					break;
				case FORMULA:
					System.out.println(cell.getCellFormula());
					break;
				case BLANK:
					System.out.println("");
				case ERROR:
				System.out.println("!");
					break;
				}
			}
		}
		
		return data;
	}
	
}
