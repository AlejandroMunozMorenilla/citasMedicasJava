package com.formacion.citasMedicasJava.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Data
@Component
public class MedicoDTO extends UsuarioDTO {
    private String numColegiado;
    private Set<PacienteDTO> pacientes;
    public MedicoDTO() {
        pacientes = new HashSet<>();
    }
}