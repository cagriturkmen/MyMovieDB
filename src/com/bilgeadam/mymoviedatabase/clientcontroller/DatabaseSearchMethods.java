package com.bilgeadam.mymoviedatabase.clientcontroller;

import java.util.ArrayList;

import com.bilgeadam.mymoviedatabase.clientdao.DatabaseSearchMethodsCsv;
import com.bilgeadam.mymoviedatabase.clientdao.IDAOImplementsClientSearchDatabase;
import com.bilgeadam.mymoviedatabase.clientdto.MoviesCsvDto;
import com.bilgeadam.mymoviedatabase.clientdto.MoviesCsvDtoPacket;

public class DatabaseSearchMethods implements IDAOImplementsClientSearchDatabase {
	
	private static DatabaseSearchMethods instance;
	private DatabaseSearchMethodsCsv dao;
	
	private DatabaseSearchMethods() {
		dao = new DatabaseSearchMethodsCsv();
	}
	
	public static DatabaseSearchMethods getInstance() {
		if (instance == null) {
			instance = new DatabaseSearchMethods();
		}
		return instance;
		
	}
	
	@Override
	public ArrayList<MoviesCsvDto> daoClientSearchByYear(String year) {
		// TODO Auto-generated method stub
		return dao.daoClientSearchByYear(year);
	}
	
	@Override
	public ArrayList<MoviesCsvDto> daoClientSearchByCategory(String searchCategory) {
		// TODO Auto-generated method stub
		return dao.daoClientSearchByCategory(searchCategory);
	}
	
	@Override
	public ArrayList<MoviesCsvDto> daoClientSearchByMoviesName(String name) {
		// TODO Auto-generated method stub
		return dao.daoClientSearchByMoviesName(name);
	}
	
	@Override
	public ArrayList<MoviesCsvDtoPacket> daoClientSearchByArthistName(String artistName) {
		// TODO Auto-generated method stub
		return dao.daoClientSearchByArthistName(artistName);
	}
	
}
