package com.bilgeadam.mymoviedatabase.clientdto;

public class MoviesCsvDtoPacket {
	
	private MoviesCsvDto movie;
	private LinksCsvDto link;
	private RatingsCsvDto rating;
	private TagsCsvDto tag;
	
	public MoviesCsvDtoPacket(Builder builder) {
		this.movie = builder.movie;
		this.link = builder.link;
		this.rating = builder.rating;
		this.tag = builder.tag;
	}
	
	public MoviesCsvDto getMovie() {
		return movie;
	}
	
	public void setMovie(MoviesCsvDto movie) {
		this.movie = movie;
	}
	
	public LinksCsvDto getLink() {
		return link;
	}
	
	public void setLink(LinksCsvDto link) {
		this.link = link;
	}
	
	public RatingsCsvDto getRating() {
		return rating;
	}
	
	public void setRating(RatingsCsvDto rating) {
		this.rating = rating;
	}
	
	public TagsCsvDto getTag() {
		return tag;
	}
	
	public void setTag(TagsCsvDto tag) {
		this.tag = tag;
	}
	
	// Builder Nesnesi
	static class Builder {
		
		private MoviesCsvDto movie;
		private LinksCsvDto link;
		private RatingsCsvDto rating;
		private TagsCsvDto tag;
		
		public Builder addMovie(MoviesCsvDto movie) {
			this.movie = movie;
			return this;
		}
		
		public Builder addLinks(LinksCsvDto link) {
			this.link = link;
			return this;
		}
		
		public Builder addRating(RatingsCsvDto rating) {
			this.rating = rating;
			return this;
		}
		
		public Builder addTag(TagsCsvDto tag) {
			this.tag = tag;
			return this;
		}
		
		public MoviesCsvDtoPacket build() {
			return new MoviesCsvDtoPacket(this);
		}
	}
	
}
