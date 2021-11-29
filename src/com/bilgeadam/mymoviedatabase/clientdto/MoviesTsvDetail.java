package com.bilgeadam.mymoviedatabase.clientdto;

import java.io.Serializable;

public class MoviesTsvDetail extends MoviesCsvDto implements Serializable {
	
	private static final long serialVersionUID = 5766169347041019596L;
	
	String tconst;
	String titleType;
	String primaryTitle;
	String originalTitle;
	String isAdult;
	String startYear;
	String endYear;
	String runtimeMinutes;
	String genres;
	
	public MoviesTsvDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public MoviesTsvDetail(String tconst, String titleType, String primaryTitle, String originalTitle, String isAdult,
			String startYear, String endYear, String runtimeMinutes, String genres2) {
		super();
		this.tconst = tconst;
		this.titleType = titleType;
		this.primaryTitle = primaryTitle;
		this.originalTitle = originalTitle;
		this.isAdult = isAdult;
		this.startYear = startYear;
		this.endYear = endYear;
		this.runtimeMinutes = runtimeMinutes;
		genres = genres2;
	}
	
	@Override
	public String toString() {
		return "MoviesTsvDetail [tconst=" + tconst + ", titleType=" + titleType + ", primaryTitle=" + primaryTitle
				+ ", originalTitle=" + originalTitle + ", isAdult=" + isAdult + ", startYear=" + startYear
				+ ", endYear=" + endYear + ", runtimeMinutes=" + runtimeMinutes + ", genres=" + genres + "]";
	}
	
	public String getTconst() {
		return tconst;
	}
	
	public void setTconst(String tconst) {
		this.tconst = tconst;
	}
	
	public String getTitleType() {
		return titleType;
	}
	
	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}
	
	public String getPrimaryTitle() {
		return primaryTitle;
	}
	
	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}
	
	public String getOriginalTitle() {
		return originalTitle;
	}
	
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	
	public String getIsAdult() {
		return isAdult;
	}
	
	public void setIsAdult(String isAdult) {
		this.isAdult = isAdult;
	}
	
	public String getStartYear() {
		return startYear;
	}
	
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	
	public String getEndYear() {
		return endYear;
	}
	
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	
	public String getRuntimeMinutes() {
		return runtimeMinutes;
	}
	
	public void setRuntimeMinutes(String runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}
	
	public String getGenres() {
		return genres;
	}
	
	public void setGenres(String genres) {
		this.genres = genres;
	}
	
}
