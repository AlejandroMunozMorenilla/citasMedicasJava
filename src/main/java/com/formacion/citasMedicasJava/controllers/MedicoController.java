package com.formacion.citasMedicasJava.controllers;

import com.formacion.citasMedicasJava.dtos.MedicoDTO;
import com.formacion.citasMedicasJava.dtos.PacienteDTO;
import com.formacion.citasMedicasJava.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public Set<MedicoDTO> listadoCompleto() {
        return medicoService.todosLosMedicos();
    }

    @GetMapping("/{id}")
    public MedicoDTO buscarPorId(@PathVariable Long id) {
        return medicoService.buscarPorId(id);
    }

    @GetMapping("/{id}/pacientes")
    public Set<PacienteDTO> listaPacientesDeMedico(@PathVariable Long id) {
        return medicoService.buscarPacientesDeMedico(id);
    }

    @PostMapping
    @PutMapping
    public ResponseEntity<MedicoDTO> guardarMedico(@RequestBody MedicoDTO medicoDto) {
        return ResponseEntity.ok(medicoService.guardarMedico(medicoDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        medicoService.eliminarMedico(id);
    }


}
