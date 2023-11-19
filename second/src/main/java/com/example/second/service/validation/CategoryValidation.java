package com.example.second.service.validation;

import com.example.second.dto.ErrorDto;
import com.example.second.request.CategoryRequest;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryValidation {
    public List<ErrorDto> validation(CategoryRequest request) {
        List<ErrorDto> errors = new ArrayList<>();

        if (StringUtils.isBlank(request.getName())) {
            errors.add(new ErrorDto("name", "name cannot be null or empty"));
        }
        return errors;
    }
}
