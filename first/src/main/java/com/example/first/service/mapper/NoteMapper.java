package com.example.first.service.mapper;

import com.example.first.entity.Note;
import com.example.first.request.NoteRequest;
import com.example.first.response.NoteResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class NoteMapper {

    public abstract Note toEntity(NoteRequest request);

    public abstract NoteResponse toDto(Note note);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Note note, NoteRequest request);
}
