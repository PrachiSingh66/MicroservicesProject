package com.moviebooking.movie.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.movie.dto.MovieRequest;
import com.moviebooking.movie.dto.MovieResponse;
import com.moviebooking.movie.entity.Movie;
import com.moviebooking.movie.repository.MovieRepository;
import com.moviebooking.movie.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {


    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieResponse addMovie(MovieRequest movieRequest) {
        // Convert DTO to Entity
        Movie movie = new Movie();
        movie.setTitle(movieRequest.getTitle());
        movie.setGenre(movieRequest.getGenre());
        movie.setLanguage(movieRequest.getLanguage());
        movie.setDescription(movieRequest.getDescription());
        movie.setRating(movieRequest.getRating());
        movie.setDurationMinutes(movieRequest.getDurationMinutes());
        movie.setReleaseDate(movieRequest.getReleaseDate());

        // Save Entity
        Movie savedMovie = movieRepository.save(movie);

        // Convert Entity back to Response DTO
        return mapToResponse(savedMovie);
    }

    @Override
    public List<MovieResponse> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MovieResponse getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with ID: " + id));
        return mapToResponse(movie);
    }

    @Override
    public List<MovieResponse> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    // Helper method to convert Entity -> DTO
    private MovieResponse mapToResponse(Movie movie) {
        MovieResponse response = new MovieResponse();
        response.setId(movie.getId());
        response.setTitle(movie.getTitle());
        response.setGenre(movie.getGenre());
        response.setLanguage(movie.getLanguage());
        response.setDescription(movie.getDescription());
        response.setRating(movie.getRating());
        response.setDurationMinutes(movie.getDurationMinutes());
        response.setReleaseDate(movie.getReleaseDate());
        return response;
    }

}
