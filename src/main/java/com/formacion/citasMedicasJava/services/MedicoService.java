package com.formacion.citasMedicasJava.services;

import com.formacion.citasMedicasJava.dtos.MedicoDTO;
import com.formacion.citasMedicasJava.dtos.PacienteDTO;
import com.formacion.citasMedicasJava.mappers.MedicoMapper;
import com.formacion.citasMedicasJava.mappers.PacienteMapper;
import com.formacion.citasMedicasJava.models.Medico;
import com.formacion.citasMedicasJava.repositories.MedicoRepository;
import com.formacion.citasMedicasJava.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoMapper medicoMapper;
    @Autowired
    private PacienteMapper pacienteMapper;

    public Set<MedicoDTO> todosLosMedicos() {
        Set<MedicoDTO> medicos = medicoRepository.findAll().stream().map(medicoMapper::toDto).collect(Collectors.toSet());
        medicos.forEach(this::rellenarPacientes);
        return medicos;
    }

    public MedicoDTO buscarPorId(Long id) {
        MedicoDTO medico = medicoMapper.toDto(medicoRepository.findById(id).orElse(null));
        rellenarPacientes(medico);
        return medico;
    }

    private void rellenarPacientes(MedicoDTO medico) {
        if (medico != null) {
            medico.setPacientes(buscarPacientesDeMedico(medico.getId()));
        }
    }

    public Set<PacienteDTO> buscarPacientesDeMedico(Long id) {
        return pacienteRepository.findAllByMedico_Id(id).stream().map(pacienteMapper::toDto).collect(Collectors.toSet());
    }


    public MedicoDTO guardarMedico(MedicoDTO medicoDto) {
        Medico medicoGuardado = medicoRepository.save(medicoMapper.toEntity(medicoDto));
        return medicoMapper.toDto(medicoGuardado);
    }

    public void eliminarMedico(Long id) {
        medicoRepository.deleteById(id);
    }

}
