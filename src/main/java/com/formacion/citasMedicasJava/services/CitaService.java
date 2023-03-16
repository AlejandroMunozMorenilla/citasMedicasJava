package com.formacion.citasMedicasJava.services;

import com.formacion.citasMedicasJava.dtos.CitaDTO;
import com.formacion.citasMedicasJava.mappers.CitaMapper;
import com.formacion.citasMedicasJava.models.Cita;
import com.formacion.citasMedicasJava.repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private CitaMapper citaMapper;


    public CitaDTO insertarCita(CitaDTO citaDTO) {
        Cita cita = citaMapper.toEntity(citaDTO);
        return citaMapper.toDto(citaRepository.save(cita));
    }

    public Set<CitaDTO> todasLasCitas() {
        return citaRepository.findAll().stream().map(citaMapper::toDto).collect(Collectors.toSet());
    }

    public CitaDTO guardarCita(CitaDTO citaDTO) {
        Cita medicoGuardado = citaRepository.save(citaMapper.toEntity(citaDTO));
        return citaMapper.toDto(medicoGuardado);
    }

    public void eliminarCita(Long id) {
        citaRepository.deleteById(id);
    }
}
