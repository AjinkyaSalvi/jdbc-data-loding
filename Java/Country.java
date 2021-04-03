import java.io.*;
import java.util.*;

import java.sql.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Country
{
	public static void main(String[] args)
	{
		String url = "jdbc:mysql://localhost:3306/soccer";
		String username = "root";
		String password = "ajinkya27";

		String CountryFile = "C:/Documents/Country.xlsx";

		String CountryName;
		double Population;
		int WorldcupsWon;
		String Manager;
		String sql;

		try
		{
			Connection myConn = DriverManager.getConnection(url, username, password);
			Statement myStmt = myConn.createStatement();

			FileInputStream fis = new FileInputStream(new File(CountryFile));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			Sheet firstSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = firstSheet.iterator();
	        while (iterator.hasNext())
	        {
	        	Row nextRow = iterator.next();
	        	Iterator<Cell> cellIterator = nextRow.cellIterator();
	            while (cellIterator.hasNext())
	            {
	            	Cell cell = cellIterator.next();
	            	CountryName = String.valueOf(cell.getStringCellValue());

	            	cell = cellIterator.next();
	            	Population = cell.getNumericCellValue();

	            	cell = cellIterator.next();
	            	WorldcupsWon = (int) cell.getNumericCellValue();

	            	cell = cellIterator.next();
	            	Manager = String.valueOf(cell.getStringCellValue());

	            	sql = "INSERT INTO COUNTRY "
	            	+ "(Country_Name, Population, No_of_Worldcup_won, Manager ) "
	            	+ "VALUES("+CountryName+", "+Population+", "+WorldcupsWon+", "+Manager+" );";

	            	myStmt.executeUpdate(sql);
	            }
	        }

	            workbook.close();
	            fis.close();

	            System.out.println("\nInsert Complete");
		}

		catch(Exception exc)
		{
			exc.printStackTrace();
		}
	}
}
