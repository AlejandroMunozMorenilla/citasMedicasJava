package com.formacion.citasMedicasJava.services;

import com.formacion.citasMedicasJava.dtos.CitaDTO;
import com.formacion.citasMedicasJava.mappers.CitaMapper;
import com.formacion.citasMedicasJava.models.Cita;
import com.formacion.citasMedicasJava.repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private CitaMapper citaMapper;

    public Set<CitaDTO> todasLasCitas() {
        return citaRepository.findAll().stream().map(citaMapper::toDto).collect(Collectors.toSet());
    }

    public CitaDTO buscarCitaPorId(Long id) {
        return citaMapper.toDto(citaRepository.findById(id).orElse(null));
    }

    public CitaDTO guardarCita(CitaDTO citaDTO) {
        Cita medicoGuardado = citaRepository.save(citaMapper.toEntity(citaDTO));
        return citaMapper.toDto(medicoGuardado);
    }

    public void eliminarCita(Long id) {
        citaRepository.deleteById(id);
    }

    public CitaDTO actualizarCita(Long id, CitaDTO citaDTO) {
        CitaDTO citaGuardada = citaMapper.toDto(citaRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
        citaGuardada.setFechaHora(citaDTO.getFechaHora());
        citaGuardada.setMotivoCita(citaDTO.getMotivoCita());
        citaGuardada.setAttribute11(citaDTO.getAttribute11());
        citaGuardada.setMedico(citaDTO.getMedico());
        citaGuardada.setPaciente(citaDTO.getPaciente());
        citaGuardada.setDiagnostico(citaDTO.getDiagnostico());
        citaRepository.save(citaMapper.toEntity(citaGuardada));
        return citaGuardada;

    }
}
