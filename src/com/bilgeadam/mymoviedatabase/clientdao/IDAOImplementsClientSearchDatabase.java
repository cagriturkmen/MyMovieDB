package com.bilgeadam.mymoviedatabase.clientdao;

import java.util.ArrayList;

import com.bilgeadam.mymoviedatabase.clientdto.MoviesCsvDto;
import com.bilgeadam.mymoviedatabase.clientdto.MoviesCsvDtoPacket;

public interface IDAOImplementsClientSearchDatabase {
	
	public ArrayList<MoviesCsvDto> daoClientSearchByYear(String year);
	
	public ArrayList<MoviesCsvDto> daoClientSearchByCategory(String searchCategory);
	
	public ArrayList<MoviesCsvDto> daoClientSearchByMoviesName(String name);
	
	public ArrayList<MoviesCsvDtoPacket> daoClientSearchByArthistName(String artistName);
	
}