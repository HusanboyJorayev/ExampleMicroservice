package com.example.second.controller;

import com.example.second.dto.ResponseDto;
import com.example.second.request.TypeRequest;
import com.example.second.response.TypeResponse;
import com.example.second.service.TypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("type")
@Tag(name = "Type api")
public class TypeController {
    private final TypeService typeService;

    @PostMapping("/create")
    public ResponseDto<TypeResponse> create(@RequestBody @Valid TypeRequest request) {
        return this.typeService.create(request);
    }

    @GetMapping("/get")
    public ResponseDto<TypeResponse> get(@RequestParam Integer id) {
        return this.typeService.get(id);
    }

    @PutMapping("/update")
    ResponseDto<TypeResponse> update(@RequestBody @Valid TypeRequest request, @RequestParam Integer id) {
        return this.typeService.update(request, id);
    }

    @DeleteMapping("/delet")
    public ResponseDto<TypeResponse> delete(@RequestParam Integer id) {
        return this.typeService.delete(id);
    }

    @GetMapping("/getAll")
    public ResponseDto<List<TypeResponse>> getAllType() {
        return this.typeService.getAllType();
    }

    @GetMapping("/pageable")
    public ResponseDto<Page<TypeResponse>> getPage(@RequestParam Integer page, @RequestParam Integer size) {
        return this.typeService.getPage(page, size);
    }
}
