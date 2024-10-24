package com.example.reservas.dto;

import com.example.reservas.model.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservaMapper {
    ReservaMapper INSTANCE = Mappers.getMapper(ReservaMapper.class);

    ReservaDto toDto(Reserva reserva);
    Reserva toEntity(ReservaDto reservaDto);
    Reserva toSaveDto(ReservaToSaveDto reservaToSaveDto);
}
