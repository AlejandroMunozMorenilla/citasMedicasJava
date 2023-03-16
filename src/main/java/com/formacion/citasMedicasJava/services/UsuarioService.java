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


    public UsuarioDTO insertarUsuario(UsuarioDTO usuarioDTO) {
        Usuario paciente = usuarioMapper.toEntity(usuarioDTO);
        return usuarioMapper.toDTO(usuarioRepository.save(paciente));
    }

    public Set<UsuarioDTO> todosLosUsuarios() {
        return usuarioRepository.findAll().stream().map(usuarioMapper::toDTO).collect(Collectors.toSet());
    }

    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuarioGuardado = usuarioRepository.save(usuarioMapper.toEntity(usuarioDTO));
        return usuarioMapper.toDTO(usuarioGuardado);
    }

    public void eliminarPaciente(Long id) {
        usuarioRepository.deleteById(id);
    }
}