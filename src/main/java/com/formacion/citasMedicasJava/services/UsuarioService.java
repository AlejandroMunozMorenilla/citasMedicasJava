package com.formacion.citasMedicasJava.services;

import com.formacion.citasMedicasJava.dtos.UsuarioDTO;
import com.formacion.citasMedicasJava.mappers.UsuarioMapper;
import com.formacion.citasMedicasJava.models.Usuario;
import com.formacion.citasMedicasJava.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;

    public Set<UsuarioDTO> todosLosUsuarios() {
        return usuarioRepository.findAll().stream().map(usuarioMapper::toDto).collect(Collectors.toSet());
    }

    public UsuarioDTO buscarPorId(Long id) {
        return usuarioMapper.toDto(usuarioRepository.findById(id).orElse(null));
    }

    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuarioGuardado = usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO));
        return usuarioMapper.toDto(usuarioGuardado);
    }

    public void eliminarPaciente(Long id) {
        usuarioRepository.deleteById(id);
    }
}