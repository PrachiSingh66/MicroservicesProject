package com.moviebooking.booking.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.booking.dto.MovieDTO;
import com.moviebooking.booking.dto.ShowtimeDTO;
import com.moviebooking.booking.dto.TheatreDTO;
import com.moviebooking.booking.entity.Booking;
import com.moviebooking.booking.feign.MovieClient;
import com.moviebooking.booking.feign.PaymentClient;
//import com.moviebooking.booking.feign.PaymentClient;
import com.moviebooking.booking.feign.ShowtimeClient;
import com.moviebooking.booking.feign.TheatreClient;
import com.moviebooking.booking.repository.BookingRepository;
import com.moviebooking.booking.service.BookingService;


@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
	
    private final BookingRepository repo;
    private final ShowtimeClient showtimeClient;
    private final MovieClient movieClient;
    private final TheatreClient theatreClient;
    @Autowired
    private PaymentClient paymentClient;

    @Override
    public Booking createBooking(Long showtimeId, Long userId, int seatCount) {

        ShowtimeDTO st = showtimeClient.getShowtime(showtimeId);
        MovieDTO movie = movieClient.getMovie(st.getMovieId());
        TheatreDTO theatre = theatreClient.getTheatre(st.getTheatreId());
        

        double amount = seatCount * 150;

        Booking booking = Booking.builder()
                .showtimeId(showtimeId)
                .seatCount(seatCount)
                .userId(userId)
                .amount(amount)
                .status("BOOKED")
                .build();

        return repo.save(booking);
    }

    @Override
    public Booking getBooking(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }
}
