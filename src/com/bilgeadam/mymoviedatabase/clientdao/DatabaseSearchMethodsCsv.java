package com.bilgeadam.mymoviedatabase.clientdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bilgeadam.mymoviedatabase.clientdto.MoviesCsvDto;
import com.bilgeadam.mymoviedatabase.clientdto.MoviesCsvDtoPacket;
import com.bilgeadam.mymoviedatabase.database.DatabaseConnection;

public class DatabaseSearchMethodsCsv implements IDAOImplementsClientSearchDatabase {
	
	@Override
	public ArrayList<MoviesCsvDto> daoClientSearchByYear(String year) {
		ArrayList<MoviesCsvDto> list = new ArrayList<MoviesCsvDto>();
		MoviesCsvDto moviesCsvDto;
		
		try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
			String sql = "select m.movieid,m.genres,m.title from movies as m where m.title like ?";
			;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + year + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				moviesCsvDto = new MoviesCsvDto();
				moviesCsvDto.setMovieId(resultSet.getInt("movieid"));
				moviesCsvDto.setTitle(resultSet.getString("title"));
				moviesCsvDto.setGenres(resultSet.getString("genres"));
				list.add(moviesCsvDto);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + "moviesCsvDto belirli yıldaki filmlerde hata oluştu");
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public ArrayList<MoviesCsvDto> daoClientSearchByCategory(String searchCategory) {
		ArrayList<MoviesCsvDto> list = new ArrayList<MoviesCsvDto>();
		MoviesCsvDto moviesCsvDto;
		
		try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
			// String sql = "select m.title,m.movieid,m.genres from movies as m where
			// LOWER(m.genres) like ? limit 10";
			String sql = "select SUBSTRING(m.title,length(m.title)-4,4) as yil,m.movieid,m.title from movies as m "
					+ "where LOWER(m.genres) like ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + searchCategory.toLowerCase() + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				moviesCsvDto = new MoviesCsvDto();
				moviesCsvDto.setMovieId(resultSet.getInt("movieid"));
				moviesCsvDto.setTitle(resultSet.getString("title"));
				moviesCsvDto.setYears(resultSet.getString("yil"));
				list.add(moviesCsvDto);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + "moviesCsvDto belirli türdeki eserlerde hata oluştu");
			e.printStackTrace();
		}
		// if (list.size() == 0) {
		// // Serverde Ara
		// }
		return list;
	}
	
	@Override
	public ArrayList<MoviesCsvDto> daoClientSearchByMoviesName(String name) {
		ArrayList<MoviesCsvDto> list = new ArrayList<MoviesCsvDto>();
		MoviesCsvDto moviesCsvDto;
		try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
			String sql = "select SUBSTRING(m.title,length(m.title)-4,4) as yil,title,max(ratings.rating),min(ratings.rating),avg(ratings.rating) from ratings "
					+ "inner join movies as m on ratings.movieid = m.movieid  where lower(m.title) like ? group by title";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + name.toLowerCase() + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				moviesCsvDto = new MoviesCsvDto();
				
				moviesCsvDto.setTitle(resultSet.getString("title"));
				moviesCsvDto.setMaxRating(resultSet.getDouble("max"));
				moviesCsvDto.setMinRating(resultSet.getDouble("min"));
				moviesCsvDto.setAverageRating(resultSet.getDouble("avg"));
				moviesCsvDto.setYears(resultSet.getString("yil"));
				list.add(moviesCsvDto);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + "moviesCsvDto belirli isimdeki filmlerde hata oluştu");
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public ArrayList<MoviesCsvDtoPacket> daoClientSearchByArthistName(String artistName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

// private void daoCsvfindDatabase() {
//
//
// adaoClientOneYearPublishWorkMovies();
//
// }
//
// public ArrayList<MoviesCsvDto> daoClientOneYearPublishWorkMovies() {
// return null;
// }
