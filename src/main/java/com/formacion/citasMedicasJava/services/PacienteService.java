package com.formacion.citasMedicasJava.services;

import com.formacion.citasMedicasJava.dtos.MedicoDTO;
import com.formacion.citasMedicasJava.dtos.PacienteDTO;
import com.formacion.citasMedicasJava.mappers.MedicoMapper;
import com.formacion.citasMedicasJava.mappers.PacienteMapper;
import com.formacion.citasMedicasJava.models.Paciente;
import com.formacion.citasMedicasJava.repositories.MedicoRepository;
import com.formacion.citasMedicasJava.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteMapper pacienteMapper;
    @Autowired
    private MedicoMapper medicoMapper;

    public Set<PacienteDTO> todosLosPacientes() {
        Set<PacienteDTO> pacientes = pacienteRepository.findAll().stream().map(pacienteMapper::toDto).collect(Collectors.toSet());
        return pacientes;
    }

    public PacienteDTO buscarPorId(Long id) {
        PacienteDTO paciente = pacienteMapper.toDto(pacienteRepository.findById(id).orElse(null));
        return paciente;
    }

    public Set<MedicoDTO> buscarMedicosDePaciente(Long id) {
        return medicoRepository.findAllByPacientes_Id(id).stream().map(medicoMapper::toDto).collect(Collectors.toSet());
    }

    public PacienteDTO insertarPaciente(PacienteDTO pacienteDto) {
        Paciente pacienteGuardado = pacienteRepository.save(pacienteMapper.toEntity(pacienteDto));
        return pacienteMapper.toDto(pacienteGuardado);
    }

    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public PacienteDTO actualizarPaciente(Long id, PacienteDTO pacienteDTO) {
        PacienteDTO pacienteGuardado = pacienteMapper.toDto(pacienteRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
        pacienteGuardado.setNombre(pacienteDTO.getNombre());
        pacienteGuardado.setApellidos(pacienteDTO.getApellidos());
        pacienteGuardado.setUsuario(pacienteDTO.getUsuario());
        pacienteGuardado.setDireccion(pacienteDTO.getDireccion());
        pacienteGuardado.setNSS(pacienteDTO.getNSS());
        pacienteGuardado.setNumTarjeta(pacienteDTO.getNumTarjeta());
        pacienteGuardado.setTelefono(pacienteDTO.getTelefono());
        pacienteRepository.save(pacienteMapper.toEntity(pacienteGuardado));
        return pacienteGuardado;
    }
}