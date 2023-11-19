package com.example.first.controller;


import com.example.first.dto.ResponseDto;
import com.example.first.request.WordTypeRequest;
import com.example.first.response.WordTypeResponse;
import com.example.first.service.WordTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("wordType")
@Tag(name = "WordType api")
public class WordTypeController {
    private final WordTypeService wordTypeService;

    @PostMapping("/create")
    public ResponseDto<WordTypeResponse> create(@RequestBody @Valid WordTypeRequest request) {
        return this.wordTypeService.create(request);
    }

    @GetMapping("/get")
    public ResponseDto<WordTypeResponse> get(@RequestParam Integer id) {
        return this.wordTypeService.get(id);
    }

    @PutMapping("/update")
    ResponseDto<WordTypeResponse> update(@RequestBody @Valid WordTypeRequest request, @RequestParam Integer id) {
        return this.wordTypeService.update(request, id);
    }

    @DeleteMapping("/delet")
    public ResponseDto<WordTypeResponse> delete(@RequestParam Integer id) {
        return this.wordTypeService.delete(id);
    }

    @GetMapping("/getAll")
    public ResponseDto<List<WordTypeResponse>> getAllType() {
        return this.wordTypeService.getAllType();
    }

    @GetMapping("/pageable")
    public ResponseDto<Page<WordTypeResponse>> getPage(@RequestParam Integer page, @RequestParam Integer size) {
        return this.wordTypeService.getPage(page, size);
    }

    @GetMapping("/getAllByWordId")
    public ResponseDto<List<WordTypeResponse>>getAllByWordId(@RequestParam Integer id) {
        return this.wordTypeService.getAllByWordId(id);
    }

    @GetMapping("/getAllByTypeId")
    public ResponseDto<List<WordTypeResponse>> getAllByTypeId(@RequestParam Integer id){
        return this.wordTypeService.getAllByTypeId(id);
    }
}
