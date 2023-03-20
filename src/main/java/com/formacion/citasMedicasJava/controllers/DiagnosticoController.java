package com.formacion.citasMedicasJava.controllers;

import com.formacion.citasMedicasJava.dtos.DiagnosticoDTO;
import com.formacion.citasMedicasJava.repositories.DiagnosticoRepository;
import com.formacion.citasMedicasJava.services.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/diagnosticoes")
public class DiagnosticoController {
    @Autowired
    private DiagnosticoService diagnosticoService;
    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @GetMapping
    public Set<DiagnosticoDTO> index() {
        return diagnosticoService.todosLosDiagnosticos();
    }

    @GetMapping("/{id}")
    public DiagnosticoDTO buscarPorId(@PathVariable Long id) {
        return diagnosticoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiagnosticoDTO> actualizarDiagnostico(@PathVariable Long id, @RequestBody DiagnosticoDTO diagnosticoDTO) {
        return ResponseEntity.ok(diagnosticoService.actualizarDiagnostico(id, diagnosticoDTO));
    }
    @PostMapping
    public ResponseEntity<DiagnosticoDTO> insertarDiagnostico(@RequestBody DiagnosticoDTO diagnosticoDTO) {
        return ResponseEntity.ok(diagnosticoService.insertarDiagnostico(diagnosticoDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        diagnosticoService.eliminarDiagnostico(id);
    }

}