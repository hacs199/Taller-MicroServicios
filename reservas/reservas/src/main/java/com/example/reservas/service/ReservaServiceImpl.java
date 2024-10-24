package com.example.reservas.service;

import com.example.reservas.dto.ReservaDto;
import com.example.reservas.dto.ReservaMapper;
import com.example.reservas.dto.ReservaToSaveDto;
import com.example.reservas.exception.NotFoundExceptionEntity;
import com.example.reservas.model.Reserva;
import com.example.reservas.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService{
    private final ReservasRepository reservaRepository;
    private final ReservaMapper reservaMapper;

    @Autowired
    public ReservaServiceImpl(ReservasRepository reservaRepository, ReservaMapper reservaMapper) {
        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
    }

    @Override
    public ReservaDto save(ReservaToSaveDto reservaDto) {
        Reserva reserva = reservaMapper.toSaveDto(reservaDto);
        return reservaMapper.toDto(reservaRepository.save(reserva));
    }

    @Override
    public ReservaDto update(Long id, ReservaToSaveDto reservaDto) {
        return reservaRepository.findById(id)
                .map(reserva -> {
                    return reservaMapper.toDto(reservaRepository.save(reserva));
                })
                .orElseThrow(() -> new NotFoundExceptionEntity("Reserva not found"));
    }

    @Override
    public ReservaDto findById(Long id) {
        return reservaRepository.findById(id)
                .map(reservaMapper::toDto)
                .orElseThrow(() -> new NotFoundExceptionEntity("Reserva not found"));
    }

    @Override
    public List<ReservaDto> findAll() {
        return reservaRepository.findAll().stream()
                .map(reservaMapper::toDto)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new NotFoundExceptionEntity("Reserva not found"));
        reservaRepository.delete(reserva);
    }

}
