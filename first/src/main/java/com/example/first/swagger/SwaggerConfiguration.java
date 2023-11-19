package com.example.first.swagger;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi dayWordApi() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/dayWord/**")
                .group("DayWord")
                .build();
    }

    @Bean
    public GroupedOpenApi noteApi() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/note/**")
                .group("Note")
                .build();
    }


    @Bean
    public GroupedOpenApi wordInSentenceApi() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/wordInSentence/**")
                .group("WordInSentence")
                .build();
    }

    @Bean
    public GroupedOpenApi wordTypeApi() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/wordType/**")
                .group("WordType")
                .build();
    }
}
