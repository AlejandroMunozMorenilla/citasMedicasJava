package com.formacion.citasMedicasJava.mappers;

import com.formacion.citasMedicasJava.dtos.MedicoDTO;
import com.formacion.citasMedicasJava.models.Medico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PacienteMapper.class)
public interface MedicoMapper {
    MedicoDTO toDto(Medico medico);

    Medico toEntity(MedicoDTO medicoDTO);
}
