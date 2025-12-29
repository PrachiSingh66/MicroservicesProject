package com.moviebooking.booking.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.moviebooking.booking.entity.Booking;
import com.moviebooking.booking.service.BookingService;


@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService service;
    
    @GetMapping("/user/{userId}")
    public List<String> getBookingsByUser(@PathVariable Long userId){
    	return List.of("Booking for user: "+userId,
    			"Booking for user: "+userId);
    			
    }

    @PostMapping("/create")
    public Booking createBooking(
            @RequestParam Long showtimeId,
            @RequestParam Long userId,
            @RequestParam int seats) {

        return service.createBooking(showtimeId, userId, seats);
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id) {
        return service.getBooking(id);
    }
}
