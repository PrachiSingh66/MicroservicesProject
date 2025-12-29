package com.moviebooking.theatre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviebooking.theatre.entity.Theatre;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    List<Theatre> findByCity(String city);
}
