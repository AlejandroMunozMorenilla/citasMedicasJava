package com.formacion.citasMedicasJava.mappers;

import com.formacion.citasMedicasJava.dtos.UsuarioDTO;
import com.formacion.citasMedicasJava.models.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario toEntity (UsuarioDTO usuarioDTO);
    UsuarioDTO toDTO (Usuario usuario);
}
