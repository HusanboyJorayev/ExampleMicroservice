package com.example.first.service.mapper;


import com.example.first.entity.WordInSentence;
import com.example.first.request.WordInSentenceRequest;
import com.example.first.response.WordInSentenceResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class WordInSentenceMapper {
    public abstract WordInSentence toEntity(WordInSentenceRequest request);

    public abstract WordInSentenceResponse toDto(WordInSentence type);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget WordInSentence type, WordInSentenceRequest request);
}
