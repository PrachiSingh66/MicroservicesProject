package com.moviebooking.movie.service;

import java.util.List;

import com.moviebooking.movie.dto.MovieRequest;
import com.moviebooking.movie.dto.MovieResponse;


public interface MovieService {

	 MovieResponse addMovie(MovieRequest movieRequest);
	    List<MovieResponse> getAllMovies();
	    MovieResponse getMovieById(Long id);
	    List<MovieResponse> getMoviesByGenre(String genre);
	    void deleteMovie(Long id);
}

