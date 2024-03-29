package com.example.first.service.mapper;


import com.example.first.entity.DayWord;
import com.example.first.request.DayWordRequest;
import com.example.first.response.DayWordResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class DayWordMapper {
    public abstract DayWord toEntity(DayWordRequest request);

    public abstract DayWordResponse toDto(DayWord type);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget DayWord type, DayWordRequest request);
}
