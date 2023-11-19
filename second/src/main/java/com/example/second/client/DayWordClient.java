package com.example.second.client;

import com.example.second.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "first",path = "/first/dayWord/**")
public interface DayWordClient {

    @GetMapping("/getAllDayWordByWordId")
    ResponseDto<List<DayWordResponse>> getAllDayWordByWordId(@RequestParam Integer id);
}
