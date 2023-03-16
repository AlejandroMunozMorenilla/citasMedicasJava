package com.formacion.citasMedicasJava.controllers;

import com.formacion.citasMedicasJava.dtos.CitaDTO;
import com.formacion.citasMedicasJava.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @GetMapping
    public Set<CitaDTO> index() {
        return citaService.todasLasCitas();
    }

    @GetMapping("/{id}")
    public CitaDTO buscarPorId(@PathVariable Long id) {
        return citaService.buscarCitaPorId(id);
    }

    @PostMapping
    public ResponseEntity<CitaDTO> guardarMedico(@RequestBody CitaDTO citaDTO) {
        return ResponseEntity.ok(citaService.guardarCita(citaDTO));
    }

    @PutMapping("/{id}")
    public CitaDTO update(@PathVariable Long id, @RequestBody CitaDTO citaDTO) {
        return citaService.guardarCita(citaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        citaService.eliminarCita(id);
    }

}
