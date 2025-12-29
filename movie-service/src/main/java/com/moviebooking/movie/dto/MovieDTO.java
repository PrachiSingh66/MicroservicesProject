package com.moviebooking.movie.dto;

public class MovieDTO {
	private Long movieId;
	private String name;
	private String genre;
	public MovieDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieDTO(Long movieId, String name, String genre) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.genre = genre;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
