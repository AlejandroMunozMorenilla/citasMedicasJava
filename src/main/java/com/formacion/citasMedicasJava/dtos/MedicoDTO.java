package com.formacion.citasMedicasJava.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
@NoArgsConstructor
@Component
public class MedicoDTO extends UsuarioDTO{
    private String numColegiado;
    private Set<PacienteDTO> pacientes;
}