package com.bilgeadam.mymoviedatabase.clientdto;

import java.io.Serializable;

public class CommonProperty implements Serializable {
	
	private static final long serialVersionUID = 7955751432473023123L;
	private int movieId;
	
	public CommonProperty() {
		
	}
	
	public CommonProperty(int movieId) {
		super();
		this.movieId = movieId;
	}
	
	@Override
	public String toString() {
		return "CommonProperty [movieId=" + movieId + "]";
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
}
