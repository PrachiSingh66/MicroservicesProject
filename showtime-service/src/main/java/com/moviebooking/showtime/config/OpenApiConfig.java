package com.moviebooking.showtime.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi showtimeApi() {
        return GroupedOpenApi.builder()
                .group("showtime")
                .pathsToMatch("/**")
                .build();
    }
}

