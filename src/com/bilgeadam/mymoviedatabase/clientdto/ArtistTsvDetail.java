package com.bilgeadam.mymoviedatabase.clientdto;

import java.io.Serializable;
import java.util.ArrayList;

public class ArtistTsvDetail implements Serializable {
	
	private static final long serialVersionUID = 8099770063404674849L;
	
	String nconst;
	String primaryName;
	String birthYear;
	String deathYear;
	String primaryProfession;
	String knownForTitles;
	ArrayList<MoviesTsvDetail> listMovie = new ArrayList<MoviesTsvDetail>();
	
	public ArtistTsvDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public ArtistTsvDetail(String nconst, String primaryName, String birthYear, String deathYear,
			String primaryProfession, String knownForTitles) {
		this.nconst = nconst;
		this.primaryName = primaryName;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
		this.primaryProfession = primaryProfession;
		this.knownForTitles = knownForTitles;
	}
	
	@Override
	public String toString() {
		return "ArthistTsvDetail [nconst=" + nconst + ", primaryName=" + primaryName + ", birthYear=" + birthYear
				+ ", deathYear=" + deathYear + ", primaryProfession=" + primaryProfession + ", knownForTitles="
				+ knownForTitles + ", listMovie=" + listMovie + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	public String getNconst() {
		return nconst;
	}
	
	public void setNconst(String nconst) {
		this.nconst = nconst;
	}
	
	public String getPrimaryName() {
		return primaryName;
	}
	
	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}
	
	public String getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	
	public String getDeathYear() {
		return deathYear;
	}
	
	public void setDeathYear(String deathYear) {
		this.deathYear = deathYear;
	}
	
	public String getPrimaryProfession() {
		return primaryProfession;
	}
	
	public void setPrimaryProfession(String primaryProfession) {
		this.primaryProfession = primaryProfession;
	}
	
	public String getKnownForTitles() {
		return knownForTitles;
	}
	
	public void setKnownForTitles(String knownForTitles) {
		this.knownForTitles = knownForTitles;
	}
	
	public ArrayList<MoviesTsvDetail> getListMovie() {
		return listMovie;
	}
	
	public void setListMovie(ArrayList<MoviesTsvDetail> listMovie) {
		this.listMovie = listMovie;
	}
	
}
