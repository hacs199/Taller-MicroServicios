package com.example.vuelos.controller;

import com.example.vuelos.dto.VueloDto;
import com.example.vuelos.dto.VueloToSaveDto;
import com.example.vuelos.exception.NotFoundExceptionEntity;
import com.example.vuelos.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vuelos")
public class VueloController {
    private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @PostMapping
    public ResponseEntity<VueloDto> save(VueloToSaveDto vueloDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vueloService.save(vueloDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VueloDto> findById(@PathVariable Long id) {
        try {
            VueloDto vueloDto = vueloService.findById(id);
            return ResponseEntity.ok(vueloDto);
        } catch (NotFoundExceptionEntity ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<VueloDto> update(@PathVariable Long id, VueloToSaveDto vueloDto) {
        try {
            VueloDto vueloDtoUpdated = vueloService.update(id, vueloDto);
            return ResponseEntity.ok(vueloDtoUpdated);
        } catch (NotFoundExceptionEntity ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            vueloService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundExceptionEntity ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
