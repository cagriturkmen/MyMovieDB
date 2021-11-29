package com.bilgeadam.mymoviedatabase.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.bilgeadam.mymoviedatabase.clientcontroller.DatabaseSearchMethods;
import com.bilgeadam.mymoviedatabase.clientdto.ArtistTsvDetail;
import com.bilgeadam.mymoviedatabase.clientdto.MoviesCsvDto;
import com.bilgeadam.mymoviedatabase.clientdto.MoviesTsvDetail;

public class ServerTsv {
	
	public void runServer() {
		
		try (ServerSocket serverSocket = new ServerSocket(5555)) {
			
			System.out.println("Server almaya hazır");
			
			Socket socket = serverSocket.accept();
			System.out.println("Bağlantı: " + socket);
			
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			while (true) {
				String searchKey = dataInputStream.readUTF();
				System.out.println("Aranacak kelime" + searchKey);
				String[] array = searchKey.split("&");
				if (array[1].equals("movie")) {
					System.out.println("Movies Tsv de aranıyor" + array[0]);
					MoviesTsvDetail result = fileReaderMoviesTryWithResources(array[0]);
					// Client e movies arıyorsak gelen sorguyu MoviesTsvDetail cast
					// edicez
					out.writeObject(result);
				} else {
					System.out.println("Artist Tsv de aranıyor" + array[0]);
					ArtistTsvDetail result = fileReaderNameCsvTryWithResources(array[0]);
					
					out.writeObject(result);
					// Client e artist arıyorsak gelen sorguyu MoviesArthistTsvDetail cast edicez
				}
				System.out.println("Cevab gönderildi");
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public MoviesTsvDetail fileReaderMoviesTryWithResources(String searchKey) {
		MoviesTsvDetail movTsv = null;
		
		String satir = "";
		String path = "C:\\bilgeadam\\raw\\movies.tsv";
		
		// try with resource yapısı
		// int movieId, String title, String genres, String tconst, String titleType,
		// String primaryTitle, String originalTitle, String isAdult, String startYear,
		// String endYear,
		// String runtimeMinutes, String genres2)
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			
			while ((satir = bufferedReader.readLine()) != null) {
				
				if (satir.toLowerCase().contains(searchKey.toLowerCase())) {
					
					StringTokenizer stringTokenizer = new StringTokenizer(satir, "\t");
					movTsv = new MoviesTsvDetail(stringTokenizer.nextToken(), stringTokenizer.nextToken(),
							stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken(),
							stringTokenizer.nextToken(), stringTokenizer.nextToken(), stringTokenizer.nextToken(),
							stringTokenizer.nextToken());
					ArrayList<MoviesCsvDto> list = DatabaseSearchMethods.getInstance()
							.daoClientSearchByMoviesName(movTsv.getPrimaryTitle());
					if (list.size() > 0) {
						MoviesCsvDto movCsv = list.get(0);
						movTsv.setYears(movCsv.getYears());
						movTsv.setMaxRating(movCsv.getMaxRating());
						movTsv.setMinRating(movCsv.getMinRating());
						movTsv.setAverageRating(movCsv.getAverageRating());
					}
					System.out.println("Film bulundu**");
					break;
				}
				
			}
			if (movTsv == null) {
				System.out.println("Film bulunamadı");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movTsv;
	}
	
	public ArtistTsvDetail fileReaderNameCsvTryWithResources(String searchKey) {
		
		String satir = "";
		String path = "C:\\bilgeadam\\raw\\names.tsv";
		ArtistTsvDetail temp = null;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			while ((satir = bufferedReader.readLine()) != null) {
				
				if (satir.toLowerCase().contains(searchKey.toLowerCase())) {
					StringTokenizer stringTokenizer = new StringTokenizer(satir, "\t");
					temp = new ArtistTsvDetail();
					if (stringTokenizer.hasMoreTokens()) {
						temp.setNconst(stringTokenizer.nextToken());
					}
					if (stringTokenizer.hasMoreTokens()) {
						temp.setPrimaryName(stringTokenizer.nextToken());
					}
					if (stringTokenizer.hasMoreTokens()) {
						temp.setBirthYear(stringTokenizer.nextToken());
					}
					if (stringTokenizer.hasMoreTokens()) {
						temp.setDeathYear(stringTokenizer.nextToken());
					}
					if (stringTokenizer.hasMoreTokens()) {
						temp.setPrimaryProfession(stringTokenizer.nextToken());
					}
					if (stringTokenizer.hasMoreTokens()) {
						temp.setKnownForTitles(stringTokenizer.nextToken());
					}
					String[] tconst = temp.getKnownForTitles().split("[,]");
					ArrayList<MoviesTsvDetail> listMovie = new ArrayList<MoviesTsvDetail>();
					for (int i = 0; i < tconst.length; i++) {
						MoviesTsvDetail movTsv = fileReaderMoviesTryWithResources(tconst[i]);
						
						listMovie.add(movTsv);
					}
					temp.setListMovie(listMovie);
					
					break;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(temp);
		return temp;
	}
	
}

// Adım 1: Server artist adını alacak
// Adım 2: Names.tsv de artist aranacak.İlk bulunan artist döngüden çıkıcak.
// Adım 3: Artistin filmlerini arayacak.movies.tsv
