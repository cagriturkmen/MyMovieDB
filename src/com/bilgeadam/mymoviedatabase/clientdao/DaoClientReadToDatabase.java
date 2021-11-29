package com.bilgeadam.mymoviedatabase.clientdao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

public class DaoClientReadToDatabase implements Serializable {
	
	private static final long serialVersionUID = 8468865962127279871L;
	
	public void readCsvDatabase() {
		csvReadDatabase();
		
	}
	
	private void csvReadDatabase() {
		String PATH = "F:\\aratatil\\links.csv";
		readLinksCsvDatabase(PATH);
		
		PATH = "F:\\aratatil\\movies.csv";
		readMoviesCsvDatabase(PATH);
		
		// PATH = "F:\\aratatil\\ratings.csv";
		// readRatingsCsvDatabase(PATH);
		
		PATH = "F:\\aratatil\\tags.csv";
		readTagsCsvDatabase(PATH);
	}
	
	private void readTagsCsvDatabase(String path) {
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			
			String toplamSatirlar = "";
			String satir = "";
			while ((satir = bufferedReader.readLine()) != null) {
				toplamSatirlar = toplamSatirlar + satir + "\n";
			}
			System.out.println(toplamSatirlar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void readRatingsCsvDatabase(String path) {
		// TODO Auto-generated method stub
		
	}
	
	private void readMoviesCsvDatabase(String path) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			
			String toplamSatirlar = "";
			String satir = "";
			while ((satir = bufferedReader.readLine()) != null) {
				toplamSatirlar = toplamSatirlar + satir + "\n";
			}
			System.out.println(toplamSatirlar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void readLinksCsvDatabase(String path) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			
			String toplamSatirlar = "";
			String satir = "";
			while ((satir = bufferedReader.readLine()) != null) {
				toplamSatirlar = toplamSatirlar + satir + "\n";
			}
			System.out.println(toplamSatirlar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
