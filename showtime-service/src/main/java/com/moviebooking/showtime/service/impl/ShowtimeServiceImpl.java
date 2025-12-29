package com.moviebooking.showtime.service.impl;

import com.moviebooking.showtime.dto.ShowtimeDTO;
import com.moviebooking.showtime.entity.Showtime;
import com.moviebooking.showtime.repository.ShowtimeRepository;
import com.moviebooking.showtime.service.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository repo;

    @Override
    public ShowtimeDTO addShowtime(ShowtimeDTO dto) {

        Showtime show = Showtime.builder()
                .movieId(dto.getMovieId())
                .theatreId(dto.getTheatreId())
                .showDate(dto.getShowDate())
                .showTime(dto.getShowTime())
                .availableSeats(dto.getAvailableSeats())
                .build();

        Showtime saved = repo.save(show);
        dto.setShowId(saved.getShowId());

        return dto;
    }

    @Override
    public ShowtimeDTO getShowtime(Long id) {
        Showtime s = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        return map(s);
    }

    @Override
    public List<ShowtimeDTO> getShowtimesByMovie(Long movieId) {
        return repo.findByMovieId(movieId)
                .stream().map(this::map).toList();
    }

    @Override
    public List<ShowtimeDTO> getShowtimesByTheatre(Long theatreId) {
        return repo.findByTheatreId(theatreId)
                .stream().map(this::map).toList();
    }

    @Override
    public List<ShowtimeDTO> getAllShowtimes() {
        return repo.findAll()
                .stream().map(this::map).toList();
    }

    @Override
    public void deleteShowtime(Long id) {
        repo.deleteById(id);
    }

    private ShowtimeDTO map(Showtime s) {
        return ShowtimeDTO.builder()
                .showId(s.getShowId())
                .movieId(s.getMovieId())
                .theatreId(s.getTheatreId())
                .showDate(s.getShowDate())
                .showTime(s.getShowTime())
                .availableSeats(s.getAvailableSeats())
                .build();
    }
}