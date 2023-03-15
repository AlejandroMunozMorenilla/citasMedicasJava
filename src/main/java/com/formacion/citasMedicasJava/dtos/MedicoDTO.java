package com.formacion.citasMedicasJava.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Builder
public class MedicoDTO implements Serializable {
    private Long id;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String numColegiado;
    private Set<PacienteDTO> pacientes;

    public MedicoDTO() {
    }
}