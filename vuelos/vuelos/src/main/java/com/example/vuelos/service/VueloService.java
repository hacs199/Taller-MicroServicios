package com.example.vuelos.service;

import com.example.vuelos.dto.VueloDto;
import com.example.vuelos.dto.VueloToSaveDto;

import java.util.List;

public interface VueloService {
    VueloDto save(VueloToSaveDto vueloDto);
    VueloDto update(Long id, VueloToSaveDto vueloDto);
    VueloDto findById(Long id);
    List<VueloDto> findAll();
    void deleteById(Long id);

}
