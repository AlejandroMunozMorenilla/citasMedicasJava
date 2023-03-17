package com.formacion.citasMedicasJava.controllers;

import com.formacion.citasMedicasJava.dtos.MedicoDTO;
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
    public Set<PacienteDTO> listadoPaceintes() {
        return medicoService.todosLosPacientes();
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPorId(@PathVariable Long id) {
        return medicoService.buscarPorId(id);
    }
    @GetMapping("/{id}/medicos")
    public Set<MedicoDTO> listaMedicosDePaciente(@PathVariable Long id) {
        return medicoService.buscarMedicosDePaciente(id);
    }

    @PostMapping
    @PutMapping
    public ResponseEntity<PacienteDTO> guardarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(medicoService.guardarPaciente(pacienteDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        medicoService.eliminarPaciente(id);
    }

}