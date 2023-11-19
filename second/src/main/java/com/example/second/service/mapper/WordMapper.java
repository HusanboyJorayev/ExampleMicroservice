package com.example.second.service.mapper;

import com.example.second.entity.Word;
import com.example.second.request.WordRequest;
import com.example.second.response.WordResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class WordMapper {
    public abstract Word toEntity(WordRequest request);

    public abstract WordResponse toDto(Word word);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Word word, WordRequest request);
}
