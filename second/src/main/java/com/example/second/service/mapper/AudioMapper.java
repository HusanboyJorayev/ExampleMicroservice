package com.example.second.service.mapper;

import com.example.second.entity.Audio;
import com.example.second.response.AudioResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public abstract class AudioMapper {


    public abstract AudioResponse toDto(Audio audio);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void update(@MappingTarget Audio audio, AudioResponse request);
}
