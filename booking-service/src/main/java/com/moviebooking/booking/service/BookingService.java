package com.moviebooking.booking.service;


import com.moviebooking.booking.entity.Booking;

public interface BookingService {

    Booking createBooking(Long showtimeId, Long userId, int seatCount);

    Booking getBooking(Long id);
}