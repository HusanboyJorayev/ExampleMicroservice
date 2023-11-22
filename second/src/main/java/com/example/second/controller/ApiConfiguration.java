package com.example.second.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.client.RestTemplate;




@Configuration
public class ApiConfiguration {

    protected static final String BASEURL="http://localhost:8090/first";
    public static final String SECOND_SERVICE="second";

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
