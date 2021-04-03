import java.io.*;
import java.util.*;

import java.sql.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PlayerAssistsGoals
{
	public static void main(String[] args)
	{
		String url = "jdbc:mysql://localhost:3306/soccer";
		String username = "root";
		String password = "ajinkya27";

		String PlayerAssistsGoalsFile = "C:/Users/Ajinkya Salvi/Documents/Study/Masters/Semester 01/Database Systems/Projects/Project 01/Input Data/Player_Assists_Goals.xlsx";

		int PlayerId;
		int Matches;
		int Goals;
		int Assists;
		int MinutesPlayed;
		String sql;

		try
		{
			Connection myConn = DriverManager.getConnection(url, username, password);
			Statement myStmt = myConn.createStatement();

			FileInputStream fis = new FileInputStream(new File(PlayerAssistsGoalsFile));
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
	            	Matches = (int) cell.getNumericCellValue();

					cell = cellIterator.next();
	            	Goals = (int) cell.getNumericCellValue();

					cell = cellIterator.next();
	            	Assists = (int) cell.getNumericCellValue();

					cell = cellIterator.next();
	            	MinutesPlayed = (int) cell.getNumericCellValue();

					sql = "INSERT INTO PLAYER_ASSISTS_GOALS "
					+ "(Player_id, No_of_Matches, Goals, Assists, MinutesPlayed ) "
					+ "VALUES("+PlayerId+", "+Matches+", "+Goals+", "+Assists+", "+MinutesPlayed+" );";

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
