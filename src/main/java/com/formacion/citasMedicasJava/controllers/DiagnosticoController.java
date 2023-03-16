package com.formacion.citasMedicasJava.controllers;

import com.formacion.citasMedicasJava.dtos.MedicoDTO;
import com.formacion.citasMedicasJava.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {
    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public Set<MedicoDTO> index() {
        return medicoService.todosLosMedicos();
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> guardarMedico(@RequestBody MedicoDTO medicoDto) {
        return ResponseEntity.ok(medicoService.guardarMedico(medicoDto));
    }

    @PutMapping("/{id}")
    public MedicoDTO update(@PathVariable Long id, @RequestBody MedicoDTO medicoDto) {
        return medicoService.guardarMedico(medicoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        medicoService.eliminarMedico(id);
    }

}