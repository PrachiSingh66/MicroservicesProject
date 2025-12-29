package com.moviebooking.showtime.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;

    private Long movieId;
    private Long theatreId;

    private String showDate;  // YYYY-MM-DD
    private String showTime;  // HH:mm

    private int availableSeats;
}
