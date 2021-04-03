import java.io.*;
import java.util.*;

import java.sql.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PlayerCards
{
	public static void main(String[] args)
	{
		String url = "jdbc:mysql://localhost:3306/soccer";
		String username = "root";
		String password = "ajinkya27";

		String PlayerCardsFile = "C:/Users/Ajinkya Salvi/Documents/Study/Masters/Semester 01/Database Systems/Projects/Project 01/Input Data/Player_Cards.xlsx";

		int PlayerId;
		int YellowCards;
		int RedCards;
		String sql;

		try
		{
			Connection myConn = DriverManager.getConnection(url, username, password);
			Statement myStmt = myConn.createStatement();

			FileInputStream fis = new FileInputStream(new File(PlayerCardsFile));
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
	            	YellowCards = (int) cell.getNumericCellValue();

					cell = cellIterator.next();
	            	RedCards = (int) cell.getNumericCellValue();

					sql = "INSERT INTO PLAYER_CARDS "
					+ "(Player_id, Yellow_Cards, Red_Cards ) "
					+ "VALUES("+PlayerId+", "+YellowCards+", "+RedCards+" );";

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
