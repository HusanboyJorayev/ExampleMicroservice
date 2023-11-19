package com.example.second.client;

import com.example.second.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "first",path = "/first/note/**")
public interface NoteClient {

    @GetMapping("/getAllNoteByWordId")
    ResponseDto<List<NoteResponse>> getAllNoteByWordId(@RequestParam Integer id);
}
