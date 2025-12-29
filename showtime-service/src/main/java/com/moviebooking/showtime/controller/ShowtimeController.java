package com.moviebooking.showtime.controller;


import com.moviebooking.showtime.dto.ShowtimeDTO;
import com.moviebooking.showtime.service.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService service;

    @PostMapping
    public ShowtimeDTO add(@RequestBody ShowtimeDTO dto) {
        return service.addShowtime(dto);
    }

    @GetMapping("/{id}")
    public ShowtimeDTO get(@PathVariable Long id) {
        return service.getShowtime(id);
    }

    @GetMapping("/movie/{movieId}")
    public List<ShowtimeDTO> getByMovie(@PathVariable Long movieId) {
        return service.getShowtimesByMovie(movieId);
    }

    @GetMapping("/theatre/{theatreId}")
    public List<ShowtimeDTO> getByTheatre(@PathVariable Long theatreId) {
        return service.getShowtimesByTheatre(theatreId);
    }

    @GetMapping
    public List<ShowtimeDTO> all() {
        return service.getAllShowtimes();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteShowtime(id);
        return "Showtime deleted.";
    }
}
