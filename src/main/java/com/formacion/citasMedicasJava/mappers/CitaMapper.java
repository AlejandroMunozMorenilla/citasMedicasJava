package com.formacion.citasMedicasJava.mappers;

import com.formacion.citasMedicasJava.dtos.CitaDTO;
import com.formacion.citasMedicasJava.models.Cita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PacienteMapper.class, MedicoMapper.class, DiagnosticoMapper.class})
public interface CitaMapper {
    CitaDTO toDto(Cita cita);

    CitaDTO toEntity(CitaDTO citaDTO);
}
