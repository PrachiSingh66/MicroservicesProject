package com.moviebooking.movie.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MovieRequest {

	   private String title;
	    private String genre;
	    private String language;
	    private String description;
	    private Double rating;
	    private Integer durationMinutes;
	    private LocalDate releaseDate;
}

