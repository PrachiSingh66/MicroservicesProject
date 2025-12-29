package com.moviebooking.booking.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    GroupedOpenApi bookingApi() {
        return GroupedOpenApi.builder()
                .group("booking")
                .pathsToMatch("/**")
                .build();
    }
}

