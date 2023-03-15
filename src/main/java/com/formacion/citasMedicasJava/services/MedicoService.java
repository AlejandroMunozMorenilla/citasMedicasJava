package com.formacion.citasMedicasJava.services;

import com.formacion.citasMedicasJava.dtos.MedicoDTO;
import com.formacion.citasMedicasJava.mappers.MedicoMapper;
import com.formacion.citasMedicasJava.models.Medico;
import com.formacion.citasMedicasJava.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private MedicoMapper medicoMapper;


    public MedicoDTO insertarMedico(MedicoDTO medicoDTO) {
        Medico medico = medicoMapper.toEntity(medicoDTO);
        return medicoMapper.toDto(medicoRepository.save(medico));
    }

    public Set<MedicoDTO> todosLosMedicos() {
        return medicoRepository.findAll().stream().map(medicoMapper::toDto).collect(Collectors.toSet());
    }

    public MedicoDTO guardarMedico(MedicoDTO medicoDto) {
        Medico medicoGuardado = medicoRepository.save(medicoMapper.toEntity(medicoDto));
        return medicoMapper.toDto(medicoGuardado);
    }

    public void eliminarMedico(Long id) {
        medicoRepository.deleteById(id);
    }
}
