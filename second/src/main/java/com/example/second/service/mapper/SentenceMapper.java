package com.example.second.service.mapper;

import com.example.second.entity.Sentence;
import com.example.second.request.SentenceRequest;
import com.example.second.response.SentenceResponce;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class SentenceMapper {
    public abstract Sentence toEntity(SentenceRequest request);

    public abstract SentenceResponce toDto(Sentence sentence);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Sentence sentence, SentenceRequest request);
}
