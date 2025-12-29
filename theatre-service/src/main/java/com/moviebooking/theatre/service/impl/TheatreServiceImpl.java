package com.moviebooking.theatre.service.impl;

import org.springframework.stereotype.Service;

import com.moviebooking.theatre.entity.Theatre;
import com.moviebooking.theatre.exception.TheatreNotFoundException;
import com.moviebooking.theatre.repository.TheatreRepository;
import com.moviebooking.theatre.service.TheatreService;

import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;

    public TheatreServiceImpl(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    @Override
    public Theatre addTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    @Override
    public Theatre getTheatreById(Long id) {
        return theatreRepository.findById(id)
                .orElseThrow(() -> new TheatreNotFoundException("Theatre not found with id " + id));
    }

    @Override
    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    @Override
    public List<Theatre> getTheatresByCity(String city) {
        return theatreRepository.findByCity(city);
    }

    @Override
    public void deleteTheatre(Long id) {
        Theatre theatre = getTheatreById(id);
        theatreRepository.delete(theatre);
    }
}