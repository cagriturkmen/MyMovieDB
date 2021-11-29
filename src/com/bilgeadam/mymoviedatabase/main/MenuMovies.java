package com.bilgeadam.mymoviedatabase.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bilgeadam.mymoviedatabase.clientcontroller.DatabaseSearchMethods;
import com.bilgeadam.mymoviedatabase.clientdao.DaoClientWriteToDatabase;
import com.bilgeadam.mymoviedatabase.clientdto.ArtistTsvDetail;
import com.bilgeadam.mymoviedatabase.clientdto.MoviesCsvDto;
import com.bilgeadam.mymoviedatabase.clientdto.MoviesTsvDetail;
import com.bilgeadam.mymoviedatabase.server.ClientTsv;

import language.ChooseLanguage;

public class MenuMovies {
	private Scanner scanner = new Scanner(System.in);
	private ChooseLanguage language = ChooseLanguage.getInstance();
	
	public void startUp() {
		List<String> listCategory = new ArrayList<String>();
		listCategory.add("Action");
		listCategory.add("Adventure");
		listCategory.add("Animation");
		listCategory.add("Children's");
		listCategory.add("Comedy");
		// listCategory.add("Crime");
		// listCategory.add("Documentary");
		// listCategory.add("Drama");
		// listCategory.add("Fantasy");
		// listCategory.add("Film-Noir");
		// listCategory.add("Horror");
		// listCategory.add("Musical");
		// listCategory.add("Mystery");
		// listCategory.add("Romance");
		// listCategory.add("Sci-Fi");
		// listCategory.add("Thriller");
		// listCategory.add("War");
		// listCategory.add("Western");
		// listCategory.add("(no genres listed)");
		List<String> listYear = new ArrayList<String>();
		listYear.add("1995");
		listYear.add("1996");
		listYear.add("1997");
		listYear.add("1998");
		listYear.add("1999");
		String choose = "";
		
		while (!choose.equals("0")) {
			choose = showMenu();
			switch (choose) {
				case "1":
					System.out.println("Aramak istediğiniz yılı giriniz");
					choose = scanner.next();
					
					List<MoviesCsvDto> temp1 = DatabaseSearchMethods.getInstance()
							.daoClientSearchByYear(choose);
					System.out.println(choose);
					for (String genres : listCategory) {
						int count = 0;
						for (MoviesCsvDto moviesCsvDto : temp1) {
							if (moviesCsvDto.getGenres().contains(genres)) {
								if (count == 0) {
									System.out.println("\t" + genres);
								}
								count++;
								System.out.printf("\t\tTİTLE = %-40s\n ", moviesCsvDto.getTitle());
								if (count > 5) {
									break;
								}
							}
							
						}
					}
					
					// for (MoviesCsvDto moviesCsvDto : temp1) {
					// System.out.printf("TİTLe = %-40s GENRES = %s%n ", moviesCsvDto.getTitle());
					// }
					// temp1.forEach(MoviesCsvDto::printTitleAndGenres);
					choose = scanner.next();
					break;
				case "2":
					System.out.println("Aramak istediğiniz kategori nedir?");
					choose = scanner.next();
					List<MoviesCsvDto> temp2 = DatabaseSearchMethods.getInstance()
							.daoClientSearchByCategory(choose);
					System.out.println(choose);
					for (String years : listYear) {
						int count = 0;
						for (MoviesCsvDto moviesCsvDto : temp2) {
							if (moviesCsvDto.getYears().contains(years)) {
								if (count == 0) {
									System.out.println("\t" + years);
								}
								count++;
								System.out.printf("\t\tTİTLE = %-40s\n", moviesCsvDto.getTitle());
								if (count > 5) {
									break;
								}
							}
						}
					}
					// temp2.forEach(System.out::println);
					choose = scanner.next();
					break;
				case "3":
					ClientTsv client2 = new ClientTsv();
					System.out.println("Film ismini giriniz");
					choose = scanner.next();
					List<MoviesCsvDto> temp3 = DatabaseSearchMethods.getInstance()
							.daoClientSearchByMoviesName(choose);
					MoviesTsvDetail mov = (MoviesTsvDetail) client2.run(choose + "&movie");
					temp3.forEach(System.out::println);
					System.out.println(mov);
					
					break;
				case "4":
					System.out.println("Artist adını giriniz");
					choose = scanner.nextLine();
					ClientTsv client = new ClientTsv();
					ArtistTsvDetail temp = (ArtistTsvDetail) client.run(choose + "&artist");
					System.out.println(temp.getPrimaryName());
					System.out.println("\t Doğum : " + temp.getBirthYear() + "\tÖlüm : " + temp.getDeathYear());
					System.out.println("\t Görevler : " + temp.getPrimaryProfession().replace(",", "-"));
					System.out.println("\t Bilindik Filmleri : ");
					int count = 1;
					for (MoviesTsvDetail temp11 : temp.getListMovie()) {
						System.out.println("\t\t " + count + "-) " + temp11.getYears() + " " + temp11.getOriginalTitle()
								+ "  " + temp11.getAverageRating());
						
						count++;
					}
					
					System.out.println();
					System.out.println();
					choose = scanner.next();
					break;
				case "5":
					DaoClientWriteToDatabase daoClientWriteToDatabase = new DaoClientWriteToDatabase();
					daoClientWriteToDatabase.writeCsvDatabase();
					choose = scanner.next();
					break;
				case "6":
					language.chanceLanguage();
					break;
				
				default:
					System.out.println("Hatalı Giriş Yaptınız");
					choose = scanner.next();
					break;
			}
			
		}
		
	}
	
	private String showMenu() {
		System.out.println(translate("LANGUAGE.NAME_APP"));
		System.out.println(translate("LANGUAGE.MENU_MAIN"));
		System.out.println("--------------------------------");
		System.out.println(translate("LANGUAGE.SEARCH_YEAR"));
		System.out.println(translate("LANGUAGE.SEARCH_CATEGORY"));
		System.out.println(translate("LANGUAGE.SEARCH_MOVIES_NAME"));
		System.out.println(translate("LANGUAGE.SEARCH_ARTIST_NAME"));
		System.out.println(translate("LANGUAGE.RESET_RELOAD"));
		System.out.println(translate("LANGUAGE.CHANCE_LANGUAGE"));
		System.out.println(translate("LANGUAGE.EXIT"));
		System.out.println("--------------------------------");
		
		String choose = scanner.next();
		scanner.nextLine();
		return choose;
	}
	
	private String translate(String s) {
		return language.getLanguage().getString(s);
	}
	
}
