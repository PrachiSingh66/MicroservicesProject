package com.moviebooking.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.movie.dto.MovieDTO;
import com.moviebooking.movie.dto.MovieRequest;
import com.moviebooking.movie.dto.MovieResponse;
import com.moviebooking.movie.service.MovieService;


@RestController
@RequestMapping("/movies")

public class MovieController {

	
    @Autowired
    private MovieService movieService;
    
    @GetMapping("/{movieId}")
    public MovieDTO getMovie(@PathVariable Long movieId) {
    	return new MovieDTO(movieId,"Inception","Sci-Fi");
    }

    @PostMapping
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest movieRequest) {
        return new ResponseEntity<>(movieService.addMovie(movieRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieResponse>> getMoviesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully");
    }
}
