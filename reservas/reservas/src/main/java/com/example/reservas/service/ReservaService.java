package com.example.reservas.service;

import com.example.reservas.dto.ReservaDto;
import com.example.reservas.dto.ReservaToSaveDto;

import java.util.List;

public interface ReservaService {
    ReservaDto save(ReservaToSaveDto reservaDto);
    ReservaDto update(Long id, ReservaToSaveDto reservaDto);
    ReservaDto findById(Long id);
    List<ReservaDto> findAll();
    void deleteById(Long id);

}
