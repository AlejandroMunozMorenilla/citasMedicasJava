package com.formacion.citasMedicasJava.controllers;

import com.formacion.citasMedicasJava.dtos.UsuarioDTO;
import com.formacion.citasMedicasJava.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public Set<UsuarioDTO> index() {
        return usuarioService.todosLosUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> guardarMedico(@RequestBody UsuarioDTO pacienteDTO) {
        return ResponseEntity.ok(usuarioService.guardarUsuario(pacienteDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        usuarioService.eliminarPaciente(id);
    }

}
