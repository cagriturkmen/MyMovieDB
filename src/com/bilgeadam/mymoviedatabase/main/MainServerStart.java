package com.bilgeadam.mymoviedatabase.main;

import com.bilgeadam.mymoviedatabase.server.ServerTsv;

public class MainServerStart {
	
	public static void main(String[] args) {
		ServerTsv serverTsv = new ServerTsv();
		serverTsv.runServer();
	}
}
