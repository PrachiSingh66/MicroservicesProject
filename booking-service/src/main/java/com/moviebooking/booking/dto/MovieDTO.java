package com.moviebooking.booking.dto;


import lombok.Data;

@Data
public class MovieDTO {
    private Long movieId;
    private String title;
    private String category;
}