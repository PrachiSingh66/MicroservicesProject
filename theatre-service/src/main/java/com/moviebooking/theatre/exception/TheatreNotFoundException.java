package com.moviebooking.theatre.exception;


public class TheatreNotFoundException extends RuntimeException {

    public TheatreNotFoundException(String message) {
        super(message);
    }
}
