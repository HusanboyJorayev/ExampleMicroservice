package com.example.second.service.mapper;

import com.example.second.entity.Category;
import com.example.second.request.CategoryRequest;
import com.example.second.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    public abstract Category toEntity(CategoryRequest request);

    public abstract CategoryResponse toDto(Category category);


    public abstract void update(@MappingTarget Category category,CategoryRequest request);
}
