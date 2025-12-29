package com.moviebooking.theatre.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi theatreApi() {
        return GroupedOpenApi.builder()
                .group("theatre")
                .pathsToMatch("/**")
                .build();
    }
}
