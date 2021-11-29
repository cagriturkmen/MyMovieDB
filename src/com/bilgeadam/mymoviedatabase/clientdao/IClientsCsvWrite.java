package com.bilgeadam.mymoviedatabase.clientdao;

import java.sql.Connection;

import com.bilgeadam.mymoviedatabase.database.DatabaseConnection;

public interface IClientsCsvWrite {
	
	public void writeCsvDatabase();
	
	default Connection getInterfaceConnection() {
		
		return DatabaseConnection.getInstance().getConnection();
		
	}
}
