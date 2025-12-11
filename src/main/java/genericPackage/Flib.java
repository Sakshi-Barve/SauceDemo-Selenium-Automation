package genericPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib implements IAutoConstant{

	public String readPropertyData(String propPath, String key) throws IOException {

		FileInputStream fis = new FileInputStream(propPath); // To provide the path of excel file
		Properties prop = new Properties(); // Create the object of Properties class
		prop.load(fis);    // To make the file ready to read  
		String data = prop.getProperty(key); // To read/fetch the value assigned to a particular key
		return data;
	}
	
	public String readExcelData(String excelPath,String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelPath);// To provide the path of excel file
		Workbook wb = WorkbookFactory.create(fis);   // To make the file ready to read        
		Sheet sheet = wb.getSheet(sheetName);     // To get into the desired sheet
		Row row = sheet.getRow(rowNo);            // To get into the desired row
		Cell cell = row.getCell(cellNo);          // To get into the desired cell
		String data = cell.getStringCellValue();   // To read the data from the cell
		return data;
	}
	
	public void writeExcelData(String excelPath,String sheetName, int rowNo,int cellNo, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelPath);// To provide the path of excel file
		Workbook wb = WorkbookFactory.create(fis);  // To make the file ready to read
		Sheet sheet = wb.getSheet(sheetName);  // To get into the desired sheet
		Row row = sheet.getRow(rowNo);         // To get into the desired row
		Cell cell = row.createCell(cellNo);    // To get into the desired cell
		cell.setCellValue(data);               // To pass the String data to the desired cell
		
		FileOutputStream fos = new FileOutputStream(excelPath);
		wb.write(fos);
	}
	
	public int getRowCount(String excelPath, String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelPath); // To provide the path of excel file
		Workbook wb = WorkbookFactory.create(fis); // To make the file ready to read
		Sheet sheet = wb.getSheet(sheetName);  // To get into the desired sheet
		int rc = sheet.getLastRowNum(); // To get the no. of rows from a sheet
		return rc;
	}
	

}