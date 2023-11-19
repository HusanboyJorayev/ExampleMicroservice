package com.example.second.service.mapper;

import com.example.second.entity.Type;
import com.example.second.request.TypeRequest;
import com.example.second.response.TypeResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class TypeMapper {

    public abstract Type toEntity(TypeRequest request);

    public abstract TypeResponse toDto(Type type);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Type type, TypeRequest request);
}
