package com.moviebooking.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            // 1. User Service
            .route("user-service", r -> r
                .path("/users/**", "/v3/api-docs/user")
                .filters(f -> f.setPath("/v3/api-docs"))
                .uri("lb://USER-SERVICE"))

            // 2. Movie Service
            .route("movie-service", r -> r
                .path("/movies/**", "/v3/api-docs/movie")
                .filters(f -> f.setPath("/v3/api-docs"))
                .uri("lb://MOVIE-SERVICE"))
         
            // 3. Booking Service
            .route("booking-service", r -> r
                .path("/bookings/**", "/v3/api-docs/booking")
                .filters(f -> f.setPath("/v3/api-docs"))
                .uri("lb://BOOKING-SERVICE"))

            // 4. Theatre Service
            .route("theatre-service", r -> r
                .path("/theatres/**", "/v3/api-docs/theatre")
                .filters(f -> f.setPath("/v3/api-docs"))
                .uri("lb://THEATRE-SERVICE"))

            // 5. Showtime Service
            .route("showtime-service", r -> r
                .path("/showtimes/**", "/v3/api-docs/showtime")
                .filters(f -> f.setPath("/v3/api-docs"))
                .uri("lb://SHOWTIME-SERVICE"))

            // 6. Payment Service
            .route("payment-service", r -> r
                .path("/payments/**", "/v3/api-docs/payment")
                .filters(f -> f.setPath("/v3/api-docs"))
                .uri("lb://PAYMENT-SERVICE"))

            .build();
    }
}
