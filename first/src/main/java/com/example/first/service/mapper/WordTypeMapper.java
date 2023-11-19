package com.example.first.service.mapper;


import com.example.first.entity.WordType;
import com.example.first.request.WordTypeRequest;
import com.example.first.response.WordTypeResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class WordTypeMapper {
    public abstract WordType toEntity(WordTypeRequest request);

    public abstract WordTypeResponse toDto(WordType type);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget WordType type, WordTypeRequest request);
}
