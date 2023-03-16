package com.formacion.citasMedicasJava.services;

import com.formacion.citasMedicasJava.dtos.PacienteDTO;
import com.formacion.citasMedicasJava.mappers.PacienteMapper;
import com.formacion.citasMedicasJava.models.Paciente;
import com.formacion.citasMedicasJava.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PacienteMapper pacienteMapper;


    public PacienteDTO insertarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteMapper.toEntity(pacienteDTO);
        return pacienteMapper.toDto(pacienteRepository.save(paciente));
    }

    public Set<PacienteDTO> todosLosPacientes() {
        return pacienteRepository.findAll().stream().map(pacienteMapper::toDto).collect(Collectors.toSet());
    }

    public PacienteDTO buscarPorId(Long id) {
        return pacienteMapper.toDto(pacienteRepository.findById(id).orElse(null));
    }

    public PacienteDTO guardarPaciente(PacienteDTO pacienteDto) {
        Paciente pacienteGuardado = pacienteRepository.save(pacienteMapper.toEntity(pacienteDto));
        return pacienteMapper.toDto(pacienteGuardado);
    }

    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}