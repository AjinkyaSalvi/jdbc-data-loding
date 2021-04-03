import java.io.*;
import java.util.*;

import java.sql.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Players
{
	public static void main(String[] args)
	{
		String url = "jdbc:mysql://localhost:3306/soccer";
		String username = "root";
		String password = "ajinkya27";

		String PlayersFile = "C:/Users/Ajinkya Salvi/Documents/Study/Masters/Semester 01/Database Systems/Projects/Project 01/Input Data/Players.xlsx";

		int PlayerId;
		String Name;
		String FName;
		String LName;
		java.sql.Date DOB = new java.sql.Date();
		String Country;
		int Height;
		String Club;
		String Position;
		int CapsCountry;
		String IsCaptain;
		String sql;

		try
		{
			Connection myConn = DriverManager.getConnection(url, username, password);
			Statement myStmt = myConn.createStatement();

			FileInputStream fis = new FileInputStream(new File(PlayersFile));
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
	            	PlayerId = (int) cell.getNumericCellValue();

					cell = cellIterator.next();
	            	Name = String.valueOf(cell.getStringCellValue());

					cell = cellIterator.next();
	            	FName = String.valueOf(cell.getStringCellValue());

					cell = cellIterator.next();
	            	LName = String.valueOf(cell.getStringCellValue());

					cell = cellIterator.next();
	            	DOB = resultSet.getDate(5);

	            	cell = cellIterator.next();
	            	Country = String.valueOf(cell.getStringCellValue());

	            	cell = cellIterator.next();
	            	Height = (int) cell.getNumericCellValue();

	            	cell = cellIterator.next();
	            	Club = String.valueOf(cell.getStringCellValue());

					cell = cellIterator.next();
	            	Position = String.valueOf(cell.getStringCellValue());

					cell = cellIterator.next();
	            	CapsCountry = (int) cell.getNumericCellValue();

					cell = cellIterator.next();
	            	IsCaptain = String.valueOf(cell.getStringCellValue());

					if(IsCaptain.compareTo("TRUE")==0)
					{
						sql = "INSERT INTO PLAYERS "
						+ "(Player_id, Name, Fname, Lname, DOB, Country, Height_in_cms, Club, Position, Caps_for_Country, IS_CAPTAIN ) "
						+ "VALUES("+PlayerId+", "+Name+", "+FName+", "+LName+", "+DOB+", "+Country+", "Height+", "Club+", "Position+", "CapsCountry+", true );";
					}

					else
					{
						sql = "INSERT INTO PLAYERS "
						+ "(Player_id, Name, Fname, Lname, DOB, Country, Height_in_cms, Club, Position, Caps_for_Country, IS_CAPTAIN ) "
						+ "VALUES("+PlayerId+", "+Name+", "+FName+", "+LName+", "+DOB+", "+Country+", "Height+", "Club+", "Position+", "CapsCountry+", false );";
					}

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
