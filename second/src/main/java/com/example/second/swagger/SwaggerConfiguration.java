package com.example.second.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {


    @Bean
    public GroupedOpenApi AudioApi() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/audio/**")
                .group("Audio")
                .build();
    }

    @Bean
    public GroupedOpenApi CategoryApi() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/category/**")
                .group("Category")
                .build();
    }



    @Bean
    public GroupedOpenApi SentenceApi() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/sentence/**")
                .group("Sentence")
                .build();
    }

    @Bean
    public GroupedOpenApi TypeApi() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/type/**")
                .group("Type")
                .build();
    }
    @Bean
    public GroupedOpenApi WordApi() {
        return GroupedOpenApi.builder()
                .pathsToMatch("/word/**")
                .group("Word")
                .build();
    }
}
