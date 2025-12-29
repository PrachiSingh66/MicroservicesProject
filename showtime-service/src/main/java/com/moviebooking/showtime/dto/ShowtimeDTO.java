package com.moviebooking.showtime.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowtimeDTO {

    private Long showId;
    private Long movieId;
    private Long theatreId;
    private String showDate;
    private String showTime;
    private int availableSeats;
}
