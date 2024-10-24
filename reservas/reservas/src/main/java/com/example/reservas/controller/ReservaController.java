package com.example.reservas.controller;


import com.example.reservas.dto.ReservaDto;
import com.example.reservas.dto.ReservaToSaveDto;
import com.example.reservas.exception.NotFoundExceptionEntity;
import com.example.reservas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reservas")
public class ReservaController {
    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaDto> save(ReservaToSaveDto reservaDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.save(reservaDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDto> findById(@PathVariable Long id) {
        try {
            ReservaDto reservaDto = reservaService.findById(id);
            return ResponseEntity.ok(reservaDto);
        } catch (NotFoundExceptionEntity ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDto> update(@PathVariable Long id, ReservaToSaveDto reservaDto) {
        try {
            ReservaDto reservaDtoUpdated = reservaService.update(id, reservaDto);
            return ResponseEntity.ok(reservaDtoUpdated);
        } catch (NotFoundExceptionEntity ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            reservaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundExceptionEntity ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
