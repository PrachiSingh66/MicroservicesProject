package com.moviebooking.showtime.service;

import com.moviebooking.showtime.dto.ShowtimeDTO;

import java.util.List;

public interface ShowtimeService {

    ShowtimeDTO addShowtime(ShowtimeDTO dto);

    ShowtimeDTO getShowtime(Long showId);

    List<ShowtimeDTO> getShowtimesByMovie(Long movieId);

    List<ShowtimeDTO> getShowtimesByTheatre(Long theatreId);

    List<ShowtimeDTO> getAllShowtimes();

    void deleteShowtime(Long showId);
}