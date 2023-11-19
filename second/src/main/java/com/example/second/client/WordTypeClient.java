package com.example.second.client;

import com.example.second.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "first",path = "/first/word/**")
public interface WordTypeClient {
    @GetMapping("/getAllByWordId")
    ResponseDto<List<WordTypeResponse>> getAllByWordId(@RequestParam Integer id);

    @GetMapping("/getAllByTypeId")
    ResponseDto<List<WordTypeResponse>>getAllByTypeId(@RequestParam Integer id);
}
