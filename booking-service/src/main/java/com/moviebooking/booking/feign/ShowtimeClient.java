package com.moviebooking.booking.feign;


/*@FeignClient(name="showtime-service")
public interface ShowtimeClient {
	@GetMapping("/showtimes/{id}")
	ShowtimeDTO getShowtime(@PathVariable Long id);
}*/

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.moviebooking.booking.dto.ShowtimeDTO;

@FeignClient(name = "showtime-service", url = "http://localhost:8003")
public interface ShowtimeClient {

    @GetMapping("/showtimes/{id}")
    ShowtimeDTO getShowtime(@PathVariable Long id);
}
