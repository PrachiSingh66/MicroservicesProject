package com.moviebooking.movie.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi movieApi() {
        return GroupedOpenApi.builder()
                .group("movie")
                .pathsToMatch("/**")
                .build();
    }
}


