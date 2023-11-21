package com.example.second.client;

import com.example.second.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientSpecification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@FeignClient(name = "",path ="/first/dayWord" /*"http://localhost:8090"*/)
/*@FeignClient("first")
public interface DayWordClient {

    @RequestMapping(method = RequestMethod.GET, value = ("/getAllDayWordByWordId"))
    ResponseDto<List<DayWordResponse>> getAllDayWordByWordId(@RequestParam Integer id);
}*/
