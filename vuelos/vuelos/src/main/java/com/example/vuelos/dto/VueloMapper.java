package com.example.vuelos.dto;

import com.example.vuelos.model.Vuelo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VueloMapper {
    VueloMapper INSTANCE = Mappers.getMapper(VueloMapper.class);

    VueloDto toDto(Vuelo vuelo);
    Vuelo toEntity(VueloDto vueloDto);
    Vuelo toSaveDto(VueloToSaveDto vueloToSaveDto);
}
