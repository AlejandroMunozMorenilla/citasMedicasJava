package com.formacion.citasMedicasJava.services;

import com.formacion.citasMedicasJava.dtos.MedicoDTO;
import com.formacion.citasMedicasJava.dtos.PacienteDTO;
import com.formacion.citasMedicasJava.mappers.MedicoMapper;
import com.formacion.citasMedicasJava.mappers.PacienteMapper;
import com.formacion.citasMedicasJava.repositories.MedicoRepository;
import com.formacion.citasMedicasJava.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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


    public MedicoDTO guardarMedico(MedicoDTO medicoDTO) {
        return medicoMapper.toDto(medicoRepository.save(medicoMapper.toEntity(medicoDTO)));
    }

    public MedicoDTO actualizarMedico(Long id, MedicoDTO medicoDatosUpdate) {
        MedicoDTO medicoGuardado = medicoMapper.toDto(medicoRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
        rellenarPacientes(medicoGuardado);
        medicoGuardado.setPacientes(medicoDatosUpdate.getPacientes());
        medicoGuardado.setNombre(medicoDatosUpdate.getNombre());
        medicoGuardado.setApellidos(medicoDatosUpdate.getApellidos());
        medicoGuardado.setUsuario(medicoDatosUpdate.getUsuario());
        medicoGuardado.setNumColegiado(medicoDatosUpdate.getNumColegiado());
        medicoGuardado.setClave(medicoDatosUpdate.getClave());
        medicoRepository.save(medicoMapper.toEntity(medicoGuardado));
        return medicoGuardado;
    }

    public void eliminarMedico(Long id) {
        medicoRepository.deleteById(id);
    }

}
