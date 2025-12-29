package com.moviebooking.booking.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowtimeDTO {
    private Long showtimeId;
    private Long movieId;
    private Long theatreId;
    private LocalDate date;
    private LocalTime time;
    private String screen;
}
