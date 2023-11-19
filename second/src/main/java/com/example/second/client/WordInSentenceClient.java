package com.example.second.client;

import com.example.second.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "first",path = "/first/wordInSentence/**")
public interface WordInSentenceClient {

    @GetMapping("/getAllByWordId")
    ResponseDto<List<WordInSentenceResponse>>getAllWordInSentenceByWordId(@RequestParam Integer id);

    @GetMapping("/getAllByWordInSentenceBySentenceId")
    ResponseDto<List<WordInSentenceResponse>> getAllWordInSentenceBySentenceId(@RequestParam Integer id);
}
