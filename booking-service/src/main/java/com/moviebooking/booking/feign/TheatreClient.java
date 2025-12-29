package com.moviebooking.booking.feign;

/*@FeignClient(name="theatre-service")
public interface TheatreClient {
	@GetMapping("/theatres/{id}")
	TheatreDTO getTheatre(@PathVariable Long id);
}*/

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.moviebooking.booking.dto.TheatreDTO;

@FeignClient(name = "theatre-service", url = "http://localhost:8002")
public interface TheatreClient {

    @GetMapping("/theatres/{id}")
    TheatreDTO getTheatre(@PathVariable Long id);
}
