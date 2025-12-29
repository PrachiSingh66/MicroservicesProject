package com.moviebooking.theatre.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.moviebooking.theatre.dto.TheatreRequest;
import com.moviebooking.theatre.entity.Theatre;
import com.moviebooking.theatre.service.TheatreService;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Theatre createTheatre(@RequestBody TheatreRequest request) {
        Theatre theatre = new Theatre();
        theatre.setName(request.getName());
        theatre.setCity(request.getCity());
        theatre.setAddress(request.getAddress());
        theatre.setTotalScreens(request.getTotalScreens());
        return theatreService.addTheatre(theatre);
    }

    @GetMapping("/{id}")
    public Theatre getTheatreById(@PathVariable Long id) {
        return theatreService.getTheatreById(id);
    }

    @GetMapping
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @GetMapping("/city/{city}")
    public List<Theatre> getTheatresByCity(@PathVariable String city) {
        return theatreService.getTheatresByCity(city);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTheatre(@PathVariable Long id) {
        theatreService.deleteTheatre(id);
    }
}