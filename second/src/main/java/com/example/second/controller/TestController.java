package com.example.second.controller;

import com.example.second.client.*;
import com.example.second.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {
    private final WordInSentenceClient wordInSentenceClient;
    private final WordTypeClient wordTypeClient;
    private final DayWordClient dayWordClient;
    private final NoteClient noteClient;

    @GetMapping("/getAllByWordId")
    ResponseDto<List<WordTypeResponse>> getAllByWordId(@RequestParam Integer id) {
        return this.wordTypeClient.getAllByWordId(id);
    }

    @GetMapping("/getAllNoteByWordId")
    ResponseDto<List<NoteResponse>>  getAllNoteByWordId(@RequestParam Integer id) {
        return this.noteClient.getAllNoteByWordId(id);
    }

    @GetMapping("/getAllDayWordByWordId")
    public ResponseDto<List<DayWordResponse>> getAllDayWordByWordId(@RequestParam Integer id) {
        return this.dayWordClient.getAllDayWordByWordId(id);
    }

    @GetMapping("/getAllWordInSentenceByWordId")
    public ResponseDto<List<WordInSentenceResponse>>getAllWordInSentenceByWordId(@RequestParam Integer id) {
        return this.wordInSentenceClient.getAllWordInSentenceByWordId(id);
    }

    @GetMapping("/getAllByTypeId")
    public ResponseDto<List<WordTypeResponse>> getAllByTypeId(@RequestParam Integer id) {
        return this.wordTypeClient.getAllByTypeId(id);
    }

    @GetMapping("/getAllByWordInSentenceBySentenceId")
    public ResponseDto<List<WordInSentenceResponse>> getAllWordInSentenceBySentenceId(@RequestParam Integer id) {
        return this.wordInSentenceClient.getAllWordInSentenceBySentenceId(id);
    }
}*/
