package com.formacion.citasMedicasJava.mappers;

import com.formacion.citasMedicasJava.dtos.DiagnosticoDTO;
import com.formacion.citasMedicasJava.models.Diagnostico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiagnosticoMapper {
    DiagnosticoDTO toDto(Diagnostico diagnostico);

    Diagnostico toEntity(DiagnosticoDTO diagnosticoDTO);
}
