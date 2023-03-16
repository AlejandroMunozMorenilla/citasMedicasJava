package com.formacion.citasMedicasJava.controllers;

import com.formacion.citasMedicasJava.dtos.DiagnosticoDTO;
import com.formacion.citasMedicasJava.services.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {
    @Autowired
    private DiagnosticoService diagnosticoService;

    @GetMapping
    public Set<DiagnosticoDTO> index() {
        return diagnosticoService.todosLosDiagnosticos();
    }

    @GetMapping("/{id}")
    public DiagnosticoDTO buscarPorId(@PathVariable Long id) {
        return diagnosticoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<DiagnosticoDTO> guardarMedico(@RequestBody DiagnosticoDTO diagnosticoDTO) {
        return ResponseEntity.ok(diagnosticoService.guardarDiagnostico(diagnosticoDTO));
    }

    @PutMapping("/{id}")
    public DiagnosticoDTO update(@PathVariable Long id, @RequestBody DiagnosticoDTO diagnosticoDTO) {
        return diagnosticoService.guardarDiagnostico(diagnosticoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        diagnosticoService.eliminarDiagnostico(id);
    }

}