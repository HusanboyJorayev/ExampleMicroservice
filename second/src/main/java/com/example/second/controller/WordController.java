package com.example.second.controller;


import com.example.second.client.DayWordResponse;
import com.example.second.client.NoteResponse;
import com.example.second.client.WordInSentenceResponse;
import com.example.second.client.WordTypeResponse;
import com.example.second.dto.ResponseDto;
import com.example.second.request.WordRequest;
import com.example.second.response.WordResponse;
import com.example.second.service.WordService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.example.second.controller.ApiConfiguration.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("word")
@Tag(name = "Word api")
public class WordController {
    private final WordService wordService;

    @Lazy
    private final RestTemplate restTemplate;

    @PostMapping("/create")
    public ResponseDto<WordResponse> create(@RequestBody @Valid WordRequest request) {
        return this.wordService.create(request);
    }

    @GetMapping("/get")
    public ResponseDto<WordResponse> get(@RequestParam Integer id) {
        return this.wordService.get(id);
    }

    @PutMapping("/update")
    ResponseDto<WordResponse> update(@RequestBody @Valid WordRequest request, @RequestParam Integer id) {
        return this.wordService.update(request, id);
    }

    @DeleteMapping("/delete")
    public ResponseDto<WordResponse> delete(@RequestParam Integer id) {
        return this.wordService.delete(id);
    }

    @GetMapping("/getAll")
    public ResponseDto<List<WordResponse>> getAllType() {
        return this.wordService.getAllType();
    }

    @GetMapping("/pageable")
    public ResponseDto<Page<WordResponse>> getPage(@RequestParam Integer page, @RequestParam Integer size) {
        return this.wordService.getPage(page, size);
    }

    @GetMapping("/getAllByAudioId")
    public ResponseDto<WordResponse> getAllByAudioId(@RequestParam Integer id) {
        return this.wordService.getAllByAudioId(id);
    }

    @GetMapping("/getAllByCategoryId")
    public ResponseDto<WordResponse> getAllByCategoryId(@RequestParam Integer id) {
        return this.wordService.getAllByCategoryId(id);
    }

    @CircuitBreaker(name = SECOND_SERVICE, fallbackMethod = "fallbackMethod")
    @RequestMapping(value = "/getAllByWordId")
    public ResponseDto<WordTypeResponse> getAllByWordId(@RequestParam Integer id) {
        String url = id == 0 ? BASEURL : BASEURL + "/wordType/getAllByWordId?id=" + id;
        return restTemplate.getForObject(url, ResponseDto.class);
    }

    public ResponseDto<WordTypeResponse> fallbackMethod(Exception e) {
        return ResponseDto.<WordTypeResponse>builder()
                .message("first service is eomething error")
                .build();
    }


    @RequestMapping(value = "/getAllDayWordByWordId")
    public ResponseDto<DayWordResponse> getAllDayWordByWordId(@RequestParam Integer id) {
        String url = id == 0 ? BASEURL : BASEURL + "/dayWord/getAllDayWordByWordId?id=" + id;
        return restTemplate.getForObject(url, ResponseDto.class);
    }

    @RequestMapping(value = "/getAllNoteByWordId")
    public ResponseDto<NoteResponse> getAllNoteByWordId(@RequestParam Integer id) {
        String url = id == 0 ? BASEURL : BASEURL + "/note/getAllNoteByWordId?id=" + id;
        return restTemplate.getForObject(url, ResponseDto.class);
    }

    @RequestMapping(value = "/getAllWordInSentenceByWordId")
    public ResponseDto<WordInSentenceResponse> getAllWordInSentenceByWordId(@RequestParam Integer id) {
        String url = id == 0 ? BASEURL : BASEURL + "/wordInSentence/getAllWordInSentenceByWordId?id=" + id;
        return restTemplate.getForObject(url, ResponseDto.class);
    }

}
