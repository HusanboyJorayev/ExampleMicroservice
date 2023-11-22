package com.example.second.controller;

import com.example.second.client.WordInSentenceResponse;
import com.example.second.dto.ResponseDto;
import com.example.second.request.SentenceRequest;
import com.example.second.response.SentenceResponce;
import com.example.second.service.SentenceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.example.second.controller.ApiConfiguration.BASEURL;

@RestController
@RequiredArgsConstructor
@RequestMapping("sentence")
@Tag(name = "Sentence api")
public class SentenceController {
    private final SentenceService sentenceService;

    @Lazy
    private final RestTemplate restTemplate;

    @PostMapping("/create")
    public ResponseDto<SentenceResponce> create(@RequestBody @Valid SentenceRequest request) {
        return this.sentenceService.create(request);
    }

    @GetMapping("/get")
    public ResponseDto<SentenceResponce> get(@RequestParam Integer id) {
        return this.sentenceService.get(id);
    }

    @PutMapping("/update")
    ResponseDto<SentenceResponce> update(@RequestBody @Valid SentenceRequest request, @RequestParam Integer id) {
        return this.sentenceService.update(request, id);
    }

    @DeleteMapping("/delet")
    public ResponseDto<SentenceResponce> delete(@RequestParam Integer id) {
        return this.sentenceService.delete(id);
    }

    @GetMapping("/getAll")
    public ResponseDto<List<SentenceResponce>> getAllType() {
        return this.sentenceService.getAllType();
    }

    @GetMapping("/pageable")
    public ResponseDto<Page<SentenceResponce>> getPage(@RequestParam Integer page, @RequestParam Integer size) {
        return this.sentenceService.getPage(page, size);
    }

    @RequestMapping(value = "/getAllByWordInSentenceBySentenceId")
    public ResponseDto<WordInSentenceResponse> getAllWordInSentenceBySentenceId(@RequestParam Integer id) {
        String url = id == 0 ? BASEURL : BASEURL + "/wordInSentence/getAllByWordInSentenceBySentenceId?id=" + id;
        return restTemplate.getForObject(url, ResponseDto.class);
    }
}
