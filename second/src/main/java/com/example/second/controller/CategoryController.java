package com.example.second.controller;


import com.example.second.dto.ResponseDto;
import com.example.second.request.CategoryRequest;
import com.example.second.response.CategoryResponse;
import com.example.second.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("category")
@Tag(name = "Category api")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseDto<CategoryResponse> create(@RequestBody @Valid CategoryRequest request) {
        return this.categoryService.create(request);
    }

    @GetMapping("/get")
    public ResponseDto<CategoryResponse> get(@RequestParam Integer id) {
        return this.categoryService.get(id);
    }

    @PutMapping("/update")
    ResponseDto<CategoryResponse> update(@RequestBody @Valid CategoryRequest request, @RequestParam Integer id) {
        return this.categoryService.update(request, id);
    }

    @DeleteMapping("/delet")
    public ResponseDto<CategoryResponse> delete(@RequestParam Integer id) {
        return this.categoryService.delete(id);
    }

    @GetMapping("/getAll")
    public ResponseDto<List<CategoryResponse>> getAllType() {
        return this.categoryService.getAllType();
    }

    @GetMapping("/pageAble")
    public ResponseDto<Page<CategoryResponse>> getPage(@RequestParam Integer page, @RequestParam Integer size) {
        return this.categoryService.getPage(page, size);
    }
}
