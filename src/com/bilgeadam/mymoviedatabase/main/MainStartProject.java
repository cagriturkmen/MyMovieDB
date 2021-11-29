package com.bilgeadam.mymoviedatabase.main;

public class MainStartProject {
	
	public static void main(String[] args) {
		// Thread serverTsv = new Thread() {
		//
		// @Override
		// public void run() {
		//
		// ServerTsv server = new ServerTsv();
		//
		// while (true) {
		// server.runServer();
		// }
		// }
		//
		// };
		
		// serverTsv.start();
		MenuMovies menuMovies = new MenuMovies();
		menuMovies.startUp();
		
	}
	
}

// DaoClientReadToDatabase daoClientReadToDatabase = new
// DaoClientReadToDatabase();
// daoClientReadToDatabase.readCsvDatabase();
