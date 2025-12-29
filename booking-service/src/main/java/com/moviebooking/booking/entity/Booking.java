package com.moviebooking.booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="bookings")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private Long showtimeId;
    private Long userId;
    private int seatCount;
    private double amount;
    private String status; 
    
}
