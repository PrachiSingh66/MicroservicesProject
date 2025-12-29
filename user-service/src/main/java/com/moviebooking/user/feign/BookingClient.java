package com.moviebooking.user.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="booking-service")
public interface BookingClient {
	@PostMapping("/bookings/user/{userId}")
	List<String> getBookingsByUser(@PathVariable("userId") Long userId);
}
