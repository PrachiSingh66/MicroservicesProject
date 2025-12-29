package com.moviebooking.booking.feign;

/*@FeignClient(name="movie-service")
public interface MovieClient {
	@GetMapping("/movies/{id}")
	MovieDTO getMovie(@PathVariable Long id);
}*/

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.moviebooking.booking.dto.MovieDTO;

@FeignClient(name = "movie-service", url = "http://localhost:8001")
public interface MovieClient {

    @GetMapping("/movies/{id}")
    MovieDTO getMovie(@PathVariable Long id);
}