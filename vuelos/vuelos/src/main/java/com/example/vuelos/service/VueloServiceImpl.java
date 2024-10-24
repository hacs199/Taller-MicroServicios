package com.example.vuelos.service;

import com.example.vuelos.dto.VueloDto;
import com.example.vuelos.dto.VueloMapper;
import com.example.vuelos.dto.VueloToSaveDto;
import com.example.vuelos.exception.NotFoundExceptionEntity;
import com.example.vuelos.model.Vuelo;
import com.example.vuelos.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloServiceImpl implements VueloService{
    private  final VueloRepository vueloRepository;
    private final VueloMapper vueloMapper;

    @Autowired
    public VueloServiceImpl(VueloRepository vueloRepository, VueloMapper vueloMapper) {
        this.vueloRepository = vueloRepository;
        this.vueloMapper = vueloMapper;
    }

    @Override
    public VueloDto save(VueloToSaveDto vueloDto) {
        Vuelo vuelo = vueloMapper.toSaveDto(vueloDto);
        return vueloMapper.toDto(vueloRepository.save(vuelo));
    }

    @Override
    public VueloDto update(Long id, VueloToSaveDto vueloDto) {
        return vueloRepository.findById(id)
                .map(vuelo -> {
                    return vueloMapper.toDto(vueloRepository.save(vuelo));
                })
                .orElseThrow(() -> new NotFoundExceptionEntity("Vuelo not found"));
    }

    @Override
    public VueloDto findById(Long id) {
        return vueloRepository.findById(id)
                .map(vueloMapper::toDto)
                .orElseThrow(() -> new NotFoundExceptionEntity("Vuelo not found"));
    }

    @Override
    public List<VueloDto> findAll() {
        return vueloRepository.findAll().stream()
                .map(vueloMapper::toDto)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        Vuelo vuelo = vueloRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptionEntity("Vuelo not found"));
        vueloRepository.delete(vuelo);
    }



}
