import java.io.*;
import java.util.*;

import java.sql.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MatchResults
{
	public static void main(String[] args)
	{
		String url = "jdbc:mysql://localhost:3306/soccer";
		String username = "root";
		String password = "ajinkya27";

		String MatchResultsFile = "C:/Users/Ajinkya Salvi/Documents/Study/Masters/Semester 01/Database Systems/Projects/Project 01/Input Data/Match_results.xlsx";

		int MatchId;
		java.sql.Date DOM = new java.sql.Date();
		java.sql.Time StartTime = new java.sql.Time();
		String Team1;
		String Team2;
		int Team1score;
		int Team2score;
		String StadiumName;
		String HostCity;
		String sql;

		try
		{
			Connection myConn = DriverManager.getConnection(url, username, password);
			Statement myStmt = myConn.createStatement();

			FileInputStream fis = new FileInputStream(new File(MatchResultsFile));
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
	            	MatchId = (int) cell.getNumericCellValue();

					cell = cellIterator.next();
	            	DOM = resultSet.getDate(2);

					cell = cellIterator.next();
	            	StartTime = resultSet.getTime(3);

					cell = cellIterator.next();
	            	Team1 = String.valueOf(cell.getStringCellValue());

					cell = cellIterator.next();
	            	Team2 = String.valueOf(cell.getStringCellValue());

					cell = cellIterator.next();
	            	Team1score = (int) cell.getNumericCellValue();

					cell = cellIterator.next();
	            	Team2score = (int) cell.getNumericCellValue();

					cell = cellIterator.next();
	            	StadiumName = String.valueOf(cell.getStringCellValue());

					cell = cellIterator.next();
	            	HostCity = String.valueOf(cell.getStringCellValue());

					sql = "INSERT INTO MATCH_RESULTS "
					+ "(Match_id, Date_of_Match, Start_Time_Of_Match, Team1, Team2, Team1_scoreName, Team2_score, Stadium_Name, Host_City ) "
					+ "VALUES("+MatchId+", "+DOM+", "+StartTime+", "+Team1+", "+Team2+", "+Team1score+", "Team2_score+", "StadiumName+", "HostCity+" );";

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
