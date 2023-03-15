package com.formacion.citasMedicasJava.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String usario;
    private String NSS;
    private String numTarjeta;
    private String telefono;
    private String direccion;
    private Set<MedicoDTO> medicos;

}
