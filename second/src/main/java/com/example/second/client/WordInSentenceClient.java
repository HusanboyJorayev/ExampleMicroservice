package com.example.second.client;

import com.example.second.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientSpecification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@FeignClient(name = "",path ="/first/wordInSentence" /*"http://localhost:8090"*/)
/*@FeignClient("first")
public interface WordInSentenceClient {

    //@GetMapping("/getAllWordInSentenceByWordId")
    @RequestMapping(method = RequestMethod.GET, value = "/getAllWordInSentenceByWordId")
    ResponseDto<List<WordInSentenceResponse>> getAllWordInSentenceByWordId(@RequestParam Integer id);

    //@GetMapping("/getAllByWordInSentenceBySentenceId")
    @RequestMapping(method = RequestMethod.GET, value = "/getAllByWordInSentenceBySentenceId")
    ResponseDto<List<WordInSentenceResponse>> getAllWordInSentenceBySentenceId(@RequestParam Integer id);
}*/
