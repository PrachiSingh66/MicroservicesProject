package com.moviebooking.theatre.service;

import java.util.List;

import com.moviebooking.theatre.entity.Theatre;


public interface TheatreService {

    Theatre addTheatre(Theatre theatre);

    Theatre getTheatreById(Long id);

    List<Theatre> getAllTheatres();

    List<Theatre> getTheatresByCity(String city);

    void deleteTheatre(Long id);
}

