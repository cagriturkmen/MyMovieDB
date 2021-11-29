package com.bilgeadam.mymoviedatabase.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	// database bağlantısını kuracak class
	private Connection connectionDatabase;
	private Connection connectionMain;
	
	// url username password çağırmak
	private static DatabaseInformation databaseInformation;
	
	// database bağlanmak için zorunlu yerdir
	private String url = databaseInformation.getUrl();
	private String url2 = databaseInformation.getUrl2();
	private String userName = databaseInformation.getUserName();
	private String password = databaseInformation.getPassword();
	
	// singleton design pattern 1.özellik
	private static DatabaseConnection instance;
	
	// singleton design pattern 2.özellik
	private DatabaseConnection() {
		
	}
	
	static {
		databaseInformation = new DatabaseInformation();
		// nullPointer Exception
		
	}
	
	// singleton design pattern 3.özellik
	// syncronized
	public static DatabaseConnection getInstance() {
		
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(databaseInformation.getForNameData());
			System.out.println("postgresql-42.3.1 jar driver yüklendi");
			
			this.connectionDatabase = DriverManager.getConnection(url, userName, password);
			System.out.println("Basarılı Bağlantı ");
		} catch (Exception e) {
			System.out.println("Hatalar meydana geldi");
			e.printStackTrace();
		}
		return connectionDatabase;
	}
	
	// getter setter
	
	public Connection getConnectionMain() {
		
		try {
			Class.forName(databaseInformation.getForNameData());
			System.out.println("postgresql-42.3.1 jar driver yüklendi");
			
			this.connectionMain = DriverManager.getConnection(url2, userName, password);
			System.out.println("Basarılı Bağlantı ");
		} catch (Exception e) {
			System.out.println("Hatalar meydana geldi");
			e.printStackTrace();
		}
		return connectionMain;
	}
	
}
