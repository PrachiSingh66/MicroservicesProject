package com.moviebooking.showtime.repository;

import com.moviebooking.showtime.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

    List<Showtime> findByMovieId(Long movieId);

    List<Showtime> findByTheatreId(Long theatreId);
}