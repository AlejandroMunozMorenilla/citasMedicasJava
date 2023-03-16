package com.formacion.citasMedicasJava.services;

import com.formacion.citasMedicasJava.dtos.DiagnosticoDTO;
import com.formacion.citasMedicasJava.mappers.DiagnosticoMapper;
import com.formacion.citasMedicasJava.models.Diagnostico;
import com.formacion.citasMedicasJava.repositories.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DiagnosticoService {
    @Autowired
    private DiagnosticoRepository diagnosticoRepository;
    @Autowired
    private DiagnosticoMapper diagnosticoMapper;


    public DiagnosticoDTO insertarDiagnostico(DiagnosticoDTO diagnosticoDTO) {
        Diagnostico diagnostico = diagnosticoMapper.toEntity(diagnosticoDTO);
        return diagnosticoMapper.toDto(diagnosticoRepository.save(diagnostico));
    }

    public Set<DiagnosticoDTO> todosLosDiagnosticos() {
        return diagnosticoRepository.findAll().stream().map(diagnosticoMapper::toDto).collect(Collectors.toSet());
    }

    public DiagnosticoDTO guardarDiagnostico(DiagnosticoDTO diagnosticoDto) {
        Diagnostico diagnosticoGuardado = diagnosticoRepository.save(diagnosticoMapper.toEntity(diagnosticoDto));
        return diagnosticoMapper.toDto(diagnosticoGuardado);
    }

    public void eliminarDiagnostico(Long id) {
        diagnosticoRepository.deleteById(id);
    }
}
