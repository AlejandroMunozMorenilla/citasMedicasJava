package com.formacion.citasMedicasJava.controllers;

import com.formacion.citasMedicasJava.dtos.PacienteDTO;
import com.formacion.citasMedicasJava.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService medicoService;

    @GetMapping
    public Set<PacienteDTO> index() {
        return medicoService.todosLosPacientes();
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPorId(@PathVariable Long id) {
        return medicoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> guardarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(medicoService.guardarPaciente(pacienteDTO));
    }

    @PutMapping("/{id}")
    public PacienteDTO update(@PathVariable Long id, @RequestBody PacienteDTO pacienteDTO) {
        return medicoService.guardarPaciente(pacienteDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        medicoService.eliminarPaciente(id);
    }

}