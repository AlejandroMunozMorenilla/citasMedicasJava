package com.formacion.citasMedicasJava.mappers;

import com.formacion.citasMedicasJava.dtos.PacienteDTO;
import com.formacion.citasMedicasJava.models.Paciente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = MedicoMapper.class)
public interface PacienteMapper {
    PacienteDTO toDto(Paciente paciente);

    Paciente toEntity(PacienteDTO pacienteDTO);
}
