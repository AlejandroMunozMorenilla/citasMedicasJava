package com.formacion.citasMedicasJava.controllers;

import com.formacion.citasMedicasJava.dtos.CitaDTO;
import com.formacion.citasMedicasJava.dtos.PacienteDTO;
import com.formacion.citasMedicasJava.models.Cita;
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

    @PutMapping("/{id}")
    public ResponseEntity<CitaDTO> actualizarCita(@PathVariable Long id, @RequestBody CitaDTO citaDTO) {
        return ResponseEntity.ok(citaService.actualizarCita(id, citaDTO));
    }
    @PostMapping
    public ResponseEntity<CitaDTO> insertarCita(@RequestBody CitaDTO pacienteDTO) {
        return ResponseEntity.ok(citaService.guardarCita(pacienteDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        citaService.eliminarCita(id);
    }

}
