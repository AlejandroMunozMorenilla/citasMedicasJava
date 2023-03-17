package com.formacion.citasMedicasJava.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Data
@Component
public class PacienteDTO extends UsuarioDTO {
    private String NSS;
    private String numTarjeta;
    private String telefono;
    private String direccion;
    public PacienteDTO() {

    }
}
