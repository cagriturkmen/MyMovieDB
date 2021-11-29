package com.bilgeadam.mymoviedatabase.clientdao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.bilgeadam.mymoviedatabase.database.DatabaseConnection;

public class DaoClientWriteToDatabase implements IClientsCsvWrite {
	
	@Override
	public void writeCsvDatabase() {
		
		if (deletedatabase()) {
			createDatabase();
			
			createTables();
			csvWriteDatabase();
		} else {
			System.out.println("Lütfen açık olan diğer oturumları kapatın");
		}
	}
	
	private void createTables() {
		try (Connection con = getInterfaceConnection()) {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(readSqlCreateDatabase());
		} catch (SQLException e) {
			System.out.println("Tablo oluşturulamadı");
		}
		
	}
	
	private void createDatabase() {
		try (Connection con = DatabaseConnection.getInstance().getConnectionMain()) {
			Statement stmt = con.createStatement();
			String query = "CREATE DATABASE maratonaratatil" + "    WITH " + "    OWNER = postgres"
					+ "    ENCODING = 'UTF8'" + "    CONNECTION LIMIT = -1";
			System.out.println(query);
			stmt.executeUpdate(query);
			System.out.println("Database oluşturuldu");
			Thread.sleep(1000);
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
			System.out.println("Database oluşturulamadı");
		}
		
	}
	
	private void csvWriteDatabase() {
		
		String PATH = "C:\\bilgeadam\\ml-latest-small\\movies.csv";
		writeMoviesCsvDatabase(PATH);
		
		PATH = "C:\\bilgeadam\\ml-latest-small\\links.csv";
		writeLinksCsvDatabase(PATH);
		
		PATH = "C:\\bilgeadam\\ml-latest-small\\ratings.csv";
		writeRatingsCsvDatabase(PATH);
		
		PATH = "C:\\bilgeadam\\ml-latest-small\\tags.csv";
		writeTagsCsvDatabase(PATH);
	}
	
	private boolean deletedatabase() {
		
		java.sql.Statement stmt;
		try (Connection con = DatabaseConnection.getInstance().getConnectionMain()) {
			stmt = con.createStatement();
			stmt.executeUpdate("drop database IF EXISTS maratonaratatil");
			System.out.println("Database Silindi");
			Thread.sleep(1000);
			
			return true;
		} catch (SQLException | InterruptedException e) {
			System.out.println("Database silinemedi");
			return false;
		}
		
	}
	
	private void writeLinksCsvDatabase(String path) {
		
		java.sql.Statement stmt;
		try (Connection con = getInterfaceConnection()) {
			stmt = con.createStatement();
			stmt.executeUpdate("COPY links from '" + path + "' DELIMITER ',' CSV HEADER;");
		} catch (SQLException e) {
			System.out.println("writeLinksCsvDatabase  hata");
		}
		
	}
	
	private void writeMoviesCsvDatabase(String path) {
		
		try (Connection con = getInterfaceConnection()) {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("COPY movies FROM '" + path + "' DELIMITER ',' CSV HEADER;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void writeRatingsCsvDatabase(String path) {
		
		try (Connection con = getInterfaceConnection()) {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"COPY ratings(userid,movieid,rating,timestamp) FROM '" + path + "' DELIMITER ',' CSV HEADER;");
		} catch (SQLException e) {
			System.out.println("writeRatingsCsvDatabase yazdırılamadı");
			
		}
		
	}
	
	private void writeTagsCsvDatabase(String path) {
		
		try (Connection connection = getInterfaceConnection()) {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("COPY tags FROM '" + path + "' DELIMITER ',' CSV HEADER;");
		} catch (SQLException e) {
			System.out.println("writeTagsCsvDatabase yazdırılamadı");
			
		}
	}
	
	public String readSqlCreateDatabase() {
		
		StringBuffer srBuffer = new StringBuffer();
		
		try {
			
			String lineString = "";
			
			String tsvPath = "./src/com/bilgeadam/mymoviedatabase/database/CreateDatabase.sql";
			
			File tsvFile = new File(tsvPath);
			
			@SuppressWarnings("resource")
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(tsvFile));
			
			while ((lineString = bufferedReader.readLine()) != null) {
				
				srBuffer.append(lineString).append("\n");
				
			}
			
		} catch (Exception e) {
			
			System.out.println("readSqlCreateDatabase hata");
			
		}
		
		return srBuffer.toString();
		
	}
}
